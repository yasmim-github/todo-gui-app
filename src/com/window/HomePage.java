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
import javax.swing.JLabel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;

public class HomePage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPesquisarAlgo;

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
		setBounds(100, 100, 718, 435);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Inter", Font.PLAIN, 14));
		menuBar.setBackground(new Color(255, 255, 255));
		setJMenuBar(menuBar);

		JButton btnNovaTarefa = new JButton("Adicionar Tarefa");
		btnNovaTarefa.setSelectedIcon(null);
		btnNovaTarefa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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

		addWindowListener((WindowListener) new WindowAdapter() {

			/**
			 * @author Yasmim de Souza Método nativo do Java, addWindowListener
			 * @param:             É um método que leva como parametro a instancia da classe
			 *                     WindowAdapter
			 * 
			 *                     public void windowClosing - Gerando um prompt perguntando
			 *                     se queremos fechar Se o valor recebido por PromptResult
			 *                     for igual a 1, o programa continua rodando, senão ele
			 *                     fecha
			 * 
			 * @param: WindowEvent we (evento de janela a ser processado)
			 * @return: void
			 * 
			 */

			@Override
			public void windowClosing(WindowEvent we) {
				String ObjButtons[] = { "Yes", "No" };
				int PromptResult = JOptionPane.showOptionDialog(null, "Are you sure you want to exit?",
						"Online Examination System", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
						ObjButtons, ObjButtons[1]);
				if (PromptResult == 0) {
					System.exit(0);
				}
			}
		});

	}

	public int getThisDefaultCloseOperation() {
		return getDefaultCloseOperation();
	}

	public void setThisDefaultCloseOperation(int defaultCloseOperation) {
		setDefaultCloseOperation(defaultCloseOperation);
	}
}
