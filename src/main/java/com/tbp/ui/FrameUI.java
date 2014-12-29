package com.tbp.ui;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import com.tbp.controller.FrameUIController;
import com.tbp.model.Graph;
import com.tbp.model.Link;
import com.tbp.model.Vertex;
import com.tbp.ui.menuBar.MenuBar;
import com.tbp.model.AdjacencyMatrix;

public class FrameUI extends JFrame {

	private MenuBar menuBar;
	private AdjacencyMatrixUI adjacencyMatrixUI;
	private MatrixDefinitionUI matrixUIDefinition;
	private JDialog jDialog;
	private AdjacencyMatrix matrix;
	private FrameUIController frameUIController;

	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new FrameUI();
	}

	/**
	 * Creates a new FrameUI
	 * 
	 */
	public FrameUI() {
		super();
		menuBar = new MenuBar(this);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setJMenuBar(menuBar);
		this.setLocation(350, 200);
		this.setPreferredSize(new Dimension(300, 300));
		this.setVisible(true);
		this.setTitle("Enumeracao de caminhos");
		this.setResizable(true);
		this.pack();

	}

	/**
	 * Shows MatrixDefinitionUI()
	 * 
	 */
	public void showMatrixDefinitionUI() {
		matrixUIDefinition = new MatrixDefinitionUI(this);
		jDialog = new JDialog(this, "Matriz", true);
		jDialog.setContentPane(matrixUIDefinition);
		jDialog.setLocationRelativeTo(null);
		jDialog.pack();
		jDialog.setVisible(true);
	}

	/**
	 * 
	 * Shows AdjacencyMatrixUI
	 */
	public void initAdjacencyMatrixUI() {
		adjacencyMatrixUI = new AdjacencyMatrixUI(matrixUIDefinition
				.getVertexNumber(), matrixUIDefinition.getVertexNumber(), this);
		jDialog = new JDialog(this, "Matriz de Adjac�ncia", true);
		jDialog.setContentPane(adjacencyMatrixUI);
		jDialog.setLocationRelativeTo(null);
		jDialog.pack();
		jDialog.setVisible(true);
	}

	/**
	 * Sets matrix
	 * 
	 * @param matrix
	 */
	public void setMatrix(AdjacencyMatrix matrix) {
		this.matrix = matrix;
	}

	/**
	 * Runs Node Labelling lgorithm
	 * 
	 */
	public void runNodeLabellingAlgorithm() {
		frameUIController = FrameUIController.getInstance();
		if (matrix != null) {
			Integer i = frameUIController.runNodeLabellingAlgorithm(matrix);
			if (i == null)
				showWarnningMessage2();
			else
				JOptionPane.showMessageDialog(null,
						"N�meros de caminhos da origem ao destino: " + i,
						"Resposta", JOptionPane.WARNING_MESSAGE);
		} else
			showWarnningMessage();
	}

	/**
	 * Runs Link Labelling Algorithm
	 */
	public void runLinkLabellingAlgorithm() {
		frameUIController = FrameUIController.getInstance();
		if (matrix != null) {
			Integer i = frameUIController.runLinkLabellingAlgorithm(matrix);
			if (i == null)
				showWarnningMessage2();
			else
				JOptionPane.showMessageDialog(null,
						"N�meros de caminhos da origem ao destino: " + i,
						"Resposta", JOptionPane.WARNING_MESSAGE);
		} else
			showWarnningMessage();
	}

	/**
	 * Runs Number Of Paths Through Any Node
	 */
	public void runNumberOfPathThroughAnyNode() {
		frameUIController = FrameUIController.getInstance();
		if (matrix != null) {
			Graph graph = frameUIController
					.runNumberOfPathThroughAnyNode(matrix);
			if (graph == null) {
				showWarnningMessage2();
			} else {
				String s = new String();
				for (Vertex v : graph.getNodes()) {
					s += "n�: "+v.getVertexNumber() + " -- R�tulo: " + v.getLabel() + "\n";
				}
				JOptionPane.showMessageDialog(null,
						"N�meros de caminhos atrav�s de qualquer n�:  \n" + s,
						"Resposta", JOptionPane.WARNING_MESSAGE);
			}
		} else
			showWarnningMessage();
	}

	/**
	 * Runs Number Of Paths Through Any Link
	 */
	public void runNumberOfPathThroughAnyLink() {
		frameUIController = FrameUIController.getInstance();
		if (matrix != null) {
			Graph graph = frameUIController
					.runNumberOfPathThroughAnyLink(matrix);
			if (graph == null) {
				showWarnningMessage2();
			} else {
				String s = new String();
				for (Link l : graph.getLinks()) {
					s += "origem: " + l.getSource().getVertexNumber() + " -- "+ "destino: " + l.getDest().getVertexNumber() + "--"+" R�tulo: "+l.getLabel() + "\n";
				}
				JOptionPane.showMessageDialog(null,
						"N�meros de caminhos atrav�s de qualquer arco:  \n" + s,
						"Resposta", JOptionPane.WARNING_MESSAGE);
			}
		} else
			showWarnningMessage();
	}

	/**
	 * 
	 * @return Returns jDialog
	 */
	public JDialog getJDialog() {
		return jDialog;
	}

	/**
	 * Shows a warnning message
	 */
	private void showWarnningMessage() {
		JOptionPane.showMessageDialog(null, "Defina a rede antes", "Aten��o",
				JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Shows a warnning message
	 */
	private void showWarnningMessage2() {
		JOptionPane.showMessageDialog(null, "Verifique a existencia de ciclos",
				"Aten��o", JOptionPane.WARNING_MESSAGE);
	}

}
