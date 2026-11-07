package domain;

import java.nio.BufferUnderflowException;

public class Entrada {
	private Usuario usuario;
	private Sesion sesion;
	private Butaca butaca;
	private int precio;
	public Entrada(Usuario usuario, Sesion sesion, Butaca butaca, int precio) {
		super();
		this.usuario = usuario;
		this.sesion = sesion;
		this.butaca = butaca;
		this.precio = precio;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Sesion getSesion() {
		return sesion;
	}
	public void setSesion(Sesion sesion) {
		this.sesion = sesion;
	}
	public Butaca getButaca() {
		return butaca;
	}
	public void setButaca(Butaca butaca) {
		this.butaca = butaca;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	

}
