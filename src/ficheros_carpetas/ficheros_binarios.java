package ficheros_carpetas;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ficheros_binarios {

	public static void main(String[] args) {
	

		
	// PRIMERO: creamos el fichero con su ruta	
	
		File binario =new File("binario.dat");
		
	
	// SEGUNDO: comprobamos si existe o no . Si no existe, crea uno.
		
		if (!binario.exists()) {
			try {
				binario.createNewFile();
			} catch (IOException e) {
				System.out.println("no se puede crear el fichero");
				//e.printStackTrace();
			}
		}
		
		
		
	// TERCERO: escribimos en el fichero con FileOutputStream y DataOutputStream
		
		
		try   /* (FileOutputStream fo= new FileOutputStream(binario,true); 		tb se puede cerrar aqui
				DataOutputStream escribir =new DataOutputStream(fo));*/ {     	
			      
			
			FileOutputStream fo= new FileOutputStream(binario,true);
			DataOutputStream escribir =new DataOutputStream(fo);
			
			escribir.writeInt(3);
			escribir.writeUTF("Silvia Monta�es");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	// CUARTO: leemos el fichero
		
		
		try {
			FileInputStream fi = new FileInputStream(binario);
			DataInputStream leer = new DataInputStream(fi);
			
			while(true) {
				System.out.println(leer.readInt());   // lee el tamaño de bits (4 en int)
				System.out.println(leer.readUTF());
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("fin de lectura del fichero");
			
		}
		
	
		
		
	}

}
