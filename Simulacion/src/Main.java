import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main extends JFrame implements ActionListener{

	/*
	 * Atributos
	 */
	private JPanel contentPane;
	JButton btnPrimerOrden;
	JButton btnSeundoOrden;

	/*
	 * Ventana principal
	 */
	public static void main(String[] args) { // metodo main para correr la aplicacion
		Main m = new Main(); // Crea nuevo objeto
		m.setVisible(true); // Muestra la ventana
		m.setResizable(false); // Para que no se pueda modificar el tamaño de la ventana
	}

	/**
	 * Create the frame.
	 */
	public Main() { // Constructor
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cuando se cierra la aplicacion, se cierra todo el proceso
		setBounds(100, 100, 450, 300); // Tamaño de ventana
		contentPane = new JPanel(); // Crea un nuevo panel
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // Agrega bordes a la ventana
		setContentPane(contentPane); // Agrega el panel a la ventana 
		contentPane.setLayout(null); // Para poner los botones donde se desee
		
		btnPrimerOrden = new JButton("Primer Orden"); // Nombre botón
		btnPrimerOrden.setBackground(Color.WHITE); // Color
		btnPrimerOrden.setFont(new Font("Arial Black", Font.BOLD, 18)); // letra
		btnPrimerOrden.setBounds(134, 70, 191, 35); // Posición y tamaña del botón (x,y,alto, ancho)
		contentPane.add(btnPrimerOrden); // Agrega al panel
		
		btnSeundoOrden = new JButton("Segundo Orden");
		btnSeundoOrden.setBackground(Color.WHITE);
		btnSeundoOrden.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnSeundoOrden.setBounds(134, 138, 201, 35);
		contentPane.add(btnSeundoOrden);
		
		btnPrimerOrden.addActionListener(this); // Agregar acciones al botón 1
		btnSeundoOrden.addActionListener(this); // Agregar acciones al botón 2
	}

	@Override
	public void actionPerformed(ActionEvent e) { // Metodo de ActionListener
		
		if(e.getSource()==btnPrimerOrden){ // Si se da click en boton 1
			PrimerOrden po = new PrimerOrden(); // Crea ventana de primer orde
			po.setVisible(true); // Visible
			po.setResizable(false); // No modificable
			po.setLocationRelativeTo(null); // Para que quede centrado
		}
		if(e.getSource()==btnSeundoOrden){
			SegundoOrden so = new SegundoOrden();
			so.setVisible(true);
			so.setResizable(false);
			so.setLocationRelativeTo(null);
		}
		
	}
}
