package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import domain.Pelicula;
import domain.Sesion;


public class VentanaCartelera extends JFrame {
	
	private static final int PELIS_POR_PAGINA = 12;
	private int paginaActual = 0;

	private JPanel panelPeliculas;
	private JLabel lblPagina;
	private JButton btnAnterior;
	private JButton btnSiguiente;

	private static final long serialVersionUID = 1L;

	private List<Pelicula> peliculas;
	private List<Sesion> sesiones;

	public VentanaCartelera(List<Pelicula> peliculas, List<Sesion> sesiones) {
		this.peliculas = peliculas;
		this.sesiones = sesiones;

		setTitle("Cine - Cartelera");
		setSize(900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		add(crearBarraSuperior(), BorderLayout.NORTH);

		JPanel contenido = new JPanel(new BorderLayout(10, 10));
		contenido.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		JLabel lblTitulo = new JLabel("Cartelera");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
		contenido.add(lblTitulo, BorderLayout.NORTH);

		panelPeliculas = new JPanel(new GridLayout(0, 4, 15, 15));

		JPanel envoltorio = new JPanel(new BorderLayout());
		envoltorio.add(panelPeliculas, BorderLayout.NORTH);
		contenido.add(envoltorio, BorderLayout.CENTER);

		contenido.add(crearPanelPaginas(), BorderLayout.SOUTH);

		add(contenido, BorderLayout.CENTER);

		mostrarPagina();
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
		menu.add(new JButton("Cartelera"));
		menu.add(new JButton("Mejor valoradas"));
		menu.add(new JButton("Reseñas"));
		menu.add(new JButton("Mi perfil"));
		barra.add(menu, BorderLayout.EAST);

		return barra;
	}

	private JPanel crearTarjeta(Pelicula p) {
		JPanel tarjeta = new JPanel();
		tarjeta.setLayout(new BoxLayout(tarjeta, BoxLayout.Y_AXIS));
		tarjeta.setBackground(Color.WHITE);
		tarjeta.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.LIGHT_GRAY),
				BorderFactory.createEmptyBorder(15, 15, 15, 15)));
		tarjeta.setCursor(new Cursor(Cursor.HAND_CURSOR));

		JLabel lblTitulo = new JLabel(p.getNombre());
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));

		JLabel lblGenero = new JLabel(p.getGenero());
		JLabel lblEdad = new JLabel("Edad: +" + p.getEdadMinima());

		tarjeta.add(lblTitulo);
		tarjeta.add(lblGenero);
		tarjeta.add(lblEdad);

		tarjeta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				abrirSesiones(p);
			}
		});

		return tarjeta;
	}

	private void abrirSesiones(Pelicula p) {
		VentanaSesiones ventana = new VentanaSesiones(p, sesiones, this);
		ventana.setVisible(true);
		setVisible(false);
	}
	private JPanel crearPanelPaginas() {
	    JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));

	    btnAnterior = new JButton("< Anterior");
	    btnSiguiente = new JButton("Siguiente >");
	    lblPagina = new JLabel();

	    btnAnterior.addActionListener(e -> {
	        paginaActual--;
	        mostrarPagina();
	    });
	    btnSiguiente.addActionListener(e -> {
	        paginaActual++;
	        mostrarPagina();
	    });

	    panel.add(btnAnterior);
	    panel.add(lblPagina);
	    panel.add(btnSiguiente);
	    return panel;
	}

	private void mostrarPagina() {
	    panelPeliculas.removeAll();

	    int inicio = paginaActual * PELIS_POR_PAGINA;
	    int fin = Math.min(inicio + PELIS_POR_PAGINA, peliculas.size());
	    for (int i = inicio; i < fin; i++) {
	        panelPeliculas.add(crearTarjeta(peliculas.get(i)));
	    }

	    int totalPaginas = (peliculas.size() + PELIS_POR_PAGINA - 1) / PELIS_POR_PAGINA;
	    if (totalPaginas == 0) {
	        totalPaginas = 1;
	    }

	    lblPagina.setText("Página " + (paginaActual + 1) + " de " + totalPaginas);
	    btnAnterior.setEnabled(paginaActual > 0);
	    btnSiguiente.setEnabled(paginaActual < totalPaginas - 1);

	    panelPeliculas.revalidate();
	    panelPeliculas.repaint();
	}	
}









