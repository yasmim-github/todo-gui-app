package com.window;

import java.awt.EventQueue;

import com.func.NormasEsc;
import com.func.ConectaBanco;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Toolkit;

public class CreateUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField textfield_senha;
	private JTextField textfield_nome;
	private JTextField textfield_email;
	private JPasswordField textfield_conf_senha;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateUser frame = new CreateUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CreateUser() {
		setTitle("Criar Conta");
		setIconImage(Toolkit.getDefaultToolkit().getImage(CreateUser.class.getResource("/assets/favicon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 578, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Criar Conta");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Inter", Font.BOLD, 20));

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Inter", Font.PLAIN, 14));

		JLabel lblNewLabel_2 = new JLabel("Email:");
		lblNewLabel_2.setFont(new Font("Inter", Font.PLAIN, 14));

		JLabel lblNewLabel_3 = new JLabel("Senha:");
		lblNewLabel_3.setFont(new Font("Inter", Font.PLAIN, 14));

		textfield_senha = new JPasswordField();
		textfield_senha.setFont(new Font("Inter", Font.PLAIN, 14));

		textfield_nome = new JTextField();
		textfield_nome.setFont(new Font("Inter", Font.PLAIN, 14));
		textfield_nome.setColumns(10);

		textfield_email = new JTextField();
		textfield_email.setFont(new Font("Inter", Font.PLAIN, 14));
		textfield_email.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Conf senha:");
		lblNewLabel_4.setFont(new Font("Inter", Font.PLAIN, 14));

		textfield_conf_senha = new JPasswordField();
		textfield_conf_senha.setFont(new Font("Inter", Font.PLAIN, 14));

		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Inter", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JButton btnNewButton_1 = new JButton("Criar conta");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Inter", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql_createUser = "INSERT INTO usuario(nome,email,senha) VALUES (?,?,?)";

				ConectaBanco factory = new ConectaBanco();
				
				try (Connection c = factory.conectar()) {
					PreparedStatement ps = c.prepareStatement(sql_createUser);
					ps.setString(1, textfield_nome.getText());
					ps.setString(2, textfield_email.getText());
					ps.setString(3, String.valueOf(textfield_senha.getPassword()));

					/**
					 * @author Yasmim de Souza Para extrair uma String de um campo de senha é
					 *         necessario o método getPassword Além disso precisamos converter pois
					 *         getPassword() retorna char ao invés de String
					 */

					String user_name = textfield_nome.getText();
					String email_user = textfield_email.getText();
					String pass = String.valueOf(textfield_senha.getPassword());
					String passconf = String.valueOf(textfield_conf_senha.getPassword());

					if(pass.equals("") || passconf.equals("") || user_name.equals("") || email_user.equals("")) {
						ps.close();
						JOptionPane.showMessageDialog(null, "Complete os campos.");
					} else if (!pass.equals(passconf)) {
						ps.close();
						JOptionPane.showMessageDialog(null, "As senhas fornecidas não são identicas");
					} else if (!NormasEsc.REGEX_EMAIL_VALIDO(email_user)) {
						ps.close();
						JOptionPane.showMessageDialog(null, "Email fornecido é inválido");
					} else if(!NormasEsc.REGEX_SENHA_VALIDA(String.valueOf(textfield_senha.getPassword()))) {
						ps.close();
						JOptionPane.showMessageDialog(null, "A senha precisa possuir oito digitos, uma letra maiuscula e um caractere especial e dois numeros.");
					}

					ps.execute();
					JOptionPane.showMessageDialog(null, "Usuario criado com sucesso!");
					System.out.println("USUARIO INSERIDO COM SUCESSO");
					HomePage homePage = new HomePage();
					homePage.setVisible(true);
				}

				catch (SQLException w) {
					if (w.getErrorCode() == 1062){
						JOptionPane.showMessageDialog(null, "Esse email já existe, faça o login.");
					} else {
						JOptionPane.showMessageDialog(null, "Aconteceu algo de errado, tente novamente mais tarde.");						
					}
				}

				textfield_nome.setText("");
				textfield_email.setText("");
				textfield_senha.setText("");
				textfield_conf_senha.setText("");

			}

		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(215)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
					.addGap(193))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(106)
					.addComponent(lblNewLabel_1)
					.addGap(4)
					.addComponent(textfield_nome, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
					.addGap(118))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(111)
					.addComponent(lblNewLabel_2)
					.addGap(4)
					.addComponent(textfield_email, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
					.addGap(118))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(105)
					.addComponent(lblNewLabel_3)
					.addGap(4)
					.addComponent(textfield_senha, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
					.addGap(117))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(69)
					.addComponent(lblNewLabel_4)
					.addGap(4)
					.addComponent(textfield_conf_senha, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
					.addGap(117))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(155)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addGap(117))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(textfield_nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_2))
						.addComponent(textfield_email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_3))
						.addComponent(textfield_senha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_4))
						.addComponent(textfield_conf_senha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(59)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addGap(76))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
