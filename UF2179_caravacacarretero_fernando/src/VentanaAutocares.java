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
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VentanaAutocares extends JFrame {

	private JPanel contentPane;
	private JTextField txtMatricula;
	private JTextField txtMarca;
	private JTextField txtKilometros;
	private JTextField txtModelo;
	private JTable tablaMostrar;
	private ArrayList<Autocar> listaAutocares;
	private JSpinner spinnerPlazas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAutocares frame = new VentanaAutocares();
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
	public VentanaAutocares() {
		listaAutocares = new ArrayList<Autocar>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[:70px:70px,grow][:100px:100px,grow][][grow]", "[36.00][][][][40px,bottom][grow]"));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		contentPane.add(panel, "cell 0 0 4 1,grow");
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gesti\u00F3n Autocares");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 11, 400, 14);
		panel.add(lblNewLabel);
		
		JLabel lblMatricula = new JLabel("Matr\u00EDcula:");
		contentPane.add(lblMatricula, "cell 0 1,alignx trailing");
		
		txtMatricula = new JTextField();
		contentPane.add(txtMatricula, "cell 1 1,growx");
		txtMatricula.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca:");
		contentPane.add(lblMarca, "cell 0 2,alignx trailing");
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		contentPane.add(txtMarca, "cell 1 2,growx");
		
		JLabel lblModelo = new JLabel("Modelo:");
		contentPane.add(lblModelo, "cell 2 2,alignx trailing");
		
		txtModelo = new JTextField();
		txtModelo.setColumns(10);
		contentPane.add(txtModelo, "cell 3 2,growx");
		
		JLabel lblKilometros = new JLabel("Kil\u00F3metros:");
		contentPane.add(lblKilometros, "cell 0 3,alignx trailing");
		
		txtKilometros = new JTextField();
		txtKilometros.setColumns(10);
		contentPane.add(txtKilometros, "cell 1 3,growx");
		
		JLabel lblPlazas = new JLabel("Plazas:");
		contentPane.add(lblPlazas, "cell 2 3");
		
		spinnerPlazas = new JSpinner();
		spinnerPlazas.setModel(new SpinnerNumberModel(30, 1, 80, 1));
		contentPane.add(spinnerPlazas, "cell 3 3");
		
		JButton btnNewButton = new JButton("Insertar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtMatricula.getText().equals("") || txtMatricula.getText() == null
						|| txtMarca.getText().equals("") || txtMarca.getText() == null
						|| txtModelo.getText().equals("") || txtModelo.getText() == null
						|| txtKilometros.getText().equals("") || txtKilometros.getText() == null
						) {
					JOptionPane.showMessageDialog(null, "Debes rellenar los datos");
					return;
				}
				Autocar a = new Autocar(txtMatricula.getText(), txtMarca.getText(), txtModelo.getText(), Integer.parseInt(txtKilometros.getText()), (Integer) spinnerPlazas.getValue());
				listaAutocares.add(a);
				Limpiar();
				
			}
		});
		contentPane.add(btnNewButton, "cell 0 4 2 1,alignx right");
		
		JButton btnNewButton_1 = new JButton("Mostrar Datos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modelo = (DefaultTableModel) tablaMostrar.getModel();
				modelo.setRowCount(0);
				
				for (Autocar a : listaAutocares) {
					Object fila [] = {
							a.getMarca(), a.getModelo(), a.getKilometros(),
							a.getNum_plazas(), a.getMatricula()
					};
					modelo.addRow(fila);
				}
				
			}
		});
		contentPane.add(btnNewButton_1, "cell 2 4 2 1,alignx left");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 5 4 1,grow");
		
		tablaMostrar = new JTable();
		tablaMostrar.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Marca", "Modelo", "Kil\u00F3metros", "Plazas", "Matr\u00EDcula"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Integer.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			
		});
		scrollPane.setViewportView(tablaMostrar);
	}

	protected void Limpiar() {
		txtMatricula.setText("");
		txtMarca.setText("");
		txtKilometros.setText("");
		txtModelo.setText("");
		spinnerPlazas.setValue(30);
	}

}
