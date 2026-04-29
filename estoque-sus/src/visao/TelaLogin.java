package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField emailField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
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
		
		emailField = new JTextField();
		emailField.setBackground(new Color(242, 242, 242));
		emailField.setBounds(100, 132, 185, 33);
		panel.add(emailField);
		emailField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(242, 242, 242));
		passwordField.setBounds(100, 225, 185, 33);
		panel.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setBounds(100, 116, 90, 14);
		panel.add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(100, 209, 44, 14);
		panel.add(lblSenha);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setBounds(225, 381, 123, 53);
		panel.add(btnNewButton);
		
		JLabel lblEsqueciMinhaSenha = new JLabel("Esqueci minha senha");
		lblEsqueciMinhaSenha.setBounds(141, 286, 108, 14);
		panel.add(lblEsqueciMinhaSenha);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Administrador\\Pictures\\unnamed.png"));
		lblNewLabel_1.setBounds(290, 124, 453, 300);
		contentPane.add(lblNewLabel_1);

	}
}
