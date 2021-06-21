import java.util.ArrayList;
import java.util.List;

public class Assignment2Main {
    public static void main(String[] args) {
        // Main fucntion with a resturant and lists for diners and chefs
        ChezWoolie resturant = new ChezWoolie();
        List<Thread> dinerThreads = new ArrayList<>();
        List<Thread> chefThreads = new ArrayList<>();
        Thread previousDiner = null;
        // Ignroe previosu thread, I tried usign it but it didn't work
        // I t only made it so that a diner can enter once the previous diner was not
        // hungry anymore

        // For loops to make new diner threads add them to the list and start
        for(int i=1; i<11; i++){
            Diner d = new Diner(i, resturant);
            Thread dThread = new Thread(d);
            dinerThreads.add(dThread);
            dThread.start();
            previousDiner = dThread;
        }
        //notfies all diners to start and stop waiting.
        // for(Thread t : dinerThreads){
        //     synchronized(resturant){
        //         resturant.notifyAll();
        //     }
        // }
        // same as diners but for chefs.
        for(int i=1; i<3; i++){
            Chef c = new Chef(i, resturant);
            Thread cThread = new Thread(c);
            chefThreads.add(cThread);
            cThread.start();
        }
        // for(Thread t : chefThreads){
        //     synchronized(resturant){
        //         resturant.notifyAll();
        //     }
        // }

        
    }
}
