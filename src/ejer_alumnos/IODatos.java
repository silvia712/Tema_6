package ejer_alumnos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IODatos {

	
	public static void mostrar(String nombreFichero, int longitudLinea) {
		
		File f =new File(nombreFichero);
		FileReader fr = null;
		Scanner leer = null;
		
		if(!f.exists()) {								// comprobar si existe. Si no existe crea uno 
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}/*else {
			System.out.println("el fichero existe");   	//podriamos borralo, solo era para comprobar
		}*/  
		
		try {
			fr = new FileReader(f);						// primero FileReader sobre el fichero "f"
			leer=new Scanner(fr);						// montamos Scanner sobre FileReader "fr"
			
			while (leer.hasNext()) { 					// para leer el fichero de forma secuencial (hasta EOF)
				String linea=leer.nextLine();			// guarda en LINEA lo que va leyendo
				formatearLinea(linea, longitudLinea);	// para mostrar como queramos
				
				
				/* System.out.println(linea);			// esta leyendo bien las lineas */
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		
		}finally {
			leer.close();								// cerramos el Scanner y FileReader
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private static void formatearLineaBusqueda (String linea, int longitudLinea, int nipBusqueda) {
		
		Persona p;
		String nombre="", apellido="";
			
		int nip;
		
		nip=Integer.parseInt(linea.substring(0,6));  // recibe un String y devuelve numero
		
		
		for (int i=7; i<linea.length(); i++) {			
			if(!linea.substring(i, i+1).equalsIgnoreCase(",")) {
				apellido+=linea.substring(i,i+1);
			}else {
				break;
			}
		}
		
		for (int i=7+apellido.length(); i<linea.length();i++) {
				nombre+=linea.substring(i,i+1);	
			}	
		
		String puntos="";
		
		for (int i=(Integer.toString(nip).length()+nombre.length()+apellido.length()); i<longitudLinea;i++) {
			puntos+=".";
		}	
	
		
		if (nip == nipBusqueda) {
			System.out.println(apellido + nombre + puntos + " " +nip);
			
			
			escribir("Busqudas.txt", apellido, nombre, puntos, nip);
		}
	
		//p = new Persona(nombre, apellido, nip);
		//p.mostrarDatos(longitudLinea);

	}
	
	
	private static void formatearLinea (String linea, int longitudLinea) {
	
		Persona p;
		String nombre="", apellido="";
			
		int nip;
		
		nip=Integer.parseInt(linea.substring(0,6));  // recibe un String y devuelve numero
		
		
		for (int i=7; i<linea.length(); i++) {			
			if(!linea.substring(i, i+1).equalsIgnoreCase(",")) {
				apellido+=linea.substring(i,i+1);
			}else {
				break;
			}
		}
		
		for (int i=7+apellido.length(); i<linea.length();i++) {
				nombre+=linea.substring(i,i+1);	
			}	
		
		String puntos="";
		
		for (int i=(Integer.toString(nip).length()+nombre.length()+apellido.length()); i<longitudLinea;i++) {
			puntos+=".";
		}	
	
		
		System.out.println(apellido + nombre + puntos + " " +nip);
		
		//Buscar un NIP
		
		
		escribir("alumnos2.txt", apellido, nombre, puntos, nip);
		//p = new Persona(nombre, apellido, nip);
		//p.mostrarDatos(longitudLinea);

	}

	
	private static void escribir (String nomfichero, String apellido, String nombre, String puntos, int nip) {
		
		String f=nomfichero;
		File fichero = new File(f);
		
		if (!fichero.exists()) {
			try {
				fichero.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
		try (FileWriter fw = new FileWriter(fichero,true);
				PrintWriter pw = new PrintWriter(fw)){
			
			pw.println(apellido + nombre + puntos + " " +nip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void buscar (int numero) {
		
		File f =new File("alumnos.txt");
		FileReader fr = null;
		Scanner leer = null;
		
		if(!f.exists()) {								// comprobar si existe. Si no existe crea uno 
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}/*else {
			System.out.println("el fichero existe");   	//podriamos borralo, solo era para comprobar
		}*/  
		
		try {
			fr = new FileReader(f);						// primero FileReader sobre el fichero "f"
			leer=new Scanner(fr);						// montamos Scanner sobre FileReader "fr"
			
			while (leer.hasNext()) { 					// para leer el fichero de forma secuencial (hasta EOF)
				String linea=leer.nextLine();			// guarda en LINEA lo que va leyendo
				formatearLineaBusqueda(linea, 50, numero);	// para mostrar como queramos
				
				
				/* System.out.println(linea);			// esta leyendo bien las lineas */
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		
		}finally {
			leer.close();								// cerramos el Scanner y FileReader
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
			
		
		
		
		
	}
	
	
	
}
			


