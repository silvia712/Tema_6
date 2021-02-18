package ficheros_binarios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ficheros_binarios {

	public static void main(String[] args) {
	

		
	// 1 - CREAMOS el fichero con su ruta	
	
		File binario =new File("binario.dat");   //.dat es el nombre de extension que queramos darle
		
	
		
	// 2 - COMPROBAMOS si existe o no . Si no existe, crea uno.
		
		if (!binario.exists()) {
			try {
				binario.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();	
				System.out.println("no se puede crear el fichero");
			}
		}
		
		
		
	// 3 - ESCRIBIMOS en el fichero con FileOutputStream y DataOutputStream
		
		FileOutputStream fo = null;
		DataOutputStream escribir = null;
		
		try   /* (FileOutputStream fo = new FileOutputStream(binario,true); 		// Se pueden cerrar aqui
				DataOutputStream escribir = new DataOutputStream(fo));*/ {     	
			      
			 fo = new FileOutputStream(binario,true);		// FileOutputStream fo = new FileOutputStream(binario,true);
			 escribir = new DataOutputStream(fo);			// DataOutputStream escribir = new DataOutputStream(fo);
			 														//	Tambien se pueden cerrar asi
			 escribir.writeInt(3);
			 escribir.writeUTF("Silvia Montanes");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}finally {											// tenemos que cerrar el fichero al acabar de leer y escribir
			try {
				fo.close();
				escribir.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
		
	// 4 - LEEMOS el fichero con FileInputStream y DataInputStream
		
		
		try {
			FileInputStream fi = new FileInputStream(binario);
			DataInputStream leer = new DataInputStream(fi);
			
			while(true) {
				System.out.println(leer.readInt());   	 // lee el tamanyo de bits (4 en int)
				System.out.println(leer.readUTF());		// UTF para String
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
