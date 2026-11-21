package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;
import java.awt.Insets;
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
	private VentanaCartelera cartelera;
	private List<Butaca> seleccionadas = new ArrayList<>();

	public VentanaButacas(Sesion sesion, VentanaCartelera cartelera) {
		this.sesion = sesion;
		this.cartelera = cartelera;
		Sala sala = sesion.getSala();
		
		setTitle("Elegir butacas - " + sesion.getPelicula().getNombre());
		setSize(Math.max(700, 60 + sala.getButacasPorFila() * 44), Math.max(500, 130 + sala.getFilas() * 36));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		JLabel lblPantalla = new JLabel("PANTALLA", SwingConstants.CENTER);
		add(lblPantalla, BorderLayout.NORTH);

		// butaca por boton
		JPanel panelButacas = new JPanel(new GridLayout(sala.getFilas(), sala.getButacasPorFila() + 1, 4, 4));
		for (Butaca b : sala.getButacas()) {
			if (b.getNumero() == 1) {
				JLabel lbFila = new JLabel("Fila " + b.getFila(), SwingConstants.CENTER);
				lbFila.setFont(new Font("Arial", Font.BOLD, 11));
				panelButacas.add(lbFila);
			}
			JButton btn = new JButton(String.valueOf(b.getNumero()));
			btn.setMargin(new Insets(0, 0, 0, 0));
			btn.setFont(new Font("Arial", Font.PLAIN, 11));
			btn.setToolTipText("Fila " + b.getFila() + ", butaca " + b.getNumero());
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
				new VentanaResumen(sesion, seleccionadas, cartelera).setVisible(true);
				dispose();
			}
		});
		add(btnContinuar, BorderLayout.SOUTH);
	}
}