package ejer_telefono_vector;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IODatos {

	
	public static Mensaje[] leerFichero (String nombreFichero) {
		
		Mensaje vMensaje[]=new Mensaje[20];
		File f=new File(nombreFichero);
		FileReader fr=null;
		Scanner leer=null;
		int cont=0;
			
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
				 String linea=leer.nextLine();
				 vMensaje[cont]=formatear_guardar(linea);
				 cont++;
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
		return vMensaje;
	}
	
	
	private static Mensaje formatear_guardar (String linea) {
				
		String mensaje="";
		String nombre="";
		
		for (int i=0; i<linea.length();i++) {
			if(!linea.substring(i,i+1).equalsIgnoreCase(":")) {
				mensaje+=linea.substring(i,i+1);
			}else {
				break; 
			}
		}
		
		for (int i=0+mensaje.length()+1;i<linea.length();i++) {
			nombre+=linea.substring(i,i+1);		
			}
		
			Mensaje m=new Mensaje(mensaje, nombre);
			
			return m;
			
	}
	
	public static void escribir_fichero(Mensaje[] vMensaje) {
		
		File f =new File ("Whatsapp2.txt");
		
		PrintWriter pw=null;
		FileWriter fw =null;
		
		if (!f.exists()) {
			
			try {
				f.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			
			try {
				pw = new PrintWriter(new FileWriter(f));
				//Recorre vector y guarda mensaje
				for (Mensaje mensaje : vMensaje) {
					if (mensaje!= null) {
						pw.println(mensaje.toString());
					}
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				pw.close();
						
			}
			
		}
		
		
	}
	
	
}
