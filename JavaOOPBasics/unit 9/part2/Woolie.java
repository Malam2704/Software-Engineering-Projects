// Mohammed Alam 9.2;
// Mkaing 2 parts that allow Woolies to cross bridges
//  One where we use threads and their sleeps to 
//  make it so that we just let them all in.
// One where we manage everything and delay the threads
// to allow  only one woolie to go at a time. 
package part2;

import java.util.ArrayList;
import java.util.List;

public class Woolie implements Runnable{
    // Fields
    private final String name;
    private int crossTime;
    private String destination;
    private boolean crossing;

    // Constructors
    public Woolie (String name, int crossTime,String destination) {
        this.name = name;
        this.destination = destination;
        this.crossTime = crossTime;
        this.crossing = false;
    }

    // Getters and setters
    public int getCrossTime() {
        return crossTime;
    }public String getDestination() {
        return destination;
    }public String getName() {
        return name;
    }public boolean getCrossing() {
        return crossing;
    }

    // When the thread is being started this is how it goess.
    // There is a for loop that starts each thread representign a woolie
    // So there needs to be a delay for each of them to go.
    @Override
    public void run(){
        // Prints the arrived message.
        System.out.println(this.name + " has arrived at the bridge.");
        // Increases the waittime based on it's crosstime so the other threads are delayed
        Bridge.increaseWaitTime(this);
        // Enters the rbidge, aka sets the bridge status to full
        Bridge.enterBridge();
        // Try catch for delay to wait for other treads that ran before.
        try{
            Thread.sleep(Bridge.getWaitTime());
        }catch(InterruptedException d){
            System.err.println("Can't wait.");
        }

        // When the wait is over it crosses
        System.out.println(this.name + " is starting to cross");
        // For loop for each crosstime second it needs to cross the bridge
        // where theboolean is set to true, and it just prints 
        // with the thread sleep delay for a second
        for(int i = 1 ; i <= crossTime ; i++) {
            if(!crossing){
                crossing = true;
            }
            System.out.println("    " + this.name + " " + i + "seconds.");
            try{
                Thread.sleep(1000); // try/catch InterruptedException
            }catch(InterruptedException j){
                System.err.println("Interupted Exception");
            }
        }
        // After the walkign for loop is done it prints and leaves the bridge allowing
        // another thread to walking to the bridge.
        System.out.println(this.name + " leaves at " + this.destination + ".");
        Bridge.leaveBridge();
    }

    public static void main(String[] args) throws InterruptedException{
        // Siomilar to part 1.
        // List<Woolie> woolList = new ArrayList<>();
        Woolie[] woolArray = new Woolie[4];
        Woolie Falco = new Woolie("Falco", 4, "Merctran");
        Woolie Marly = new Woolie("Marly", 3, "Sicstine");
        Woolie Deidre = new Woolie("Deirdre", 5, "Merctran");
        Woolie McDonald = new Woolie("McDonald", 5, "Sicstine");

        woolArray[0] = Falco;
        woolArray[1] = Marly;
        woolArray[2] = Deidre;
        woolArray[3] = McDonald;

        Thread[] threadarray = new Thread[4];
        for(int i = 0; i<woolArray.length; i++){
            // Create a new thread to start for the computer
            Thread thread = new Thread(woolArray[i]);
            // add thread to the thread array
            threadarray[i] = thread;
            // essentially runs the run() function
            // thread.start();
        }
        for(Thread thread : threadarray){
            thread.start();
        }

    }

}
