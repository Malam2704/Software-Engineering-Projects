package Heaps;

import java.util.Arrays;

public class ArrayHeap implements Heap{
    public int[] array;
    private int size;

    public ArrayHeap(){
        array = new int[3];
        size = 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(array) + ", " + size;
    }

    @Override
    public int size() {
        return size;    
    }

    @Override
    public void add(int value) {    
        if(size == array.length){
            int[] bigger = Arrays.copyOf(array, size*2);
            array = bigger;
        }

        array[size] = value;
        
        int child = size;
        int parent = (child - 1)/2;
        while(array[parent] > array[child]){
            swap(parent, child);
            child = parent;
            parent = (child-1)/2;
        }

        size++;
    }

    private void swap(int index_a, int index_b){
        if(index_a != index_b){
            int old_val = array[index_a];
            int new_vale = array[index_b];

            array[index_b] = new_vale;
            array[index_a] = old_val;
        }
    }

    @Override
    public int remove() {
        int temp = array[0];
        size--;

        swap(0,size);
        array[size] = 0;

        // magic happens 
        int parent = 0;
        while(true){
            int left = (parent * 2) + 1;
            int right = (parent * 2) + 2;
            int dest = parent;

            if(left < size && array[left] < array[parent]){
                dest = left;
            }

            if(right < size && array[right] < array[left]){
                dest = right;
            }

            if(dest!= parent){
                swap(parent, dest);
                parent = dest;
            }else{
                break;
            }
        }

        return temp;
    }

    public static void main(String[] args) {
        Heap heap = new ArrayHeap();
        System.out.println(heap);

        heap.add(6);
        heap.add(4);
        heap.add(3);
        heap.add(1);
        heap.add(6);
        heap.add(7);
        heap.add(-1);

        System.out.println(heap);

        System.out.println(heap.remove() + ", " + heap);
    }

}
