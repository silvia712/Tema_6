package ejer_cifrado;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IODatos_cif {

	
	public static void leer(String cifrado) {
		
		File f = new File (cifrado);
	
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
			FileReader fr=null;
			Scanner leer=null;
		
			
			try {
				fr=new FileReader(f);
				leer=new Scanner(fr);
				
				while (leer.hasNext()) {
					String linea=leer.nextLine();
					formatear(linea);
	
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}finally {
				try {
					fr.close();
					leer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
	}
	
	
	private static void formatear(String linea) {
		
		String mensaje="", simbolos=",. ";
		String abecedario="abcdefghijklmnñopqrstuvwxyz";
		
		
		for (int i=0;i<linea.length();i++) {
			if (linea.substring(i,i+1).equalsIgnoreCase(" ")) {
				mensaje+=" ";
			}
			
			for (int j=0;j<abecedario.length();j++) {
				if ( (linea.substring(i,i+1).equalsIgnoreCase(abecedario.substring(j,j+1))) && (j>=7) ){
						mensaje+=abecedario.substring(j-7,j-6);
					}else if ( (linea.substring(i,i+1).equalsIgnoreCase(abecedario.substring(j,j+1))) && (j<7) ){
						mensaje+=abecedario.substring(j+20,j+21);
							}
						}
					}System.out.println(mensaje);
					
		
		File a =new File("descifrado.txt");
		PrintWriter pw=null;
		
		
		if (!a.exists()) {
			try {
				a.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			pw=new PrintWriter(new FileWriter(a,true));
			pw.println(mensaje);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			pw.close();
		}
	}
					

}
			

	
	
	

