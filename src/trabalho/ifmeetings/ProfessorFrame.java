import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class ProfessorFrame {

	JFrame frame;
	private JTextField txtMatrIF;
	private JTextField txtForm;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtIdade;
	private JTextField txtFone;
	private JTextField txtCpf;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfessorFrame window = new ProfessorFrame();
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
	public ProfessorFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 510, 444);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Professor");
		lblNewLabel.setBounds(219, 11, 55, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Matr\u00EDcula do IF:");
		lblNewLabel_1.setBounds(10, 41, 114, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtMatrIF = new JTextField();
		txtMatrIF.setBounds(10, 66, 205, 20);
		frame.getContentPane().add(txtMatrIF);
		txtMatrIF.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Forma\u00E7\u00E3o:");
		lblNewLabel_2.setBounds(267, 41, 79, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtForm = new JTextField();
		txtForm.setBounds(267, 66, 217, 20);
		frame.getContentPane().add(txtForm);
		txtForm.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Nome:");
		lblNewLabel_3.setBounds(10, 111, 73, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 136, 205, 20);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("E-mail:");
		lblNewLabel_4.setBounds(267, 111, 55, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(267, 136, 217, 20);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Idade:");
		lblNewLabel_5.setBounds(10, 180, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		txtIdade = new JTextField();
		txtIdade.setBounds(10, 205, 145, 20);
		frame.getContentPane().add(txtIdade);
		txtIdade.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Telefone:");
		lblNewLabel_6.setBounds(187, 180, 73, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		txtFone = new JTextField();
		txtFone.setBounds(187, 205, 159, 20);
		frame.getContentPane().add(txtFone);
		txtFone.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("CPF:");
		lblNewLabel_7.setBounds(381, 180, 46, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(381, 205, 103, 20);
		frame.getContentPane().add(txtCpf);
		txtCpf.setColumns(10);
		
		JButton btnNewButton = new JButton("Inserir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection conn = null;
				
				try {
				
				conn = Conexao.getConnection(); 

				String sql = "insert into professor values (?, ?, ?, ?, ?, ?, ?)"; 

				PreparedStatement stm = conn.prepareStatement(sql); 

				stm.setInt(1, Integer.parseInt(txtMatrIF.getText()));
				stm.setString(2, txtNome.getText());
				stm.setString(3, txtIdade.getText());
				stm.setString(4, txtEmail.getText());
				stm.setString(5, txtForm.getText());
				stm.setString(6, txtCpf.getText());
				stm.setString(7, txtFone.getText());
				
				int executar = stm.executeUpdate(); 
				
				if(executar > 0) {
					JOptionPane.showMessageDialog(null, "Usuário inserido", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Usuário NÃO inserido", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				
				stm.close();
				conn.close();
				
				} catch (Exception e1) {
				  e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(10, 244, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Selecionar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
				
					Connection conn = Conexao.getConnection();
					
					String sql = "select * from professor where matri_if = ?";
				
					PreparedStatement pstm = conn.prepareStatement(sql);
					
					pstm.setInt(1, Integer.parseInt(txtMatrIF.getText()));
					
					ResultSet rs = pstm.executeQuery();
					
					DefaultTableModel modelo = (DefaultTableModel) table.getModel();
					
					while(rs.next()) {
						
					String[] linhas = new String[] {rs.getString("MATRI"), rs.getString("EMAIL"), rs.getString("FORMACAO")
					, rs.getString("NOME"), rs.getString("IDADE"), rs.getString("FONE"), rs.getString("CPF")};
						
					modelo.addRow(linhas);
					}	
					
					rs.close();
					pstm.close();
					conn.close();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}		
		});
		btnNewButton_1.setBounds(138, 244, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Alterar");
		btnNewButton_2.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent e) {
			
				Connection conn = null;
				
				try {
				
				conn = Conexao.getConnection(); 

				String sql = "update professor set nome = ?, idade = ?, email = ?, formacao = ?, cpf = ?, fone = ? where matri_if = ?"; 

				PreparedStatement stm = conn.prepareStatement(sql); 

				stm.setInt(1, Integer.parseInt(txtMatrIF.getText()));
				stm.setString(2, txtNome.getText());
				stm.setString(3, txtIdade.getText());
				stm.setString(4, txtEmail.getText());
				stm.setString(5, txtForm.getText());
				stm.setString(6, txtCpf.getText());
				stm.setString(7, txtFone.getText());
				
				stm.executeUpdate(); 

				stm.close();
				conn.close();
				
				} catch (Exception e1) {
				  e1.printStackTrace();
				}			
				
				}
			
			});
		btnNewButton_2.setBounds(267, 244, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Deletar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Connection conn = null;
				
				try {
				
				conn = Conexao.getConnection(); 

				String sql = "delete from professor where matri_if = ?";  

				PreparedStatement stm = conn.prepareStatement(sql); 

				stm.setInt(1, Integer.parseInt(txtMatrIF.getText()));
				
				int executar = stm.executeUpdate(); 
				
				if(executar > 0) {
					JOptionPane.showMessageDialog(null, "Usuário removido", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Usuário NÃO removido", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				
				stm.close();
				conn.close();
				
				} catch (Exception e1) {
				  e1.printStackTrace();
				}			
			}
		});
		btnNewButton_3.setBounds(395, 244, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 278, 474, 82);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MATRI", "EMAIL", "FORMACAO", "FONE", "IDADE", "NOME", "CPF"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_4 = new JButton("Limpar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					txtMatrIF.setText("");
					txtNome.setText("");
					txtIdade.setText("");
					txtEmail.setText("");
					txtForm.setText("");
					txtCpf.setText("");
					txtFone.setText("");
			}
		});
		btnNewButton_4.setBounds(197, 371, 89, 23);
		frame.getContentPane().add(btnNewButton_4);
	}
}
