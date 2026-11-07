package GUI;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import domain.Pelicula;
import domain.Sala;
import domain.Sesion;

public class mainGUI {

	public static void main(String[] args) {
		// Cargar películas y reseñas desde los CSV
		LeerCSV lector = new LeerCSV();
		lector.cargarPeliculas("resources/data/peliculas.csv");
		lector.cargarResenas("resources/data/resenas.csv");
		List<Pelicula> peliculas = lector.getPeliculas();

		// Sesiones de prueba (hasta que haya sesiones.csv)
				List<Sesion> sesiones = new ArrayList<>();
				Sala sala1 = new Sala(1, 6, 10);
				Sala sala2 = new Sala(2, 5, 8);
				sesiones.add(new Sesion("S1", peliculas.get(0), sala1, LocalDate.now(), LocalTime.of(18, 30), 8.5));
				sesiones.add(new Sesion("S2", peliculas.get(0), sala2, LocalDate.now(), LocalTime.of(22, 0), 9.0));

		// Abrir la cartelera
		VentanaCartelera v = new VentanaCartelera(peliculas, sesiones);
		v.setVisible(true);
	}
}