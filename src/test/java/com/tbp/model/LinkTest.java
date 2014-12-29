package com.tbp.model;


import org.junit.Test;
import static org.junit.Assert.*;

public class LinkTest {


    @Test
    public void testConstructor() {
        Vertex v1 = new Vertex();
        v1.setVertexNumber(1);
        Vertex v2 = new Vertex();
        v2.setVertexNumber(2);

        Link link = new Link(v1, v2, 3);
        assertEquals(v1, link.getSource());
        assertEquals(v2, link.getDest());
        assertEquals(3, link.getLabel().intValue());


    }

}
