package co.com.conversormoneda;

import java.util.ArrayList;

public class Conversor {

	private String nombre;
	private String unidadBase;
	private ArrayList<TipoDeconversion> listaUnidades;

	public Conversor(String nombre, Unidad[] lista, String unidadBase) {

		ArrayList<TipoDeconversion> listaConversiones = new ArrayList<>();

		//de peso Colombiano a moneda extranjera
		for (Unidad unidad : lista) {
			listaConversiones.add(new TipoDeconversion(unidad," De " + unidadBase + " a " + unidad.getNombre(), 1));
		}

		// de moneda extranjera a peso Colombiano, invierto taza de cambio 1/taza
		for (Unidad unidad : lista) {
			listaConversiones.add(new TipoDeconversion(unidad," De " + unidad.getNombre() + " a " + unidadBase, -1));
		}

		this.listaUnidades = listaConversiones;
		this.nombre = nombre;
		this.unidadBase = unidadBase;
	}
	
	
	public float convertir(String unidadDeCambio, float monto) {

		for (TipoDeconversion conversion : this.listaUnidades) {
			if (conversion.getTipoDeconversion() == unidadDeCambio) {
				return (float) conversion.convertir(monto);
			}
		}

		return 0;

	}

	/*Retorna un String[] (Array de String) con los nombres de las unidades en las que se puede hacer las conversiones */

	public String[] getListaConversiones() {

		// obtengo un arraylist de los nombres de la listaUnidades
		ArrayList<String> nombres = new ArrayList<String>();
		for (TipoDeconversion m : this.listaUnidades) {
			nombres.add(m.getTipoDeconversion());
		}

		// devuelve un array de string con todos los nombres de las unidades disponibles
		String[] s = new String[nombres.size()];
		return s = nombres.toArray(s);
	}

	public String getNombre() {
		return this.nombre;
	}
	
	
	public String getNombreMoneda (String tipoDeCambio) {
		
		String retorno = "";
		for(TipoDeconversion conversion: listaUnidades) {
			if(conversion.getTipoDeconversion() == tipoDeCambio)
				if(conversion.getDireccion() < 1) {
					retorno = this.unidadBase;
				}else {
					retorno = conversion.getNombreUnidad();
				}
		}
		
		return retorno;
	}

}
