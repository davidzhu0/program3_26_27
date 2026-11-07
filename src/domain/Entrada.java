package domain;

public class Entrada {
	private Usuario usuario;
	private Sesion sesion;
	private Butaca butaca;
	private float precio;
	public Entrada(Usuario usuario, Sesion sesion, Butaca butaca, float precio) {
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
	public float getPrecio() {
		return precio;
	}
	@Override
	public String toString() {
		return "Entrada [usuario=" + usuario + ", sesion=" + sesion + ", butaca=" + butaca + ", precio=" + precio + "]";
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	

}
