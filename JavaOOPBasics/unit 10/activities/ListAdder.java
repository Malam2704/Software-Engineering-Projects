package concurrency;

import java.util.ArrayList;
import java.util.List;

public class ListAdder implements Runnable{
    private final List<Integer> sharedList;
    private final int num;

    public ListAdder(List<Integer> sharedList, int num){
        this.sharedList = sharedList;
        this.num = num;
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        for(int n=0; n<num; n++){
            synchronized(sharedList){
                sharedList.add(n);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        // create one list to be shared
        List<Integer> totalList =  new ArrayList<>();
        
        // create and start 100 threads, each of which adds 50 values to
        // the shared list
        List<Thread> threads =  new ArrayList<>();
        for(int j=0; j<101; j++){
            ListAdder adder =  new ListAdder(totalList, 50);
            Thread thread = new Thread(adder);
            thread.start();
            threads.add(thread);
        }

        // use join to wait for all 100 threads to finish
        for(Thread thread : threads){
            thread.join();
        }

        // print the size of the list.
        System.out.println(totalList.size());
    }
}
