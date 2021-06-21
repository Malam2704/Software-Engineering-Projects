package ds;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public interface Queue<E>{

    public abstract void enqueue(E value);

    public E dequeue();

    abstract int size();
}