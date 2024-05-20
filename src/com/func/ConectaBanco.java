package com.func;

import java.sql.*;

public class ConectaBanco {
	
	private String usuario = "root";
	private String senha = "root";
	private String host = "localhost";
	private String porta  = "3306";
	private String bd = "bd_todo";
	
	public Connection conectar() {
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://" + host + ":" + porta + "/" + bd, usuario, senha);
			return c;
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
}