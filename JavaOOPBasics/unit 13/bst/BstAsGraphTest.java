package bst;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

import graphs.Graph;

@Testable
public class BstAsGraphTest {
    
    @Test
    public void TestMakeBst(){
        int[] ma = {1,10,3,4,5,6,7,9};
        BinaryNode mn = BstAsGraph.makeBst(ma);
        Graph<Integer> mygGraph = BstAsGraph.convertToGraph(mn);

        assertEquals(mygGraph.contains(1), true);
        assertEquals(mn.infixTraversal(), "1 3 4 5 6 7 9 10 ");
    }

    @Test
    public void TestConverToGraph(){
        int[] ma = {1,10,3,4,5,6,7,9};
        BinaryNode mn = BstAsGraph.makeBst(ma);
        Graph<Integer> mygGraph = BstAsGraph.convertToGraph(mn);

        assertEquals(mygGraph.contains(1), true);
        assertEquals(mn.infixTraversal(), "1 3 4 5 6 7 9 10 ");
        assertEquals(mygGraph.connected(1, 3), true);
        assertEquals(mygGraph.connected(1, 4), true);
        assertEquals(mygGraph.connected(1, 5), true);
        assertEquals(mygGraph.connected(1, 6), true);
        assertEquals(mygGraph.connected(1, 7), true);
        assertEquals(mygGraph.connected(1, 8), false);
        assertEquals(mygGraph.connected(1, 9), true);
        assertEquals(mygGraph.connected(1, 10), true);
    }
}
