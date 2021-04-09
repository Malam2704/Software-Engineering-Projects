package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AdjacencyGraph<E> implements Graph<E> {    
    private final Map<E, Vertex<E>> vertices;
    
    public AdjacencyGraph(){
        this.vertices = new HashMap<>();
    }

    @Override
    public int size() {
        return vertices.size();
    }

    @Override
    public void add(E value) {
        Vertex<E> vertex = new Vertex<>(value);
        vertices.put(value, vertex);
    }

    @Override
    public boolean contains(E value) {
        return vertices.containsKey(value);
    }

    @Override
    public void connectDirected(E a, E b) {
        Vertex<E> vertexA = vertices.get(a);
        Vertex<E> vertexB = vertices.get(b);

        vertexA.connect(vertexB);
    }

    @Override
    public void connectUndirected(E a, E b) {
        Vertex<E> vertexA = vertices.get(a);
        Vertex<E> vertexB = vertices.get(b);
        vertexA.connect(vertexB);
        vertexB.connect(vertexA);
    }

    @Override
    public boolean connected(E a, E b) {
        Vertex<E> vertexA = vertices.get(a);
        Vertex<E> vertexB = vertices.get(b);

        return vertexA.connected(vertexB);
    }

    @Override
    public boolean bfSearch(E start, E end) {
        Vertex<E> startV = vertices.get(start);
        Vertex<E> endV = vertices.get(end);

        LinkedList<Vertex<E>> queue = new LinkedList<>();
        Set<Vertex<E>> visited = new HashSet<>();

        queue.add(startV);
        visited.add(startV);

        while(!queue.isEmpty()){
            Vertex<E> v = queue.remove(0);
            if(v == endV){
                return true;
            } else{
                Set<Vertex<E>> neighbors = v.getNeighbors();
                for(Vertex<E> n: neighbors){
                    if(!visited.contains(n)){
                        visited.add(n);
                        queue.add(n);
                    }
                }
            }
        }

        return false;
    }

    @Override
    public List<E> bfPath(E start, E end) {
        Vertex<E> startV = vertices.get(start);
        Vertex<E> endV = vertices.get(end);

        LinkedList<Vertex<E>> queue = new LinkedList<>();
        Map<Vertex<E>, Vertex<E>> predecessors = new HashMap<>();

        queue.add(startV);
        predecessors.put(startV, null);

        while(!queue.isEmpty()){
            Vertex<E> v = queue.remove(0);
            if( v == endV){
                return makePath(predecessors, endV);
            } else{
                Set<Vertex<E>> neighbors = v.getNeighbors();
                for(Vertex<E> n: neighbors){
                    if(!predecessors.containsKey(n)){
                        predecessors.put(n, v);
                        queue.add(n);
                    }
                }
            }
        }

        return null;
    }

    // fix this
    private List<E> makePath(Map<Vertex<E>, Vertex<E>> predecessors, Vertex<E> endV){
        if(!predecessors.containsKey(endV)){
            return null;
        } else{
            LinkedList<E> path = new LinkedList<>();

            Vertex<E> current = endV;
            while(current != null){
                path.add(0, current.getValue());
                Vertex<E> predecessor = predecessors.get(current);
                current = predecessor;
            }

            return path;
        }
    }

    @Override
    public int countConnectedComponents() {
        // Makes a set that's empy and makes a count
        // and iterates over the maps hey set
        //  if there isn't a specific key in that set then the count is inc
        //  -remented and a specifc version of bsf is made, but I gvae up soent way too 
        //  many hours and can't comprehend this
        Set<E> my_Set = new HashSet<>();
        int count = 0;
        for(E key: vertices.keySet()){
            if(my_Set.contains(key) == false){
                my_Set.add(key);
                count++;
            }
        }

        return count;

        // LinkedList<Vertex<E>> queue = new LinkedList<>();
        // Set<Vertex<E>> visited = new HashSet<>();

        // queue.add(startV);
        // visited.add(startV);

        // while(!queue.isEmpty()){
        //     Vertex<E> v = queue.remove(0);
        //     if(v == endV){
        //         return visited.size();
        //     } else{
        //         Set<Vertex<E>> neighbors = v.getNeighbors();
        //         for(Vertex<E> n: neighbors){
        //             if(!visited.contains(n)){
        //                 visited.add(n);
        //                 queue.add(n);
        //             }
        //         }
        //     }
        // }
        // return visited.size();
    }

    @Override
    public boolean dfSearch(E start, E end) {
        Set<Vertex<E>> visited = new HashSet<>();
        Vertex<E> startV = vertices.get(start);
        Vertex<E> endV = vertices.get(end);
        visited.add(startV);
        visitDFS(startV, visited);
        return visited.contains(endV);
    }

    private void visitDFS(Vertex<E> a, Set<Vertex<E>> my_Set){
        for(Vertex<E> n : a.getNeighbors()){
            if(my_Set.contains(n) == false){
                my_Set.add(n);
                // when it checks the initial vertex a, it also appllied
                // this function to the neighbors of it, and checks it
                // making a sort fo recursion whcih will apply to it's 
                // neighbors and their neighbors and so on.
                visitDFS(n, my_Set);
            }
        }
    }

    @Override
    public List<E> dfPath(E start, E end) {
        Set<Vertex<E>> visited = new HashSet<>();
        Vertex<E> startV = vertices.get(start);
        Vertex<E> endV = vertices.get(end);
        visited.add(startV);

        return visitDFPath(startV, endV, visited);
    }

    private List<E> visitDFPath(Vertex<E> startV, Vertex<E> endV, Set<Vertex<E>> my_Set){
        if(startV == endV){
            LinkedList<E> a_list = new LinkedList<>();
            a_list.add(endV.getValue());
            return a_list;
        }else{
            for(Vertex<E> n : startV.getNeighbors()){
                if(!my_Set.contains(n)){
                    my_Set.add(n);
                    List<E> path = visitDFPath(n, endV, my_Set);
                    if(path != null){
                        path.add(0, startV.getValue());
                        return path;
                    }
                }
            }
            return null;
        }
    }
}
