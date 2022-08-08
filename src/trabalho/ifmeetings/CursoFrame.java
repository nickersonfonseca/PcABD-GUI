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

public class CursoFrame {

	JFrame frame;
	private JTextField txtTipo;
	private JTextField txtTurno;
	private JTextField txtCodCurso;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CursoFrame window = new CursoFrame();
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
	public CursoFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 311);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Curso");
		lblNewLabel.setBounds(174, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo do curso:");
		lblNewLabel_1.setBounds(188, 98, 104, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtTipo = new JTextField();
		txtTipo.setBounds(66, 54, 308, 20);
		frame.getContentPane().add(txtTipo);
		txtTipo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Turno:");
		lblNewLabel_2.setBounds(10, 98, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtTurno = new JTextField();
		txtTurno.setBounds(66, 95, 104, 20);
		frame.getContentPane().add(txtTurno);
		txtTurno.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Tipo:");
		lblNewLabel_3.setBounds(10, 57, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		txtCodCurso = new JTextField();
		txtCodCurso.setBounds(302, 95, 72, 20);
		frame.getContentPane().add(txtCodCurso);
		txtCodCurso.setColumns(10);
		
		JButton btnNewButton = new JButton("Inserir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection conn = null;
				
				try {
				
				conn = Conexao.getConnection(); 

				String sql = "insert into curso values (?, ?, ?)"; 

				PreparedStatement stm = conn.prepareStatement(sql); 

				stm.setInt(1, Integer.parseInt(txtCodCurso.getText()));
				stm.setString(2, txtTipo.getText());
				stm.setString(3, txtTurno.getText());
				
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
		btnNewButton.setBounds(10, 137, 77, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Selecionar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					
					Connection conn = Conexao.getConnection();
					
					String sql = "select * from curso where tipo = ?";
				
					PreparedStatement pstm = conn.prepareStatement(sql);
					
					pstm.setString(1, txtTipo.getText());
					
					ResultSet rs = pstm.executeQuery();
					
					DefaultTableModel modelo = (DefaultTableModel) table.getModel();
					
					while(rs.next()) {
						
					String[] linhas = new String[] {rs.getString("Tipo"), rs.getString("Turno")};
						
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
		btnNewButton_1.setBounds(97, 137, 94, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Alterar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					Connection conn = null;
					
					try {
					
					conn = Conexao.getConnection(); 

					String sql = "update curso set turno = ?, tipo = ? where cod_curso = ?";  

					PreparedStatement stm = conn.prepareStatement(sql); 

					stm.setInt(1, Integer.parseInt(txtCodCurso.getText()));
					stm.setString(2, txtTipo.getText());
					stm.setString(3, txtTurno.getText());
					
					stm.executeUpdate(); 

					stm.close();
					conn.close();
					
					} catch (Exception e1) {
					  e1.printStackTrace();
					}
				}
		});
		btnNewButton_2.setBounds(201, 137, 81, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Deletar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					Connection conn = null;
					
					try {
					
					conn = Conexao.getConnection(); 

					String sql = "delete from curso where cod_curso = ?"; 

					PreparedStatement stm = conn.prepareStatement(sql); 

					stm.setInt(1, Integer.parseInt(txtCodCurso.getText()));
		
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
		btnNewButton_3.setBounds(297, 137, 77, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 171, 364, 59);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CodCurso", "Tipo", "Turno"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_4 = new JButton("Limpar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				txtCodCurso.setText("");
				txtTipo.setText("");
				txtTurno.setText("");
			}
		});
		btnNewButton_4.setBounds(148, 238, 89, 23);
		frame.getContentPane().add(btnNewButton_4);
	}

}
