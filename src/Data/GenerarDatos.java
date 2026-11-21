package Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import domain.Pelicula;
import domain.Sala;
import domain.Sesion;

public class GenerarDatos {

	private static LocalDate inicio = LocalDate.of(2026, 1, 5);
	private static int maxnum = 10;
	private static LocalTime[] horarios = { LocalTime.of(12, 0), LocalTime.of(17, 0), LocalTime.of(22, 0) };
	private static double precio = 5.50;
	private static long semilla = 42;

	public static List<Sala> crearSalas() {
		List<Sala> salas = new ArrayList<>();

		Sala sala1 = new Sala(1, 16, 20);
		Sala sala2 = new Sala(2, 16, 20);

		Sala sala3 = new Sala(3, 13, 18);
		Sala sala4 = new Sala(4, 13, 18);
		Sala sala5 = new Sala(5, 13, 18);
		Sala sala6 = new Sala(6, 13, 18);

		Sala sala7 = new Sala(7, 10, 12);
		Sala sala8 = new Sala(8, 10, 12);
		Sala sala9 = new Sala(9, 10, 12);
		Sala sala10 = new Sala(10, 10, 12);
		Sala sala11 = new Sala(11, 10, 12);
		Sala sala12 = new Sala(12, 10, 12);

		salas.add(sala1);
		salas.add(sala2);
		salas.add(sala3);
		salas.add(sala4);
		salas.add(sala5);
		salas.add(sala6);
		salas.add(sala7);
		salas.add(sala8);
		salas.add(sala9);
		salas.add(sala10);
		salas.add(sala11);
		salas.add(sala12);

		return salas;
	}

	public static int numeroSemana(LocalDate fecha) {
		return (int) (ChronoUnit.DAYS.between(inicio, fecha) / 7);
	}

	public static LocalDate inicioSemana(int semana) {
		return inicio.plusWeeks(semana);
	}

	public static List<Pelicula> peliculasDeLaSemana(List<Pelicula> todas, int semana) {
		Random random = new Random(semilla);
		List<Pelicula> yaSalieron = new ArrayList<>();
		List<Pelicula> cartelera = new ArrayList<>();

		for (int s = 0; s <= semana; s++) {
			cartelera = new ArrayList<>();

			while (cartelera.size() < maxnum && cartelera.size() < todas.size()) {
				if (yaSalieron.size() == todas.size()) {
					yaSalieron.clear();
				}

				Pelicula p = todas.get(random.nextInt(todas.size()));

				if (!yaSalieron.contains(p) && !cartelera.contains(p)) {
					yaSalieron.add(p);
					cartelera.add(p);
				}
			}
		}
		return cartelera;
	}

	public static List<Sesion> generarSesiones(List<Pelicula> peliculas, List<Sala> salas, LocalDate hoy, int semanas) {
		List<Sesion> sesiones = new ArrayList<>();
		int primeraSemana = Math.max(0, numeroSemana(hoy));

		for (int semana = primeraSemana; semana < primeraSemana + semanas; semana++) {
			List<Pelicula> cartelera = peliculasDeLaSemana(peliculas, semana);
			LocalDate inicio = inicioSemana(semana);
			Random random = new Random(semilla + semana);

			for (int dia = 0; dia < 7; dia++) {
				LocalDate fecha = inicio.plusDays(dia);

				for (LocalTime hora : horarios) {
					List<Sala> salasLibres = new ArrayList<>(salas);

					for (int i = 0; i < cartelera.size(); i++) {
						int posicion = random.nextInt(salasLibres.size());
						Sala sala = salasLibres.get(posicion);
						salasLibres.remove(posicion);

						Pelicula p = cartelera.get(i);
						String id = fecha + "-S" + sala.getNumero() + "-" + hora;
						sesiones.add(new Sesion(id, p, sala, fecha, hora, precio));
					}
				}
			}
		}
		return sesiones;
	}

	public static List<Pelicula> peliculasEnCartelera(List<Sesion> sesiones, LocalDate hoy) {
		LocalDate inicio = inicioSemana(numeroSemana(hoy));
		LocalDate fin = inicio.plusDays(6);
		List<Pelicula> resultado = new ArrayList<>();
		for (Sesion s : sesiones) {
			if (!s.getFecha().isBefore(inicio) && !s.getFecha().isAfter(fin) && !resultado.contains(s.getPelicula())) {
				resultado.add(s.getPelicula());
			}
		}
		return resultado;
	}
}