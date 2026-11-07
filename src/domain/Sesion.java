package domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class Sesion {
	private String id;
	private Pelicula pelicula;
	private Sala sala;
	private LocalDate fecha;
	private LocalTime hora;
	private double precio;

	public Sesion() {
		super();
	}

	public Sesion(String id, Pelicula pelicula, Sala sala, LocalDate fecha, LocalTime hora, double precio) {
		super();
		this.id = id;
		this.pelicula = pelicula;
		this.sala = sala;
		this.fecha = fecha;
		this.hora = hora;
		this.precio = precio;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Sesion [id=" + id + ", pelicula=" + pelicula + ", sala=" + sala + ", fecha=" + fecha + ", hora="
				+ hora + ", precio=" + precio + "]";
	}
}