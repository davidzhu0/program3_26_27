package domain;

import java.util.ArrayList;
import java.util.List;

public class Sala {
	private int numero;
	private int filas;
	private int butacasPorFila;
	private List<Butaca> butacas;

	public Sala() {
		super();
		this.butacas = new ArrayList<>();
	}

	public Sala(int numero, int filas, int butacasPorFila) {
		super();
		this.numero = numero;
		this.filas = filas;
		this.butacasPorFila = butacasPorFila;
		this.butacas = new ArrayList<>();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getFilas() {
		return filas;
	}

	public void setFilas(int filas) {
		this.filas = filas;
	}

	public int getButacasPorFila() {
		return butacasPorFila;
	}

	public void setButacasPorFila(int butacasPorFila) {
		this.butacasPorFila = butacasPorFila;
	}

	public List<Butaca> getButacas() {
		return butacas;
	}

	public void setButacas(List<Butaca> butacas) {
		this.butacas = butacas;
	}

	@Override
	public String toString() {
		return "Sala [numero=" + numero + ", filas=" + filas + ", butacasPorFila=" + butacasPorFila
				+ ", butacas=" + butacas.size() + "]";
	}
}