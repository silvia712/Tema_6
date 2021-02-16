package ejer_contraseña;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IODatos_c {

	
	public static void guardar_datos (Password vector[]) {
		
		File f =new File("datos.dat");
		
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		
		
		try {
			FileOutputStream fo = new FileOutputStream(f,true);
			DataOutputStream escribir =new DataOutputStream(fo);
			
			for (Password p : vector) {
				
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
	
	
	
}
