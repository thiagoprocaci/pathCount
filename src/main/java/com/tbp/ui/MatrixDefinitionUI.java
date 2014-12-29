package com.tbp.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

/**
 * 
 * @author Thiago B. Procaci
 */
public class MatrixDefinitionUI extends JPanel {

	private JButton jButton1;
	private JLabel jLabel1;
	private JTextField jtfNumber;
	private Integer vertexNumber;
	private FrameUI frameUI;

	/** Creates new form MatrixUIDefinition */
	public MatrixDefinitionUI(FrameUI frameUI) {
		this.frameUI = frameUI;
		initComponents();
	}

	/**
	 * 
	 * @return Returns the vertexNumber
	 */
	public Integer getVertexNumber() {
		return vertexNumber;
	}

	/**
	 * Initialize the graphics components
	 */
	private void initComponents() {
		jLabel1 = new JLabel();
		jtfNumber = new JTextField();
		jButton1 = new JButton();

		jLabel1.setFont(new java.awt.Font("Arial", 0, 18));
		jLabel1.setText("Defina o numero de vertices");

		jtfNumber.setFont(new java.awt.Font("Tahoma", 0, 18));
		jtfNumber.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				jtfNumberKeyPressed(evt);
			}
		});

		jButton1.setText("Gerar Matriz");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addGroup(
						layout.createParallelGroup(
								GroupLayout.Alignment.LEADING).addGroup(
								layout.createSequentialGroup().addGap(23, 23,
										23).addComponent(jLabel1)).addGroup(
								layout.createSequentialGroup().addGap(101, 101,
										101).addComponent(jtfNumber,
										GroupLayout.PREFERRED_SIZE, 40,
										GroupLayout.PREFERRED_SIZE)).addGroup(
								layout.createSequentialGroup().addGap(73, 73,
										73).addComponent(jButton1)))
						.addContainerGap(28, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addContainerGap().addComponent(
						jLabel1).addPreferredGap(
						LayoutStyle.ComponentPlacement.RELATED).addComponent(
						jtfNumber, GroupLayout.PREFERRED_SIZE, 32,
						GroupLayout.PREFERRED_SIZE).addPreferredGap(
						LayoutStyle.ComponentPlacement.RELATED, 14,
						Short.MAX_VALUE).addComponent(jButton1)
						.addContainerGap()));
	}

	/**
	 * on key pressed at jtfNumber
	 * 
	 * @param evt
	 */
	private void jtfNumberKeyPressed(KeyEvent evt) {

	}

	/**
	 * On click generates matrix
	 * 
	 * @param evt
	 */
	private void jButton1ActionPerformed(ActionEvent evt) {
		String numberText = jtfNumber.getText().trim();
		try {
			this.vertexNumber = Integer.parseInt(numberText);
			frameUI.getJDialog().dispose();
			frameUI.initAdjacencyMatrixUI();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "N�mero inv�lido", "Aten��o",
					JOptionPane.WARNING_MESSAGE);
		}
	}

}
