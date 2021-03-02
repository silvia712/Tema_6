package ejer_agente;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import ejer_contrasena_bin_objeto.Password;

public class IODAt {

	
	public static void pinta_menu() {
		
		System.out.println("\nMenu principal. Pulse la opcion deseada\n");
		System.out.println("1-Ver todos los agentes");
		System.out.println("2-Ver agentes por salario");
		System.out.println("3-Alta nuevo piso");
		System.out.println("4-Alta nueva arma");
		System.out.println("5-Alta nuevo agente");
		System.out.println("6-Encriptar informacion");
		System.out.println("7-Desencriptar informacion");
		System.out.println("8-Salir");
	}
	
	
	public static void ver_agentes(Agente vAgentes[]) {  
		
		for (int i=0;i<vAgentes.length;i++) {
			if(vAgentes[i]!=null) {
				System.out.println(vAgentes[i]);
			}
		}
	}
		
	
	public static void salario_agentes(Agente vAgentes[]) { 
		
		System.out.println("Introduce el salario minimo");
		Scanner leer=new Scanner(System.in);
		float cantidad =leer.nextFloat();
		float maximo=0;
		
		
		for(int i=0;i<vAgentes.length;i++) {
			if((vAgentes[i]!=null) && (vAgentes[i]).getSalario()>=maximo) {
				maximo=vAgentes[i].getSalario();
			}
		}
		
		for (int i=0;i<vAgentes.length;i++) {
			if((vAgentes[i]!=null) && (cantidad<=vAgentes[i].getSalario())) {
				System.out.println(vAgentes[i]);
			}else if ((vAgentes[i]!=null) && (cantidad>maximo)){
				System.out.println("no hay agentes para el salario indicado");
				break;
			}
		}	
	}
		
		
	
	
	
	
	public static void nuevaArmasoPiso (String ruta) { 
		
		Scanner leer=new Scanner(System.in);
		
		File f = new File(ruta);
		
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		 
		try (FileWriter fw = new FileWriter(f,true);PrintWriter pw = new PrintWriter(fw) ){
		
			String dato;
			
			if (ruta.equalsIgnoreCase("ficheros/pisos.txt")) {
				System.out.println("Dime el piso para guardar");
				dato = leer.nextLine();
				pw.println(dato);
			}else {
				System.out.println("Dime el arma para guardar");
				dato = leer.nextLine();
				pw.println(dato);
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}	

	
	public static String[] cargarDatosTexto(String nombreFichero) {
		
		String vItems[]=new String [20];
		int cont = 0;
		String ruta ="ficheros/" + nombreFichero;
		
		File f = new File(ruta);
		  
		if(!f.exists()) {
			  
			 try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		  }
		
		FileReader fr = null;
		Scanner leer =null;
		
			try {
				fr= new FileReader(f);
				leer=new Scanner(fr);
				 
				while (leer.hasNext()) {
					vItems[cont]=leer.nextLine();
					cont++;
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					fr.close();
					leer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return vItems;
	}
	

		
	public static String encriptar(Agente vAgentes[]) {
		
		String info="ficheros/info.dat";
		File f =new File(info);
		
		if (!f.exists()){
			try {
				f.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		FileOutputStream fo = null;
		ObjectOutputStream escribir = null;
						
		
		try {
			fo = new FileOutputStream(f);
			escribir = new ObjectOutputStream(fo);
			
			 for (int i=0;i<vAgentes.length;i++) {
				 if(vAgentes[i]!=null) {
					 escribir.writeObject(vAgentes);
				 }
			 }
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return info;
		}
		
	
	
	public static void desencriptar(String info ) {
		
		Agente vAgen[]=new Agente[20];
		
		File f =new File(info);
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		FileInputStream fi=null;
		ObjectInputStream leer=null;
		
		try {
			fi=new FileInputStream(info);
			leer=new ObjectInputStream(fi);
			
			vAgen=(Agente[]) leer.readObject();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Agente a : vAgen) {
			if(a!=null) {
				System.out.println(a);
			}
			
		}
		
	}
		
	}
	
		
	

		
	
	
	
	

	

