// Mohammed Alam
// I used an Array Heap to imitate a Queue which is sorting by priority which is already
//  the default order whcih the Array Heap is adding values by
package ds;

public class HeapPQ implements Queue<Integer>{
    Heap my_q;

    public HeapPQ(){
        this.my_q = new ArrayHeap();
    }

    // just adds a vlaue into the queue, made form adding to the array heap
    @Override
    public void enqueue(Integer value) {
        int new_val = (int)(value);
        this.my_q.add(new_val);
    }

    // returns an integer type of the remove variable of the arrayheap
    @Override
    public Integer dequeue() {
        return this.my_q.remove();
    }

    // returns the size() of the variable
    @Override
    public int size() {
        return this.my_q.size();
    }

    // returns the to string of the variable we made for an array heap
    @Override
    public String toString() {
        return my_q.toString();
    }

    // Main method here
    public static void main(String[] args) {
        HeapPQ mine = new HeapPQ();
        mine.enqueue(5);
        mine.enqueue(1);
        mine.enqueue(2);
        mine.enqueue(4);
        mine.enqueue(7);
        mine.enqueue(3);
        mine.enqueue(1);
        System.out.println(mine);
        System.out.println("size is " + mine.size());
        System.out.println(mine.dequeue());
        System.out.println(mine.dequeue());
        System.out.println(mine.dequeue());
        System.out.println(mine.dequeue());
        System.out.println(mine.dequeue());
    }
}
