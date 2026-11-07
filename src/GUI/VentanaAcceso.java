package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import domain.Socio;
import domain.Usuario;

public class VentanaAcceso extends JFrame {

	private static final long serialVersionUID = 1L;

	private static List<Usuario> usuarios = new ArrayList<>();

	private VentanaCartelera cartelera;

	private JTextField txLogin = new JTextField();
	private JPasswordField psLogin = new JPasswordField();

	private JTextField txRegistro = new JTextField();
	private JTextField txCorreo = new JTextField();
	private JPasswordField psRegistro = new JPasswordField();
	private JPasswordField psRepetir = new JPasswordField();

	public VentanaAcceso(VentanaCartelera cartelera) {
		this.cartelera = cartelera;

		setTitle("Cine - Acceso");
		setSize(950, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		add(crearBarraSuperior(), BorderLayout.NORTH);

		JPanel pContenido = new JPanel(new GridLayout(1, 2, 40, 0));
		pContenido.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
		pContenido.add(crearPanelLogin());
		pContenido.add(crearPanelRegistro());
		add(pContenido, BorderLayout.CENTER);
	}

	private JPanel crearBarraSuperior() {
		Header header = new Header();

		header.getbCartelera().addActionListener(e -> {
			if (cartelera != null) {
				cartelera.setVisible(true);
				dispose();
			}
		});

		return header;
	}

	private JPanel crearPanelLogin() {
		JLabel lbTitulo = new JLabel("Iniciar sesión");
		lbTitulo.setFont(new Font("Arial", Font.BOLD, 22));

		JLabel lbLogin = new JLabel("Usuario");
		JLabel lbPsLogin = new JLabel("Contraseña");
		JButton bLogin = new JButton("Iniciar sesión");
		bLogin.addActionListener(e -> iniciarSesion());

		JPanel pCampos = new JPanel(new GridLayout(5, 1, 0, 8));
		pCampos.setPreferredSize(new Dimension(0, 220));
		pCampos.add(lbLogin);
		pCampos.add(txLogin);
		pCampos.add(lbPsLogin);
		pCampos.add(psLogin);
		pCampos.add(bLogin);

		return crearColumna(lbTitulo, pCampos);
	}

	private JPanel crearPanelRegistro() {
		JLabel lbTitulo = new JLabel("Registrarse");
		lbTitulo.setFont(new Font("Arial", Font.BOLD, 22));

		JLabel lbRegistro = new JLabel("Usuario");
		JLabel lbCorreo = new JLabel("Correo");
		JLabel lbPsRegistro = new JLabel("Contraseña");
		JLabel lbPsRepetir = new JLabel("Repite la contraseña");
		JButton bRegistro = new JButton("Crear cuenta");
		bRegistro.addActionListener(e -> registrarse());

		JPanel pCampos = new JPanel(new GridLayout(9, 1, 0, 8));
		pCampos.setPreferredSize(new Dimension(0, 400));
		pCampos.add(lbRegistro);
		pCampos.add(txRegistro);
		pCampos.add(lbCorreo);
		pCampos.add(txCorreo);
		pCampos.add(lbPsRegistro);
		pCampos.add(psRegistro);
		pCampos.add(lbPsRepetir);
		pCampos.add(psRepetir);
		pCampos.add(bRegistro);

		return crearColumna(lbTitulo, pCampos);
	}

	private JPanel crearColumna(JLabel lbTitulo, JPanel pCampos) {
		JPanel pColumna = new JPanel(new BorderLayout(0, 15));
		pColumna.add(lbTitulo, BorderLayout.NORTH);
		pColumna.add(pCampos, BorderLayout.CENTER);

		JPanel pArriba = new JPanel(new BorderLayout());
		pArriba.add(pColumna, BorderLayout.NORTH);
		return pArriba;
	}

	private void iniciarSesion() {
		String usuario = txLogin.getText().trim();
		String contrasena = new String(psLogin.getPassword());

		for (Usuario u : usuarios) {
			if (u.getNombre().equals(usuario) && u.getContrasena().equals(contrasena)) {
				VentanaPerfil perfil = new VentanaPerfil(cartelera, u);
				if (cartelera != null) {
					cartelera.setPerfil(perfil);
				}
				perfil.setVisible(true);
				dispose();
				return;
			}
		}
		JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.");
	}

	private void registrarse() {
		String usuario = txRegistro.getText().trim();
		String correo = txCorreo.getText().trim();
		String contrasena = new String(psRegistro.getPassword());
		String repetir = new String(psRepetir.getPassword());

		if (usuario.isEmpty() || correo.isEmpty() || contrasena.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Rellena todos los campos.");
			return;
		}
		if (!contrasena.equals(repetir)) {
			JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.");
			return;
		}
		for (Usuario u : usuarios) {
			if (u.getNombre().equals(usuario)) {
				JOptionPane.showMessageDialog(this, "Ese usuario ya existe.");
				return;
			}
		}

		usuarios.add(new Usuario("U" + (usuarios.size() + 1), usuario, correo, contrasena, Socio.BASE));
		JOptionPane.showMessageDialog(this, "Cuenta creada. Ya puedes iniciar sesión.");
		txLogin.setText(usuario);
	}

	public static void main(String[] args) {
		new VentanaAcceso(null).setVisible(true);
	}
}