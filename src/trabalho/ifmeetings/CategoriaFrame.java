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
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class CategoriaFrame {

	JFrame frame;
	private JTextField txtCodCat;
	private JTextField txtDesc;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CategoriaFrame window = new CategoriaFrame();
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
	public CategoriaFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 305);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Categoria ");
		lblNewLabel.setBounds(158, 11, 79, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo da categoria: ");
		lblNewLabel_1.setBounds(10, 46, 122, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Descri\u00E7\u00E3o:");
		lblNewLabel_2.setBounds(10, 83, 122, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtCodCat = new JTextField();
		txtCodCat.setBounds(142, 46, 180, 20);
		frame.getContentPane().add(txtCodCat);
		txtCodCat.setColumns(10);
		
		txtDesc = new JTextField();
		txtDesc.setBounds(142, 80, 232, 20);
		frame.getContentPane().add(txtDesc);
		txtDesc.setColumns(10);
		
		JButton btnNewButton = new JButton("Inserir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				Connection conn = null;
				
				try {
				
				conn = Conexao.getConnection(); 

				String sql = "insert into categoria values (?, ?)"; 

				PreparedStatement stm = conn.prepareStatement(sql); 

				stm.setInt(1, Integer.parseInt(txtCodCat.getText()));
				stm.setString(2, txtDesc.getText());
				
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
		btnNewButton.setBounds(10, 133, 79, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Selecionar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					
					Connection conn = Conexao.getConnection();
					
					String sql = "select * from categoria where desc = ?";
				
					PreparedStatement pstm = conn.prepareStatement(sql);
					
					pstm.setString(1, txtDesc.getText());
					
					ResultSet rs = pstm.executeQuery();
					
					DefaultTableModel modelo = (DefaultTableModel) table.getModel();
					
					while(rs.next()) {
						
					String[] linhas = new String[] {rs.getString("Descri\\u00E7\\u00E3o")};
						
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
		btnNewButton_1.setBounds(99, 133, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Alterar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Connection conn = null;
				
				try {
				
				conn = Conexao.getConnection(); 

				String sql = "update categoria set descricao = ? where cod_cat = ?"; 

				PreparedStatement stm = conn.prepareStatement(sql); 

				stm.setInt(1, Integer.parseInt(txtCodCat.getText()));
				stm.setString(2, txtDesc.getText());
				
				stm.executeUpdate(); 

				stm.close();
				conn.close();
				
				} catch (Exception e1) {
				  e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(198, 133, 79, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Deletar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Connection conn = null;
				
				try {
				
				conn = Conexao.getConnection(); 

				String sql = "delete from categoria where cod_cat = ?"; 

				PreparedStatement stm = conn.prepareStatement(sql); 

				stm.setInt(1, Integer.parseInt(txtCodCat.getText()));
				
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
		btnNewButton_3.setBounds(285, 133, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 167, 364, 53);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CodCat", "Descri\u00E7\u00E3o"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_4 = new JButton("Limpar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				txtCodCat.setText("");
				txtDesc.setText(""); 
			}
		});
		btnNewButton_4.setBounds(142, 232, 89, 23);
		frame.getContentPane().add(btnNewButton_4);
	}

}
