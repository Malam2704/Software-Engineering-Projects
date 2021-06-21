import java.util.ArrayList;
import java.util.List;

public class Incremementor {
    private int count = 0;
    private Object lock = new Object();

    // Don't do precision synchronization
    // because much slower.
    public void increment(){
        // synchronized(lock){
        //     count++;
        // }
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        Incremementor inc = new Incremementor();

        List<Thread> threads = new ArrayList<>();
        
        // create and start 10 threads that each call incrmemnet 100,000 times.
        for(int i=0; i<10; i++){
            // Thread thread = new Thread(){
            //     @Override
            //     public void run() {

            //     }
            // };
            Thread thread = new Thread(new Runnable(){
                @Override
                public void run() {
                    for(int j=0; j<1000000; j++){
                        synchronized(inc){
                            inc.increment();
                        }
                    }
                }
            });
            thread.start();
            threads.add(thread);
        }
        // wait for them to finish
        for (Thread thread : threads) {
            thread.join();
        }
        // print the count
        System.out.println(inc.count);
    }
}
