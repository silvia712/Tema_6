package ejer_alumnos_vector;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;



public class IODatos {

	
	public static Persona[] cargarDatos(String nombreFichero, int longitudLinea) {
		
		File f =new File(nombreFichero);
		FileReader fr = null;
		Scanner leer = null;
		Persona vPersonas[] = new Persona[20];
		int cont=0;
		
		if(!f.exists()) {								
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			fr = new FileReader(f);						// primero FileReader sobre el fichero "f"
			leer=new Scanner(fr);						// montamos Scanner sobre FileReader "fr"
			
			while (leer.hasNext()) { 					// para leer el fichero de forma secuencial (hasta EOF)
				String linea=leer.nextLine();			// guarda en LINEA lo que va leyendo
				vPersonas[cont] = formatearLinea(linea, longitudLinea);	// para mostrar como queramos
				cont++;
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
		
		return vPersonas;
		
	}
	
	private static Persona formatearLinea (String linea, int longitudLinea) {
		
			Persona p;
			String nombre="", apellido="";
				
			int nip;
			
			nip=Integer.parseInt(linea.substring(0,6));  
			
			
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
		
					
			p = new Persona(nombre, apellido, nip);
		
		return p;
		//p.mostrarDatos(longitudLinea);

	}
	
	
	
}
