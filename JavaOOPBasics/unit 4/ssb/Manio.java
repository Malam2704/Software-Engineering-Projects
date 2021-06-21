package ssb;

import java.util.Random;

// Similar to the Lonk file
public class Manio extends Fighter{
    private final int HEALTH = 100;
    private static final Random RNG = new Random();

    public Manio(Names name){
        super(name, 100);
    }

    @Override
    public int[] attack() {
        int upperbound = 50;
        int lowerbound = 25;

        int adder = RNG.nextInt(upperbound - lowerbound);

        int[] my_attack = {(lowerbound+adder)};
        return my_attack;
    }

    // Only difference form Lonk is that there's only a 25% chance and it cna doge the entire attack
    // array
    @Override
    public void takeDamage(int[] damage) {
        double chance = RNG.nextDouble();
        int total = 0;
        if(RNG.nextDouble() < 0.25){
            System.out.println("Haha " + getName() + " dodges!");
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
