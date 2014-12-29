package com.tbp.model;


import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import java.util.Map;

import static org.junit.Assert.*;

public class GraphTest {


    private AdjacencyMatrix m;

    @Before
    public void doBefore() {
        m = new AdjacencyMatrix(6);
        m.setValue(0, 1, 1);
        m.setValue(0, 2, 1);
        m.setValue(1, 2, 1);
        m.setValue(1, 3, 1);
        m.setValue(1, 4, 1);
        m.setValue(2, 4, 1);
        m.setValue(2, 5, 1);
        m.setValue(3, 5, 1);
        m.setValue(4, 5, 1);
        for (int i = 0; i < m.getRows(); i++) {
            for (int j = 0; j < m.getCols(); j++) {
                if(m.getValue(i, j) == null){
                    m.setValue(i, j, 0);
                }
            }
        }
    }

    @Test
    public void testConstructor() {
        Graph graph = new Graph(m);
        assertEquals(6, graph.getNodes().size());
        assertEquals(9, graph.getLinks().size());
        assertEquals(graph.getSource(), graph.getNodes().get(0));
        assertEquals(graph.getDest(), graph.getNodes().get(graph.getNodes().size() - 1));
        assertEquals(2, graph.getSource().getSuccessors().size());
        assertEquals(3, graph.getDest().getPredecessors().size());

        assertEquals(graph.getIncomingLinks(graph.getDest()).size(), graph.getDest().getPredecessors().size());
        assertEquals(graph.getOutGoingLinks(graph.getSource()).size(), graph.getSource().getSuccessors().size());

        Map<Integer, Vertex> vertexMap = new HashMap<Integer, Vertex>();
        for(Vertex vertex: graph.getSource().getSuccessors()) {
            vertexMap.put(vertex.getVertexNumber(), vertex);
        }

        assertTrue(vertexMap.containsKey(1));
        assertTrue(vertexMap.containsKey(2));

        vertexMap = new HashMap<Integer, Vertex>();
        for(Link link: graph.getOutGoingLinks(graph.getSource())) {
            vertexMap.put(link.getDest().getVertexNumber(), link.getDest());
            assertEquals(graph.getSource(), link.getSource());
        }

        assertTrue(vertexMap.containsKey(1));
        assertTrue(vertexMap.containsKey(2));

        vertexMap = new HashMap<Integer, Vertex>();
        for(Vertex vertex: graph.getDest().getPredecessors()) {
            vertexMap.put(vertex.getVertexNumber(), vertex);
        }

        assertTrue(vertexMap.containsKey(3));
        assertTrue(vertexMap.containsKey(4));
        assertTrue(vertexMap.containsKey(2));

    }


}
