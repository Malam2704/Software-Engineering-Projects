package graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class WVertex<E>{
    private E value;
    private Map<WVertex<E>, Edge<E>> neighbors;

    public WVertex(E value){
        this.value = value;
        neighbors = new HashMap<>();
    }

    public E getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public void connect(WVertex<E> neighbor, double weight){
        Edge<E> edge = new Edge<>(this, neighbor, weight);
        neighbors.put(neighbor, edge);
    }

    public Edge<E> edge(WVertex<E> neighbor){
        return neighbors.get(neighbor);
    }

    // fix this
    public Set<Edge<E>> edges(){
        Set<Edge<E>> edges = new TreeSet<>();
        edges.addAll(neighbors.values());
        return edges;
    }

}
