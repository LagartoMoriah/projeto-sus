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
import modelo.Usuario;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cpfField;
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

		cpfField = new JTextField();
		cpfField.setBackground(new Color(242, 242, 242));
		cpfField.setBounds(100, 132, 185, 33);
		panel.add(cpfField);
		cpfField.setColumns(10);

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

		JButton loginBtn = new JButton("Entrar");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = cpfField.getText().trim();
				String senha = new String(passwordField.getPassword());

				ConexaoUsuario service = new ConexaoUsuario();
				Usuario usuarioLogado = service.buscarUsuario(cpf, senha);

				if (usuarioLogado != null) {
					JOptionPane.showMessageDialog(null, "Bem-vindo, " + usuarioLogado.getNome());

					if (usuarioLogado.isAdmin()) {
						// Se for Admin (isadmin == 1 no banco)
						new TelaAdmin().setVisible(true);
					} else {
						// Se não for Admin (isadmin == 0 no banco)
						new TelaUnidade().setVisible(true);
					}

					dispose(); // Fecha a tela de login
				} else {
					JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos");
				}
			}
		});
		loginBtn.setBounds(225, 381, 123, 53);
		panel.add(loginBtn);

		JLabel lblEsqueciMinhaSenha = new JLabel("Esqueci minha senha");
		lblEsqueciMinhaSenha.setBounds(141, 286, 108, 14);
		panel.add(lblEsqueciMinhaSenha);
		
		JButton cadBtn = new JButton("Cadastrar");
		cadBtn.setBounds(67, 381, 123, 53);
		panel.add(cadBtn);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Administrador\\Pictures\\unnamed.png"));
		lblNewLabel_1.setBounds(290, 124, 453, 300);
		contentPane.add(lblNewLabel_1);

	}
}
