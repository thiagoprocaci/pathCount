package com.tbp.ui.menuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

import com.tbp.ui.FrameUI;

public class MenuBar extends JMenuBar implements ActionListener {

	private JMenuItem about;
	private JMenuItem exit;
	private JSeparator jSeparator1;
	private JMenu file;
	private JMenuItem help;
	private JMenuItem defineGraph;
	private JMenuItem runNodeLabelling;
	private JMenuItem runLinkLabelling;
	private JMenuItem pathThroughAnyNode;
	private JMenuItem pathThroughAnyLink;
	private FrameUI frameUI;

	/**
	 * Creates a new MenuBar
	 * 
	 */
	public MenuBar(FrameUI frameUI) {
		file = new JMenu();
		about = new JMenuItem();
		exit = new JMenuItem();
		help = new JMenuItem();
		runNodeLabelling = new JMenuItem();
		runLinkLabelling = new JMenuItem();
		pathThroughAnyLink = new JMenuItem();
		pathThroughAnyNode = new JMenuItem();
		defineGraph = new JMenuItem();
		jSeparator1 = new JSeparator();

		file.setText("File");
		about.setText("About");
		defineGraph.setText("Define Network");
		runNodeLabelling.setText("Node-labelling algorithm");
		runLinkLabelling.setText("Link-labelling algorithm");
		pathThroughAnyLink
				.setText("Number of paths between any link algorithm");
		pathThroughAnyNode.setText("Number of paths between any node algorithm");
		exit.setText("Exit");
		help.setText("Help");

		about.addActionListener(this);
		help.addActionListener(this);
		exit.addActionListener(this);
		defineGraph.addActionListener(this);
		runNodeLabelling.addActionListener(this);
		runLinkLabelling.addActionListener(this);
		pathThroughAnyLink.addActionListener(this);
		pathThroughAnyNode.addActionListener(this);

		file.add(defineGraph);
		file.add(runNodeLabelling);
		file.add(runLinkLabelling);
		file.add(pathThroughAnyNode);
		file.add(pathThroughAnyLink);
		file.add(about);
		file.add(help);
		file.add(jSeparator1);
		file.add(exit);
		add(file);

		this.frameUI = frameUI;
	}

	/**
	 * Defines the actions
	 */
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(about)) {
			JOptionPane
					.showMessageDialog(
							null,
							"Developer \n Thiago Baesso Procaci ",
							"Developer", JOptionPane.INFORMATION_MESSAGE);
		} else {
			if (e.getSource().equals(defineGraph)) {
				frameUI.showMatrixDefinitionUI();
			} else {
				if (e.getSource().equals(help)) {
					JOptionPane
							.showMessageDialog(
									null,
									"Algorithms to count paths in a directed network \n \n ",
									"Help", JOptionPane.INFORMATION_MESSAGE);
				} else {
					if (e.getSource().equals(exit)) {
						System.exit(0);
					} else {
						if (e.getSource().equals(runNodeLabelling)) {
							frameUI.runNodeLabellingAlgorithm();
						} else {
							if (e.getSource().equals(runLinkLabelling)) {
								frameUI.runLinkLabellingAlgorithm();
							} else {
								if (e.getSource().equals(pathThroughAnyLink)) {
									frameUI.runNumberOfPathThroughAnyLink();
								} else {
									if (e.getSource()
											.equals(pathThroughAnyNode)) {
										frameUI.runNumberOfPathThroughAnyNode();
									}
								}
							}
						}
					}
				}
			}
		}

	}

}
