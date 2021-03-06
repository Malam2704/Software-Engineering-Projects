// Mohammed Alam, 4.3, 
// This was ahrd, I amde 6 modules, abt, a INtRange, a Fibonacci,
// a range Iterator and FIbonacci iterator, and a testing file called abtTest
// We use these iterators to amekr simple for each loops for data structures
// similar to python's list implementations
package ds;

import java.util.Iterator;

public class IntRange implements adt{
    // All of the variables needs to be initialized
    protected int start;
    protected int stop;
    protected int step;

    // Example sof constructors being made for ranges with a start,stop, step
    // a start, stop, and a just stop
    public IntRange(int start, int stop, int step){
        this.start = start;
        this.stop = stop;
        this.step = step;
    }
    public IntRange(int start, int stop){
        this.start = start;
        this.stop = stop;
        this.step = 1;
    }
    public IntRange(int stop){
        this.start = 0;
        this.stop = stop;
        this.step = 1;
    }

    // This overides the adt interface and returns the size of the 
    // iteration made
    @Override
    public int size(){
        int count = 0;
        for (int i=start; i<stop; i+= step){
            count++;
        }
        return count;
    }

    // returns the value of the index we asked for, by adding 
    // the index+1, the position of the index with the step, and adding
    // it into the start
    @Override
    public int get(int index) {
        int adder = step*(index);
        if((start + adder) > stop){
            throw new IndexOutOfBoundsException("Index is non existent");
        }else{
            return start + adder;
        }
    }

    // This is important you return the RangeIterator class
    // for every time you overide the iterator function
    @Override
    public RangeIterator iterator() {
        return new RangeIterator(start,stop,step);
    }

    // Main function that tests values and fucntions of this class
    public static void main(String[] args) {
        IntRange my_range = new IntRange(2, 20, 3);
        System.out.println(my_range.get(6));
        for(int i : new IntRange(2, 20, 3)) {  System.out.println(i);}

        // List<String> two = new ArrayList<>();
        // two.append("123");
        // two.append("456");
        // two.append("789");
        // forList(two);
    }
}
