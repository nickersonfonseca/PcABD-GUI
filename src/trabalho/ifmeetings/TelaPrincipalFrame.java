import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipalFrame {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipalFrame window = new TelaPrincipalFrame();
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
	public TelaPrincipalFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 485, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tela Principal");
		lblNewLabel.setBounds(192, 36, 94, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Alterar entidade:");
		lblNewLabel_1.setBounds(53, 66, 100, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Aluno");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			AlunoFrame aluno = new AlunoFrame();
			aluno.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 104, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Professor");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			ProfessorFrame professor = new ProfessorFrame();
			professor.frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(109, 104, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Curso");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			CursoFrame curso = new CursoFrame();
			curso.frame.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(10, 150, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Categoria");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			CategoriaFrame categoria = new CategoriaFrame();
			categoria.frame.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(109, 150, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("Saiba mais:");
		lblNewLabel_2.setBounds(311, 66, 72, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_4 = new JButton("Calculadora");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			CalculadoraFrame calculadora = new CalculadoraFrame();
			calculadora.frame.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(249, 117, 89, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Tradutor");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			TradutorFrame tradutor = new TradutorFrame();
			tradutor.frame.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(348, 117, 89, 23);
		frame.getContentPane().add(btnNewButton_5);
	}
}
