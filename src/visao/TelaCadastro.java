package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import infra.ConexaoUsuario;

public class TelaCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nomeField;
	private JTextField cpfField;
	private JTextField emailField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
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
	public TelaCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 11, 382, 539);
		contentPane.add(panel);
		panel.setLayout(null);

		nomeField = new JTextField();
		nomeField.setBackground(new Color(242, 242, 242));
		nomeField.setBounds(10, 25, 362, 33);
		panel.add(nomeField);
		nomeField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nome Completo");
		lblNewLabel.setBounds(10, 11, 90, 14);
		panel.add(lblNewLabel);

		JLabel lblSenha = new JLabel("CPF");
		lblSenha.setBounds(10, 69, 44, 14);
		panel.add(lblSenha);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(10, 132, 44, 14);
		panel.add(lblEmail);
		
		cpfField = new JTextField();
		cpfField.setColumns(10);
		cpfField.setBackground(new Color(242, 242, 242));
		cpfField.setBounds(10, 83, 362, 33);
		panel.add(cpfField);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBackground(new Color(242, 242, 242));
		emailField.setBounds(10, 157, 362, 33);
		panel.add(emailField);
		
		JLabel lblSenha_1 = new JLabel("Senha");
		lblSenha_1.setBounds(10, 201, 44, 14);
		panel.add(lblSenha_1);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(242, 242, 242));
		passwordField.setBounds(10, 220, 362, 33);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = nomeField.getText().trim();
				String cpf = cpfField.getText().trim();
				String email = emailField.getText().trim();
				String senha = new String(passwordField.getPassword());
				
				if(nome.isEmpty() || cpf.isEmpty() || email.isEmpty() || senha.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
					return;
				}
				
				try {
					ConexaoUsuario service = new ConexaoUsuario();
					service.inserirUsuario(nome, cpf, email, senha);
					JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
					
					nomeField.setText("");
		            cpfField.setText("");
		            emailField.setText("");
		            passwordField.setText("");
		            
				}catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + ex.getMessage());
		        }
			}
		});
		btnNewButton.setBounds(211, 318, 161, 48);
		panel.add(btnNewButton);
		
		JButton voltarBtn = new JButton("Voltar");
		voltarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaLogin().setVisible(true);
				dispose();
			}
		});
		voltarBtn.setBounds(211, 397, 161, 48);
		panel.add(voltarBtn);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Administrador\\Pictures\\unnamed.png"));
		lblNewLabel_1.setBounds(290, 124, 453, 300);
		contentPane.add(lblNewLabel_1);

	}
}
