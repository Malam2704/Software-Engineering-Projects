package ds;

import java.util.Iterator;

public interface adt extends Iterable<Integer>{
    public int size();
    public int get(int index);
    public Iterator<Integer> iterator();
}
