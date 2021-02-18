package ejer_contrasena_bin;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class IODatos {

	
	public static void guardar_datos (Password vContrasena[]) {    // escribe de vector a fichero (OUT) 
		
			String fichero ="datos.dat";
			File f = new File(fichero);    // File f = File ("datos.dat");
			
			if (!f.exists()) {
				try {
					f.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
			
			try {
				FileOutputStream fo = new FileOutputStream(f);
				DataOutputStream escribir = new DataOutputStream(fo);
				
				for (Password p: vContrasena) {		
					if (p!=null) {
							escribir.writeUTF(p.getUsuario());
							escribir.writeInt(p.getPassword());
							escribir.writeBoolean(p.isSegura());
					}
				}
			
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
	
	
	/*	public static Password[] devolver_datos(String fichero,Password vContrasena) {	// devuelve del fichero al vector (leer - IN)
			
			/*File f =new File(fichero);   
			
			if (!f.exists()) {
				try {
					f.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
			
		
			try {
					FileInputStream	fi = new FileInputStream(fichero);
					DataInputStream leer = new DataInputStream(fi);
					
					while(true) {
						
					   String usuario=leer.readUTF();
					   int password=leer.readInt();
					   boolean seguro=leer.readBoolean();
					}
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("fin del lectura");
			}
			
			return vContrasena;
		}*/
	
	
		
			
		
	}


