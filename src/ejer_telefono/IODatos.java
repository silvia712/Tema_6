package ejer_telefono;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IODatos {
	
	
	public static void leer(String nombreFichero) {
			
		File f= new File(nombreFichero);
		FileReader fr =null;
		Scanner leer=null;
		
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				}
			}
			
		try {
			fr=new FileReader(f);
			leer=new Scanner(fr);
			
			while (leer.hasNext()) {
				String linea=leer.nextLine();
				formatearLinea(linea);
			}
			
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}finally {
			
			leer.close();
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void formatearLinea (String linea) {
		
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
	
		
		File w =new File ("whatsapp.txt");
		PrintWriter pw=null;
		
		
		if (!w.exists()) {
			try {
				w.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			pw= new PrintWriter(new FileWriter(w,true));
			pw.println(nombre + ":" + mensaje);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			pw.close();
		}
	}
	
		
		
		
		
		
	
	
	
	
	
}

