import java.util.Random;

public class Chef implements Runnable{
    private int id;
    private ChezWoolie resturamt;
    private Random RNG = new Random();
    private Food[] ourMeals = {new Food("Risotto", 2), 
        new Food("Caaserole", 4), new Food("Pizza", 4),
        new Food("Chicken Over Rice", 3)};

    public Chef(int id,ChezWoolie r){
        this.id = id;
        this.resturamt = r;
        this.resturamt.addChef();
    }

    @Override
    public String toString() {
        return "Chef: " + id;
    }

    @Override
    public void run() {
        // Smae thing as diner
        synchronized(resturamt){
            try{
                resturamt.wait();
            }catch(InterruptedException j){}
            resturamt.addChef();
        }
        //resturamt.addChef();
        System.out.println("Chef " + id + " has entered");
        while(resturamt.getCount() > 0){
            // after chef is entered while loop as logn as there are diners
            // tries to amke a food out of the menu options given from a food
            // array above.
            try{
                // gets rand intdex and waits to prepare it in woolie seconds
                Food fod = ourMeals[RNG.nextInt(4)];
                System.out.println("Chef " + id + " is preparing Food " + fod);
                Thread.sleep(resturamt.getWoolSecond());
                // Sync so that the food is serves good
                // synchronized(resturamt){
                //     resturamt.serve(fod);
                // }
                // serves a diner food in their thread
                resturamt.serve(fod);
                System.out.println("Chef has placed " + fod + " on the conveyor belt");
            }catch(InterruptedException j){
                System.err.println("Eh Chef");
            }
        }
        // chef leaves and if statement to check if 0 chefs then close
        System.out.println("Chef " + id +" has left!");
        resturamt.chefLeaves();
        try{Thread.sleep(resturamt.getWoolSecond());}catch(InterruptedException j){}
        synchronized(resturamt){
            if(resturamt.getChefCount() == 0){
                System.out.println("The Resturant is closed");
            }
        }
    }
    
}
