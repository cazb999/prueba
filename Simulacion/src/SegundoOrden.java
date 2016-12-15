import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class SegundoOrden extends JFrame implements ActionListener{
	
	/*
	 * Atributos
	 */
	
	private JPanel contentPane;
	private JTextField txtKcr;
	JButton btnCalcular;
	JButton btnNuevo;
	private Leer leer = new Leer();
	JLabel lblPrCont;
	JLabel lblKfCont;
	JLabel lblTiCont;
	JLabel lblTdCont;
	private JTable table;
	
	/*
	 * Constructor. Se crea el frame 
	 */
	public SegundoOrden() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblKcr = new JLabel("Kcr");
		lblKcr.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblKcr.setBounds(199, 36, 99, 21);
		contentPane.add(lblKcr);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.setBackground(Color.WHITE);
		btnCalcular.setFont(new Font("Arial Black", Font.BOLD, 16));
		btnCalcular.setBounds(199, 83, 130, 31);
		contentPane.add(btnCalcular);
		
		JLabel lblPr = new JLabel("Pr");
		lblPr.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblPr.setBounds(209, 125, 46, 21);
		contentPane.add(lblPr);
		
		JLabel lblKf = new JLabel("Kf");
		lblKf.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblKf.setBounds(209, 157, 46, 21);
		contentPane.add(lblKf);
		
		JLabel lblTi = new JLabel("Ti");
		lblTi.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblTi.setBounds(209, 189, 46, 21);
		contentPane.add(lblTi);
		
		lblPrCont = new JLabel("---");
		lblPrCont.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblPrCont.setBackground(Color.ORANGE);
		lblPrCont.setBounds(265, 125, 155, 21);
		contentPane.add(lblPrCont);
		
		lblKfCont = new JLabel("---");
		lblKfCont.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblKfCont.setBackground(Color.ORANGE);
		lblKfCont.setBounds(264, 157, 156, 21);
		contentPane.add(lblKfCont);
		
		lblTiCont = new JLabel("---");
		lblTiCont.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblTiCont.setBackground(Color.ORANGE);
		lblTiCont.setBounds(264, 189, 156, 21);
		contentPane.add(lblTiCont);
		
		txtKcr = new JTextField();
		txtKcr.setFont(new Font("Arial", Font.BOLD, 16));
		txtKcr.setBounds(255, 31, 165, 31);
		contentPane.add(txtKcr);
		txtKcr.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 179, 255);
		contentPane.add(scrollPane);
		
		DefaultTableModel modelo = new DefaultTableModel();
		table = new JTable(modelo); // Modelo de la tabla
		table.setModel(new DefaultTableModel(
			new Object[][] { // Arreglo de dos valores
			},
			new String[] {
				"t", "g(t)" // Nombre de las dos columnas
			}
		) {
			Class[] columnTypes = new Class[] { // Como son 2 columnas
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		ArrayList<String[]> datos = leer.importarDatos("segundoOrden.txt"); // Trae los datos de segundo orden
		for (int i = 0; i < datos.size(); i++) { // Recorre datos
			((DefaultTableModel)table.getModel()).addRow(datos.get(i)); // Inserta filas a la tabla
		}
		scrollPane.setViewportView(table); // Agrega un scroll a la tabla (bajar)
		JLabel lblTd = new JLabel("Td");
		lblTd.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblTd.setBounds(209, 223, 46, 21);
		contentPane.add(lblTd);
		lblTdCont = new JLabel("---");
		lblTdCont.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblTdCont.setBackground(Color.ORANGE);
		lblTdCont.setBounds(264, 223, 156, 21);
		contentPane.add(lblTdCont);
		
		btnNuevo = new JButton("Nuevo Cálculo");
		btnNuevo.setFont(new Font("Arial", Font.BOLD, 14));
		btnNuevo.setBackground(Color.WHITE);
		btnNuevo.setBounds(274, 257, 155, 31);
		contentPane.add(btnNuevo);
		
		btnCalcular.addActionListener(this);
		btnNuevo.addActionListener(this);
	}
	
	/*
	 * Método llamado de Action listener, donde se define la funcionalidad del boton enviar
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCalcular){// Si se ingresa un valor en el campo de Kcr se hacen los calculos
			txtKcr.setEditable(false); // Cuando se da calcular quedan blouqeados
			btnCalcular.setEnabled(false);
			if(!txtKcr.getText().equals("")){ // Verfica que txt no está vacío
				String ker = txtKcr.getText(); // Trae lo que se ingresó
				String[] info = calcular(ker); // Guarda en un vector lo que retorna el método calcular
				insertarDatos(info[0], info[1], info[2], info[3]); // Al método insertar datos le pasas cada posición del vector
			}
			else //Si no se ingresa un valor, aparece un mensaje. Excepción 
			{
				JOptionPane.showMessageDialog(this, "Por favor ingresa un numero");
			}			
		}
		
		if(e.getSource()==btnNuevo){
			PrimerOrden po = new PrimerOrden();
			po.setVisible(true);
			po.setResizable(false);
			po.setLocationRelativeTo(null);
			this.dispose();
		}
	}
	
	public String[] calcular(String kcr){ // Método calcular
		ArrayList<String[]> datos = leer.importarDatos("segundoOrden.txt"); // Trae los datos
		double numeroMayor = 0;
		double pico1 = 0;
		double pico2 = 0;
		for (int i = 0; i < datos.size() - 1; i++) { // Recorre el Array de datos
			String sn = datos.get(i)[1].toString(); // Guarda en String el dato en la posición i de la posición 1 del vector
			char[] AuxSn = sn.toCharArray(); // Pasa a char el String y lo guarda en un vector del char
			sn = ""; // String sn vacío
			for (int j = 0; j < AuxSn.length; j++) { // cambia coma por puntos
				if(AuxSn[j] == ','){
					AuxSn[j] = '.';
				}
				sn = sn+AuxSn[j]; // Agrega a String cada char
			}
			double n = Double.parseDouble(sn); // Pasa String a double guardando en una var double
			if( n > numeroMayor){ // Buscar el mayor valor
				numeroMayor = n; // Guarda el mayor en una varible "numeroMayor"
			}
		}
		double auxNM = numeroMayor * 1000; // Psar 3 decimales a entero
		int cont = 0; // variable de cont
		for (int i = 0; i < datos.size(); i++) { // Recorre el Array datos
			String sn = datos.get(i)[1].toString(); // Trae los datos del Array en la posición y i. Del vector trae los datos en la posición 1
			char[] AuxSn = sn.toCharArray(); // Pasa String a char y lo guarda en un vector
			sn = "";
			for (int j = 0; j < AuxSn.length; j++) {
				if(AuxSn[j] == ','){
					AuxSn[j] = '.';
				}
				sn = sn + AuxSn[j];
			}
			double n = Double.parseDouble(sn);
			if((int)auxNM == (int)(n*1000) && cont == 0){ // Comparar para encontrar el primer pico y verifica que el contador sea 0 
				char[] vecP1 = datos.get(i)[0].toCharArray();
				String sP1 = "";
				for (int j = 0; j < vecP1.length; j++) {
					if(vecP1[j] == ','){
						vecP1[j] = '.';
					}
					sP1 = sP1 + vecP1[j];
				}
				pico1 = Double.parseDouble(sP1);
				cont ++;
			}
			else if((int)auxNM == (int)(n*1000) && cont == 1){ // 
				char[] vecP2 = datos.get(i)[0].toCharArray();
				String sP2 = "";
				for (int j = 0; j < vecP2.length; j ++) {
					if(vecP2[j] == ','){
						vecP2[j]='.';
					}
					sP2 = sP2 + vecP2[j];
				}
				pico2 = Double.parseDouble(sP2);
				cont ++;
			}
		}
		double periodo = pico2 - pico1;
		double kc = Double.parseDouble(kcr);
		double Kp = (0.60 * kc);
		double Ti = (0.5 * periodo);
		double Td = (periodo / 8);		
		String[] retor = {"" + periodo, "" + Kp, "" + Ti, "" + Td};
		return retor;
	}
	
	public void insertarDatos(String periodo, String Kp, String Ti, String Td){
		lblKfCont.setText("" + Kp);
		//---------------------------------Ti---------------------------
		
		lblTiCont.setText("" + Ti);
		
		//-------------------------------Td----------------------------------
		
		lblTdCont.setText("" + Td);
		
		//--------------------------------periodo----------------------
		lblPrCont.setText("" + periodo);
	}
}