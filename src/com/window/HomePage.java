package com.window;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.func.ConectaBanco;
import com.func.Tarefa;
import com.main.Main;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.SpringLayout;

public class HomePage extends JFrame {
	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	private JTextField txtPesquisarAlgo;
	private static JPanel containerTarefas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HomePage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(HomePage.class.getResource("/assets/favicon.png")));
		setTitle("TodoList");

		/**
		 * @author Yasmim de Souza Construtor da classe HomePage, quando a classe for
		 *         instanciada, poderemos usar o método herdado na instancia, exemplo :
		 *         nomeInstancia.setVisible(true) para tornar a página vísivel
		 */

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 900, 640);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Inter", Font.PLAIN, 14));
		menuBar.setBackground(new Color(255, 255, 255));
		setJMenuBar(menuBar);

		JButton btnNovaTarefa = new JButton("Adicionar Tarefa");
		btnNovaTarefa.setSelectedIcon(null);
		btnNovaTarefa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WizardCriarTarefa criarTarefa = new WizardCriarTarefa();
				criarTarefa.setVisible(true);
			}
		});
		btnNovaTarefa.setIcon(new ImageIcon(HomePage.class.getResource("/assets/plus.png")));
		btnNovaTarefa.setFont(new Font("Inter", Font.PLAIN, 14));
		btnNovaTarefa.setBackground(new Color(255, 255, 255));
		btnNovaTarefa.setForeground(new Color(24, 24, 24));
		menuBar.add(btnNovaTarefa);

		JButton btnAcssTrfConc = new JButton("Tarefas Concluidas");
		btnAcssTrfConc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAcssTrfConc.setIcon(new ImageIcon(HomePage.class.getResource("/assets/check.png")));
		btnAcssTrfConc.setFont(new Font("Inter", Font.PLAIN, 14));
		btnAcssTrfConc.setBackground(new Color(255, 255, 255));
		btnAcssTrfConc.setForeground(new Color(24, 24, 24));
		menuBar.add(btnAcssTrfConc);

		txtPesquisarAlgo = new JTextField();
		txtPesquisarAlgo.setHorizontalAlignment(SwingConstants.LEFT);
		txtPesquisarAlgo.setFont(new Font("Inter", Font.PLAIN, 14));
		txtPesquisarAlgo.setForeground(new Color(83, 83, 83));
		txtPesquisarAlgo.setText("pesquisar tarefa...");
		menuBar.add(txtPesquisarAlgo);
		txtPesquisarAlgo.setColumns(10);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();

		containerTarefas = new JPanel();
		containerTarefas.setLayout(new BoxLayout(containerTarefas, BoxLayout.Y_AXIS));

		scrollPane.setViewportView(containerTarefas);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
		    gl_contentPane.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_contentPane.createSequentialGroup()
		            .addContainerGap()
		            .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 909, Short.MAX_VALUE)
		            .addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
		    gl_contentPane.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_contentPane.createSequentialGroup()
		            .addContainerGap()
		            .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
		            .addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		selectTarefas();
		
		addWindowListener((WindowListener) new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				String ObjButtons[] = { "Sim", "Não" };
				int PromptResult = JOptionPane.showOptionDialog(null, "Você realmente deseja sair?",
						"Mensagem", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
						ObjButtons, ObjButtons[1]);
				if (PromptResult == 0) {
					System.exit(0);
				}
			}
		});

	}
	
	public static void createPanelTask() {
		containerTarefas.removeAll();
		
		for(int i = 0; i < Main.tarefas.size(); i++) {
			containerTarefas.add(Main.tarefas.get(i).CriarPainelTarefa());
		}
	}
	
	public void selectTarefas() {
		String sql = "SELECT * FROM tarefa WHERE id_usuario = ?";
		ConectaBanco factory = new ConectaBanco();
		
		try(Connection c = factory.conectar()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, Main.usuario.getIdentificador());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int idTarefa = rs.getInt("id_tarefa");
				String titulo = rs.getString("titulo");
				String descricao = rs.getString("descricao");
				String prioridade = rs.getString("prioridade");
				String etiqueta = rs.getString("etiqueta");
				String data = rs.getDate("data_estimada_conclusao").toString();
				Boolean concluida = rs.getBoolean("concluida");
				
				Tarefa tarefa = new Tarefa();
				tarefa.setIdentificador(idTarefa);
				tarefa.setTitulo(titulo);
				tarefa.setDescricao(descricao);
				tarefa.setPrioridade(prioridade);
				tarefa.setEtiqueta(etiqueta);
				tarefa.setData(data);
				tarefa.setConcluido(concluida);
				
				Main.tarefas.add(tarefa);
			}
			
			createPanelTask();
		} catch(SQLException error) {
			error.printStackTrace();
		}
	}

	public int getThisDefaultCloseOperation() {
		return getDefaultCloseOperation();
	}

	public void setThisDefaultCloseOperation(int defaultCloseOperation) {
		setDefaultCloseOperation(defaultCloseOperation);
	}
}
