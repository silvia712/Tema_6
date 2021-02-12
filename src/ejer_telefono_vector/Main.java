package ejer_telefono_vector;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Mensaje vMensajes[]=IODatos.leerFichero("telegram.txt");
		
		for (Mensaje mensaje : vMensajes) {
			if (mensaje!=null) {
				System.out.println(mensaje.toString());
			}
		}
		IODatos.escribir_fichero(vMensajes);
		
	}

}
