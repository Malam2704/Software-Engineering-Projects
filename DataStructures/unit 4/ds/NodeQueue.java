package ds;

public class NodeQueue<T> implements Queue<T>{
    private Node<T> front;
    private Node<T> back;
    private int size;

    public NodeQueue(){
        front = null;
        back = null;
        size = 0;
    }

    @Override
    public void enqueue(T value){
        Node<T> node = new Node<T>(value);
        if(front == null){
            front = node;
            back = node;
        }else{
            back.setNext(node);
            back = node;
        }
        size++;
    }

    @Override
    public T dequeue(){
        T value = front.getValue();
        front = front.getNext();
        if(front == null){
            back = null;
        }
        size--;
        return value;
    }

    @Override
    public int size(){
        return size;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new NodeQueue<>();

        q.enqueue(123);
        q.enqueue(456);

        int x = q.dequeue();
        System.out.println(x);


    }
}
