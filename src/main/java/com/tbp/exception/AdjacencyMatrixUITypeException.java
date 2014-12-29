package com.tbp.exception;

/**
 * AdjacencyMatrixUITypeException
 * @author Thiago B. Procaci
 *
 */
public class AdjacencyMatrixUITypeException extends Exception {

	private static String MSG_EXCEPTION = "Type not allowed. All matrix values must be integer";	
	private int row;
	private int col;
	
	/**
	 * Creates a new AdjacencyMatrixUITypeException
	 *
	 */
	public AdjacencyMatrixUITypeException(int row,int col) {
		super("At row: "+ row +" col: "+col+" "+ MSG_EXCEPTION);
		this.row = row;
		this.col = col;		
	}

	/**
	 * 
	 * @return Returns the column that occurred the com.tbp.exception
	 */
	public int getCol() {
		return col;
	}

	/**
	 * 
	 * @return Returns the row that occurred the com.tbp.exception
	 */
	public int getRow() {
		return row;
	}


	
}
