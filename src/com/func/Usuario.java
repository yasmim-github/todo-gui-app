package com.func;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import com.window.AcessUser;
import com.window.HomePage;

public class Usuario {
	private int identificador;
	private String nome;
	private String email;
	private String senha;
	//private boolean status;
	
	public int getIdentificador() {
		return identificador;
	}
	
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void criarUsuario(JTextField textfield_nome, JTextField textfield_email, JPasswordField textfield_senha, JPasswordField textfield_conf_senha) {
		String sql_createUser = "INSERT INTO usuario(nome,email,senha) VALUES (?,?,?)";
		ConectaBanco factory = new ConectaBanco();
		
		try (Connection c = factory.conectar()) {
			PreparedStatement ps = c.prepareStatement(sql_createUser);
			ps.setString(1, textfield_nome.getText());
			ps.setString(2, textfield_email.getText());
			ps.setString(3, String.valueOf(textfield_senha.getPassword()));

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
			JOptionPane.showMessageDialog(null, "Usuário criado com sucesso!");
			
			AcessUser login = new AcessUser();
			login.setVisible(true);
		} catch (SQLException error) {
			if (error.getErrorCode() == 1062){
				JOptionPane.showMessageDialog(null, "Esse email já existe, faça o login.");
			} else {
				JOptionPane.showMessageDialog(null, "Aconteceu algo de errado, tente novamente mais tarde.");						
			}
		}
	}
	
	public void loginUsuario(JTextField email, JPasswordField password) {
		String SQL_login = "SELECT * FROM usuario WHERE email = ? AND senha = ?";
		ConectaBanco factory = new ConectaBanco();
		
		try(Connection c = factory.conectar()){
			PreparedStatement ps = c.prepareStatement(SQL_login);
			
			ps.setString(1, email.getText());
			ps.setString(2, String.valueOf(password.getPassword()));
			
			String email_user = email.getText();
			String pass = String.valueOf(password.getPassword());
			
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
				setIdentificador(rs.getInt("id_usuario"));
				setNome(rs.getString("nome"));
				setEmail(rs.getString("email"));
				setSenha(rs.getString("senha"));
				
				JOptionPane.showMessageDialog(null, "Você entrou no sistema.");
				HomePage homePage = new HomePage();
				homePage.setVisible(true);
			}
		} catch(SQLException error) {
			error.printStackTrace();
		}
	}
	
	//Métodos em construção....
	
	//public boolean isStatus() {
	//	return status;
	//}
	
	//public void setStatus(boolean status) {
	//	this.status = status;
	//}
	
	// !!! revisar metodo de alterar senha:
	
	/*
	public String alterarSenha() {
		String novasenha = JOptionPane.showInputDialog("nova senha"); //alterar para classe Jframe
		String sql = "";
		
		setSenha(novasenha);
		return novasenha;
	}
	*/

	
}
