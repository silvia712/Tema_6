package ejer_contrasena_bin;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Password vContrasena[]= new Password[10];
		/*vContrasena[0]= new Password("silvia",3,false);
		vContrasena[1]= new Password("ivan",2578,true);
			
		IODatos.guardar_datos(vContrasena);*/
		
		
		
		Scanner leer=new Scanner (System.in);
		System.out.println("escribe nuevos datos a guardar (usuario,password,segura)");
		String usuario=leer.nextLine();
		int password=leer.nextInt();
		boolean segura=leer.nextBoolean();
				
			
			for (int i=0; i<vContrasena.length;i++) {
				if (vContrasena[i]==null) {
						vContrasena[i]= new Password(usuario,password,segura);
						break;
					}
				}
			
			for (int i=0;i<vContrasena.length;i++) {
				System.out.println(vContrasena[i]);
				
			}
			
			
		//IODatos.guardar_datos(vContrasena);

		
		
	}

}
