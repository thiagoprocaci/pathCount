package com.tbp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Describes a graph vertex
 * 
 * @author Thiago B. Procaci
 * 
 */
public class Vertex  {


	// Public constants
	public static Integer N_SCANNABLE = 0;
	public static Integer SCANNED = 1;
	public static Integer UNSCANNABLE = 2;
	public static Integer L_SCANNABLE = 3;

	// variables declaration
	private Integer vertexNumber;
	private List<Vertex> successors;
	private List<Vertex> predecessors;
	private Integer label;
	private Integer state;

	/**
	 * Creates a new Vertex
	 */
	public Vertex() {
		this.successors = new ArrayList<Vertex>(0);
		this.predecessors = new ArrayList<Vertex>(0);
	}


	/**
	 * 
	 * @return Returns vertexNumber
	 */
	public Integer getVertexNumber() {
		return vertexNumber;
	}

	/**
	 * Sets vertexNumber
	 * 
	 * @param vertexNumber
	 */
	public void setVertexNumber(Integer vertexNumber) {
		this.vertexNumber = vertexNumber;
	}

	/**
	 * 
	 * @return Returns successors list
	 */
	public List<Vertex> getSuccessors() {
		return successors;
	}


	/**
	 * Adds a new successor
	 * 
	 * @param vertex
	 */
	public void addSuccessor(Vertex vertex) {
		this.successors.add(vertex);
	}


	/**
	 * 
	 * @return Returns predecessors
	 */
	public List<Vertex> getPredecessors() {
		return predecessors;
	}


	/**
	 * Adds a new predecessor
	 * 
	 * @param vertex
	 */
	public void addPredecessor(Vertex vertex) {
		this.predecessors.add(vertex);
	}


	/**
	 * 
	 * @return Returns label
	 */
	public Integer getLabel() {
		return label;
	}

	/**
	 * Sets label
	 * 
	 * @param label
	 */
	public void setLabel(Integer label) {
		this.label = label;
	}

	/**
	 * 
	 * @return Returns state
	 */
	public Integer getState() {
		return state;
	}

	/**
	 * Sets state
	 * 
	 * @param state
	 */
	public void setState(Integer state) {
		this.state = state;
	}

	/**
	 * Checks if all successors has the state parameter
	 * 
	 * @param state
	 * @return true or false
	 */
	public boolean allSuccessorIs(Integer state) {
		if(this.successors.isEmpty())
			return false;		
		for (Vertex v : this.successors) {	
			if (v.getState() != state) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks if all successors has the state parameter
	 * 
	 * @param state
	 * @return true or false
	 */
	public boolean allPredeccessorIs(Integer state) {
		if(this.predecessors.isEmpty())
			return false;		
		for (Vertex v : this.predecessors) {
			if (v.getState() != state) {
				return false;
			}
		}
		return true;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex vertex = (Vertex) o;

        if (vertexNumber != null ? !vertexNumber.equals(vertex.vertexNumber) : vertex.vertexNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return vertexNumber != null ? vertexNumber.hashCode() : 0;
    }
}
