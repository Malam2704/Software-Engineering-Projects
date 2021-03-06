package graphs;

import java.util.HashSet;
import java.util.Set;

public class Vertex<E> {
    private E value;
    private Set<Vertex<E>> neighbors;

    public Vertex(E value){
        this.value = value;
        this.neighbors = new HashSet<>();
    }

    public E getValue() {
        return value;
    }

    public void connect(Vertex<E> neighbor){
        neighbors.add(neighbor);
    }

    public boolean connected(Vertex<E> vertex){
        return neighbors.contains(vertex);
    }

    public Set<Vertex<E>> getNeighbors() {
        return neighbors;
    }



}
