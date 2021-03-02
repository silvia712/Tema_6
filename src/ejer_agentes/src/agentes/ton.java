package agentes;

import IODatos.IODatos;

public class ton {

	
	/**
	 * Recibe la ruta de un archivo y restaura varios ficheros contenidos en �l.
	 * @param vRutas Vector con las rutas de los archivos que se restaurar�n.
	 * @param vAgentes Vector donde se guardar�n los datos de tipo Agente.
	 * @param vArmas Vector donde se guardar�n las armas en formato String.
	 * @param vPisos Vector donde se guardar�n los pisos en formato String.
	 */
	
	/**
	 * Guarda en un fichero .dat la informaci�n de los vectores recibidos.
	 * @param ruta La ruta del fichero donde se guardar� la informaci�n.
	 * @param vAgentes Vector de objetos de clase Agente.
	 * @param vArmas Vector de armas en formato String.
	 * @param vPisos Vector de pisos en formato String.
	 */
	
	
	
	
	
	private String[] vArmas;
	private int muertes;

	/**
	 * Instancia un objeto de clase A007 con los datos especificados. vArmas se rellena autom�ticamente con la informaci�n del fichero correspondiente.
	 * @param nombre El nombre propio del agente.
	 * @param edad La edad del agente.
	 * @param direccion La direcci�n postal del agente.
	 * @param salario El salario que cobra el agente.
	 * @param muertes El n�mero de bajas realizadas por el agente.
	 */
	public A007(String nombre, int edad, String direccion, float salario, int muertes) {
		super(nombre, edad, direccion, salario);
		this.vArmas = IODatos.cargarDatosTexto("Armas.txt");
		this.muertes = muertes;
	}

	/**
	 * Genera un String con la lista de armas de las que dispone el agente, separadas por comas.
	 * @return String con todas las armas separadas por comas.
	 */
	private String todasArmas() {
	
		String todasArmas = "";
	
		for (int i = 0; i < vArmas.length; i++) {
			if (vArmas[i] != null) {
				todasArmas += vArmas[i];
			}
			if (i < vArmas.length - 1 && vArmas[i + 1] != null)
				todasArmas += ", ";
		}
		
		return todasArmas;
	}

	
//	GETTERS Y SETTERS
	public String[] getArmas() {
		return vArmas;
	}

	public void setArmas(String[] armas) {
		this.vArmas = armas;
	}

	public int getMuertes() {
		return muertes;
	}

	public void setMuertes(int muertes) {
		this.muertes = muertes;
	}

	@Override
	public String toString() {
		return super.toString() + "\n  N�mero de bajas: ".toUpperCase() + muertes + "\n  Armas: ".toUpperCase() + todasArmas();
	}
	
	
	
	
	
	
	
	
	
}
