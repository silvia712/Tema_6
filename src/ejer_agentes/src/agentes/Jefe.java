package agentes;

public final class Jefe extends Agente {

	private int mandato;

	public Jefe(String nombre, int edad, String direccion, float salario, int mandato) {
		super(nombre, edad, direccion, salario);
		this.mandato = mandato;
	}

	public int getMandato() {
		return mandato;
	}

	public void setMandato(int mandato) {
		this.mandato = mandato;
	}

	@Override
	public String toString() {
		return "Jefe [mandato=" + mandato + "]";
	}
	
	
	
	
	
}
