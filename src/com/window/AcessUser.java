package com.window;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.func.NormasEsc;
import com.func.ConectaBanco;
import com.func.Usuario;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Toolkit;

public class AcessUser extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField emailField;
	private JButton btnCancel;
	private JButton btnEntrar;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcessUser frame = new AcessUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AcessUser() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AcessUser.class.getResource("/assets/favicon.png")));
		setTitle("Entrar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setForeground(new Color(24, 24, 24));
		lblNewLabel_1.setFont(new Font("Inter", Font.PLAIN, 14));

		emailField = new JTextField();
		emailField.setForeground(new Color(24, 24, 24));
		emailField.setFont(new Font("Inter", Font.PLAIN, 14));
		emailField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Senha:");
		lblNewLabel_2.setForeground(new Color(24, 24, 24));
		lblNewLabel_2.setFont(new Font("Inter", Font.PLAIN, 14));

		btnCancel = new JButton("Cancelar");
		btnCancel.setBackground(new Color(255, 255, 255));
		btnCancel.setForeground(new Color(24, 24, 24));
		btnCancel.setFont(new Font("Inter", Font.PLAIN, 14));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		btnEntrar = new JButton("Entrar");
		btnEntrar.setBackground(new Color(255, 255, 255));
		btnEntrar.setForeground(new Color(24, 24, 24));
		btnEntrar.setFont(new Font("Inter", Font.PLAIN, 14));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SQL_login = "SELECT * FROM usuario WHERE email = ? AND senha = ?";
				ConectaBanco factory = new ConectaBanco();
				Usuario usuario = new Usuario();
				
				try(Connection c = factory.conectar()){
					PreparedStatement ps = c.prepareStatement(SQL_login);
					
					ps.setString(1, emailField.getText());
					ps.setString(2, String.valueOf(passwordField.getPassword()));
					
					String email_user = emailField.getText();
					String pass = String.valueOf(passwordField.getPassword());
					
					if(email_user.equals("") || pass.equals("")) {
						ps.close();
						JOptionPane.showMessageDialog(null, "Complete os campos.");
					} else if(!NormasEsc.REGEX_EMAIL_VALIDO(email_user)) {
						ps.close();
						JOptionPane.showMessageDialog(null, "Email fornecido é inválido.");
					} else if(!NormasEsc.REGEX_SENHA_VALIDA(pass)) {
						ps.close();
						JOptionPane.showMessageDialog(null, "A senha precisa possuir oito digitos, uma letra maiuscula e um caractere especial e dois numeros.");
					}
					
					ResultSet rs = ps.executeQuery();
					
					if(!rs.next()) {
						JOptionPane.showMessageDialog(null, "Email ou senha inválidos.");
					} else {
						usuario.setIdentificador(rs.getInt("id_usuario"));
						usuario.setNome(rs.getString("nome"));
						usuario.setEmail(rs.getString("email"));
						usuario.setSenha(rs.getString("senha"));
						JOptionPane.showMessageDialog(null, "Você entrou no sistema.");
						HomePage homePage = new HomePage();
						homePage.setVisible(true);
					}
				} catch(SQLException error) {
					error.printStackTrace();
				}
			}
		});

		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(24, 24, 24));
		passwordField.setFont(new Font("Inter", Font.PLAIN, 14));
		
		JLabel lblNewLabel = new JLabel("Entrar");
		lblNewLabel.setForeground(new Color(24, 24, 24));
		lblNewLabel.setFont(new Font("Inter", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(76)
					.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addComponent(btnEntrar, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addGap(78))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(91)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(lblNewLabel_1)
							.addGap(24)
							.addComponent(emailField, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addGap(24)
							.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)))
					.addGap(103))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(194)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
					.addGap(175))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1))
						.addComponent(emailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(13)
							.addComponent(lblNewLabel_2))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnCancel)
						.addComponent(btnEntrar))
					.addGap(51))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
