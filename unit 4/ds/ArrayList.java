package ds;

import java.sql.Array;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E>{
    protected Object[] elements;
    int size;

    public ArrayList() {
        elements = new Object[2];
        size = 0;
    }

    @Override 
    public int size(){
        return size;
    }

    @Override
    public void set(int index, E value) {
        elements[index] = value;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        Object value = elements[index];
        E e = (E)value;
        return e;
    }

    @Override
    public void append(E value) {
        if(size == elements.length){
            Object[] bigger = Arrays.copyOf(elements, size*2);
            elements = bigger;
        }
        elements[size] = value;
        size++;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(elements, size);
    }
}
