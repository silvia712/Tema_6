package ejer_ventas_bin;

public class Ventas {

	private String nombre_cliente;
	private int cod_producto;
	private int u_ventas;
	private double precio_u;
	
		
	public Ventas(String nombre_cliente, int cod_producto, int u_ventas, double precio_u) {
		super();
		this.nombre_cliente = nombre_cliente;
		this.cod_producto = cod_producto;
		this.u_ventas = u_ventas;
		this.precio_u = precio_u;
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
	public int getU_ventas() {
		return u_ventas;
	}
	public void setU_ventas(int u_ventas) {
		this.u_ventas = u_ventas;
	}
	public double getPrecio_u() {
		return precio_u;
	}
	public void setPrecio_u(double precio_u) {
		this.precio_u = precio_u;
	}


	@Override
	public String toString() {
		return "Ventas [nombre_cliente=" + nombre_cliente + ", cod_producto=" + cod_producto + ", u_ventas=" + u_ventas
				+ ", precio_u=" + precio_u + "]";
	}
	
	
	
	
}
