package com.tbp.model;


import org.junit.Test;
import static org.junit.Assert.*;


public class VertexTest {

    @Test
    public void testConstructor() {
        Vertex v1 = new Vertex();
        assertNotNull(v1.getPredecessors());
        assertNotNull(v1.getSuccessors());
        assertTrue(v1.getPredecessors().isEmpty());
        assertTrue(v1.getSuccessors().isEmpty());
    }


    @Test
    public void testGet() {
        Vertex v1 = new Vertex();
        v1.setVertexNumber(1);
        v1.setLabel(3);
        v1.setState(2);

        assertEquals(1, v1.getVertexNumber().intValue());
        assertEquals(2, v1.getState().intValue());
        assertEquals(3, v1.getLabel().intValue());

    }

    @Test
    public void testAddSuccessorPredecessor() {
        Vertex v1 = new Vertex();
        v1.setVertexNumber(1);
        Vertex v2 = new Vertex();
        v2.setVertexNumber(2);

        v1.addSuccessor(v2);
        v2.addPredecessor(v1);

        assertEquals(v2.getVertexNumber(), v1.getSuccessors().get(0).getVertexNumber());
        assertEquals(v1.getVertexNumber(), v2.getPredecessors().get(0).getVertexNumber());

    }

    @Test
    public void testAllSuccessorIs() {
        Vertex v1 = new Vertex();
        v1.setVertexNumber(1);
        Vertex v2 = new Vertex();
        v2.setVertexNumber(2);
        v2.setState(4);
        Vertex v3 = new Vertex();
        v3.setVertexNumber(3);
        v3.setState(4);

        v1.addSuccessor(v2);
        v1.addSuccessor(v3);


        assertTrue(v1.allSuccessorIs(4));
        v3.setState(5);
        assertFalse(v1.allSuccessorIs(5));
    }

    @Test
    public void testAllPredeccessorIs() {
        Vertex v1 = new Vertex();
        v1.setVertexNumber(1);
        Vertex v2 = new Vertex();
        v2.setVertexNumber(2);
        v2.setState(4);
        Vertex v3 = new Vertex();
        v3.setVertexNumber(3);
        v3.setState(4);

        v1.addPredecessor(v2);
        v1.addPredecessor(v3);


        assertTrue(v1.allPredeccessorIs(4));
        v3.setState(5);
        assertFalse(v1.allPredeccessorIs(5));
    }

}
