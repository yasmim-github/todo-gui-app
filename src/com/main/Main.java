package com.main;

import java.util.ArrayList;
import com.func.Tarefa;
import com.func.Usuario;
import com.window.LogWin;

public class Main {
	public static Usuario usuario;
	public static ArrayList<Tarefa> tarefas = new ArrayList<>();
	
	public static void main(String[] args) {
		usuario = new Usuario();
		LogWin logWin = new LogWin();
		logWin.setVisible(true);
	}	
}
