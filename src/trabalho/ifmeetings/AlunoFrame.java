import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class AlunoFrame {

	JFrame frame;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtInsc;
	private JTextField txtFone;
	private JTextField txtIdade;
	private JTextField txtEnder;
	private JTextField txtCpf;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlunoFrame window = new AlunoFrame();
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
	public AlunoFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 435);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Aluno");
		lblNewLabel.setBounds(214, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("N\u00FAmero de Inscri\u00E7\u00E3o:");
		lblNewLabel_1.setBounds(21, 118, 102, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nome:");
		lblNewLabel_2.setBounds(21, 55, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtNome = new JTextField();
		txtNome.setBounds(21, 80, 196, 20);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("E-mail:");
		lblNewLabel_3.setBounds(253, 55, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(253, 80, 206, 20);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtInsc = new JTextField();
		txtInsc.setBounds(21, 143, 102, 20);
		frame.getContentPane().add(txtInsc);
		txtInsc.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Telefone:");
		lblNewLabel_4.setBounds(171, 118, 68, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		txtFone = new JTextField();
		txtFone.setBounds(171, 143, 128, 20);
		frame.getContentPane().add(txtFone);
		txtFone.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Idade:");
		lblNewLabel_5.setBounds(343, 118, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		txtIdade = new JTextField();
		txtIdade.setBounds(343, 143, 116, 20);
		frame.getContentPane().add(txtIdade);
		txtIdade.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Endere\u00E7o:");
		lblNewLabel_6.setBounds(21, 186, 102, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		txtEnder = new JTextField();
		txtEnder.setBounds(21, 210, 196, 20);
		frame.getContentPane().add(txtEnder);
		txtEnder.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("CPF:");
		lblNewLabel_7.setBounds(274, 186, 46, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(274, 210, 185, 20);
		frame.getContentPane().add(txtCpf);
		txtCpf.setColumns(10);
		
		JButton btnNewButton = new JButton("Inserir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Connection conn = null;
				
				try {
				
				conn = Conexao.getConnection(); 

				String sql = "insert into aluno values (?, ?, ?, ?, ?, ?, ?)"; 

				PreparedStatement stm = conn.prepareStatement(sql); 

				stm.setInt(1, Integer.parseInt(txtInsc.getText()));
				stm.setString(2, txtNome.getText());
				stm.setString(3, txtEmail.getText());
				stm.setString(4, txtFone.getText());
				stm.setString(5, txtCpf.getText());
				stm.setString(6, txtEnder.getText());
				stm.setInt(7, Integer.parseInt(txtIdade.getText()));
				
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
		btnNewButton.setBounds(21, 256, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Selecionar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					
					Connection conn = Conexao.getConnection();
					
					String sql = "select * from aluno where cpf = ?";
				
					PreparedStatement pstm = conn.prepareStatement(sql);
					
					pstm.setString(1, txtCpf.getText());
					
					ResultSet rs = pstm.executeQuery();
					
					DefaultTableModel modelo = (DefaultTableModel) table.getModel();
					
					while(rs.next()) {
						
					String[] linhas = new String[] {rs.getString("Nome"), rs.getString("Email")
					, rs.getString("CPF"), rs.getString("Ender"), rs.getString("Fone"), rs.getString("Idade")};
						
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
		btnNewButton_1.setBounds(138, 256, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Deletar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Connection conn = null;
				
				try {
				
				conn = Conexao.getConnection(); 

				String sql = "delete from Aluno where num_insc = ?"; 

				PreparedStatement stm = conn.prepareStatement(sql); 

				stm.setInt(1, Integer.parseInt(txtInsc.getText()));

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
		btnNewButton_2.setBounds(257, 256, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Alterar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Connection conn = null;
				
				try {
				
				conn = Conexao.getConnection(); 

				String sql = "update Aluno set nome = ?, email = ?, fone = ?, cpf = ?, ender = ?, idade = ? where num_insc = ?"; 

				PreparedStatement stm = conn.prepareStatement(sql); 

				stm.setInt(1, Integer.parseInt(txtInsc.getText()));
				stm.setString(2, txtNome.getText());
				stm.setString(3, txtEmail.getText());
				stm.setString(4, txtFone.getText());
				stm.setString(5, txtCpf.getText());
				stm.setString(6, txtEnder.getText());
				stm.setInt(7, Integer.parseInt(txtIdade.getText()));
				
				stm.executeUpdate(); 

				stm.close();
				conn.close();
				
				} catch (Exception e1) {
				  e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(370, 256, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 290, 438, 60);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"NumInsc", "Nome", "Email", "CPF", "Ender", "Fone", "Idade"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, String.class, Integer.class
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
			
				txtInsc.setText("");
				txtNome.setText("");
				txtEmail.setText("");
				txtFone.setText("");
				txtCpf.setText("");
				txtEnder.setText("");
				txtIdade.setText(""); 
			}
		});
		btnNewButton_4.setBounds(186, 362, 89, 23);
		frame.getContentPane().add(btnNewButton_4);
	}
}
