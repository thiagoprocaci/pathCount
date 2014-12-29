package com.tbp.controller;

import com.tbp.algorithm.PathCount;
import com.tbp.model.Graph;
import com.tbp.model.AdjacencyMatrix;

/**
 * This class allow the view frameUI access the com.tbp.model components
 * @author Thiago B. Procaci
 *
 */
public class FrameUIController {

	public static FrameUIController INSTANCE = new FrameUIController();
	
	/**
	 * Creates a new FrameUIControlle
	 */
	private FrameUIController(){
		
	}
	
	/**
	 * 
	 * @return Returns a instance of FrameUIControlle
	 */
	public static FrameUIController getInstance(){
		return INSTANCE;
	}
	
	/**
	 * Runs Node-Labelling Algorithm
	 * @param m
	 */
	public Integer runNodeLabellingAlgorithm(AdjacencyMatrix m){
		Graph graph = new Graph(m);
		return PathCount.nodeLabellingAlgorithm(graph);
	}
	
	/**
	 * Runs Link-Labelling Algorithm
	 * @param m
	 */
	public Integer runLinkLabellingAlgorithm(AdjacencyMatrix m){
		Graph graph = new Graph(m);
		return PathCount.linkLabellingAlgorithm(graph);
	}
	
	/**
	 * Runs number of path through any node
	 * @param m
	 */
	public Graph runNumberOfPathThroughAnyNode(AdjacencyMatrix m){
		Graph graph = new Graph(m);
		return PathCount.getNumberOfPathThroughAnyNode(graph);	
	}
	
	/**
	 * Runs number of path through any link
	 * @param m
	 */
	public Graph runNumberOfPathThroughAnyLink(AdjacencyMatrix m){
		Graph graph = new Graph(m);
		return PathCount.getNumberOfPathThroughAnyLink(graph);
	}
	
}
