package bst;

import graphs.AdjacencyGraph;
import graphs.Graph;

public class BstAsGraph {
    private int size;

    // Takes an array, tierates ofver, but makes null binary node, if it's null
    // menaing an array hasn't beenc reated yet, make one with the first int in the array
    // then continue to jsut add.
    public static BinaryNode makeBst(int[] array){
        BinaryNode mine = null;
        for (int i : array) {
            if(mine == null){
                mine = new BinaryNode(i);
            }else{
                mine.binaryInsert(i);
            }
        }
        return mine;
    }

    // Gets the infix traversal array form bst, and sepeerates them
    // turngion them into ints, takign the first one and making that the first
    // grpah point, then  iterating ove rhte rest fo the array
    // and adding those into myGraph
    public static Graph<Integer> convertToGraph(BinaryNode bst){
        String[] myBStringArray = bst.infixTraversal().split(" ");
        int first = Integer.parseInt(myBStringArray[0]);

        Graph<Integer> myGraph = new AdjacencyGraph<>();
        myGraph.add(first);
        for (int i=1; i< myBStringArray.length; i++) {
            int num = Integer.parseInt(myBStringArray[i]);
            myGraph.add(num);
            myGraph.connectDirected(first, num);
        }
        return myGraph;
    }

    public static void main(String[] args) {
        int[] ma = {1,10,3,4,5,6,7,9};
        BinaryNode mn = makeBst(ma);
        System.out.println(mn.infixTraversal());

        System.out.println(convertToGraph(mn));
    }
}
