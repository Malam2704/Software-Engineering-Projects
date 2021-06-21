package activities;

public class Deadlock implements Runnable{
    private Object lockOne;
    private Object lockTwo;

    @Override
    public void run() {
        System.out.println("Trying to get lock " + lockOne + "...");
        synchronized(lockOne){
            System.out.println("Got lock one, trying to get " + lockTwo + "...");
            synchronized(lockTwo){
                System.out.println("Got Both locks");
            }
        }
    }

    public static void main(String[] args) {
        Deadlock a = new Deadlock();
        Deadlock b = new Deadlock();

        
    }
    
}
