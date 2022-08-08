import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculadoraFrame {

	JFrame frame;
	private JTextField txtN1;
	private JTextField txtN2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraFrame window = new CalculadoraFrame();
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
	public CalculadoraFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 260);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Calculadora:");
		lblNewLabel.setBounds(173, 48, 77, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("N\u00FAmero 01:");
		lblNewLabel_1.setBounds(71, 89, 68, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("N\u00FAmero 02:");
		lblNewLabel_2.setBounds(289, 89, 68, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtN1 = new JTextField();
		txtN1.setBounds(46, 125, 112, 20);
		frame.getContentPane().add(txtN1);
		txtN1.setColumns(10);
		
		txtN2 = new JTextField();
		txtN2.setBounds(263, 125, 120, 20);
		frame.getContentPane().add(txtN2);
		txtN2.setColumns(10);
		
		JButton Calcular = new JButton("Calcular");
		Calcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Double n1 = Double.parseDouble(txtN1.getText());
				Double n2 = Double.parseDouble(txtN2.getText()); 

				Double soma = n1 + n2;
				Double sub = n1 - n2;
				Double mult = n1 * n2;
				Double div = n1/n2; 

				String Resultado = "Soma: " + soma + "\n Subtração: " + sub + "\n Multiplicação: " + mult + "\n Divisão" + div; 
			
				JOptionPane.showMessageDialog(null, Resultado, "Calculadora", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		Calcular.setBounds(112, 181, 89, 23);
		frame.getContentPane().add(Calcular);
		
		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				txtN1.setText("");
				txtN2.setText("");
			}
		});
		btnNewButton.setBounds(211, 181, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
