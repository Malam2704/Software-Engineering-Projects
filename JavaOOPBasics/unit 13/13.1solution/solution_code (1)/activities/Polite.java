package activities;

public class Polite implements Runnable {
    private static final Object LOCK = new Object();

    private final String message;

    public Polite(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        synchronized(LOCK) {
            for(int i=0; i<10; i++) {
                System.out.println(message);
                LOCK.notify();
                
                if(i != 9) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        // squash
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Polite("After You!")).start();
        new Thread(new Polite("No, After You!")).start();
    }
    
}
