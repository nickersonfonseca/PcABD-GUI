import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TradutorFrame {

	JFrame frame;
	private JTextField txtEstacao;
	private JTextField txtDia;
	private JTextField txtLocal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TradutorFrame window = new TradutorFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TradutorFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 541, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tradutor");
		lblNewLabel.setBounds(237, 11, 59, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Escolha o seu favorito entre as op\u00E7\u00F5es:");
		lblNewLabel_1.setBounds(10, 62, 202, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Esta\u00E7\u00E3o do ano:");
		lblNewLabel_2.setBounds(218, 62, 78, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JComboBox<Object> cbEstacao = new JComboBox<Object>();
		cbEstacao.setModel(new DefaultComboBoxModel(new String[] {"Selecionar:", "Ver\u00E3o", "Inverno", "Outono", "Primavera"}));
		cbEstacao.setBounds(200, 94, 106, 22);
		frame.getContentPane().add(cbEstacao);
		
		JLabel lblNewLabel_3 = new JLabel("Dia da semana:");
		lblNewLabel_3.setBounds(326, 62, 74, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JComboBox<Object> cbDia = new JComboBox<Object>();
		cbDia.setModel(new DefaultComboBoxModel(new String[] {"Selecionar:", "Domingo", "Segunda", "Ter\u00E7a", "Quarta", "Quinta", "Sexta", "S\u00E1bado"}));
		cbDia.setBounds(316, 94, 94, 22);
		frame.getContentPane().add(cbDia);
		
		JLabel lblNewLabel_4 = new JLabel("Local favorito:");
		lblNewLabel_4.setBounds(425, 62, 74, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JComboBox<Object> cbLocal = new JComboBox<Object>();
		cbLocal.setModel(new DefaultComboBoxModel(new String[] {"Selecionar:", "Pra\u00E7a", "Escola", "Museu", "Praia", "Livraria"}));
		cbLocal.setBounds(421, 94, 94, 22);
		frame.getContentPane().add(cbLocal);
		
		JLabel lblNewLabel_5 = new JLabel("Portugu\u00EAs para ingl\u00EAs:");
		lblNewLabel_5.setBounds(190, 152, 121, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		txtEstacao = new JTextField();
		txtEstacao.setBounds(36, 199, 115, 20);
		frame.getContentPane().add(txtEstacao);
		txtEstacao.setColumns(10);
		
		txtDia = new JTextField();
		txtDia.setBounds(190, 199, 129, 20);
		frame.getContentPane().add(txtDia);
		txtDia.setColumns(10);
		
		txtLocal = new JTextField();
		txtLocal.setBounds(354, 199, 115, 20);
		frame.getContentPane().add(txtLocal);
		txtLocal.setColumns(10);
		
		JButton btnNewButton = new JButton("Traduzir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if (cbEstacao.getSelectedItem().toString().equalsIgnoreCase("Verão")) {
					txtEstacao.setText("Verão >>> Summer");
					} else if (cbEstacao.getSelectedItem().toString().equalsIgnoreCase("Inverno")) {
					txtEstacao.setText("Inverno >>> Winter");
					} else if (cbEstacao.getSelectedItem().toString().equalsIgnoreCase("Outono")) {
					txtEstacao.setText("Outono >>> Autumn");
					}
					 else {
					txtEstacao.setText("Primavera >>> Spring"); 
					}

					if (cbDia.getSelectedItem().toString().equalsIgnoreCase("Domingo")) {
					txtDia.setText("Domingo >>> Sunday");
					} else if (cbDia.getSelectedItem().toString().equalsIgnoreCase("Segunda")) {
						txtDia.setText("Segunda-feira >>> Monday");
					} else if (cbDia.getSelectedItem().toString().equalsIgnoreCase("Terça")) {
						txtDia.setText("Terça-feira >>> Tuesday");
					} else if (cbDia.getSelectedItem().toString().equalsIgnoreCase("Quarta")) {
						txtDia.setText("Quarta-feira >>> Wednesday");
					} else if (cbDia.getSelectedItem().toString().equalsIgnoreCase("Quinta")) {
						txtDia.setText("Quinta-feira >>> Thursday");
					} else if (cbDia.getSelectedItem().toString().equalsIgnoreCase("Sexta")) {
						txtDia.setText("Sexta-feira >>> Friday");
					} else {
						txtDia.setText("Sábado >>> Saturday");
					}


					if (cbLocal.getSelectedItem().toString().equalsIgnoreCase("Praça")) {
					txtLocal.setText("Praça >>> Square");
					} else if (cbLocal.getSelectedItem().toString().equalsIgnoreCase("Escola")) {
						txtLocal.setText("Escola >>> School");
					} else if (cbLocal.getSelectedItem().toString().equalsIgnoreCase("Museu")) {
						txtLocal.setText("Museu >>> Museum");
					} else if (cbLocal.getSelectedItem().toString().equalsIgnoreCase("Praia")) {
						txtLocal.setText("Praia >>> Beach");
					} else { 
						txtLocal.setText("Livraria >>> Library");
					}
			}
		});
		btnNewButton.setBounds(135, 247, 78, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Limpar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cbDia.setSelectedIndex(0);
				cbLocal.setSelectedIndex(0);
				cbEstacao.setSelectedIndex(0);
				txtEstacao.setText(" ");
				txtDia.setText(" ");
				txtLocal.setText(" ");
			}
		});
		btnNewButton_1.setBounds(292, 247, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
