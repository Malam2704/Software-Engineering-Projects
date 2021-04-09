package ds;

public class Node<E> {
    private E value;
    private Node<E> next;

    public Node(E value, Node<E> next){
        this.value = value;
        this.next = next;
    }

    public Node(E value){
        this(value, null);
    }

    public Node<E> getNext() {
        return next;
    }

    public E getValue() {
        return value;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
