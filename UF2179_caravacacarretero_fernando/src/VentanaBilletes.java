import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.TextArea;

public class VentanaBilletes extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtPrecioBillete;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnIda;
	private JRadioButton rdbtnIdaVuelta;
	private JRadioButton rdbtnTarjetaDorada;
	private JTextArea textArea;
	private JComboBox comboBoxOrigen;
	private JComboBox comboBoxDestino;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaBilletes frame = new VentanaBilletes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaBilletes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][:150px:150px,grow][:60px:60px,grow][:150px:150px]", "[grow][][][][][27.00][][300px]"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		contentPane.add(panel_1, "cell 0 0 5 1,grow");
		panel_1.setLayout(new MigLayout("", "[145px]", "[17px]"));
		
		JLabel lblNewLabel = new JLabel("VENTA DE BILLETES");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.BLACK);
		panel_1.add(lblNewLabel, "cell 0 0,alignx left,aligny top");
		
		JLabel lblOrigen = new JLabel("Origen:");
		contentPane.add(lblOrigen, "cell 1 1,alignx trailing");
		
		comboBoxOrigen = new JComboBox();
		comboBoxOrigen.setModel(new DefaultComboBoxModel(new String[] {"Adamuz", "And\u00FAjar", "Cabra", "Carde\u00F1a", "Obejo", "Santaella"}));
		contentPane.add(comboBoxOrigen, "cell 2 1 3 1,growx");
		
		JLabel lblMarca = new JLabel("Destino:");
		contentPane.add(lblMarca, "cell 1 2,alignx trailing");
		
		comboBoxDestino = new JComboBox();
		comboBoxDestino.setModel(new DefaultComboBoxModel(new String[] {"Adamuz", "And\u00FAjar", "Cabra", "Carde\u00F1a", "Obejo", "Santaella"}));
		contentPane.add(comboBoxDestino, "cell 2 2 3 1,growx");
		
		JLabel lblNombre = new JLabel("Nombre:");
		contentPane.add(lblNombre, "cell 1 3,alignx trailing");
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		contentPane.add(txtNombre, "cell 2 3,growx");
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		contentPane.add(lblApellidos, "cell 3 3,alignx center");
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		contentPane.add(txtApellidos, "cell 4 3,growx");
		
		JLabel lblPrecio = new JLabel("Precio:");
		contentPane.add(lblPrecio, "cell 1 4,alignx trailing");
		
		txtPrecioBillete = new JTextField();
		txtPrecioBillete.setBackground(Color.WHITE);
		txtPrecioBillete.setEditable(false);
		txtPrecioBillete.setText("20");
		txtPrecioBillete.setColumns(5);
		contentPane.add(txtPrecioBillete, "cell 2 4,alignx left");
		
		JLabel lblBillete = new JLabel("Billete:");
		contentPane.add(lblBillete, "cell 1 5,alignx right");
		lblBillete.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "cell 2 5,alignx left,growy");
		panel.setLayout(new MigLayout("", "[][][][][]", "[][]"));
		
		rdbtnIda = new JRadioButton("Ida");
		buttonGroup.add(rdbtnIda);
		panel.add(rdbtnIda, "cell 2 1");
		rdbtnIda.setSelected(true);
		
		rdbtnIdaVuelta = new JRadioButton("Ida y Vuelta");
		buttonGroup.add(rdbtnIdaVuelta);
		panel.add(rdbtnIdaVuelta, "cell 3 1");
		
		rdbtnTarjetaDorada = new JRadioButton("Tarjeta Dorada");
		buttonGroup.add(rdbtnTarjetaDorada);
		panel.add(rdbtnTarjetaDorada, "cell 4 1");
		
		JButton btnNewButton = new JButton("CALCULAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxOrigen.getSelectedIndex()==comboBoxDestino.getSelectedIndex()) {
					JOptionPane.showMessageDialog(null, "Debes elegir un origen y destino distinto.");
					return;
				}
				
				String Ida = (String) comboBoxOrigen.getSelectedItem();
				String Destino = (String) comboBoxDestino.getSelectedItem();
				String Nombre = txtNombre.getText();
				String Apellidos = txtApellidos.getText();
				
				textArea.setText("Trayecto: "+Ida+" a "+Destino+"\n"
				+"Viajero: "+Nombre+" "+Apellidos+"\n"
				+"Precio: "+Cobrar());
				
				Limpiar();
				
			}
		});
		contentPane.add(btnNewButton, "cell 1 6 4 1,alignx center");
		
		textArea = new JTextArea();
		contentPane.add(textArea, "cell 1 7 4 1,grow");
	}

	protected void Limpiar() {
		comboBoxOrigen.setSelectedIndex(0);
		comboBoxDestino.setSelectedIndex(0);
		txtNombre.setText("");
		txtApellidos.setText("");
		rdbtnIda.setSelected(true);
		
	}

	protected double Cobrar() {
		double precio=0, billeteviaje = Double.parseDouble(txtPrecioBillete.getText());
		
		if(rdbtnIda.isSelected())
			precio = billeteviaje;
			
		if(rdbtnIdaVuelta.isSelected())
			precio = (billeteviaje * 2) - ((billeteviaje * 2) * 0.20);
			
		if(rdbtnTarjetaDorada.isSelected())
			precio = billeteviaje - (billeteviaje * 0.30);
			
		return precio;
	}

}
