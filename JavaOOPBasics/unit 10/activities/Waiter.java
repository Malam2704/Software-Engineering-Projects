package activities;

import java.util.ArrayList;
import java.util.List;

public class Waiter implements Runnable{
    private final Object lock;

    public Waiter(Object lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized(lock){
            try{
                System.out.println("Waiting...");
                lock.wait();
            }catch(InterruptedException j){}
        }

        System.out.println("Hello World!");
    }

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        List<Thread> threads = new ArrayList<>();

        for(int i=1; i<11; i++){
            Waiter waiter =  new Waiter(lock);
            Thread t = new Thread(waiter);
            t.start();
        }

        Thread.sleep(1000);

        System.out.println("Notifying...");
        synchronized(lock){
            // for(int i=1; i<11; i++){
            //     lock.notify();
            // }
            lock.notifyAll();
        }
    }
    
}
