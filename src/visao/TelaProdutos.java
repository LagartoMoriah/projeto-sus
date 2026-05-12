package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import infra.ConexaoProduto;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JList;

public class TelaProdutos extends JFrame {
	ConexaoProduto DAOp = new ConexaoProduto();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProdutos frame = new TelaProdutos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public TelaProdutos() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("UBS JORDANOPOLIS");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(0, 128, 192));
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(266, 11, 246, 32);
		contentPane.add(lblNewLabel_1_1);
		
		
		JList<String> list = new JList(DAOp.getProdutos());
		list.setFont(new Font("Arial", Font.PLAIN, 12));
		list.setBackground(new Color(229, 229, 229));
		list.setBounds(10, 52, 203, 498);
		contentPane.add(list);

	}
}
