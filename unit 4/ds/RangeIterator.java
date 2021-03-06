package ds;

import java.util.Iterator;

// Range iterator that has a stop start adn step
public class RangeIterator implements Iterator<Integer> {
    private int start;
    private int stop;
    private int step;
    private int counter = 0;

    public RangeIterator(int start, int stop, int step){
        this.start = start;
        this.stop = stop;
        this.step = step;
    }

    // checks if the next value would be above our stop limit and if so
    // returns what the boolean is
    @Override
    public boolean hasNext(){
        return  start + counter < stop;
    }

    // the next value is a counter we made for incrementing how many i's
    // there were already iterated over, and with that multiplies by step to add
    //  to the original start for the current value
    @Override
    public Integer next() {
        int result = (int)(start + counter);
        counter += step;
        return result;
    }
}
