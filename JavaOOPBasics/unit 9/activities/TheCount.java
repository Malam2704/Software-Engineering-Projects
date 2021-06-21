package activities;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class TheCount implements Runnable{
    private static final int[] COUNT = new int[1];
    private final int id;

    public TheCount(int id){
        this.id = id;
    }

    // Corruption, since various threads are runnign a loop and the only
    // thing that is being modified is COUNT, we only synchronize it.
    @Override
    public void run() {
        System.out.println(id +" is stating");
        for(int i=0; i<100000; i++){
            synchronized(COUNT){
                COUNT[0] = COUNT[0] + 1;
            }
        }
        System.out.println( id + " is finished.");
    }

    public static void main(String[] args) throws InterruptedException{
        List<Thread> threads =  new ArrayList<>();
        long start = System.currentTimeMillis();

        for(int i=0; i<10; i++){
            TheCount count = new TheCount(i);
            Thread thread = new Thread(count);
            threads.add(thread);
            thread.start();
        }

        for(Thread thread : threads){
            thread.join();
        }

        System.out.println(COUNT[0]);
    }
    
}
