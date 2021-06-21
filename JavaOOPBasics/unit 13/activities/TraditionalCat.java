package activities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TraditionalCat<T> implements Concatenator<T>, Iterable<T>{
    private List<T> listo;

    public TraditionalCat(){
        this.listo = new ArrayList<>();
    }

    @Override
    public void add(T l) {
        // TODO Auto-generated method stub
        listo.add(l);
    }

    @Override
    public void remove(T l) {
        // TODO Auto-generated method stub
        listo.remove(l);
    }

    @Override
    public String concatenate() {
        // TODO Auto-generated method stub
        String s = "";
        for(T ca : listo){
            s += ca;
        }
        return s;
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return listo.iterator();
    }

    public static void main(String[] args) {
        Concatenator<Integer> cat = new TraditionalCat<>();
        cat.add(123);
        cat.add(456);
        cat.add(678);

        for(int x : cat){
            System.out.println(x);
        }
    }
}
