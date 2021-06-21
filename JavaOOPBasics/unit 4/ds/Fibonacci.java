package ds;

public class Fibonacci implements adt{
    // All of the variables needs to be initialized
    protected int f1;
    protected int f2;
    protected int size;

    // Example sof constructors being made for ranges with size
    public Fibonacci(int size){
        this.f1 = 0;
        this.f2 = 1;
        this.size = size;
    }

    // This overides the adt interface and returns the size of the 
    // iteration made
    @Override
    public int size() {
        return size;
    }

    // returns if the index is 0 or 1, 0 or 1 respectively,
    // and else it applies the fibonacci sequence for a time of index-1
    // similar to the python range, then it just creates temp variables
    // of f1 and f2 and sets f1 to equal temp2, and f2 to temp + temp2
    // returns f2, the last numbe rin the sequence when it's done.
    @Override
    public int get(int index) {
        if(index > (size)){
            throw new IndexOutOfBoundsException(" Index doesn't exist");
        }else if(index == 0){
            return 0;
        }else if(index == 1){
            return 1;
        }else{
            for(int i=0; i<(index-1); i++){
                int temp = f1;
                int temp2 = f2; 
                f1 = temp2;
                f2 = temp + temp2;
            }
            return f2;
        }
    }

    // This is important you return the FibonacciIterator class
    // for every time you overide the iterator function
    @Override
    public FibonacciIterator iterator() {
        return new FibonacciIterator(10);
    }
    // Main function that tests values and fucntions of this class
    public static void main(String[] args) {
        Fibonacci my_range = new Fibonacci(10);
        System.out.println(my_range.get(9));
        System.out.println("__________________");
        for(int i : new Fibonacci(10)) {  
            System.out.println(i);
        }
    }
}
