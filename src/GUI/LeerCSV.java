package GUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import domain.Actor;
import domain.Pelicula;
import domain.Resena;

public class LeerCSV {

	private Map<String, Pelicula> peliculas = new LinkedHashMap<>();   
	private Map<String, Actor> actores = new HashMap<>();        

	//id;nombre;descripcion;director;actores;año;duracion;edadMinima;genero;puntuacion;popularidad
	//actores:Nombre1|Nombre2|...
	public void cargarPeliculas(String ruta) {
		File file = new File(ruta);
		try {
			Scanner sc = new Scanner(file, "UTF-8");
			sc.nextLine(); 
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] datos = linea.split(";");

				Pelicula p = new Pelicula(datos[0], datos[1], datos[2], datos[3], new ArrayList<>(),
						Integer.parseInt(datos[5]), Integer.parseInt(datos[6]), Integer.parseInt(datos[7]),
						datos[8], Double.parseDouble(datos[9]), Double.parseDouble(datos[10]));

				for (String nombre : datos[4].split("\\|")) {
					Actor a = actores.get(nombre);
					if (a == null) {
						a = new Actor(nombre);
						actores.put(nombre, a);
					}
					p.getActores().add(a);
					a.getPeliculas().add(p);
				}

				peliculas.put(p.getId(), p);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.err.println("No se encuentra el fichero: " + ruta);
		}
	}

	//idPelicula;usuario;texto
	public void cargarResenas(String ruta) {
		File file = new File(ruta);
		try {
			Scanner sc = new Scanner(file, "UTF-8");
			sc.nextLine(); 
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] datos = linea.split(";");

				Pelicula p = peliculas.get(datos[0]);
				if (p != null) {
					p.getResenas().add(new Resena(p, datos[1], datos[2]));
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.err.println("No se encuentra el fichero: " + ruta);
		}
	}

	public List<Pelicula> getPeliculas() {
		return new ArrayList<>(peliculas.values());
	}

	public Map<String, Actor> getActores() {
		return actores;
	}
	

public static void main(String[] args) {
	LeerCSV lector = new LeerCSV();
	lector.cargarPeliculas("resources/data/peliculas.csv");
	lector.cargarResenas("resources/data/resenas.csv");

	List<Pelicula> peliculas = lector.getPeliculas();

	// 1. ¿Cuántas se han cargado?
	System.out.println("Películas: " + peliculas.size());
	System.out.println("Actores: " + lector.getActores().size());

	// 2. Primera película con sus datos
	Pelicula p = peliculas.get(0);
	Pelicula p1 = peliculas.get(2);
	System.out.println("\n" + p);
	System.out.println("\n" + p1);

	// 3. Sus actores
	System.out.println("\nActores:");
	for (Actor a : p.getActores()) {
		System.out.println("  " + a.getNombre());
	}

	// 4. Sus reseñas
	System.out.println("\nReseñas (" + p.getResenas().size() + "):");
	for (Resena r : p.getResenas()) {
		System.out.println("  " + r.getUsuario() + ": " + r.getTexto());
	}

	// 5. Un actor con todas sus películas
	Actor tom = lector.getActores().get("Tom Hanks");
	System.out.println("\nPelículas de Tom Hanks:");
	for (Pelicula peli : tom.getPeliculas()) {
		System.out.println("  " + peli.getNombre());
	}
}
}