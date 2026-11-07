package domain;

public class Butaca {
	private String id;
	private int fila;
	private boolean disponible;
	public Butaca(String id, int fila, boolean disponible) {
		super();
		this.id = id;
		this.fila = fila;
		this.disponible = disponible;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		this.fila = fila;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
}
