package domain;

public class Sesion {
	private Pelicula pelicula;
	private String fecha;
	private String hora;
	private double precio;
	public Sesion(Pelicula pelicula, String fecha, String hora, double precio) {
		super();
		this.pelicula = pelicula;
		this.fecha = fecha;
		this.hora = hora;
		this.precio = precio;
	}
	public Pelicula getPelicula() {
		return pelicula;
	}
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
}
