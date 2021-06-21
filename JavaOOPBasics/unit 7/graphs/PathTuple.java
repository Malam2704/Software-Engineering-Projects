package graphs;

public class PathTuple<E> {
    private WVertex<E> vertex;
    private WVertex<E> predecessor;
    private double distance;

    public PathTuple(WVertex<E> vertex){
        this.vertex = vertex;
        this.predecessor = null;
        this.distance = Double.MAX_VALUE;
    }

    public double getDistance() {
        return distance;
    }
    public WVertex<E> getPredecessor() {
        return predecessor;
    }
    public WVertex<E> getVertex() {
        return vertex;
    }

    public void update(WVertex<E> predecessor, double distance){
        // Compare the parameter to the field, and fi it is less
        // save the predecessor and distance.
        if(distance < this.distance){
            this.distance = distance;
            this.predecessor = predecessor;
        }
        // otherwise ignore it
    }

    @Override
    public String toString() {
        String string = vertex + ":(" + predecessor + ", ";
        if(distance == Double.MAX_VALUE){
            string += "infinity)";
        }else{
            string += distance + ")";
        }
        return string;
    }
}
