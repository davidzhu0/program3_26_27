package domain;

public class Sala {
	private int numero;
	private int butacas;
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getButacas() {
		return butacas;
	}
	public void setButacas(int butacas) {
		this.butacas = butacas;
	}
	public Sala(int numero, int butacas) {
		super();
		this.numero = numero;
		this.butacas = butacas;
	}
	

}
