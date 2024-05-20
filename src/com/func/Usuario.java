package com.func;

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
