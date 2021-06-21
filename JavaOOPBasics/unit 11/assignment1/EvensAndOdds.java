package assignment1;

public class EvensAndOdds implements Runnable{
    // An object lock and bool to switch between even and odd.
    private static Object lock = new Object();
    private static boolean boolStart;

    // helper method
    public void myMethod(){
        // one is ttrue other is false based on bool, and always switches.
        // then a for loop one for odd counting one for even.
        if(boolStart == true){
            boolStart = false;
            for(int i=1; i<100; i+=2){
                // After each number is printed it tells the other
                // thread which was waiting on this one to resume while
                // this one waits
                System.out.println("Odd Counter: " + i);
                lock.notifyAll();
                try{
                    lock.wait();
                }catch(InterruptedException j){}
            }
        }else{
            // same as above
            for(int i=2; i<101; i+=2){
                System.out.println("Even Counter: " + i);
                lock.notifyAll();
                try{
                    lock.wait();
                }catch(InterruptedException j){}
            }
        }
    }

    @Override
    public void run() {
        // since there are waits for each number to print
        // we synchronized all those waitings to make sure they 
        // are done in the order each thread is started.
        synchronized(lock){
            myMethod();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Thread eh = new Thread(() -> {
        //     for(int i=1; i<100; i+=2){
        //         synchronized(lock){
        //             System.out.println("Odd Counter: " + i);
        //         }
        //     }
        // });
        // Thread er = new Thread(() -> {
        //     for(int i=2; i<101; i+=2){
        //         synchronized(lock){
        //             System.out.println("Even Counter: " + i);
        //         }
        //     }
        // });


        // bool is true, and needs to be started in main and not in the top
        // becuase it would be true for all threads instead of null and being set
        // after each thread is run.
        boolStart = true;
        // Runnables are made with threads and they are started.
        EvensAndOdds eve1 = new EvensAndOdds();
        EvensAndOdds eve2 = new EvensAndOdds();
        Thread eh = new Thread(eve1);
        Thread er = new Thread(eve2);

        eh.start();
        Thread.sleep(1000);
        er.start();
    }
}
