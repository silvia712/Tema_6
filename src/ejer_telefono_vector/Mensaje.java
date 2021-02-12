package ejer_telefono_vector;

public class Mensaje {
	
	
	private String mensaje;
	private String nombre;
	
	
	public Mensaje(String mensaje, String nombre) {
		this.mensaje = mensaje;
		this.nombre = nombre;
	}


	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return nombre + ": " + mensaje;
	}

	
	

}
