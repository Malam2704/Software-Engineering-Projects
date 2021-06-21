package activities;

import java.util.LinkedList;
import java.util.List;

public class Consumer implements Runnable{
    private int id;
    private LinkedList<String> queue;

    public Consumer(int id, LinkedList<String> mal){
        this.queue = mal;
        this.id = id;
    }

    @Override
    public void run() {
        while(true){
            String message = null;
            synchronized(queue){
                // if queue is empty, wait on it.
                while(queue.isEmpty()){
                    try{
                        System.out.println(id + " is waiting ...");
                        queue.wait();
                    }catch(InterruptedException j){
                        System.err.println("Ehyppp");
                    }
                }

                // Ptherwise remove 1 message
                message = queue.remove(0);
            }
            // print it.
            System.out.println(id + " " + message);
        }
    }

    public static void main(String[] args) {
        LinkedList<String> queue =  new LinkedList<>();
        queue.add("Eh");
        queue.add("bruh!");

        Consumer consumer = new Consumer(0, queue);
    }
    
}
