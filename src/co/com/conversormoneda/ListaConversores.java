package co.com.conversormoneda;

import java.util.ArrayList;

public class ListaConversores {
	
	private ArrayList<Conversor> lista ;
	
	public ListaConversores(Conversor[] lista) {
		this.lista = new ArrayList<>();
		for(Conversor conversor:lista) {
			this.lista.add(conversor);
		}
	}
	
	public String[] getListaConversores() {

		// obtengo un arraylist de los nombres de la listaUnidades
		ArrayList<String> nombres = new ArrayList<String>();
		for (Conversor m : this.lista) {
			nombres.add(m.getNombre());
		}

		// devuelve un array de string con todos los nombres de las unidades disponibles
		String[] s = new String[nombres.size()];
		return s = nombres.toArray(s);
	}
	
	public Conversor getConversor(String nombre) {
		
		Conversor retornoConversor = null;
		
		for(Conversor conversor:this.lista) {
			
			if(nombre == conversor.getNombre()) {
				retornoConversor = conversor;
			}

		}
		
		return retornoConversor;
	}
	
}
