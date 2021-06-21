package activities;

import java.util.ArrayList;
import java.util.List;

public class NameThread implements Runnable{
    private final String myStr;
    private final int index; 
    private final Thread previous;
    
    public NameThread(String p, int i, Thread previous){
        this.myStr = p;
        this.index = i;
        this.previous = previous;
    }

    @Override
    public void run() {
        if(previous != null){
            try{
                previous.join();
            }catch(InterruptedException j){
                System.err.println("Exc");
            }
        }
        System.out.print(myStr.charAt(index));
    }

    public static void main(String[] args) throws InterruptedException {
        String name = "Mohammed";

        List<Thread> threads = new ArrayList<>();

        Thread previous = null;

        for(int j=0; j<name.length(); j++){
            NameThread nt = new NameThread(name, j, previous);
            Thread t = new Thread(nt);
            t.start();
            threads.add(t);
            previous = t;
        }

        for(Thread thread: threads){
            thread.join();
        }

        System.out.println("!");
    }

}