package ejer_ventas_bin;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
		String fichero = "ventas.dat";
		Ventas vClientes[] = new Ventas[15];
		
		vClientes[0]=new Ventas("Ivan", 111, 4, 15.25);
		vClientes[1]=new Ventas("Adelin", 222, 7, 2.50);
		vClientes[2]=new Ventas("Angel", 333, 2, 120.75);
		vClientes[3]=new Ventas("Gil", 444, 3, 70.15);
		vClientes[4]=new Ventas("Tomas", 555, 5, 35.50);
		vClientes[5]=new Ventas("Jordi", 666, 3, 55.30);
		vClientes[6]=new Ventas("Diego", 777, 6, 1.89);
		
		
		// 1 - Crear fichero binario  y escribir las ventas
		
				IODatos.escribir_ventas_en_fichero(vClientes, fichero);
				

		// 2 - Mostrar el contenido del fichero en un vector nuevo y contar el total de clientes
				
				System.out.println("LISTADO CLIENTES\n");
				int suma=0;
				
				for (Ventas v : IODatos.devolver_datos_en_vector(fichero)) {
					if(v!=null) {
						System.out.println(v);
						suma=suma+1;
					}
				}	System.out.println("\nTOTAL: " + suma + " clientes");
	
				
		// 3 - Calcular la facturacion de uno de los clientes
				
				System.out.println("\nDe que cliente quieres calcular su facturacion?");
				
					String cliente="";
					Scanner leer= new Scanner(System.in);
					cliente=leer.nextLine();
					
					IODatos.calculo_venta(cliente,IODatos.devolver_datos_en_vector(fichero) );
		
				}
			

		
	}


