package ds;

public class ArrayQueue<E> implements Queue<E>{
    private Object[] elements;
    private int front;
    private int back;
    private int size;

    public ArrayQueue(){
        elements = new Object[2];
        front = 0;
        back = 0;
        size = 0;
    }

    @Override
    public void enqueue(E value){
        if(size == elements.length) {
            resize();
        }
        elements[back] = value;
        back = (back + 1) % elements.length;
        size++;
    }

    @Override
    public E dequeue(){
        if(size == 0){
            return null;
        }
        Object my_val = elements[front];
        E e = (E)my_val;
        elements[front] = null;
        front = (front + 1) % elements.length;
        size--;
        return e;
    }

    @Override 
    public int size(){
        return size;
    }

    private void resize(){
        Object[] bigger = new Object[size*2];
        for(int dest=0; dest<size; dest++){
            int source = (dest + front) % size;
            bigger[dest] = elements[source];
        }
        elements = bigger;
        front = 0;
        back = size;
    }
}

