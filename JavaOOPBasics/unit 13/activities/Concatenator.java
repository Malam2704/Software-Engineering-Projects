package activities;

import java.util.Iterator;

public interface Concatenator<T> extends Iterable<T>{
    void add(T l);
    void remove(T l);
    String concatenate();
}
