import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SequentialCount implements Runnable{
    private static List<Thread> threads =  new ArrayList<>();
    private int mynum;
    private Thread previous;

    // Each sequential count is a number
    public SequentialCount(int p,Thread previous){
        this.mynum = p;
        this.previous = previous;
    }

    // Just prints out the field which is a number
    // I don;t know if it's right, but I tried so many things and
    // it's not working, how do you call join without making a method.
    @Override
    public void run() {
        // TODO Auto-generated method stub
        if(previous != null){
            try{
                previous.join();
            }catch(InterruptedException j){}
        }
        System.out.println(mynum);
        // try {
        //     doTheMagic(this.threads);
        // } catch (InterruptedException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        // try{
        //     Thread.join();
        // }catch(InterruptedException j){
        //     System.err.println("Int ex");
        // }
    }   

    // Helper function
    public static void doTheMagic(List<Thread> threads) throws InterruptedException{
        // It starts the thread and joins it immedietly
        // for all of the threads in the list.
        // for(Thread thread : threads){
        //     thread.start();
        //     thread.join();
        // }
    }
    
    public static void main(String[] args) throws InterruptedException{
        // List made, and scanner for the number
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();

        // makes a sequential count ype and adds it to 
        // a thread, the the thread gets added to the list
        Thread previous = null;
        for(int i=0; i<=n; i++){
            SequentialCount count = new SequentialCount(i,previous);
            Thread thread = new Thread(count);
            threads.add(thread);
            thread.start();
            previous = thread;
        }
        //doTheMagic(threads);
    }
}
