// Weapon called Naginate for the Panda's use
package kfp;

import java.util.Arrays;
import java.util.Random;

public class Naginata{
    private static double damage;

    // COnstructor takes the paramertirzed amount of damage
    // that is at max bounds and treats it as a double for damage
    public Naginata(double damage){
        this.damage = damage;
    }

    // String return
    @Override
    public String toString(){
        return "Fist dealing damage!" + damage;
    }

    // attack method which usues a Random seed of 1 for constance sake
    //  and returns an int with a decimal added together for the attack
    public static double attack(){
        Random r = new Random(1);
        double n = r.nextInt((int)damage) + r.nextDouble();
        return n;
    }
}
