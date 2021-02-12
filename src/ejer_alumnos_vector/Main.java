package ejer_alumnos_vector;

public class Main {

	public static void main(String[] args) {
	
		Persona vPersonas[] = IODatos.cargarDatos("alumnos.txt", 50);
		
		for (Persona persona : vPersonas) {
			if(persona!=null)
				System.out.println(persona.mostrarConFormato(50));
		}

		
		for (Persona persona : vPersonas) {
			if(persona!=null && persona.getNip()==657858)
				System.out.println(persona.mostrarConFormato(50));
				
		}
		
	}

}
