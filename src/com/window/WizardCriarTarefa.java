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
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 52, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Criar tarefa");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		

		JLabel lblNewLabel_1 = new JLabel("Título");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));

		txtObrigatrio = new JTextField();
		txtObrigatrio.setForeground(new Color(0, 0, 0));
		txtObrigatrio.setText("*\r\n");
		txtObrigatrio.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Prioridade");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(128, 128, 192));

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Desejável", "Importante", "Essencial" }));
		comboBox.setMaximumRowCount(3);

		JLabel lblNewLabel_3 = new JLabel("Data");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));

		textField = new JTextField();
		textField.setText("*");
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JButton btnNewButton_1 = new JButton("Adicionar");

		JLabel lblNewLabel_4 = new JLabel("Etiqueta");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1
				.setModel(new DefaultComboBoxModel(new String[] { "Trabalho", "Casa", "Estudo", "Lazer", "Compras" }));
		comboBox_1.setMaximumRowCount(5);

		JLabel lblNewLabel_5 = new JLabel("Descrição");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		JTextArea textArea = new JTextArea();
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(separator,
								GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(btnNewButton)
								.addPreferredGap(ComponentPlacement.RELATED, 268, Short.MAX_VALUE)
								.addComponent(btnNewButton_1))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(37)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_2).addComponent(lblNewLabel_1)
												.addComponent(lblNewLabel_3))
										.addGap(18)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(textField).addComponent(txtObrigatrio)
												.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(lblNewLabel_4).addGap(18)
														.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGap(42))
												.addGroup(gl_contentPane.createSequentialGroup().addGap(33)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 168,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(lblNewLabel_5)))))
								.addGroup(Alignment.LEADING,
										gl_contentPane.createSequentialGroup().addGap(178).addComponent(lblNewLabel))))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblNewLabel).addGap(20)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
								.addComponent(txtObrigatrio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4).addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_5))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_3)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton)
								.addComponent(btnNewButton_1))
						.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
		
		retornaInputs(txtObrigatrio.getText(),(String) comboBox.getSelectedItem(),textField.getText(),(String) comboBox_1.getSelectedItem(),textArea.getText());
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
