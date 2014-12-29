package com.tbp.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.tbp.exception.AdjacencyMatrixUITypeException;
import com.tbp.model.AdjacencyMatrix;

/**
 * This class describes an user interface of a matrix
 * 
 * @author Thiago B. Procaci
 * 
 */
public class AdjacencyMatrixUI extends JPanel {

	private int rows;
	private int cols;
	private JPanel matrixPanel;
	private JPanel buttonPanel;
	private JButton jbtnOK;
	private FrameUI frameUI;

	/**
	 * Creates a new MatrixUI
	 * 
	 * @param rows
	 * @param cols
	 */
	public AdjacencyMatrixUI(int rows, int cols, FrameUI frameUI) {
		this.frameUI = frameUI;
		this.rows = rows + 1;
		this.cols = cols + 1;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		initMatrixPanel();
		initButtonPanel();
		this.add(matrixPanel);
		this.add(buttonPanel);

	}

	/**
	 * 
	 * @return Returns a matrix equivalent to matrixUI
	 * @throws AdjacencyMatrixUITypeException
	 */
	private AdjacencyMatrix buildMatrix() throws AdjacencyMatrixUITypeException {
		AdjacencyMatrix matrix = new AdjacencyMatrix(rows - 1);
		int rowAux = 0;
		int colAux = 0;
		Object[] components = matrixPanel.getComponents();
		for (int i = 0; i < components.length; i++) {
			if (components[i] instanceof JTextField) {
				String text = ((JTextField) components[i]).getText();
				try {
					Integer aux = Integer.parseInt(text);
					if (aux != 0 && aux != 1)
						throw new AdjacencyMatrixUITypeException(rowAux + 1,
								colAux + 1);

					matrix.setValue(rowAux, colAux, aux);
				} catch (NumberFormatException e) {
					throw new AdjacencyMatrixUITypeException(rowAux + 1,
							colAux + 1);
				}
				if (colAux + 1 < matrix.getCols()) {
					colAux++;
				} else {
					colAux = 0;
					rowAux++;
				}
			}
		}
		return matrix;
	}

	/**
	 * 
	 * Builds the buttonPanel
	 */
	private void initButtonPanel() {
		buttonPanel = new JPanel();
		jbtnOK = new JButton();

		jbtnOK.setText("OK");
		jbtnOK.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jbtnOKActionPerformed(evt);
			}
		});

		GroupLayout layout = new GroupLayout(buttonPanel);
		buttonPanel.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING)
				.addGroup(
						GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap(72,
								Short.MAX_VALUE).addComponent(jbtnOK)
								.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addContainerGap().addComponent(
						jbtnOK).addContainerGap(GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)));
	}

	/**
	 * 
	 * Builds the MatrixPanel
	 */
	private void initMatrixPanel() {
		matrixPanel = new JPanel(new GridLayout(rows + 1, cols + 1));
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (i == 0 && j == 0) {
					JLabel jLabel = new JLabel("");
					matrixPanel.add(jLabel);
				} else {
					if (j == 0 && i != 0) {
						JLabel jLabel = new JLabel("X" + (i-1) + "    ");
						matrixPanel.add(jLabel);
					} else {
						if (i == 0 && j != 0) {
							JLabel jLabel = new JLabel("X" + (j-1) + "    ");
							matrixPanel.add(jLabel);
						} else {
							JTextField jTextField = new JTextField();
							jTextField.setText(null);
							matrixPanel.add(jTextField);
						}
					}
				}
			}
		}

	}

	/**
	 * On click ok
	 * 
	 * @param evt
	 */
	private void jbtnOKActionPerformed(ActionEvent evt) {
		try {
			AdjacencyMatrix matrix = buildMatrix();
			frameUI.getJDialog().dispose();
			frameUI.setMatrix(matrix);
		} catch (AdjacencyMatrixUITypeException e) {
			JOptionPane.showMessageDialog(null,
					"The matrix should contains only 0 and 1. Check position: ("
							+ e.getRow() + "," + e.getCol() + ")", "Attention",
					JOptionPane.WARNING_MESSAGE);
		}
	}

}
