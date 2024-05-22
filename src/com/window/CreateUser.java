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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 539, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Criar conta");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JLabel lblNewLabel_1 = new JLabel("Nome:");

		JLabel lblNewLabel_2 = new JLabel("Email:");

		JLabel lblNewLabel_3 = new JLabel("Senha:");

		textfield_senha = new JPasswordField();

		textfield_nome = new JTextField();
		textfield_nome.setColumns(10);

		textfield_email = new JTextField();
		textfield_email.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Conf senha:");

		textfield_conf_senha = new JPasswordField();

		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JButton btnNewButton_1 = new JButton("Criar conta");
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

					if (!pass.equals(passconf)) {
						ps.close();
						JOptionPane.showMessageDialog(null, "Erro 01 : As senhas fornecidas não são identicas");
					} else if (!NormasEsc.REGEX_EMAIL_VALIDO(email_user)) {
						ps.close();
						JOptionPane.showMessageDialog(null, "Erro 02 : Email fornecido é inválido");
					} else if (!NormasEsc.REGEX_USER_VALIDO(user_name)) {
						ps.close();
						JOptionPane.showMessageDialog(null,
								"Erro 03 : Usuário precisa conter pelo menos um número e caracter especial (-, _ ou %)");
					}

					ps.execute();
					JOptionPane.showMessageDialog(null, "Usuario criado com sucesso!");
					System.out.println("USUARIO INSERIDO COM SUCESSO");
					HomePage homePage = new HomePage();
					homePage.setVisible(true);

				}

				catch (Exception w) {
					w.printStackTrace();
				}

				textfield_nome.setText("");
				textfield_email.setText("");
				textfield_senha.setText("");
				textfield_conf_senha.setText("");

			}

		});

		JLabel lblNewLabel_5 = new JLabel(
				"*O usuário deve conter pelo menos 3 letras\r\n ou numero e pelo menos 1 caracter especial ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 9));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(171).addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(45).addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 387,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_2).addComponent(lblNewLabel_1)
												.addComponent(lblNewLabel_3).addComponent(lblNewLabel_4))
										.addGap(28)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(textfield_conf_senha, GroupLayout.DEFAULT_SIZE, 250,
														Short.MAX_VALUE)
												.addComponent(textfield_senha, GroupLayout.DEFAULT_SIZE, 250,
														Short.MAX_VALUE)
												.addComponent(textfield_nome, GroupLayout.DEFAULT_SIZE, 250,
														Short.MAX_VALUE)
												.addComponent(textfield_email, 162, 250, Short.MAX_VALUE)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(btnNewButton)
														.addPreferredGap(ComponentPlacement.RELATED, 90,
																Short.MAX_VALUE)
														.addComponent(btnNewButton_1)))))))
				.addGap(94)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(22).addComponent(lblNewLabel).addGap(11)
						.addComponent(lblNewLabel_5).addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textfield_nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1))
						.addGap(24)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textfield_email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2))
						.addGap(21)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textfield_senha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3))
						.addGap(9)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textfield_conf_senha, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4))
						.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton)
								.addComponent(btnNewButton_1))
						.addGap(21)));
		contentPane.setLayout(gl_contentPane);
	}
}
