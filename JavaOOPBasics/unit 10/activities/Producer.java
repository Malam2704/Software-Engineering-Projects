package activities;

import java.util.LinkedList;
import java.util.Random;

public class Producer implements Runnable{
    private final int id;
    private final LinkedList<String> queue;
    private Random RNG = new Random();

    public Producer(int id, LinkedList<String> queue){
        this.id = id;
        this.queue = queue;
    }

    @Override
    public void run() {
        int messageNumber = 1;
        while(true){
            // sleep for 1 second
            try{
                Thread.sleep(1000);
            }catch(InterruptedException k){
                // squash
            }

            // generate a random int form 1-5
            int ranDInt = RNG.nextInt(5) + 1;

            synchronized(queue){
                // create that number of messages and add them to teh queue
                for(int i=0; i<ranDInt; i++){
                    String message = id + ": Message #" + messageNumber++;
                    queue.add(message);
                }

                // notfiy the queue
                queue.notify();
            }
        }
    } 
    
    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();

        for(int i=0; i<10; i++){
            Consumer consumer = new Consumer(i, queue);
            Thread cThread = new Thread(consumer);
            cThread.start();
        }

        for(int i=0; i<10; i++){
            Producer producer = new Producer(i, queue);
            Thread pThread = new Thread(producer);
            pThread.start();
        }
    }
}
