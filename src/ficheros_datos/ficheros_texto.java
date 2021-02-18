package ficheros_datos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ficheros_texto {

	public static void main(String[] args) {
		
		
	 // 1 - CREAR UNA CARPETA
	
		String nombreCarpeta;
		Scanner leerCarpeta=new Scanner(System.in);
		  
		 System.out.print("Escribe nombre de la carpeta");
		 nombreCarpeta=leerCarpeta.nextLine();
		
		 File d = new File (nombreCarpeta);
		
		 
		 	if (!d.exists()) {			// si D no existe
		 		d.mkdir();				// se crea con mkdir
		 	}
	 	
	 	
	 // 2 - CREAR UN FICHERO DENTRO DE LA CARPETA
	 
	 	String nombreFichero;
	 	Scanner leerFichero=new Scanner(System.in);
	 	
		 System.out.print("Escribe el nombre del fichero");
		 nombreFichero=leerFichero.nextLine();
		 
		 File f= new File (nombreCarpeta+"/"+nombreFichero); //ruta
		 
		 	if (!f.exists()) {				// si F no existe
		 		try {						// se crea con createNewFile
					f.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
		 	}
		 	
	 	
	 // 3 - ESCRIBIR EN EL FICHERO
	 	
		 	 PrintWriter pw=null;
		 	
		 	try {
				pw =new PrintWriter(new FileWriter(f,true));
				pw.println("hola soy Silvia");
			} catch (IOException e) {
				e.printStackTrace();
			}
		 	
		 	finally{
				pw.close();			//hay que cerrarlo,si no no guarda cambios
			}
		 	
	
	// 4 - LEER UN FICHERO y MOSTRAR POR PANTALLA
		
		 	FileReader fr = null;
		 	Scanner sc = null;
		 	
		 	try {
				fr = new FileReader(f);
				sc = new Scanner (fr);
				
				while (sc.hasNext()) {
					String linea=sc.nextLine();
					System.out.println(linea);
				}	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}finally {
				sc.close();
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		 	
			
		
	}

}
