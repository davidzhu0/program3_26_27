package GUI;

import java.util.ArrayList;
import java.util.List;

import domain.Pelicula;
import domain.Sesion;

public class mainGUI {

	public static void main(String[] args) {
		// Cargar películas y reseñas desde los CSV
		LeerCSV lector = new LeerCSV();
		lector.cargarPeliculas("resources/data/peliculas.csv");
		lector.cargarResenas("resources/data/resenas.csv");
		List<Pelicula> peliculas = lector.getPeliculas();

		// Sesiones: de momento vacía (no hay sesiones.csv)
		List<Sesion> sesiones = new ArrayList<>();

		// Abrir la cartelera
		VentanaCartelera v = new VentanaCartelera(peliculas, sesiones);
		v.setVisible(true);
	}
}