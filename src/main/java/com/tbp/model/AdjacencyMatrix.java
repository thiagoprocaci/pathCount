package com.tbp.model;

/**
 * Describes an Adjacency Matrix. This matrix accepts only values 0 or 1
 * 
 * @author Thiago B. Procaci
 * 
 */
public class AdjacencyMatrix {

	private Integer[][] matrix;
	private int rows;
	private int cols;

	/**
	 * Creates a new Adjacency Matrix
	 * 
	 * @param dimension
	 * 
	 */
	public AdjacencyMatrix(int dimension) {
		matrix = new Integer[dimension][dimension];
		this.rows = dimension;
		this.cols = dimension;
	}

	/**
	 * 
	 * @param i
	 * @param j
	 * @return Returns the value of a specified position
	 */
	public Integer getValue(int i, int j) {
		return matrix[i][j];
	}

	/**
	 * Sets the value of a specified position
	 * 
	 * @param i
	 * @param j
	 * @param value
	 */
	public void setValue(int i, int j, Integer value) {
		if (value == 1 || value == 0)
			matrix[i][j] = value;
	}

	/**
	 * 
	 * @return Returns the number of columns
	 */
	public int getCols() {
		return cols;
	}

	/**
	 * 
	 * @return Returns the numbers of rows
	 */
	public int getRows() {
		return rows;
	}



}
