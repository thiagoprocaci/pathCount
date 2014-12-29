package com.tbp.algorithm;


import com.tbp.model.AdjacencyMatrix;
import com.tbp.model.Graph;
import com.tbp.model.Link;
import com.tbp.model.Vertex;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PathCountTest {

    private AdjacencyMatrix m;


    @Before
    public void doBefore() {
        m = new AdjacencyMatrix(7);
        m.setValue(0, 1, 1);
        m.setValue(0, 2, 1);
        m.setValue(1, 3, 1);
        m.setValue(1, 4, 1);
        m.setValue(2, 3, 1);
        m.setValue(2, 4, 1);
        m.setValue(2, 5, 1);
        m.setValue(3, 5, 1);
        m.setValue(3, 6, 1);
        m.setValue(4, 5, 1);
        m.setValue(4, 6, 1);
        m.setValue(5, 6, 1);

        for (int i = 0; i < m.getRows(); i++) {
            for (int j = 0; j < m.getCols(); j++) {
                if(m.getValue(i, j) == null){
                    m.setValue(i, j, 0);
                }
            }
        }
    }

    @Test
    public void testNodeLabellingAlgorithm() {
        Graph graph = new Graph(m);
        assertEquals(9, PathCount.nodeLabellingAlgorithm(graph).intValue());
    }

    @Test
    public void testLinkLabellingAlgorithm() {
        Graph graph = new Graph(m);
        assertEquals(9, PathCount.nodeLabellingAlgorithm(graph).intValue());
    }

    @Test
    public void testGetNumberOfPathThroughAnyNode() {
        Graph graph = new Graph(m);
        graph = PathCount.getNumberOfPathThroughAnyNode(graph);
        for(Vertex v: graph.getNodes()) {
            switch (v.getVertexNumber()) {
                case 0:
                    assertEquals(9, v.getLabel().intValue());
                    break;
                case 1:
                    assertEquals(4, v.getLabel().intValue());
                    break;
                case 2:
                    assertEquals(5, v.getLabel().intValue());
                    break;
                case 3:
                    assertEquals(4, v.getLabel().intValue());
                    break;
                case 4:
                    assertEquals(4, v.getLabel().intValue());
                    break;
                case 5:
                    assertEquals(5, v.getLabel().intValue());
                    break;
                case 6:
                    assertEquals(9, v.getLabel().intValue());
                    break;
               default:
                   fail("Should not be executed");
            }
        }
    }

    @Test
    public void testGetNumberOfPathThroughAnyLink() {
        Graph graph = new Graph(m);
        graph = PathCount.getNumberOfPathThroughAnyLink(graph);
        for(Link link: graph.getLinks()) {
            Integer sourceId = link.getSource().getVertexNumber();
            Integer destId = link.getDest().getVertexNumber();
            if(sourceId == 0 && destId == 1) {
                assertEquals(4, link.getLabel().intValue());
                continue;
            }
            if(sourceId == 0 && destId == 2) {
                assertEquals(5, link.getLabel().intValue());
                continue;
            }
            if(sourceId == 1 && destId == 3) {
                assertEquals(2, link.getLabel().intValue());
                continue;
            }
            if(sourceId == 1 && destId == 4) {
                assertEquals(2, link.getLabel().intValue());
                continue;
            }
            if(sourceId == 2 && destId == 3) {
                assertEquals(2, link.getLabel().intValue());
                continue;
            }
            if(sourceId == 2 && destId == 4) {
                assertEquals(2, link.getLabel().intValue());
                continue;
            }
            if(sourceId == 2 && destId == 5) {
                assertEquals(1, link.getLabel().intValue());
                continue;
            }
            if(sourceId == 3 && destId == 5) {
                assertEquals(2, link.getLabel().intValue());
                continue;
            }
            if(sourceId == 3 && destId == 6) {
                assertEquals(2, link.getLabel().intValue());
                continue;
            }
            if(sourceId == 4 && destId == 5) {
                assertEquals(2, link.getLabel().intValue());
                continue;
            }
            if(sourceId == 4 && destId == 6) {
                assertEquals(2, link.getLabel().intValue());
                continue;
            }
            if(sourceId == 5 && destId == 6) {
                assertEquals(5, link.getLabel().intValue());
                continue;
            }

            fail("Should not be executed..");
        }


    }

}
