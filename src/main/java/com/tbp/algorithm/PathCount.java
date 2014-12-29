package com.tbp.algorithm;

import java.util.ArrayList;
import java.util.List;

import com.tbp.model.Graph;
import com.tbp.model.Link;
import com.tbp.model.Vertex;

/**
 * Provides the basics path count algorithms
 * 
 * @author Thiago B. Procaci
 * 
 */
public class PathCount {

	/**
	 * Runs node-labelling com.tbp.algorithm
	 * 
	 * @param graph
	 * @return Returns the number of paths from source to destiny - Returns null
	 *         if exists cycles
	 */
	public static Integer nodeLabellingAlgorithm(Graph graph) {
		List<Vertex> nScannableVertexList = new ArrayList<Vertex>();
		// inicialization
		for (Vertex vertex : graph.getNodes()) {
			if (vertex.getSuccessors().isEmpty()) {
				vertex.setState(Vertex.N_SCANNABLE);
				vertex.setLabel(0);
				nScannableVertexList.add(vertex);
			} else {
				vertex.setLabel(null);
				vertex.setState(Vertex.UNSCANNABLE);
			}
		}
		graph.getDest().setLabel(1);
		boolean finish = false;
		// Termination condition
		while (!finish) {
			// checking cycles
			if (nScannableVertexList.isEmpty())
				return null;
			Vertex vertex = nScannableVertexList.get(0);
			vertex.setState(Vertex.SCANNED);
			nScannableVertexList.remove(vertex);
			// general step
			for (Vertex vertex2 : vertex.getPredecessors()) {
				if (vertex2.getLabel() == null)
					vertex2.setLabel(vertex.getLabel());
				else
					vertex2.setLabel(vertex2.getLabel() + vertex.getLabel());
				if (vertex2.allSuccessorIs(Vertex.SCANNED) && vertex2.getState() != Vertex.SCANNED) {
					if (vertex2.equals(graph.getSource())) {
						finish = true;
						break;
					}
					vertex2.setState(Vertex.N_SCANNABLE);
					nScannableVertexList.add(vertex2);
				}
			}
		}
		return graph.getSource().getLabel();
	}

	/**
	 * Runs link-labelling com.tbp.algorithm
	 * 
	 * @param graph
	 * @return Returns the number of paths from source to destiny if does not
	 *         exist cycles - Returns null if exists cycles
	 */
	public static Integer linkLabellingAlgorithm(Graph graph) {
		List<Vertex> lScannableVertexList = new ArrayList<Vertex>();
		// inicialization
		for (Vertex vertex : graph.getNodes()) {
			if (vertex.getPredecessors().isEmpty()) {
				vertex.setState(Vertex.L_SCANNABLE);
				lScannableVertexList.add(vertex);
				for (Link link : graph.getLinks()) {
					if (link.getSource().equals(vertex)) {
						link.setLabel(0);
					}
				}
			}
		}
		for (Link link : graph.getLinks()) {
			if (link.getSource().equals(graph.getSource())) {
				link.setLabel(1);
			}
		}
		boolean finish = false;
		// Termination condition
		while (!finish) {
			// checking cycles
			if (lScannableVertexList.isEmpty())
				return null;
			Vertex vertex = lScannableVertexList.get(0);
			vertex.setState(Vertex.SCANNED);
			lScannableVertexList.remove(vertex);
			for (Vertex vertex2 : vertex.getSuccessors()) {
				List<Link> outGoinglinks = graph.getOutGoingLinks(vertex2);
				Link link = graph.getLink(vertex, vertex2);
				for (Link link2 : outGoinglinks) {
					if (link2.getLabel() == null)
						link2.setLabel(link.getLabel());
					else
						link2.setLabel(link2.getLabel() + link.getLabel());
				}
				if (vertex2.allPredeccessorIs(Vertex.SCANNED)) {
					if (vertex2.equals(graph.getDest())) {
						finish = true;
						break;
					}
					vertex2.setState(Vertex.L_SCANNABLE);
					lScannableVertexList.add(vertex2);
				}
			}
		}
		int returnValue = 0;
		List<Link> list = graph.getIncomingLinks(graph.getDest());
		for (Link link : list) {
			returnValue += link.getLabel();
		}
		return returnValue;
	}

	/**
	 * 
	 * @param graph
	 * @return Returns a graph labeled with the number of path through in each node
	 */
	public static Graph getNumberOfPathThroughAnyNode(Graph graph) {
		// getting the inverse graph
		Graph inverseGraph = graph.getInverseGraph();		
		// runs node labelling com.tbp.algorithm for each graph
		if(nodeLabellingAlgorithm(graph) == null)
			return null;		
		if(nodeLabellingAlgorithm(inverseGraph) == null)
			return null;
		for (Vertex v1 : graph.getNodes()) {
			for (Vertex v2 : inverseGraph.getNodes()) {
				if(v1.equals(v2)){
					v1.setLabel(v1.getLabel()*v2.getLabel());
					break;
				}
			}
		}	
		return graph;
	}
	
	/**
	 * 
	 * @param graph
	 * @return Returns a graph labeled with the number of path through in each link
	 */
	public static Graph getNumberOfPathThroughAnyLink(Graph graph){
		// getting the inverse graph
		Graph inverseGraph = graph.getInverseGraph();		
		// runs link labelling com.tbp.algorithm for each graph
		if(linkLabellingAlgorithm(graph) == null)
			return null;		
		if(linkLabellingAlgorithm(inverseGraph) == null)
			return null;
		for (Link l1 : graph.getLinks()) {
			for (Link l2 : inverseGraph.getLinks()) {
				if(l1.getSource().equals(l2.getDest()) && l1.getDest().equals(l2.getSource())){
					l1.setLabel(l1.getLabel()*l2.getLabel());
					break;
				}
			}
		}	
		return graph;
	}

}
