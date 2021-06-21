package concurrency;

public class Countdown implements Runnable {

    @Override
    public void run() {
        // TODO Auto-generated method stub
        int time = -10;
        boolean done = true;
        while(done){
            if(time <0){
                System.out.println("T" + time);
            }else if(time == 0){
                System.out.println("Liftoff");
            }else{
                System.out.println(time);
            }

            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                System.err.println("Interrupted");
            }
            time++;
        }
    }

    public static void main(String[] args) {
        Countdown countdown = new Countdown();
        Thread thread = new Thread(countdown);
        thread.start();
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            System.err.println("Interrupted");
        }
        System.out.println("Boo!");
    }
    
}
