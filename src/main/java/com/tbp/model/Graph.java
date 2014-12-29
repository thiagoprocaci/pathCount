package com.tbp.model;

import java.util.ArrayList;
import java.util.List;

import com.tbp.model.support.GraphsUtil;

/**
 * Describes a graph
 * 
 * @author Thiago B. Procaci
 * 
 */
public class Graph {

	private List<Vertex> nodes;
	private List<Link> links;
	private Vertex source;
	private Vertex dest;
	private AdjacencyMatrix adjacencyMatrix;



	/**
	 * Creates a new Graph
	 * 
	 * @param matrix
	 */
	public Graph(AdjacencyMatrix matrix) {
		this.adjacencyMatrix = matrix;
		this.nodes = new ArrayList<Vertex>();
		this.links = new ArrayList<Link>();
		// creating the vertex (nodes)
		for (int i = 0; i < matrix.getRows(); i++) {
			Vertex vertex = new Vertex();
			vertex.setVertexNumber(i);
			this.nodes.add(vertex);
		}
		// getting the successors and predecessor
		for (Vertex vertex : this.nodes) {
			List<Integer> list = GraphsUtil.getSuccessorsList(matrix, vertex
					.getVertexNumber());
			if (list != null) {
				for (Integer i : list) {
					vertex.addSuccessor(nodes.get(i));
					// Creating Links
					Link link = new Link(vertex, nodes.get(i), null);
					this.links.add(link);
				}
			}
			list = GraphsUtil.getPredecessors(matrix, vertex.getVertexNumber());
			if (list != null) {
				for (Integer i : list) {
					vertex.addPredecessor(nodes.get(i));
				}
			}
		}
		// defines the source and dest - default
		this.source = nodes.get(0);
		this.dest = nodes.get(nodes.size() - 1);
	}

	/**
	 * 
	 * @return Returns nodes
	 */
	public List<Vertex> getNodes() {
		return nodes;
	}

	/**
	 * 
	 * @return Returns links
	 */
	public List<Link> getLinks() {
		return links;
	}



	/**
	 * 
	 * @return Returns source vertex
	 */
	public Vertex getSource() {
		return source;
	}

	/**
	 * Sets source vertex
	 * 
	 * @param source
	 */
	public void setSource(Vertex source) {
		this.source = source;
	}

	/**
	 * 
	 * @return Returns dest vertex
	 */
	public Vertex getDest() {
		return dest;
	}

	/**
	 * Sets dest vertex
	 * 
	 * @param dest
	 */
	public void setDest(Vertex dest) {
		this.dest = dest;
	}


	/**
	 * 
	 * @param source
	 * @param destiny
	 * @return Returns the link between two vertex
	 */
	public Link getLink(Vertex source, Vertex destiny) {
		for (Link link : this.getLinks()) {
			if (link.getSource().equals(source)
					&& link.getDest().equals(destiny))
				return link;
		}
		return null;
	}

	/**
	 * 
	 * @param vertex
	 * @return Returns outGoing links of a vertex
	 */
	public List<Link> getIncomingLinks(Vertex vertex) {
		List<Link> links = new ArrayList<Link>();
		for (Link link : this.getLinks()) {
			if (link.getDest().equals(vertex))
				links.add(link);
		}
		return links;
	}

	/**
	 * 
	 * @param vertex
	 * @return Returns outGoing links of a vertex
	 */
	public List<Link> getOutGoingLinks(Vertex vertex) {
		List<Link> links = new ArrayList<Link>();
		for (Link link : this.getLinks()) {
			if (link.getSource().equals(vertex))
				links.add(link);
		}
		return links;
	}

	/**
	 * 
	 * @return Returns the inverse graph
	 */
	public Graph getInverseGraph() {
		AdjacencyMatrix matrix = new AdjacencyMatrix(this.adjacencyMatrix
				.getRows());
		for (int i = 0; i < this.adjacencyMatrix.getRows(); i++) {
			for (int j = 0; j < this.adjacencyMatrix.getCols(); j++) {
				matrix.setValue(j, i, this.adjacencyMatrix.getValue(i, j));
			}
		}
		Graph g = new Graph(matrix);
		Vertex aux = g.getDest();
		g.setDest(g.getSource());
		g.setSource(aux);
		return g;
	}

}
