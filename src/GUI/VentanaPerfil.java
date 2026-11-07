package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import domain.Usuario;

public class VentanaPerfil extends JFrame {

	private static final long serialVersionUID = 1L;

	private VentanaCartelera cartelera;
	private Usuario usuario;

	public VentanaPerfil(VentanaCartelera cartelera, Usuario usuario) {
		this.cartelera = cartelera;
		this.usuario = usuario;

		setTitle("Cine - Mi perfil");
		setSize(950, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		add(crearBarraSuperior(), BorderLayout.NORTH);

		JPanel pContenido = new JPanel(new BorderLayout(30, 0));
		pContenido.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
		pContenido.add(crearPanelPerfil(), BorderLayout.WEST);
		pContenido.add(crearPanelDerecho(), BorderLayout.CENTER);
		add(pContenido, BorderLayout.CENTER);
	}

	private JPanel crearBarraSuperior() {
		Header header = new Header();

		header.getbCartelera().addActionListener(e -> {
			if (cartelera != null) {
				cartelera.setVisible(true);
				setVisible(false);
			}
		});

		return header;
	}

	private JPanel crearPanelPerfil() {
		JLabel lbTitulo = new JLabel("Mi perfil");
		lbTitulo.setFont(new Font("Arial", Font.BOLD, 22));

		JLabel lbFoto = new JLabel("Foto", SwingConstants.CENTER);
		lbFoto.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		lbFoto.setPreferredSize(new Dimension(120, 120));
		JPanel pFoto = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		pFoto.add(lbFoto);

		JTextField txUsuario = new JTextField(usuario != null ? usuario.getNombre() : "Usuario");
		JTextField txEmail = new JTextField(usuario != null ? usuario.getCorreo() : "Email");
		txUsuario.setEditable(false);
		txEmail.setEditable(false);
		JButton bCambiar = new JButton("Cambiar contraseña");
		JButton bCerrar = new JButton("Cerrar sesión");

		bCerrar.addActionListener(e -> {
			if (cartelera != null) {
				cartelera.setPerfil(null);
				cartelera.setVisible(true);
			}
			dispose();
		});

		JPanel pDatos = new JPanel(new GridLayout(4, 1, 0, 12));
		pDatos.setPreferredSize(new Dimension(260, 200));
		pDatos.add(txUsuario);
		pDatos.add(txEmail);
		pDatos.add(bCambiar);
		pDatos.add(bCerrar);

		JPanel pCentro = new JPanel(new BorderLayout(0, 15));
		pCentro.add(pFoto, BorderLayout.NORTH);
		pCentro.add(pDatos, BorderLayout.CENTER);

		JPanel pPerfil = new JPanel(new BorderLayout(0, 15));
		pPerfil.add(lbTitulo, BorderLayout.NORTH);
		pPerfil.add(pCentro, BorderLayout.CENTER);

		JPanel pIzquierda = new JPanel(new BorderLayout());
		pIzquierda.setPreferredSize(new Dimension(260, 0));
		pIzquierda.add(pPerfil, BorderLayout.NORTH);
		return pIzquierda;
	}

	private JPanel crearPanelDerecho() {
		JLabel lbEntradas = new JLabel("Mis entradas");
		lbEntradas.setFont(new Font("Arial", Font.BOLD, 22));

		JPanel pLista = new JPanel(new GridLayout(3, 1, 0, 10));
		for (int i = 0; i < 3; i++) {
			JLabel lbPelicula = new JLabel("Película");
			lbPelicula.setFont(new Font("Arial", Font.BOLD, 13));
			JLabel lbSesion = new JLabel("Sesión");
			JLabel lbButacas = new JLabel("Butacas");
			JLabel lbTotal = new JLabel("Total");

			JPanel pFila = new JPanel(new FlowLayout(FlowLayout.LEFT, 25, 15));
			pFila.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
			pFila.add(lbPelicula);
			pFila.add(lbSesion);
			pFila.add(lbButacas);
			pFila.add(lbTotal);
			pLista.add(pFila);
		}

		JLabel lbTipo = new JLabel("Tipo de entrada");
		lbTipo.setFont(new Font("Arial", Font.BOLD, 22));

		JPanel pBotones = new JPanel(new GridLayout(1, 4, 15, 0));
		ButtonGroup bgTipo = new ButtonGroup();
		String[] tipos = { "Normal", "Niño", "Senior", "Estudiante" };
		for (String tipo : tipos) {
			JToggleButton bTipo = new JToggleButton("<html><center>" + tipo + "<br>- %</center></html>");
			bTipo.setPreferredSize(new Dimension(0, 70));
			bgTipo.add(bTipo);
			pBotones.add(bTipo);
		}
		bgTipo.getElements().nextElement().setSelected(true);

		JPanel pArriba = new JPanel(new BorderLayout(0, 10));
		pArriba.add(lbEntradas, BorderLayout.NORTH);
		pArriba.add(pLista, BorderLayout.CENTER);

		JPanel pAbajo = new JPanel(new BorderLayout(0, 10));
		pAbajo.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		pAbajo.add(lbTipo, BorderLayout.NORTH);
		pAbajo.add(pBotones, BorderLayout.CENTER);

		JPanel pDerecha = new JPanel(new BorderLayout(0, 10));
		pDerecha.add(pArriba, BorderLayout.NORTH);
		pDerecha.add(pAbajo, BorderLayout.CENTER);

		JPanel pDerechaArriba = new JPanel(new BorderLayout());
		pDerechaArriba.add(pDerecha, BorderLayout.NORTH);
		return pDerechaArriba;
	}

	public static void main(String[] args) {
		new VentanaPerfil(null, null).setVisible(true);
	}
}