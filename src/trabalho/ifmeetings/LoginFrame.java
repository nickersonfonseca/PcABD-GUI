import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LoginFrame  extends TelaPrincipalFrame{

	private JFrame frame;
	private JTextField txtEmail;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame window = new LoginFrame();
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
	public LoginFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 102, 51));
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 0));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(33, 22, 365, 167);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setFont(new Font("Ebrima", Font.BOLD, 14));
		lblNewLabel.setBounds(145, 11, 63, 19);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("E-mail:");
		lblNewLabel_1.setFont(new Font("Ebrima", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(33, 44, 63, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Senha:");
		lblNewLabel_2.setBounds(33, 85, 63, 14);
		panel.add(lblNewLabel_2);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(106, 41, 227, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(106, 82, 157, 20);
		panel.add(txtSenha);
		txtSenha.setColumns(10);
		
		JButton btnNewButton = new JButton("ENTRAR");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			
			try {
			Connection conn = Conexao.getConnection(); 
		
			String sql = "insert into usuario values (?, ?)";
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, Integer.parseInt(txtSenha.getText()));
			pstm.setString(2, txtEmail.getText());
			
			pstm.executeUpdate();
			
			TelaPrincipalFrame novo = new TelaPrincipalFrame();
			novo.frame.setVisible(true);
			
			pstm.close();
			conn.close();
			
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			}
		
		});
		btnNewButton.setBounds(69, 133, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Limpar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				txtEmail.setText("");
				txtSenha.setText("");
			}
		});
		btnNewButton_1.setBounds(206, 133, 89, 23);
		panel.add(btnNewButton_1);
	}
}
