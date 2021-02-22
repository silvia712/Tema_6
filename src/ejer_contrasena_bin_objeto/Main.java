package ejer_contrasena_bin_objeto;

public class Main {

	private static final String RUTA = "contrasena.dat";  // declarado como constante
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Password vContrasena [] = IODatos.devolver_objetos_de_fichero(RUTA);
		/*vContrasena[0] = new Password("silvia",57, false);
		vContrasena[1] = new Password("ivan",147895, true);*/
		
		
		
		IODatos.guardar_en_fichero_objetos(vContrasena,RUTA);
		
	}

}
