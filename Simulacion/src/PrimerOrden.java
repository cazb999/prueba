import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

import java.awt.Font;

import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;

public class PrimerOrden extends JFrame implements ActionListener{
	private JPanel contentPane; // Atributo para agrupar componentes
	private JTextField txtUsc; // Atributo para digitar la primera entrada
	private JTextField txtUsi; // Atributo para digitar la segunda entrada
	JButton btnCalcular; // Botón para calcualr cuando se ingrean las entradas
	JButton btnNuevo;
	private Leer leer = new Leer(); // llama a la clase leer para leer el archivo
	JLabel lblT1; // Crea T0 de la interfaz
	JLabel lblT2; // Crea T1 de la interfaz
	JLabel lblT3; // Crea T2 de la interfaz
	JLabel lblKp; // Crea Kp de la interfaz
	JLabel lblTi; // Crea Ti de la interfaz
	JLabel lblTd; // Crea Td de la interfaz
	JLabel lblT1Cont; // Crea la respuesta de T0 
	JLabel lblT2Cont; // Crea la respuesta de T1
	JLabel lblT3Cont; // Crea la respuesta de T2
	JLabel lblKpCont; // Crea la respuesta de Kp
	JLabel lblTiCont; // Crea la respuesta de Ti
	JLabel lblTdCont; // Crea la respuesta de Td
	private JTable table; // Crea la tabla donde se cargan los datos

	public PrimerOrden() { //Constructor. Se crea el Frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Terminar todo el proceso
		setBounds(100, 100, 445, 344); // Tamaño de la ventana (x,y,ancho,alto)
		contentPane = new JPanel(); // Nuevo panel
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // Bordes
		setContentPane(contentPane); // Agrega panel al marco
		contentPane.setLayout(null); // Para ubicar los botones donde se desee
		JLabel lblMe = new JLabel("U0"); // Nombre de la primera entrada
		lblMe.setFont(new Font("Arial Black", Font.BOLD, 14)); // Tipo de letra
		lblMe.setBounds(199, 36, 99, 21); // Tamaño y posicion
		contentPane.add(lblMe); //

		JLabel lblMco = new JLabel("U∞"); // Nombre de la segunda entrada
		lblMco.setFont(new Font("Arial Black", Font.BOLD, 14)); // Tipo de letra
		lblMco.setBounds(199, 81, 130, 21); //
		contentPane.add(lblMco); //

		btnCalcular = new JButton("Calcular"); // Nombre del botón
		btnCalcular.setBackground(Color.WHITE); // Color del botón
		btnCalcular.setFont(new Font("Arial Black", Font.BOLD, 16)); // Tipo de letra del botón
		btnCalcular.setBounds(199, 130, 130, 31); // 
		contentPane.add(btnCalcular); // Agrega el botón

		lblT1 = new JLabel("t0"); // Nombre de t0
		lblT1.setFont(new Font("Arial Black", Font.BOLD, 14)); // Tipo de letra de t0
		lblT1.setBounds(10, 181, 46, 21); //
		contentPane.add(lblT1); // Agrega el botón

		lblT2 = new JLabel("t1"); // Nombre de t1
		lblT2.setFont(new Font("Arial Black", Font.BOLD, 14)); // Tipo de letra de t1
		lblT2.setBounds(10, 213, 46, 21); //
		contentPane.add(lblT2); // Agregar el botón

		lblT3 = new JLabel("t2"); // Nombre de t2
		lblT3.setFont(new Font("Arial Black", Font.BOLD, 14)); // Tipo de letra de t2
		lblT3.setBounds(10, 245, 46, 21);
		contentPane.add(lblT3); // Agregar label

		lblT1Cont = new JLabel("---"); // Nombre del campo de to
		lblT1Cont.setBackground(Color.ORANGE); // Color
		lblT1Cont.setFont(new Font("Arial Black", Font.BOLD, 14)); // Tipo de letra
		lblT1Cont.setBounds(67, 181, 122, 21);
		contentPane.add(lblT1Cont); // Agregar label

		lblT2Cont = new JLabel("---"); // Nombre del campo de t1
		lblT2Cont.setFont(new Font("Arial Black", Font.BOLD, 14)); // Tipo de letra
		lblT2Cont.setBackground(Color.ORANGE); // Color
		lblT2Cont.setBounds(66, 213, 123, 21);
		contentPane.add(lblT2Cont); // Agregar label

		lblT3Cont = new JLabel("---"); // Nombre del campo de t2
		lblT3Cont.setFont(new Font("Arial Black", Font.BOLD, 14)); // Tipo de letra
		lblT3Cont.setBackground(Color.ORANGE); // Color
		lblT3Cont.setBounds(66, 245, 123, 21);
		contentPane.add(lblT3Cont); // Agregar label

		lblKp = new JLabel("Kp"); // Nombre de Kp
		lblKp.setFont(new Font("Arial Black", Font.BOLD, 14)); // Tipo de letra
		lblKp.setBounds(199, 181, 46, 21);
		contentPane.add(lblKp); // Agregar label

		lblTi = new JLabel("Ti"); // Nombre de Ti
		lblTi.setFont(new Font("Arial Black", Font.BOLD, 14)); // Tipo de letra
		lblTi.setBounds(199, 213, 46, 21);
		contentPane.add(lblTi); // Agregar label

		lblTd = new JLabel("Td"); // Nombre de Td
		lblTd.setFont(new Font("Arial Black", Font.BOLD, 14)); // Tipo de letra
		lblTd.setBounds(199, 245, 46, 21);
		contentPane.add(lblTd); // Agregar label

		lblKpCont = new JLabel("---"); // Nombre del campo de Kp
		lblKpCont.setFont(new Font("Arial Black", Font.BOLD, 14)); // Tipo de letra
		lblKpCont.setBackground(Color.ORANGE);
		lblKpCont.setBounds(255, 181, 165, 21);
		contentPane.add(lblKpCont); // Agregar label

		lblTiCont = new JLabel("---"); // Nombre del campo de Ti
		lblTiCont.setFont(new Font("Arial Black", Font.BOLD, 14)); // Tipo de letra
		lblTiCont.setBackground(Color.ORANGE);
		lblTiCont.setBounds(254, 213, 166, 21);
		contentPane.add(lblTiCont); // Agregar label

		lblTdCont = new JLabel("---"); // Nombre del campo de Td
		lblTdCont.setFont(new Font("Arial Black", Font.BOLD, 14)); // Tipo de letra
		lblTdCont.setBackground(Color.ORANGE);
		lblTdCont.setBounds(254, 245, 166, 21);
		contentPane.add(lblTdCont); // Agregar label

		txtUsc = new JTextField(); // crear txt de datos
		txtUsc.setFont(new Font("Arial", Font.BOLD, 16)); // Tipo de letra
		txtUsc.setBounds(320, 31, 100, 31);
		contentPane.add(txtUsc); // Agregar el txt de la primera entrada
		txtUsc.setColumns(10); // espacio de txt

		txtUsi = new JTextField(); // crear txt
		txtUsi.setFont(new Font("Arial", Font.BOLD, 16)); // Tipo de letra
		txtUsi.setColumns(10);
		txtUsi.setBounds(320, 76, 100, 31);
		contentPane.add(txtUsi); // Agregar el txt de la segunda entrada

		JScrollPane scrollPane = new JScrollPane(); // lo que va a llevar la tabla
		scrollPane.setBounds(10, 11, 179, 150);// dimensiones
		contentPane.add(scrollPane); // se añade al panel

		DefaultTableModel modelo = new DefaultTableModel(); //crea un modelo para la tabla
		table = new JTable(modelo); // crea una tabla y le agrega el modelo
		table.setModel(new DefaultTableModel( // al modelo le agrega las columnas que va a llevar
				new Object[][] { // vector de las columnas
				},
				new String[] {
						"t", "g(t)"
				}
				) 
		{
			Class[] columnTypes = new Class[] { //crea un vector y le agrega 2 strings
					String.class, String.class // string t, g(t)
			};
			public Class getColumnClass(int columnIndex) { // trae la clase, parametro el index de la columan y retorna el el index de la columna
				return columnTypes[columnIndex];//
			}
		});
		ArrayList<String[]> datos = leer.importarDatos("primerOrden.txt");// agregar los datos de la clase leer, que se traen en el  metodo importar datos
		for (int i = 0; i < datos.size(); i++) { // agrega los datos a la tabla
			((DefaultTableModel)table.getModel()).addRow(datos.get(i)); 
		}
		scrollPane.setViewportView(table); // la tabla contiene ese scrollpane
		
		btnNuevo = new JButton("Nuevo Cálculo");
		btnNuevo.setFont(new Font("Arial", Font.BOLD, 14));
		btnNuevo.setBackground(Color.WHITE);
		btnNuevo.setBounds(264, 275, 165, 31);
		contentPane.add(btnNuevo);
		
		btnCalcular.addActionListener(this);// accion del boton
		btnNuevo.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {// metodo que se agrega cuando impelmenta la clase actionlistener
		if(e.getSource() == btnCalcular){ // verfica la accion del boton calcular
			txtUsi.setEditable(false);
			txtUsc.setEditable(false);
			btnCalcular.setEnabled(false);
			if(!txtUsi.getText().equals("") && !txtUsc.getText().equals("")){ // verfica que los datos no esten vacios
				String usi = txtUsi.getText();// trae los datos de un texto en txtUsi
				String usc = txtUsc.getText(); // trae los datos de un texto en txtUsc
				calcular(usi, usc); // llama al metodo calcular y pasa los metodos que piden
			}
			else // campos no estan llenos,envia excepcion
			{
				JOptionPane.showMessageDialog(this, "Por favor llene todos los campos");
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

	public void calcular(String usi, String usc){ // metodo calcular

		//------------------------------------T0 y T1 y T2 --------------------------------

		double t0=0;
		double t1=0;
		double t2=0;

		ArrayList<String[]> datos = leer.importarDatos("primerOrden.txt"); //llama metodo importar datos y lo guarda en un arraylist

		double[] vecX = new double[datos.size()];
		double[] vecY = new double[datos.size()];
		
		//--------------------guardar los x en un vector
		for (int i = 0; i < vecX.length; i++) {
			String auxX = datos.get(i)[0];
			char[] charX = auxX.toCharArray();
			auxX="";
			for (int j = 0; j < charX.length; j++) {
				if(charX[j]==','){
					charX[j]='.';
				}
				auxX=auxX+charX[j];
			}
			vecX[i] = Double.parseDouble(auxX);
		}
		
		//--------------------guardar los y en un vector
		for (int i = 0; i < vecY.length; i++) {
			String auxY = datos.get(i)[1];
			char[] charY = auxY.toCharArray();
			auxY="";
			for (int j = 0; j < charY.length; j++) {
				if(charY[j]==','){
					charY[j]='.';
				}
				auxY=auxY+charY[j];
			}
			vecY[i] = Double.parseDouble(auxY);
		}
		
		int ultimox = vecX.length;
		double m =0;
		double max = 0;
		int imax = 0;
		
		
		for (int i = 0; i < (ultimox-2); i++) {
			m=(vecY[i+1]-vecY[i])/(vecX[i+1]-vecX[i]);
			if(m>max){
				max=m;
				imax=i;
			}
		}
		//------------------Hallar el maximo y-----------------
		int ceroy=0;
		int yInfinitoPos = 0;
		double maxDou=0;
		for (int i = 0; i < vecY.length; i++) {
			if(vecY[i] > maxDou){
				yInfinitoPos=i;
			}
		}
		
				
		if(yInfinitoPos == ceroy){
			yInfinitoPos=yInfinitoPos+1;
		}
		double yInfinito =vecY[yInfinitoPos];
		
		//-------------------Hallar el menor de y------------------------------
		int yCeroPos = 0;
		double minDou=0;
		for (int i = 0; i < vecY.length; i++) {
			if(vecY[i]<minDou){
				yCeroPos=i;
			}
		}
		int cero=0;
		if(yCeroPos==cero){
			yCeroPos=yCeroPos+1;
		}
		double yCero=vecY[yCeroPos];
		
		//y=mx+b
		//y-mx=b
		double b = (vecY[imax])-max*vecX[imax];
		
		//--------------------------Encontar t2---------------------------------
		double y = 0;
		t2 = 0;
		int x = 1;
		while(y<=yInfinito){
			y=(max*(vecX[x]))+b;
			t2=vecX[x];
			x++;
		}
		
		//------------------------Encontrar t1---------------------------
		t1=0;
		int xmenos=imax;
		while(y>yCero){
			y=(max*(vecX[xmenos]))+b;
			t1=vecX[xmenos];
			xmenos--;
		}
		
		//------------------------Encontrar t0------------------------------
		t0=0;
		int w = 1;
		y = 0;
		while(y==yCero){
			y=vecY[w];
			//t0=vecX[w]
			t0=vecX[w];
			w++;
		}
		
		lblT1Cont.setText(""+t0);
		lblT2Cont.setText(""+t1);
		lblT3Cont.setText(""+t2);
		
		//------------------------------------Yinf Y0--------------------------------

		String y0 = datos.get(0)[1]; // Agrega la posición 0 del array y en esa pocision la posicion 1 del vector 
		String yinf = datos.get(datos.size()-1)[1]; // Ultima posicion del array de la ultima posicion del vector 

		//------------------------------------K0--------------------------------

		char[] auxY0= y0.toCharArray(); // Crea un vector de chars. Pasa a char lo que hay en Y0
		char[] auxYinf= yinf.toCharArray(); // Crea un vector de chars. Pasa a char lo que hay en Yinf
		y0 = ""; // Iguala variables a vacío
		yinf = ""; // Iguala variables a vacío
		for (int i = 0; i < auxY0.length; i++) { // Cambia comas por puntos
			if(auxY0[i] == ','){
				auxY0[i] = '.'; 
			}
			y0=y0+auxY0[i]; // Cambia comas por puntos
		}

		for (int i = 0; i < auxYinf.length; i++) {  // Cambia comas por puntos
			if(auxYinf[i] == ','){
				auxYinf[i] = '.'; 
			}
			yinf=yinf+auxYinf[i]; // Va agregando los chars a la variable String
		}
		
		Double restaA = Double.parseDouble(yinf) - Double.parseDouble(y0); // Pasa a double y Resta Yinf - Yo
		Double restaB = Double.parseDouble(usi) - Double.parseDouble(usc); // Pasa String a double y resta usi - usc
		double K0 = restaA/restaB; 

		//------------------------------------T0--------------------------------



		double T0 = t1-t0; // Pasa a double y Resta t1 - t0

		//----------------------------------r0-----------------------


		double r0 = t2-t1;

		//--------------------------Kp-------------------------------
		double Kp = (1.2*r0)/(K0*T0);
		lblKpCont.setText(""+Kp);

		//-------------------------Ti------------------
		double Ti = 2*T0;
		lblTiCont.setText(""+Ti);

		//------------------------Td------------------------------
		double Td = 0.5*T0;
		lblTdCont.setText(""+Td);

	}


}