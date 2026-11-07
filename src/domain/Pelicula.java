package domain;

import java.util.ArrayList;
import java.util.List;

public class Pelicula {
	private String id;
	private String nombre;
	private String descripcion;
	private String director;
	private List<Actor> actores;
	private int año;
	private int duracion;          // minutos
	private int edadMinima;
	private String genero;
	private double puntuacion;     // 0-5
	private double popularidad;
	private List<Resena> resenas;

	public Pelicula() {
		super();
		this.actores = new ArrayList<>();
		this.resenas = new ArrayList<>();
	}

	public Pelicula(String id, String nombre, String descripcion, String director, List<Actor> actores, int año,
			int duracion, int edadMinima, String genero, double puntuacion, double popularidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.director = director;
		this.actores = actores;
		this.año = año;
		this.duracion = duracion;
		this.edadMinima = edadMinima;
		this.genero = genero;
		this.puntuacion = puntuacion;
		this.popularidad = popularidad;
		this.resenas = new ArrayList<>();
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

	public List<Actor> getActores() {
		return actores;
	}

	public void setActores(List<Actor> actores) {
		this.actores = actores;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public int getEdadMinima() {
		return edadMinima;
	}

	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
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

	public double getPopularidad() {
		return popularidad;
	}

	public void setPopularidad(double popularidad) {
		this.popularidad = popularidad;
	}

	public List<Resena> getResenas() {
		return resenas;
	}

	public void setResenas(List<Resena> resenas) {
		this.resenas = resenas;
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", nombre=" + nombre + ", director=" + director + ", año=" + año
				+ ", duracion=" + duracion + ", edadMinima=" + edadMinima + ", genero=" + genero
				+ ", puntuacion=" + puntuacion + ", popularidad=" + popularidad + "]";
	}
}