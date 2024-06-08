package com.main;

import java.util.ArrayList;
import java.util.Locale;

import com.models.Tarefa;
import com.models.Usuario;
import com.window.TelaInicial;

public class Main {
	public static Usuario usuario;
	public static ArrayList<Tarefa> tarefas = new ArrayList<>();
	
	public static void main(String[] args) {
		Locale.setDefault(new Locale("pt", "BR"));
		usuario = new Usuario();
		TelaInicial telaInicial = new TelaInicial();
		telaInicial.setVisible(true);
	}
}
