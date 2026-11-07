package domain;

import java.util.List;

public class Pelicula {
	private String id;
	private String nombre;
	private String descripcion;
	private String director;
	private List<String> actores;
	private int año;
	private String productora;
	private int edadMinima;
	private float presupuesto;
	private String genero;
	private double puntuacion;
	
	
	
	
	
	public Pelicula() {
		super();
	}

	public Pelicula(String id, String nombre, String descripcion, String director, List<String> actores, int año,
			String productora, int edadMinima, float presupuesto, String genero, double puntuacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.director = director;
		this.actores = actores;
		this.año = año;
		this.productora = productora;
		this.edadMinima = edadMinima;
		this.presupuesto = presupuesto;
		this.genero = genero;
		this.puntuacion = puntuacion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public List<String> getActores() {
		return actores;
	}

	public void setActores(List<String> actores) {
		this.actores = actores;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public String getProductora() {
		return productora;
	}

	public void setProductora(String productora) {
		this.productora = productora;
	}

	public int getEdadMinima() {
		return edadMinima;
	}

	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
	}

	public float getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(float presupuesto) {
		this.presupuesto = presupuesto;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public double getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	
	
	
	
	
}
