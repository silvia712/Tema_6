package ejer_contraseña;

public class Main_c {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Password vContraseña[]= new Password[10];
		
		vContraseña[0]= new Password("silvia",3,false);
		vContraseña[1]= new Password("ivan",2578,true);
	
		IODatos_c.guardar_datos(vContraseña);
		
		
	}

}
