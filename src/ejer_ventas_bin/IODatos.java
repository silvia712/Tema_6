package ejer_ventas_bin;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IODatos {


	public static void escribir_ventas_en_fichero(Ventas vClientes[], String fichero) {
	
		File f = new File (fichero);
		
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		 
		try (FileOutputStream fo = new FileOutputStream(f);
			DataOutputStream escribir=new DataOutputStream(fo);){
			
			for (Ventas v : vClientes) {
				if (v!=null) {
					escribir.writeUTF(v.getNombre_cliente());
					escribir.writeInt(v.getCod_producto());
					escribir.writeInt(v.getUnidades_vendidas());
					escribir.writeFloat((float)v.getPrecio_unidad());     // daba error float. Casting bien hecho ?????
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
	
	
	public static void guardar_objetos(Ventas vClientes[], String fichero) {
		
		File f = new File (fichero);
		
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try (FileOutputStream fo = new FileOutputStream(f);
			ObjectOutputStream escribir=new ObjectOutputStream(fo)){
			
			for (Ventas v : vClientes) {
				if (v!=null) {
					escribir.writeObject(v);
					
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
	
	
		
	
	public static Ventas[] devolver_datos_en_vector(String fichero) {
		
		Ventas vVentas[]=new Ventas[10];
		int contador=0; //posicion 0 del vector
		
		File f= new File(fichero);
		
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		 
		try (FileInputStream fi = new FileInputStream(f);
			 DataInputStream leer=new DataInputStream(fi);){
			
			while (true) {
				String nombre_cliente=leer.readUTF();
				int cod_producto=leer.readInt();
				int unidades_vendidas=leer.readInt();
				float precio_unidad=leer.readFloat();
				
				vVentas[contador]=new Ventas(nombre_cliente, cod_producto, unidades_vendidas, precio_unidad);
				contador++;
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			
		} 
		
		return vVentas;
	}
	
	
	public static Ventas[] cargar_objetos(String fichero) {
		
		Ventas vVentas[]=new Ventas[10];
		int contador=0; //posicion 0 del vector
		
		File f= new File(fichero);
		
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		 
		try (FileInputStream fi = new FileInputStream(f);
			 ObjectInputStream leer=new ObjectInputStream(fi);){
			
			while (true) {
				vVentas[contador]=(Ventas) leer.readObject();
				contador++;
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return vVentas;
	}
	
	
	
	public static void calculo_venta(String cliente, Ventas vVentas[]) {
		
		double total_compra=0;
		
		for (Ventas v : vVentas) {
			if((v!=null) && cliente.equalsIgnoreCase(v.getNombre_cliente())) {
				total_compra=v.getUnidades_vendidas()*v.getPrecio_unidad();
			}
		}System.out.println("Total facturacion de " + cliente + ": " + total_compra);

	}
	
	
	
	
	
	
	/* private static int calcular_clientes_diferentes(Ventas vVentas[]){
	 * 
	 * 		int total=0;
	 * 		String vNombre[]=new String[vVentas.length];
	 * 		
	 * 		
	 * 		for(Venta venta:vVentas){
	 * 			if (venta!=null){
	 * 				for (int i=;i<vNombres.length;i++){
	 * 					if(vNombre[i]!=null){
	 * 						if(!venta.getCliente().equalIgnoreCase(vNombre[i])){
	 * 							break;
	 * 							}
	 * 					}else{
	 * 						total++;
	 * 						vNombres[i]=venta.getCliente();
	 * 						break;
	 * 						}
	 * 			return total;
	 * 							
	 * }
	 * }
	 * 	
	 * 
	 * 
	 */
	
		
	
	
}
