package activities;

import java.util.ArrayList;
import java.util.List;

public class HelloThread implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello World");
    }

    public static void main(String[] args) throws InterruptedException{
        List<Thread> threads = new ArrayList<>();

        for(int i=0; i<5; i++){
            HelloThread hello = new HelloThread();
            Thread thread = new Thread(hello);
            thread.start();
        }

        for(Thread thread : threads){
            thread.join();
        }

        //Thread.sleep(10);
        System.out.println("Goodbye!");
    }
}
