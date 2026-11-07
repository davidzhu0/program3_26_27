package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import domain.Butaca;
import domain.Sesion;

public class VentanaResumen extends JFrame {

	private static final long serialVersionUID = 1L;

	public VentanaResumen(Sesion sesion, List<Butaca> butacas) {
		setTitle("Resumen de la compra");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		// De momento descuento fijo: cuando esté el Usuario se sacará de su tipo de socio
		double descuento = 0.0;
		double precioEntrada = sesion.getPrecio() * (1 - descuento);
		double total = precioEntrada * butacas.size();

		String textoButacas = "";
		for (Butaca b : butacas) {
			textoButacas += b.getFila() + "-" + b.getNumero() + "  ";
		}

		JPanel panelDatos = new JPanel(new GridLayout(0, 1));
		panelDatos.add(new JLabel("Película: " + sesion.getPelicula().getNombre()));
		panelDatos.add(new JLabel("Fecha: " + sesion.getFecha() + "   Hora: " + sesion.getHora()));
		panelDatos.add(new JLabel("Sala: " + sesion.getSala().getNumero()));
		panelDatos.add(new JLabel("Butacas: " + textoButacas));
		panelDatos.add(new JLabel("Precio entrada: " + sesion.getPrecio() + " €"));
		panelDatos.add(new JLabel("Descuento: " + (int) (descuento * 100) + " %"));
		panelDatos.add(new JLabel("TOTAL: " + String.format("%.2f", total) + " €"));
		add(panelDatos, BorderLayout.CENTER);

		JButton btnConfirmar = new JButton("Confirmar compra");
		btnConfirmar.addActionListener(e -> {
			sesion.getButacasOcupadas().addAll(butacas);
			JOptionPane.showMessageDialog(this, "Compra realizada");
			dispose();
		});
		add(btnConfirmar, BorderLayout.SOUTH);
	}
}
