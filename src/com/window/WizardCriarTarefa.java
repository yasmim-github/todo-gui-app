package com.window;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.func.Tarefa;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class WizardCriarTarefa extends JFrame {

	/**
	 * @author Yasmim de Souza Classe utilizada para guiar o usuario a criar uma
	 *         nova tarefa
	 * 
	 *         Traduçaõ : Wizard é um termo utilizado para se referir a aplicações
	 *         GUI que guiam o usuário a fazer uma açõa. Como instalação de um
	 *         app...É um esquema de projeto para realizar operações complexas com
	 *         um método passo-a-passo
	 */

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtObrigatrio;
	private JTextField textField;

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
				
						txtObrigatrio = new JTextField();
						txtObrigatrio.setHorizontalAlignment(SwingConstants.LEFT);
						txtObrigatrio.setFont(new Font("Inter", Font.PLAIN, 14));
						txtObrigatrio.setForeground(new Color(24, 24, 24));
						txtObrigatrio.setText("*\r\n");
						txtObrigatrio.setColumns(10);
				
						textField = new JTextField();
						textField.setHorizontalAlignment(SwingConstants.LEFT);
						textField.setFont(new Font("Inter", Font.PLAIN, 14));
						textField.setText("*");
						textField.setColumns(10);
						
								JLabel lblNewLabel_4 = new JLabel("Etiqueta");
								lblNewLabel_4.setFont(new Font("Inter", Font.PLAIN, 14));
								lblNewLabel_4.setForeground(new Color(24, 24, 24));
						
								JComboBox comboBox_1 = new JComboBox();
								comboBox_1.setFont(new Font("Inter", Font.PLAIN, 14));
								comboBox_1.setForeground(new Color(24, 24, 24));
								comboBox_1
										.setModel(new DefaultComboBoxModel(new String[] { "Trabalho", "Casa", "Estudo", "Lazer", "Compras" }));
								comboBox_1.setMaximumRowCount(5);
						
								JLabel lblNewLabel_3 = new JLabel("Data");
								lblNewLabel_3.setFont(new Font("Inter", Font.PLAIN, 14));
								lblNewLabel_3.setForeground(new Color(24, 24, 24));
				
						JLabel lblNewLabel_2 = new JLabel("Prioridade");
						lblNewLabel_2.setFont(new Font("Inter", Font.PLAIN, 14));
						lblNewLabel_2.setForeground(new Color(24, 24, 24));
		
				JComboBox comboBox = new JComboBox();
				comboBox.setFont(new Font("Inter", Font.PLAIN, 14));
				comboBox.setForeground(new Color(24, 24, 24));
				comboBox.setModel(new DefaultComboBoxModel(new String[] { "Desejável", "Importante", "Essencial" }));
				comboBox.setMaximumRowCount(3);
				JTextArea txtrDescrioDaTarefa = new JTextArea();
				txtrDescrioDaTarefa.setBackground(new Color(255, 255, 255));
				txtrDescrioDaTarefa.setFont(new Font("Inter", Font.PLAIN, 14));
				txtrDescrioDaTarefa.setForeground(new Color(24, 24, 24));
				txtrDescrioDaTarefa.setText("Descrição da Tarefa");
				
				retornaInputs(txtObrigatrio.getText(),(String) comboBox.getSelectedItem(),textField.getText(),(String) comboBox_1.getSelectedItem(),txtrDescrioDaTarefa.getText());
		
				JButton btnNewButton = new JButton("Cancelar");
				btnNewButton.setBackground(new Color(255, 255, 255));
				btnNewButton.setFont(new Font("Inter", Font.PLAIN, 14));
				btnNewButton.setForeground(new Color(24, 24, 24));
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
		
				JButton btnNewButton_1 = new JButton("Adicionar");
				btnNewButton_1.setBackground(new Color(255, 255, 255));
				btnNewButton_1.setFont(new Font("Inter", Font.PLAIN, 14));
				btnNewButton_1.setForeground(new Color(24, 24, 24));
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
									.addComponent(btnNewButton_1))
								.addComponent(txtrDescrioDaTarefa, GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
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
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
										.addComponent(txtObrigatrio, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
									.addGap(36)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_4)
										.addComponent(lblNewLabel_2))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(comboBox, 0, 249, Short.MAX_VALUE)
										.addComponent(comboBox_1, 0, 249, Short.MAX_VALUE))))
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
										.addComponent(txtObrigatrio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_3)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(59))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_4)
										.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2))
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addComponent(txtrDescrioDaTarefa, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
							.addGap(49)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(30))
				);
				contentPane.setLayout(gl_contentPane);
	}
	
	public String[] retornaInputs(String titulo, String prioridade, String data, String etiqueta, String desc) {
        String tTitulo = titulo;
        String tPrioridade = (String) prioridade;
        String tData = data; // Assuming this is where the date input is
        String tEtiqueta = (String) etiqueta;
        String tDesc = desc;
        String[] valores = {tTitulo, tPrioridade, tData, tEtiqueta, tDesc};
        return valores;
    }
	
}
