package ssb;

import java.util.Random;

public class Lonk extends Fighter{
    private final int HEALTH = 150;
    private static final Random RNG = new Random();

    public Lonk(Names name){
        super(name, 150);
    }

    // Just returns a 45 sword attack array
    @Override
    public int[] attack() {
        int[] my_attack = {45};

        return my_attack;
    }

    // Takes a damage array, and a for loop for each attack in the array beign taken
    // if the random generator is above 0.5 ro 50% the fulll attack will commense and
    // not be blocked. A total is used to keep the total damage taken, incase I mgiht need it later
    @Override
    public void takeDamage(int[] damage) {
        double chance = RNG.nextDouble();
        int total = 0;
        if(RNG.nextDouble() < 0.50){
            // this.health-= (damage[i]/2);
            System.out.println("Haha " + getName() + " Blocks!");
            for(int i=0; i<damage.length; i++){
                this.health -= (damage[i] / 2);
                System.out.println(getName() + "Took " + damage[i]/2 + " damage!");
                total += (damage[i] / 2);
            }
        }else{
            // this.health-= damage;
            for(int i=0; i<damage.length; i++){
                this.health -= damage[i];
                System.out.println(this.name + " took " + damage[i] + " damage!");
                total += damage[i];
            }
        }

        health = health > 0 ? health : 0;
    }
}
