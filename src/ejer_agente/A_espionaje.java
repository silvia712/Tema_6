package ejer_agente;

import java.util.Arrays;
import java.util.Scanner;

public final class A_espionaje extends Agente {

	public String pisos[];

	public A_espionaje(String nombre, int edad, String direccion, float salario, String pisos[]) {
		super(nombre, edad, direccion, salario);
		this.pisos = IODAt.cargarDatosTexto("ficheros/pisos.txt");
	}

	public String[] getPisos() {
		return pisos;
	}

	public void setPisos(String[] pisos) {
		this.pisos = pisos;
	}

	@Override
	public String toString() {
		return "A_espionaje [pisos=" + Arrays.toString(pisos) + "]";
	}


	
	
}
