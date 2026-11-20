//IAG (herramienta: Claude)
//SIN CAMBIOS
package GUI;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Descarga el póster de cada película de peliculas.csv usando la API de TMDB.
 * Resultado: resources/images/posters/1.jpg, 2.jpg, ... (el número es el id de la película)
 *
 * Necesita una API key gratuita de TMDB: https://www.themoviedb.org/settings/api
 * Solo hay que ejecutarlo UNA vez. Si se vuelve a ejecutar, se salta los pósters que ya existen.
 */
public class DescargarPosters {

	// Pega aquí tu API key (la "API Key", no el "Read Access Token"). ¡No la subas a GitHub!
	static final String API_KEY = "6bb1c0f7f7fdab8c228b3ec25b29585c";

	static final String RUTA_CSV = "resources/data/peliculas.csv";
	static final String CARPETA = "resources/images/posters";
	static final String TAMANO = "w342"; // w185, w342, w500 u original

	static final HttpClient http = HttpClient.newHttpClient();
	static final Pattern POSTER = Pattern.compile("\"poster_path\"\\s*:\\s*\"([^\"]+)\"");

	public static void main(String[] args) throws IOException, InterruptedException {
		if (API_KEY.startsWith("PEGA_AQUI")) {
			System.out.println("Primero pon tu API key de TMDB en la constante API_KEY.");
			return;
		}

		List<String> lineas = Files.readAllLines(Paths.get(RUTA_CSV), StandardCharsets.UTF_8);
		Files.createDirectories(Paths.get(CARPETA));

		int ok = 0, yaExistian = 0;
		StringBuilder fallos = new StringBuilder();

		for (String linea : lineas.subList(1, lineas.size())) {
			// id;nombre;descripcion;director;actores;año;...
			String[] datos = linea.split(";");
			String id = datos[0];
			String nombre = datos[1];
			String anio = datos[5];
			Path destino = Paths.get(CARPETA, id + ".jpg");

			if (Files.exists(destino)) {
				yaExistian++;
				continue;
			}

			try {
				// Primero con el año (más preciso); si no hay resultado, sin año
				String poster = buscarPoster(nombre, anio);
				if (poster == null) poster = buscarPoster(nombre, null);
				if (poster == null) poster = buscarPoster(nombre.replaceAll("\\s*\\(.*?\\)", ""), anio);

				if (poster == null) {
					fallos.append("  ").append(id).append(" - ").append(nombre).append("\n");
				} else {
					descargar("https://image.tmdb.org/t/p/" + TAMANO + poster, destino);
					ok++;
					System.out.println("OK  " + id + " - " + nombre);
				}
			} catch (IOException e) {
				fallos.append("  ").append(id).append(" - ").append(nombre)
						.append(" (").append(e.getMessage()).append(")\n");
			}

			Thread.sleep(50); // no saturar la API
		}

		System.out.println("\nDescargados: " + ok + " | Ya existían: " + yaExistian);
		if (fallos.length() > 0) {
			System.out.println("Sin póster (usa una imagen por defecto para estas):\n" + fallos);
		}
	}

	/** Busca la película en TMDB y devuelve su poster_path, o null si no lo encuentra. */
	static String buscarPoster(String nombre, String anio) throws IOException, InterruptedException {
		String url = "https://api.themoviedb.org/3/search/movie"
				+ "?api_key=" + API_KEY
				+ "&query=" + URLEncoder.encode(nombre, StandardCharsets.UTF_8)
				+ (anio != null ? "&year=" + anio : "");

		HttpResponse<String> resp = http.send(
				HttpRequest.newBuilder(URI.create(url)).GET().build(),
				HttpResponse.BodyHandlers.ofString());

		if (resp.statusCode() == 401) throw new IOException("API key no válida");
		if (resp.statusCode() != 200) throw new IOException("HTTP " + resp.statusCode());

		Matcher m = POSTER.matcher(resp.body());
		return m.find() ? m.group(1) : null;
	}

	static void descargar(String url, Path destino) throws IOException, InterruptedException {
		HttpResponse<byte[]> resp = http.send(
				HttpRequest.newBuilder(URI.create(url)).GET().build(),
				HttpResponse.BodyHandlers.ofByteArray());
		if (resp.statusCode() != 200) throw new IOException("HTTP " + resp.statusCode() + " al bajar la imagen");
		Files.write(destino, resp.body());
	}
}