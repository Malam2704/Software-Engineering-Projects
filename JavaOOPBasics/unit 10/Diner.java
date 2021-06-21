import java.util.Random;

public class Diner implements Runnable{
    private int id;
    private int hungerRating;
    private Random RNG = new Random();
    private ChezWoolie resturant;
    // private Thread previous;

    public Diner(int id,ChezWoolie r){
        this.hungerRating = RNG.nextInt(5) + 5;
        this.id = id;
        this.resturant = r;
        //this.previous = prev;
    }

    @Override
    public String toString() {
        return "Diner: " + id + "with a Hunger rating of " + hungerRating;
    }

    // it waits it's turn to be entered with sync
    @Override
    public void run() {
        synchronized(resturant){
            resturant.enter();
        }try{
            Thread.sleep();
        }catch(InterruptedException j){}
        //resturant.enter();
        System.out.println("Diner " + id + " has entered");

        // While so that while it's nto hungry it starts eating
        while(hungerRating > 0){
            // After ti enters tiem to take a seat
            try{
                Thread.sleep(resturant.getWoolSecond());
            }catch(InterruptedException j){}

            // Tries to get a food from the conveyor belt
            // and thread sleeps allowign for eating time.
            Food myFood = null;
            try{
                myFood = resturant.retrieve();
                Thread.sleep(resturant.getWoolSecond());
            }catch(InterruptedException j){
                System.err.println("Int ex");
            }
            // eaten and hunger drops
            System.out.println("Diner " + id + " has eaten" + myFood);
            hungerRating--;
        }
        // leaves
        System.out.println("Diner " + id + " has left");
        resturant.exit();
    }
}
