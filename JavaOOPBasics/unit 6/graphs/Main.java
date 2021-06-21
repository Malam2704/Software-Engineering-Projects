package graphs;
// Main method used to test everything, I made a filename vairbale and applied it
//  so it prints the textg file along wiht the result of the count connected compnents fucntion
//  applied to that file name.
public class Main {
    public static void main(String[] args) {
        try{
            System.out.println(GraphReader.readGraph("data/a_6_1.txt"));
            String filename = "data/a_13_5.txt";
            System.out.println(filename + " connected components: " + GraphReader.readGraph(filename).countConnectedComponents());
            filename = "data/a_22_3.txt";
            System.out.println(filename + " connected components: " + GraphReader.readGraph(filename).countConnectedComponents());
            filename = "data/a_26_4.txt";
            System.out.println(filename + " connected components: " + GraphReader.readGraph(filename).countConnectedComponents());
            filename = "data/a_6_1.txt";
            System.out.println(filename + " connected components: " + GraphReader.readGraph(filename).countConnectedComponents());
            filename = "data/a_7_3.txt";
            System.out.println(filename + " connected components: " + GraphReader.readGraph(filename).countConnectedComponents());
            filename = "data/bipartite.txt";
            System.out.println(filename + " connected components: " + GraphReader.readGraph(filename).countConnectedComponents());
            filename = "data/k2.txt";
            System.out.println(filename + " connected components: " + GraphReader.readGraph(filename).countConnectedComponents());
            filename = "data/k2_2.txt";
            System.out.println(filename + " connected components: " + GraphReader.readGraph(filename).countConnectedComponents());
            filename = "data/k3.txt";
            System.out.println(filename + " connected components: " + GraphReader.readGraph(filename).countConnectedComponents());
            filename = "data/k3_3.txt";
            System.out.println(filename + " connected components: " + GraphReader.readGraph(filename).countConnectedComponents());
            filename = "data/k4.txt";
            System.out.println(filename + " connected components: " + GraphReader.readGraph(filename).countConnectedComponents());
            filename = "data/k5.txt";
            System.out.println(filename + " connected components: " + GraphReader.readGraph(filename).countConnectedComponents());
            filename = "data/non_bipartite.txt";
            System.out.println(filename + " connected components: " + GraphReader.readGraph(filename).countConnectedComponents());
            filename = "data/v2.txt";
            System.out.println(filename + " connected components: " + GraphReader.readGraph(filename).countConnectedComponents());

        }catch(Exception d){
            System.out.println("Can't read file");
        }
    }
}
