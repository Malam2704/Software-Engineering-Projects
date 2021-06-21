package concurrency;

public class CounterThread extends Thread{
    private final String name;

    public CounterThread(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for(int i= 0; i<101; i++){
            System.out.println(name + ": " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CounterThread thread = new CounterThread("Counter 1");
        System.out.println("thread is alive: " + thread.isAlive());
        thread.start();

        int x=1;
        while(thread.isAlive()){
            Thread.sleep(50);
            x++;
        }
        System.out.println("checked " + x + " times");
        for(char c='A'; c<='Z';c++){
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
