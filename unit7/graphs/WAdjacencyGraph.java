package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WAdjacencyGraph<E> implements WGraph<E>{
    private final Map<E, WVertex<E>> vertices;

    public WAdjacencyGraph(){
        vertices = new HashMap<>();
    }

    @Override
    public void add(E value) {
        WVertex<E> vertex = new WVertex<>(value);
        vertices.put(value, vertex);
    }

    @Override
    public boolean contains(E value) {
        return vertices.containsKey(value);
    }

    @Override
    public int size() {
        return vertices.size();
    }

    @Override
    public void connect(E a, E b, double weight) {
        WVertex<E> vertexA = vertices.get(a);
        WVertex<E> vertexB = vertices.get(b);

        vertexA.connect(vertexB, weight);
        vertexB.connect(vertexA, weight);
    }

    @Override
    public boolean connected(E a, E b) {
        WVertex<E> vertexA = vertices.get(a);
        WVertex<E> vertexB = vertices.get(b);
        return vertexA.edge(vertexB) != null;
    }

    @Override
    public double weight(E a, E b) {
        WVertex<E> vertexA = vertices.get(a);
        WVertex<E> vertexB = vertices.get(b);
        return vertexA.edge(vertexB).getWeight();
    }

    @Override
    public WPath<E> nearestNeighbors(E start, E end) {
        WVertex<E> s = vertices.get(start);
        WVertex<E> e = vertices.get(end);

        Set<WVertex<E>> visited = new HashSet<>();
        visited.add(s);

        return visitDFPath(s, e, visited);
    }

    private WPath<E> visitDFPath(WVertex<E> v, WVertex<E> e, 
        Set<WVertex<E>> visited) {
        if(v == e) {
            // List<E> path = new LinkedList<>();
            // path.add(e.getValue());
            return new WPath<>(e.getValue());
        } else {
            for(Edge<E> edge : v.edges()){
                WVertex<E> neighbor = edge.getTo();
                if(!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    WPath<E> path = visitDFPath(neighbor, e, visited);
                    if(path != null) {
                        path.prepend(v.getValue(), edge.getWeight());
                        // path.add(0, v.getValue());
                        return path;
                    }
                }
            }
            return null;
        }
    }

    @Override
    public WPath<E> dijkstrasPath(E start, E end) {
        // step 1 setup
        WVertex<E> startV = vertices.get(start);
        WVertex<E> endV = vertices.get(end);

        Map<WVertex<E>, PathTuple<E>> tuples = new HashMap<>();
        TupleQueue<E> queue = new TupleQueue<>();

        for(WVertex<E> vertex: vertices.values()){
            PathTuple<E> tuple = new PathTuple<>(vertex);
            tuples.put(vertex, tuple);
            queue.enqueue(tuple);
        }

        PathTuple<E> startTuple = tuples.get(startV);
        startTuple.update(null, 0);

        // step 2
        while(queue.size() > 0){
            PathTuple<E> tuple = queue.dequeue();
            if(tuple.getDistance() == Double.MAX_VALUE){
                break;
            }

            WVertex<E> v = tuple.getVertex();
            for(Edge<E> edge : v.edges()){
                WVertex<E> n = edge.getTo();
                double distance = tuple.getDistance() + edge.getWeight();
                PathTuple<E> nTuple = tuples.get(n);
                nTuple.update(v, distance);
            }
        }

        // Step 3 - building the path
        PathTuple<E> endTuple = tuples.get(endV);
        if(endTuple.getDistance() == Double.MAX_VALUE){
            return null;
        }

        WPath<E> path = new WPath<>(endV.getValue());
        double distance = endTuple.getDistance();

        WVertex<E> v = endTuple.getPredecessor();
        while(v != null){
            path.prepend(v.getValue(), distance);
            distance = 0;
            PathTuple<E> vTuple = tuples.get(v);
            v = vTuple.getPredecessor();
        }

        return path;
    }

}
