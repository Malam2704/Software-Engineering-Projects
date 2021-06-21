import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sleeper implements Runnable{
    private int seconds;

    public Sleeper(int seconds){
        this.seconds = seconds;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try{
            System.out.println("Sleeping for " + seconds + " seconds");
            Thread.sleep(seconds);
            System.out.println("I'm wide awake");
        }catch(InterruptedException j){}
    }

    public static void main(String[] args) throws InterruptedException {
        Random RNG = new Random();
        List<Thread> threads = new ArrayList<>();

        for(int i=0; i<4; i++){
            Sleeper sleeper = new Sleeper(RNG.nextInt(5000));
            Thread sThread = new Thread(sleeper);
            sThread.start();
            //sThread.join();
            threads.add(sThread);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        // 50 minutes ish
        System.out.println("Everyone is awake");
    }
}
