package domain;

import java.util.ArrayList;
import java.util.List;

public class Actor {
	private String nombre;
	private List<Pelicula> peliculas;

	public Actor() {
		super();
		this.peliculas = new ArrayList<>();
	}

	public Actor(String nombre) {
		super();
		this.nombre = nombre;
		this.peliculas = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	@Override
	public String toString() {
		return "Actor [nombre=" + nombre + ", peliculas=" + peliculas.size() + "]";
	}
}