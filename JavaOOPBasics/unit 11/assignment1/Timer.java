// Mohammed Alam Assignment 11.1
// Made two functions one using the thread timing 
// to check vectors and arralists, the other synchronizing
// two threads based on a lock.
package assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Timer {
    // Timer method has a name, list and int for num of vals
    public static void Timermethod(String name, List<Integer> intList, int numberofValues){
        //start timer
        long currrentTime = System.nanoTime();
        // for loop adds the specified num of values
        for(int i=0; i<numberofValues; i++){
            intList.add(0);
        }
        // end time , total time is end - start
        long laterTime = System.nanoTime();
        //System.out.println("Time it took to add those numbers: " + (laterTime - currrentTime));
        // String statemetn to tell user that it finished and it took this amount of time in a format.
        System.out.println("Filled " + name + " with " + numberofValues + " in " + String.format("%,d",(laterTime - currrentTime)) + " nano seconds");
    }

    public static void main(String[] args) {
        // vector and list made in method, new threads made with lambdas
        //  where they only do the timermethod and are started.
        List<Integer> intList = new ArrayList<>();
        Vector vecList = new Vector<>();

        Thread arrayThread = new Thread(() -> {
           Timermethod("Array List timer", intList, 5); 
        });
        Thread vecThread = new Thread(() -> {
            Timermethod("Vector List timer", vecList, 5); 
        }); 

        arrayThread.start();
        vecThread.start();

        //Timermethod("Adding 0s timer", intList, 5);
        //Timermethod("Adding 0s timer", vecList, 5);
    }
}
