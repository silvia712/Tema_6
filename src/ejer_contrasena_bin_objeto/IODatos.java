package ejer_contrasena_bin_objeto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IODatos {

	
	public static void guardar_en_fichero_objetos(Password vContrasena[], String fichero2) {
				
				//String fichero2 ="contrasena.dat";
				File f = new File(fichero2);
				
				if(!f.exists()) {
					try {
						f.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				FileOutputStream fo = null;
				ObjectOutputStream escribir = null;
						
				
				try {
					fo = new FileOutputStream(f);
					escribir = new ObjectOutputStream(fo);
					
					for (Password p : vContrasena) {					// esta opcion escribe el Objeto
						if(p!=null) {
							escribir.writeObject(p);  					
						}
					}
					
					/* for (Password p : vContrasena) {					// esta opcion escribe el Vector
						if(p!=null) { 					
							escribir.writeObject(vContrasena);        
						}
					} */
					
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
	
	
	
	public static Password[] devolver_objetos_de_fichero(String fichero2) {
		
		Password vPass[] = new Password [5];
		int cont=0;
		
		/*File f = new File(fichero2);
		
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
		FileInputStream fi=null;
		ObjectInputStream leer=null;
		
		try {
			fi=new FileInputStream(fichero2);
			leer=new ObjectInputStream(fi);
			
			/*while(true) {
				vPass[cont] = (Password) leer.readObject();  //casting. While true pq se leeran objetos
				cont++;
			}*/
			
			vPass= (Password[]) leer.readObject();		//sin while true pq se lee un vector.Si hubiera mas vectores
														// seria con while true
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("fin de lectura");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return vPass;
	}
	
	
}
