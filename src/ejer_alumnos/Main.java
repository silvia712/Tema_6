package ejer_alumnos;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		IODatos.mostrar("alumnos.txt",50);
		
		
		int numero;
		Scanner leer=new Scanner(System.in);
		System.out.println("Escribe tu nip");
		numero=leer.nextInt();
		IODatos.buscar(numero);
	}

}
