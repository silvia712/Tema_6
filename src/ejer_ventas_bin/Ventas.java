package ejer_ventas_bin;


public class Ventas {

	private String nombre_cliente;
	private int cod_producto;
	private int unidades_vendidas;
	private double precio_unidad;
	
	public Ventas(String nombre_cliente, int cod_producto, int unidades_vendidas, double precio_unidad) {
		this.nombre_cliente = nombre_cliente;
		this.cod_producto = cod_producto;
		this.unidades_vendidas = unidades_vendidas;
		this.precio_unidad = precio_unidad;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public int getCod_producto() {
		return cod_producto;
	}

	public void setCod_producto(int cod_producto) {
		this.cod_producto = cod_producto;
	}

	public int getUnidades_vendidas() {
		return unidades_vendidas;
	}

	public void setUnidades_vendidas(int unidades_vendidas) {
		this.unidades_vendidas = unidades_vendidas;
	}

	public double getPrecio_unidad() {
		return precio_unidad;
	}

	public void setPrecio_unidad(double precio_unidad) {
		this.precio_unidad = precio_unidad;
	}

	@Override
	public String toString() {
		return "nombre_cliente = " + nombre_cliente + ", cod_producto = " + cod_producto + ", unidades_vendidas = "
				+ unidades_vendidas + ", precio_unidad = " + precio_unidad ;
	}
	
		

	
	
}
