package main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import Data.GenerarDatos;
import Data.LeerCSV;
import GUI.VentanaCartelera;
import domain.Pelicula;
import domain.Sala;
import domain.Sesion;

public class main {

	public static void main(String[] args) {
		
		LeerCSV lector = new LeerCSV();
		lector.cargarPeliculas("resources/data/peliculas.csv");
		lector.cargarResenas("resources/data/resenas.csv");
		List<Pelicula> peliculas = lector.getPeliculas();

		List<Sala> salas = GenerarDatos.crearSalas();
		List<Sesion> sesiones = GenerarDatos.generarSesiones(peliculas, salas, LocalDate.now(), 2);
		List<Pelicula> cartelera = GenerarDatos.peliculasEnCartelera(sesiones, LocalDate.now());

		VentanaCartelera v = new VentanaCartelera(cartelera, sesiones);
		v.setVisible(true);

	}
}