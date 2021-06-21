package concurrency;

public class RunnableCounter implements Runnable {
    private final String name;

    public RunnableCounter(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for(int i= 0; i<101; i++){
            System.out.println(name + ": " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Thread[] threads = new Thread[5];
        for(int j=1; j<6; j++){
            Runnable counter = new RunnableCounter("Runnable " + j);
            //counter.run();

            Thread thread = new Thread(counter);
            thread.start();
            threads[j-1] = thread;
        }

        for(Thread thread: threads){
            System.out.println(thread.getName());
            thread.join();
        }

        // for(char c='A'; c<='Z';c++){
        //     System.out.print(c + " ");
        // }
        // System.out.println();
        System.out.println("Countin all done");
    }
}
