package ejer_agente;

import java.util.Arrays;

/**
 * 
 * @author Silvia
 *
 */

public final class A_007 extends Agente{

	private int muertes;
	private String [] armas;
	
	public A_007(String nombre, int edad, String direccion, float salario, int muertes, String[] armas) {
		super(nombre, edad, direccion, salario);
		this.muertes = muertes;
		this.armas = IODAt.cargarDatosTexto("ficheros/armas.txt");
	}

	public int getMuertes() {
		return muertes;
	}

	public void setMuertes(int muertes) {
		this.muertes = muertes;
	}

	public String[] getArmas() {
		return armas;
	}

	public void setArmas(String[] armas) {
		this.armas = armas;
	}

	@Override
	public String toString() {
		return "A_007 [muertes=" + muertes + ", armas=" + Arrays.toString(armas) + "]";
	}
	

	
	
}
