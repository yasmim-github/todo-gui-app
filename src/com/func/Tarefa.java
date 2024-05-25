package com.func;

import java.awt.Color;
import java.awt.Container;
import java.sql.Date;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.window.WizardCriarTarefa;

public class Tarefa {

	private String titulo;
	private String prioridade;
	private String data;
	private String descricao;
	private String etiqueta;
	private boolean concluido;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public boolean isConcluido() {
		return concluido;
	}

	public void setConcluido(boolean concluido) {
		this.concluido = concluido;
	}

	public Tarefa(String titulo, String prioridade, String data) {
		this.titulo = titulo;
		this.prioridade = prioridade;
		this.data = data;
	}

	public Tarefa(String titulo, String prioridade, String data, String etiqueta, String descricao) {
		this.titulo = titulo;
		this.prioridade = prioridade;
		this.data = data;
		this.etiqueta = etiqueta;
		this.descricao = descricao;
	}
	
	
	public void CriarTarefa() {

		/**
		 * @author Yasmim de Souza O construtor será utilzado para criar o objeto para
		 *         ser enviado ao banco Em conjunto com o método EstruturaTarefa que vai
		 *         adicionar a parte gráfica da tarefa
		 * 
		 *         A instancia da Tarefa.java será utilizada em WizardCriarTarefa.java
		 */
		
		WizardCriarTarefa telacriartarefa = new WizardCriarTarefa(); // retorna com os valores definidos pelo usuário
	
		

	}

	public void EstruturaTarefa(Container contentPane) {

		JLabel nometarefateste = new JLabel("Nome tarefa");
		JButton prioridadetarefateste = new JButton("prioridade");
		prioridadetarefateste.setBackground(new Color(36, 36, 223));
		prioridadetarefateste.setForeground(new Color(255, 255, 255));
		prioridadetarefateste.setEnabled(false);
		JLabel descteste = new JLabel("Desc :");
		JLabel lblNewLabel_1 = new JLabel("...");
		JButton btndatateste = new JButton("Data :" + "data definida pelo user");
		btndatateste.setEnabled(false);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(34)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(descteste)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_1))
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(nometarefateste)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(prioridadetarefateste)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btndatateste)))
				.addContainerGap(150, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(42)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(nometarefateste)
								.addComponent(prioridadetarefateste).addComponent(btndatateste))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(descteste)
								.addComponent(lblNewLabel_1))
						.addContainerGap(150, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}

	public void ExcluirTarefa() {
		// Em construção...
		// excluir tarefa
	}

	public void EditarTarefa() {
		// Em construção...
		// WIP : conecta no db...
		// update numa tarefa que já existe
		// se não existir a tarefa
		// gerar um erro
	}

	public boolean ConcluirTarefa() {
		// Em construção...
		// WIP : levar a tarefa para a pagina de tarefas concluidas
		setConcluido(true);
		return true;
		// se a tarefa já estiver concluida, volta para a main page
		// retorna falso

	}
}
