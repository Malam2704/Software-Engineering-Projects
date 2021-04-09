package ds;

import java.util.Iterator;

public class NodeIterator<E> implements Iterator<E>{
    Node<E> node;

    public NodeIterator(Node<E> node){
        System.out.println("Creating a new Node Iterator");
        this.node = node;
    }

    public boolean hasNext(){
        System.out.println("hasNext(): " + (node != null));
        return node != null;
    }

    @Override
    public E next(){
        //1. Return the value in it's current Node
        E value = node.getValue();
        System.out.println("next(): " + value);
        // move ndoe to next node
        node = node.getNext();

        return value;
    }
}
