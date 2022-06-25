package co.com.conversormoneda;

public class TipoDeconversion {
	
	private Unidad unidad;
	private String tipoDeCoversion;
	private int direccion;
	
	public TipoDeconversion(Unidad unidad,String tipo, int direccion) {
		this.unidad = unidad;
		this.tipoDeCoversion = tipo;
		this.direccion = direccion;
	}
	
	public double convertir (double monto) {
		if (direccion > 0) {
			return unidad.convertirAUnidad(monto);
		}else if(direccion<0){
			return unidad.convertirDeUnidad(monto);
		}else {
			return 0;
		}
	}
	
	public String getTipoDeconversion() {
		return this.tipoDeCoversion;
	}
	
	public String getNombreUnidad() {
		return unidad.getNombre();
	}
	
	public int getDireccion() {
		return this.direccion;
	}
}

