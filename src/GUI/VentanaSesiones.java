package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import domain.Pelicula;
import domain.Sesion;


public class VentanaSesiones extends JFrame {

	private static final long serialVersionUID = 1L;

	private Pelicula pelicula;
	private JFrame ventanaCartelera;

	public VentanaSesiones(Pelicula pelicula, List<Sesion> sesiones, JFrame ventanaCartelera) {
		this.pelicula = pelicula;
		this.ventanaCartelera = ventanaCartelera;

		setTitle("Cine - Sesiones de " + pelicula.getNombre());
		setSize(900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		add(crearBarraSuperior(), BorderLayout.NORTH);

		JPanel contenido = new JPanel(new BorderLayout(20, 10));
		contenido.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		contenido.add(crearPanelPelicula(), BorderLayout.WEST);

		contenido.add(crearPanelSesiones(sesiones), BorderLayout.CENTER);

		JButton btnVolver = new JButton("Volver a cartelera");
		btnVolver.addActionListener(e -> volverACartelera());
		JPanel panelAbajo = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelAbajo.add(btnVolver);
		contenido.add(panelAbajo, BorderLayout.SOUTH);

		add(contenido, BorderLayout.CENTER);
	}

	private JPanel crearBarraSuperior() {
		JPanel barra = new JPanel(new BorderLayout());
		barra.setBackground(new Color(40, 40, 40));
		barra.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

		JLabel lblCine = new JLabel("Cine");
		lblCine.setForeground(Color.WHITE);
		lblCine.setFont(new Font("Arial", Font.BOLD, 20));
		barra.add(lblCine, BorderLayout.WEST);

		JPanel menu = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		menu.setOpaque(false);

		JButton btnCartelera = new JButton("Cartelera");
		btnCartelera.addActionListener(e -> volverACartelera());

		menu.add(btnCartelera);
		menu.add(new JButton("Mejor valoradas"));
		menu.add(new JButton("Reseñas"));
		menu.add(new JButton("Mi perfil"));
		barra.add(menu, BorderLayout.EAST);

		return barra;
	}

	private JPanel crearPanelPelicula() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(Color.WHITE);
		panel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.LIGHT_GRAY),
				BorderFactory.createEmptyBorder(15, 15, 15, 15)));

		JLabel lblTitulo = new JLabel(pelicula.getNombre());
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));

		panel.add(lblTitulo);
		panel.add(new JLabel(pelicula.getGenero()));
		panel.add(new JLabel("Edad: +" + pelicula.getEdadMinima()));

		return panel;
	}

	private JPanel crearPanelSesiones(List<Sesion> sesiones) {
		JPanel panel = new JPanel(new BorderLayout(5, 10));

		JLabel lblSesiones = new JLabel("Sesiones");
		lblSesiones.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(lblSesiones, BorderLayout.NORTH);

		String[] columnas = { "Hora", "Sala", "Precio" };
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int fila, int columna) {
				return false;
			}
		};

		for (Sesion s : sesiones) {
			if (s.getPelicula().getNombre().equals(pelicula.getNombre())) {
				modelo.addRow(new Object[] {
						s.getHora(),
						s.getSala(),
						s.getPrecio() + " €"
				});
			}
		}

		if (modelo.getRowCount() == 0) {
			panel.add(new JLabel("No hay sesiones para esta película."), BorderLayout.CENTER);
		} else {
			JTable tabla = new JTable(modelo);
			tabla.setRowHeight(30);
			tabla.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
			// Aquí más adelante se puede abrir la selección de butacas al elegir una fila
			panel.add(new JScrollPane(tabla), BorderLayout.CENTER);
		}

		return panel;
	}

	private void volverACartelera() {
		ventanaCartelera.setVisible(true);
		dispose();
	}
}
