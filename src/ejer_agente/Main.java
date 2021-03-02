package ejer_agente;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
		Agente vAgentes[]= new Agente[10];
		 vAgentes[1]= new Agente("yo", 39, "bbbbb", 1500);
		 vAgentes[2]= new Agente("tu", 40, "rrrrr", 2000); 
		
		Scanner leer=new Scanner(System.in);
		int opcion=0;
		
		System.out.println("\n***AGENCIA DE ESPIONAJE TIA ***");
		
		
			do {
					IODAt.pinta_menu();
					opcion=leer.nextInt();
				
								
						switch (opcion) {
							case 1:
								IODAt.ver_agentes(vAgentes);
								break;
							case 2:
								IODAt.salario_agentes(vAgentes);
								break;
							case 3:
								IODAt.nuevaArmasoPiso("ficheros/pisos.txt");
								break;
							case 4:
								IODAt.nuevaArmasoPiso("ficheros/armas.txt");
								break;
							case 5:
								//IODAt.nuevo(vAgentes);
								break;
							case 6:
								IODAt.encriptar(vAgentes);
								System.out.println("Informacion encriptada\n");
								break;
							case 7:
								IODAt.desencriptar(IODAt.encriptar(vAgentes));
								break;
							case 8:
								System.out.println("Sesion cerrada");
								break;	
							}
					
				
				}while (opcion>0 && opcion<8);
		
		
	}

}
