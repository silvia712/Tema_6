package ejer_telefono_vector;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class IODatos {

	public static void leerFichero (String nombreFichero) {
		
		Mensaje vMensaje[]=new Mensaje[10];
		File f=new File(nombreFichero);
		FileReader fr=null;
		Scanner leer=null;
			
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			fr=new FileReader(f);
			leer=new Scanner (fr);
			
			 while(leer.hasNext()) {
				 String linea=leer.next();
				 formatear_guardar(linea);
				 // como guardo en el vector?
			 }
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			leer.close();
		}
	}
	
	private static Mensaje formatear_guardar (String linea) {
				
		String mens="";
		String nomb="";
		
		for (int i=0; i<linea.length();i++) {
			if(!linea.substring(i,i+1).equalsIgnoreCase(":")) {
				mens+=linea.substring(i,i+1);
			}else {
				break; //esto no lo entiendo
			}
		}
		
		for (int i=0+mens.length()+1;i<linea.length();i++) {
			nomb+=linea.substring(i,i+1);		
			}
		
			Mensaje m=new Mensaje(mens, nomb);
			return m;
			
	} 
	
	
}
