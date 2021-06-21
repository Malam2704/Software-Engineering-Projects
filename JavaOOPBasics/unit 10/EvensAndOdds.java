// Mohammed Alam 10.1
// Implemetnt two variations of thread knowledge
// using thread sleep and thread join to display outputs

public class EvensAndOdds implements Runnable{
    // Fields
    private int numStart;
    private boolean isEven;
    
    // Uses a param id to see where it would start counting
    // that tells if it's even or odd and prints those nums
    public EvensAndOdds(int id){
        if((id % 2) != 0){
            this.isEven = false;
        }else{
            this.isEven = true;
        }
        //this.numStart = id;
    }

    // Getters
    public boolean getIsEven(){
        return isEven;
    }
    public int getNumStart() {
        return numStart;
    }

    // I mean it just runs a for loop for the specified  numbers with a time
    // delay of 1000 with the Thread.sleep with try and catch
    @Override
    public void run(){
        //numStart ++;
        //System.out.println("Current Number: " + numStart);
        if(!getIsEven()){
            for(int i=1; i<100; i+= 2){
                System.out.println("Odd: " + i);
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException j){
                    System.err.println("Inter exc");
                }
            }
        }else{
            for(int i=2; i<101; i+= 2){
                System.out.println("Even: " + i);
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException j){
                    System.err.println("Inter exc");
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Thread array and class implementations that are parameterized into threads
        Thread[] threadArray =  new Thread[2];
        EvensAndOdds odds =  new EvensAndOdds(1);
        EvensAndOdds evens =  new EvensAndOdds(2);
        Thread Oddo = new Thread(odds);
        Thread Eveno = new Thread(evens);
        threadArray[0] = Oddo;
        threadArray[1] = Eveno;

        // for(Thread thread: threadArray){
        //     thread.start();
        //     while(thread.isAlive()){
        //         thread.sleep(1000);
        //     }
        //     //thread.sleep(10);
        // }
        
        //runs the threads we made.
        Oddo.start();
        Oddo.sleep(100);
        Eveno.start();
    }
    
}
