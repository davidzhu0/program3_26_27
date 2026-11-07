//IAG (herramienta: Claude)
//SIN CAMBIOS
package domain;

public class Resena {
	private Pelicula pelicula;
	private String usuario;
	private String texto;

	public Resena() {
		super();
	}

	public Resena(Pelicula pelicula, String usuario, String texto) {
		super();
		this.pelicula = pelicula;
		this.usuario = usuario;
		this.texto = texto;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "Reseña [pelicula=" + pelicula.getNombre() + ", usuario=" + usuario + ", texto=" + texto + "]";
	}
}