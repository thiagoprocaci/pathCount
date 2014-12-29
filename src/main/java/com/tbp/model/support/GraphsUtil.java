package com.tbp.model.support;

import java.util.ArrayList;
import java.util.List;

import com.tbp.model.AdjacencyMatrix;

/**
 * This class provides the basics graphs com.tbp.algorithm
 * 
 * @author Thiago B. Procaci
 * 
 */
public class GraphsUtil {

	/**
	 * 
	 * @param matrix
	 * @param vertexRow
	 * @return Returns the successors list of a vertex
	 */
	public static List<Integer> getSuccessorsList(AdjacencyMatrix matrix,
			int vertexRow) {
		List<Integer> sucessors = new ArrayList<Integer>();
		for (int i = 0; i < matrix.getCols(); i++) {
			if (matrix.getValue(vertexRow, i).equals(1))
				sucessors.add(i);
		}
		if (sucessors.isEmpty())
			return null;

		return sucessors;
	}	
	
	/**
	 * 
	 * @param matrix
	 * @param vertexCol
	 * @return Returns the predecessors list of a vertex
	 */
	public static List<Integer> getPredecessors(AdjacencyMatrix matrix,int vertexCol){
		List<Integer> predecessors = new ArrayList<Integer>();
		for (int i = 0; i < matrix.getRows(); i++) {
			if (matrix.getValue(i,vertexCol).equals(1))
				predecessors.add(i);
		}
		if (predecessors.isEmpty())
			return null;

		return predecessors;
		
	}

}
