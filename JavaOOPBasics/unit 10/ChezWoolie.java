// Mohammed Alam, Assignment 10.1
// Make an assignment that works in a way that We can get diners all into
// our resturant and feed them so taht they're ntohungry usign synchronizzation tactics
import java.util.ArrayList;
import java.util.List;

public class ChezWoolie {
    private int woolSecond = 1;
    private int count;
    private int chefCount;
    private List<Food> conveyor;

    // constructor goes here
    public ChezWoolie(){
        this.count = 0;
        this.chefCount = 0;
        this.conveyor = new ArrayList<>();
    }

    public List<Food> getConveyor() {
        return conveyor;
    }public int getCount() {
        return count;
    }public int getWoolSecond() {
        return woolSecond;
    }public int getChefCount() {
        return chefCount;
    }

    // Add chef commadns similar to enter and exit commands for diners
    public void addChef(){
        chefCount++;
    }public void chefLeaves(){
        chefCount--;
    }

    // The diners exit and enter commands which amke sure they are added
    // correctly
    public void enter() {
        synchronized(this) {
            count++;
        }
    }
    public synchronized void exit() {
        count--;
    }

    // Adds food to the conveyor belt mad eby chefs that are in sync
    // from when the chefs make them and add them.
    public void serve(Food food) {
        synchronized(conveyor) {
            conveyor.add(food);
            conveyor.notify();
        }
    }

    // In sync remvoed form the belt and given to the Diner
    // Waits until there's food
    public Food retrieve() throws InterruptedException {
        synchronized(conveyor) {
            while(conveyor.isEmpty()) {
                // try/catch omitted
                conveyor.wait();
            }
            return conveyor.remove(0);
        }
    }

}

