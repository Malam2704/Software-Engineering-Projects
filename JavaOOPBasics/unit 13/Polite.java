public class Polite implements Runnable{
    private String message = "";
    private final Object lock;

    public Polite(String message, Object lock){
        this.message = message;
        this.lock = lock;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        synchronized(lock){
            for(int i=0; i<10; i++){
                System.out.println(message);
                // Synchronizing without the code at the bottom
                // just does the loop for one then stops for the other
                // and doens't start unil 10 messages form the smae thread.
                if(i<9){
                    lock.notify();
                    try{
                        lock.wait();
                    }catch(InterruptedException j){
                        // 
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Object lock = new Object();
        new Thread(new Polite("After you!",lock)).start();
        new Thread(new Polite("No, After you!",lock)).start();
    }
}
