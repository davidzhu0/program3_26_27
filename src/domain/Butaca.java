package domain;

public class Butaca {
	private Sala sala;
	private int fila;
	private int numero;

	public Butaca(Sala sala, int fila, int numero) {
		super();
		this.sala = sala;
		this.fila = fila;
		this.numero = numero;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Butaca [sala=" + sala.getNumero() + ", fila=" + fila + ", numero=" + numero + "]";
	}
}
