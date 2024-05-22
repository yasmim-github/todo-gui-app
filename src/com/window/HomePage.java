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

		/**
		 * @author Yasmim de Souza Construtor da classe HomePage, quando a classe for
		 *         instanciada, poderemos usar o método herdado na instancia, exemplo :
		 *         nomeInstancia.setVisible(true) para tornar a página vísivel
		 */

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(34, 47, 202));
		setJMenuBar(menuBar);

		JButton btnNovaTarefa = new JButton("+");
		btnNovaTarefa.setBackground(new Color(255, 255, 255));
		btnNovaTarefa.setForeground(new Color(34, 47, 202));
		menuBar.add(btnNovaTarefa);

		JButton btnAcssTrfConc = new JButton("tarefas concluidas");
		btnAcssTrfConc.setBackground(new Color(255, 255, 255));
		btnAcssTrfConc.setForeground(new Color(34, 47, 202));
		menuBar.add(btnAcssTrfConc);

		txtPesquisarAlgo = new JTextField();
		txtPesquisarAlgo.setForeground(new Color(166, 166, 215));
		txtPesquisarAlgo.setText("pesquisar tarefa...");
		menuBar.add(txtPesquisarAlgo);
		txtPesquisarAlgo.setColumns(10);

		JLabel lupinha = new JLabel("🔎");
		lupinha.setForeground(new Color(34, 47, 202));
		menuBar.add(lupinha);
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
