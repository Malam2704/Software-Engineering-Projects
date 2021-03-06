package graphs;

public class Graphs {
    public static Graph<String> makeGraph(){
        Graph<String> mine = new AdjacencyGraph<>();

        mine.add("A");
        mine.add("B");
        mine.add("C");
        mine.add("D");
        mine.add("E");
        mine.add("F");
        mine.add("G");
        mine.add("H");
        mine.add("I");
        mine.add("J");
        mine.add("K");

        mine.connectUndirected("A", "B");
        mine.connectDirected("A", "C");
        mine.connectUndirected("B", "E");
        mine.connectUndirected("C", "D");
        mine.connectUndirected("C", "E");
        mine.connectDirected("C", "H");
        mine.connectDirected("D", "B");
        mine.connectUndirected("D", "F");
        mine.connectDirected("E", "F");
        mine.connectUndirected("F", "G");

        mine.connectUndirected("I", "K");
        mine.connectDirected("J", "I");
        mine.connectUndirected("J", "K");

        return mine;
    }
}
