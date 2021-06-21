package ds;

import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer> {
    private int size;
    private int f1;
    private int f2;
    private int counter = 1;

    public FibonacciIterator(int size){
        this.size = size;
        this.f1 = 0;
        this.f2 = 1;
    }

    @Override
    public boolean hasNext(){
        return counter < size;
    }

    @Override
    public Integer next() {
        if(counter == 1){
            counter++;
            return 0;
        }else if(counter == 2){
            counter++;
            return 1;
        }else{
            int temp = f1;
            int temp2 = f2; 
            f1 = temp2;
            f2 = temp + temp2;
            counter++;
            return f2;
        }
    }
}
