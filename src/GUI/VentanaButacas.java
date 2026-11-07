package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import domain.Butaca;
import domain.Sala;
import domain.Sesion;

public class VentanaButacas extends JFrame {

	private static final long serialVersionUID = 1L;

	private Sesion sesion;
	private List<Butaca> seleccionadas = new ArrayList<>();

	public VentanaButacas(Sesion sesion) {
		this.sesion = sesion;
		Sala sala = sesion.getSala();

		setTitle("Elegir butacas - " + sesion.getPelicula().getNombre());
		setSize(700, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		JLabel lblPantalla = new JLabel("PANTALLA", SwingConstants.CENTER);
		add(lblPantalla, BorderLayout.NORTH);

		// butaca por boton
		JPanel panelButacas = new JPanel(new GridLayout(sala.getFilas(), sala.getButacasPorFila(), 5, 5));
		for (Butaca b : sala.getButacas()) {
			JButton btn = new JButton(b.getFila() + "-" + b.getNumero());
			btn.setOpaque(true);

			if (sesion.getButacasOcupadas().contains(b)) {
				btn.setBackground(Color.RED);
				btn.setEnabled(false);
			} else {
				btn.setBackground(Color.GREEN);
				btn.addActionListener(e -> {
					if (seleccionadas.contains(b)) {
						seleccionadas.remove(b);
						btn.setBackground(Color.GREEN);
					} else {
						seleccionadas.add(b);
						btn.setBackground(Color.YELLOW);
					}
				});
			}
			panelButacas.add(btn);
		}
		add(panelButacas, BorderLayout.CENTER);

		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(e -> {
			if (!seleccionadas.isEmpty()) {
				new VentanaResumen(sesion, seleccionadas).setVisible(true);
				dispose();
			}
		});
		add(btnContinuar, BorderLayout.SOUTH);
	}
}
