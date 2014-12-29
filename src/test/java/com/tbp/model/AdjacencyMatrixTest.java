package com.tbp.model;


import org.junit.Test;
import static org.junit.Assert.*;

public class AdjacencyMatrixTest {

    @Test
    public void testConstructor() {
        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(3);
        assertEquals(3, adjacencyMatrix.getCols());
        assertEquals(3, adjacencyMatrix.getRows());
        for (int i = 0; i < adjacencyMatrix.getRows(); i++) {
            for (int j = 0; j < adjacencyMatrix.getCols(); j++) {
                assertNull(adjacencyMatrix.getValue(i, j));
            }
        }
    }

    @Test
    public void testSetValue() {
        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(3);
        adjacencyMatrix.setValue(0,1,12);
        assertNull(adjacencyMatrix.getValue(0, 1));
        adjacencyMatrix.setValue(0,1,1);
        assertEquals(1, adjacencyMatrix.getValue(0, 1).intValue());
        adjacencyMatrix.setValue(0,1,0);
        assertEquals(0, adjacencyMatrix.getValue(0, 1).intValue());
    }


}
