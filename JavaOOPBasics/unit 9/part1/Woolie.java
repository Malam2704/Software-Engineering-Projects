package part1;

import java.util.ArrayList;
import java.util.List;

public class Woolie implements Runnable{
    private final String name;
    private int crossTime;
    private String destination;

    public Woolie (String name, int crossTime,String destination) {
        this.name = name;
        this.destination = destination;
        this.crossTime = crossTime;
    }

    public int getCrossTime() {
        return crossTime;
    }public String getDestination() {
        return destination;
    }public String getName() {
        return name;
    }

    @Override
    public void run(){
        // Simple starts to pritn crossing lines
        // with a tab and for loop for crossing time
        // that occutns until it reaches it's crossing time
        // then just prints it leaves.
        System.out.println(this.name + " has arrived at the bridge.");
        System.out.println(this.name + " is starting to cross");
        for(int i = 1 ; i <= crossTime ; i++) {
            System.out.println("    " + this.name + " " + i + "seconds.");
	        try{
                Thread.sleep(1000); // try/catch InterruptedException
            }catch(InterruptedException j){
                System.err.println("Interupted Exception");
            }
        }
        System.out.println(this.name + " leaves at " + this.destination + ".");
    }

    public static void main(String[] args) throws InterruptedException{
        // Woolie and thread arrays to contain interations to 
        // start threads with two fro loops, one for threads and one for Woolies.
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

        // We make threads with the for loop that iterates
        // through woolies.
        Thread[] threadarray = new Thread[4];
        for(int i = 0; i<woolArray.length; i++){
            // Create a new thread to start for the computer
            Thread thread = new Thread(woolArray[i]);
            // add thread to the thread array
            threadarray[i] = thread;
        }

        // After we have our threads array we just start.
        for(Thread thread : threadarray){
            // essentially runs the run() function
            thread.start();
        }

    }

}
