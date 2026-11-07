package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Header extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton bCartelera = new JButton("Cartelera");
	private JButton bValoradas = new JButton("Mejor valoradas");
	private JButton bResenas = new JButton("Reseñas");
	private JButton bPerfil = new JButton("Mi perfil");

	public Header() {
		setLayout(new BorderLayout());
		setBackground(new Color(40, 40, 40));
		setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

		JLabel lbCine = new JLabel("Cine");
		lbCine.setForeground(Color.WHITE);
		lbCine.setFont(new Font("Arial", Font.BOLD, 20));
		add(lbCine, BorderLayout.WEST);

		JPanel pMenu = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		pMenu.setOpaque(false);
		pMenu.add(bCartelera);
		pMenu.add(bValoradas);
		pMenu.add(bResenas);
		pMenu.add(bPerfil);
		add(pMenu, BorderLayout.EAST);
	}

	public JButton getbCartelera() {
		return bCartelera;
	}

	public JButton getbValoradas() {
		return bValoradas;
	}

	public JButton getbResenas() {
		return bResenas;
	}

	public JButton getbPerfil() {
		return bPerfil;
	}
}