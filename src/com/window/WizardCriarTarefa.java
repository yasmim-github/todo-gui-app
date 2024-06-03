package com.window;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.func.Tarefa;
import com.main.Main;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import com.window.*;

public class WizardCriarTarefa extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField titulo_field;
	private JTextField data_field;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WizardCriarTarefa frame = new WizardCriarTarefa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public WizardCriarTarefa() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(WizardCriarTarefa.class.getResource("/assets/favicon.png")));
		setTitle("Criar Tarefa");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 857, 516);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		
				JLabel lblNewLabel = new JLabel("Criar tarefa");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setFont(new Font("Inter", Font.BOLD, 20));
				lblNewLabel.setForeground(new Color(24, 24, 24));
		

		JLabel lblNewLabel_1 = new JLabel("Título");
		lblNewLabel_1.setFont(new Font("Inter", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(new Color(24, 24, 24));
				
						titulo_field = new JTextField();
						titulo_field.setHorizontalAlignment(SwingConstants.LEFT);
						titulo_field.setFont(new Font("Inter", Font.PLAIN, 14));
						titulo_field.setForeground(new Color(24, 24, 24));
						titulo_field.setText("*\r\n");
						titulo_field.setColumns(10);
				
						data_field = new JTextField();
						data_field.setHorizontalAlignment(SwingConstants.LEFT);
						data_field.setFont(new Font("Inter", Font.PLAIN, 14));
						data_field.setText("*");
						data_field.setColumns(10);
						
								JLabel lblNewLabel_4 = new JLabel("Etiqueta");
								lblNewLabel_4.setFont(new Font("Inter", Font.PLAIN, 14));
								lblNewLabel_4.setForeground(new Color(24, 24, 24));
						
								JComboBox etiqueta_comboBox = new JComboBox();
								etiqueta_comboBox.setFont(new Font("Inter", Font.PLAIN, 14));
								etiqueta_comboBox.setForeground(new Color(24, 24, 24));
								etiqueta_comboBox
										.setModel(new DefaultComboBoxModel(new String[] { "Trabalho", "Casa", "Estudo", "Lazer", "Compras" }));
								etiqueta_comboBox.setMaximumRowCount(5);
						
								JLabel lblNewLabel_3 = new JLabel("Data");
								lblNewLabel_3.setFont(new Font("Inter", Font.PLAIN, 14));
								lblNewLabel_3.setForeground(new Color(24, 24, 24));
				
						JLabel lblNewLabel_2 = new JLabel("Prioridade");
						lblNewLabel_2.setFont(new Font("Inter", Font.PLAIN, 14));
						lblNewLabel_2.setForeground(new Color(24, 24, 24));
		
				JComboBox prioridade_comboBox = new JComboBox();
				prioridade_comboBox.setFont(new Font("Inter", Font.PLAIN, 14));
				prioridade_comboBox.setForeground(new Color(24, 24, 24));
				prioridade_comboBox.setModel(new DefaultComboBoxModel(new String[] { "Desejável", "Importante", "Essencial" }));
				prioridade_comboBox.setMaximumRowCount(3);
				JTextArea descrisao_field = new JTextArea();
				descrisao_field.setBackground(new Color(255, 255, 255));
				descrisao_field.setFont(new Font("Inter", Font.PLAIN, 14));
				descrisao_field.setForeground(new Color(24, 24, 24));
				descrisao_field.setText("Descrição da Tarefa");
				
				JButton btnNewButton = new JButton("Cancelar");
				btnNewButton.setBackground(new Color(255, 255, 255));
				btnNewButton.setFont(new Font("Inter", Font.PLAIN, 14));
				btnNewButton.setForeground(new Color(24, 24, 24));
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
		
				JButton add_tarefa = new JButton("Adicionar");
				add_tarefa.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Tarefa tarefa = new Tarefa();
						tarefa.CriarTarefa(titulo_field, descrisao_field, prioridade_comboBox, etiqueta_comboBox, data_field, tarefa);
					    Main.tarefas.add(tarefa);	
					    titulo_field.setText("");
					    descrisao_field.setText("");
					    data_field.setText("");
					    HomePage.createPanelTask();
					}
				});
				add_tarefa.setBackground(new Color(255, 255, 255));
				add_tarefa.setFont(new Font("Inter", Font.PLAIN, 14));
				add_tarefa.setForeground(new Color(24, 24, 24));
				GroupLayout gl_contentPane = new GroupLayout(contentPane);
				gl_contentPane.setHorizontalGroup(
					gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(90)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(189)
									.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(167))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnNewButton)
									.addPreferredGap(ComponentPlacement.RELATED, 482, Short.MAX_VALUE)
									.addComponent(add_tarefa))
								.addComponent(descrisao_field, GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblNewLabel_1))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(8)
											.addComponent(lblNewLabel_3)))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(data_field, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
										.addComponent(titulo_field, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
									.addGap(36)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_4)
										.addComponent(lblNewLabel_2))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(prioridade_comboBox, 0, 249, Short.MAX_VALUE)
										.addComponent(etiqueta_comboBox, 0, 249, Short.MAX_VALUE))))
							.addGap(99))
				);
				gl_contentPane.setVerticalGroup(
					gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(44)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(53)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(titulo_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_3)
										.addComponent(data_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(59))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_4)
										.addComponent(etiqueta_comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(prioridade_comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2))
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addComponent(descrisao_field, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
							.addGap(49)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(add_tarefa, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(30))
				);
				contentPane.setLayout(gl_contentPane);
	}
	
}
