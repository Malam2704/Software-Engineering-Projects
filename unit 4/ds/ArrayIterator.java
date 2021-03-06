package ds;

import java.util.Iterator;

public class ArrayIterator<E> implements Iterator<E> {
    private final Object[] elements;
    private final int size;
    private int index;

    public ArrayIterator(Object[] elements, int size){
        this.elements = elements;
        this.size = size;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < size;
    }

    @Override
    public E next() {
        E value = (E)elements[index];
        index++;
        return value;
    }
}
