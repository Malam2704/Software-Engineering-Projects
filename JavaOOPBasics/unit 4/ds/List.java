package ds;

import java.util.Iterator;

public interface List<E> extends Iterable<E>{
    public abstract void append(E value);
    public E get(int index);
    abstract void set(int index, E value);
    int size();

    @Override
    default Iterator<E> iterator() {
        throw new UnsupportedOperationException("iterator not implemented");
    }
}
