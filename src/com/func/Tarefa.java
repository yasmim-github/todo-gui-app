package com.func;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.main.Main;
import com.window.HomePage;
import net.miginfocom.swing.MigLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class Tarefa {
	private int identificador;
	private String titulo;
	private String prioridade;
	private String data;
	private String descricao;
	private String etiqueta;
	private boolean concluido;

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	
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

	public boolean Concluido() {
		return concluido;
	}

	public void setConcluido(boolean concluido) {
		this.concluido = concluido;
	}
	
	public void CriarTarefa(JTextField titulo, JTextArea descrisao_field, JComboBox<?> prioridade, JComboBox<?> etiqueta, JTextField data, Tarefa tarefa) {
		String sql = "INSERT INTO tarefa (titulo, descricao, prioridade, etiqueta, data_estimada_conclusao, id_usuario) VALUES (?, ?, ?, ?, ?, ?)";
		
		ConectaBanco factory = new ConectaBanco();
		Usuario usuario = Main.usuario;
				
		try(Connection c = factory.conectar()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, titulo.getText());
			ps.setString(2, descrisao_field.getText());
			ps.setString(3, prioridade.getSelectedItem().toString());
			ps.setString(4, etiqueta.getSelectedItem().toString());
			ps.setString(5, data.getText());
			ps.setInt(6, usuario.getIdentificador());
			ps.execute();
			
			tarefa.setTitulo(titulo.getText());
			tarefa.setDescricao(descrisao_field.getText());
			tarefa.setPrioridade(prioridade.getSelectedItem().toString());
			tarefa.setEtiqueta(etiqueta.getSelectedItem().toString());
			tarefa.setData(data.getText());
			tarefa.setConcluido(false);
			
			JOptionPane.showMessageDialog(null, "Tarefa criada com sucesso.");
		} catch(SQLException error) {
			System.out.println(error);
		}
	}
	
	public JPanel CriarPainelTarefa() {
		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("ToolTip.border"));
		
		JLabel titulo = new JLabel(getTitulo());
		titulo.setFont(new Font("Inter", Font.PLAIN, 12));
		
		JLabel descrisao = new JLabel(getDescricao());
		descrisao.setFont(new Font("Inter", Font.PLAIN, 12));
		panel.setLayout(new MigLayout("", "[70px:70px,center][120px:120px,center][160px:160px,center][100px:100px,center][100px:100px,center][160px:160px,center][50px:50px,center]", "[60px:60px]"));
		
		JCheckBox concluir = new JCheckBox("Concluir");
		concluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//concluir tarefa
				
			}
		});
		concluir.setFont(new Font("Inter", Font.PLAIN, 12));
		
		JLabel data_termino = new JLabel(getData());
		data_termino.setHorizontalAlignment(SwingConstants.CENTER);
		data_termino.setFont(new Font("Inter", Font.PLAIN, 12));
		
		panel.add(concluir, "cell 0 0,alignx center,aligny center");
		panel.add(titulo, "cell 1 0,alignx center,aligny center");
		panel.add(descrisao, "cell 2 0,alignx center,aligny center");
		
		JLabel prioridade = new JLabel(getPrioridade());
		prioridade.setFont(new Font("Inter", Font.PLAIN, 12));
		panel.add(prioridade, "cell 3 0");
		
		JLabel etiqueta = new JLabel(getEtiqueta());
		etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
		etiqueta.setFont(new Font("Inter", Font.PLAIN, 12));
		panel.add(etiqueta, "cell 4 0");
		panel.add(data_termino, "cell 5 0,alignx center,aligny center");
		
		JButton editar = new JButton("");
		editar.setIcon(new ImageIcon(HomePage.class.getResource("/assets/edit.png")));
		editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//editar tarefa
				
			}
		});
		
		editar.setFont(new Font("Inter", Font.PLAIN, 12));
		panel.add(editar, "cell 6 0,alignx center,aligny center");
		
		return panel;
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
