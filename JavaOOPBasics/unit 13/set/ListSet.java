package set;

import java.util.ArrayList;
import java.util.Iterator;

import org.hamcrest.internal.ArrayIterator;

public class ListSet<T> implements Set<T> {
    ArrayList<T> myArrayList = new ArrayList<>();

    // O(1) complexity, always adds to the end, so same for all inputs.
    @Override
    public void add(T e) {
        // TODO Auto-generated method stub
        myArrayList.add(this.size() - 1, e);
    }

    // O(n) complexity, linear for loop based on the size. 
    @Override
    public void remove(T o) {
        // TODO Auto-generated method stub
        if(this.contains(o)){
            for(int i=0; i<myArrayList.size(); i++){
                if(myArrayList.get(i) == o || myArrayList.get(i).equals(o)){
                    myArrayList.remove(o);
                }
            }
        }
    }

    // O(n), the array list is going to interate it's size until
    // it finds o in itself.
    @Override
    public boolean contains(T o) {
        // TODO Auto-generated method stub
        if(myArrayList.contains(o)){
            return true;
        }
        return false;
    }

    // O(c) because only 1 things needed.
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return myArrayList.size();
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        Iterator<T> myIterator = new ArrayIterator(array);
    }
}
