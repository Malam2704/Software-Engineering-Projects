// Mohammed Alam, Assignment 8.2
// Goats vs Trolls implementation where I switched up attacks and used 
// with anonymous classes, and lambdas to make it simpler, using Lists
// to get targets to be attack these implementations,the Cleave,Magic Missiles
// fireball, and Bash attacks. 

package gvt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Mage extends Goat {

    /**
     * Example of using the Ability interface
     */

    //  Commented out because I used an anonymous class
    // private static class BasicAttack implements Ability {
    //     @Override
    //     public void use(List<Troll> enemies, List<Goat> party) {
    //         Goat.basicAttack(enemies, party);
    //     }
    // }

    /**
     * Mage ability list. There is one list for all mages.
     */
    private static final Map <String, Ability> abilities = new HashMap<> ();
    static {
        /**
         * Add new abilities in here
         */

        // Basic Attack
        // Anonymous class implementation
        abilities.put ("Staff Attack", new Ability(){
            @Override
            public void use(List<Troll> enemies, List<Goat> party) {
                Goat.basicAttack(enemies, party);
            }
        });

        // Magic Missiles
        // The Magic missiles attack which uses an anonymous class
        //  the basically gets 4 random targets in an array of targets
        // and seperates each missile into it's own attack, and
        // each random target in the target array gets one of those attacks
        // since it's a random target, an enemy can be chosen multiple times.
        abilities.put("Magic Missiles", new Ability(){
            public void use(List<Troll> enemies, List<Goat> party) {
                Troll[] targets  = {getRandomTarget(enemies),getRandomTarget(enemies),getRandomTarget(enemies),getRandomTarget(enemies)};
                // for(int i=0; i<4;i++){
                //     targets[i] = getRandomTarget(enemies);
                //     System.out.println(targets[i]);
                // }
                int[][] hits = {{9},{9},{9},{9}};
                for(int i =0; i<4;i++){
                    Attack attack = new Attack ("Magic Missile", hits[i], DamageType.PHYSICAL);
                    targets[i].takeDamage(attack);
                    removeVanquished (enemies, targets[i]);
                }
            }
        });

        // Fireball attack 
        // This basically gets a random number which can be a huge range form 0 - 75
        // and the fireball attacks a random target, and it's residue which is half
        // as powerful attacks another random enemy.
        // There are 2 mini attaks made for the main fireball and it's residue.
        abilities.put("Fireball", (List<Troll> enemies, List<Goat> party) -> {
            Troll target = getRandomTarget(enemies);
            Troll target2 = getRandomTarget(enemies);
            
            Random RNG = new Random(1);
            int fireDamage = RNG.nextInt(75);

            int[] fires = {(int)fireDamage,(int)fireDamage/2};
            int[] fires_residue = {(int)fireDamage/2,(int)fireDamage/4};
            Attack fireball = new Attack("Fire ball", fires, DamageType.MAGICAL);
            Attack residue_ball = new Attack("Fire ball", fires_residue, DamageType.MAGICAL);
            
            target.takeDamage(fireball);
            removeVanquished(enemies, target);
            target2.takeDamage(residue_ball);
            removeVanquished(enemies, target2);
        });
    }

    public Mage(String name) {
        super(name, 100, abilities);
    }

    // public Attack attack() {
    //     int[] hits = {9, 9, 9, 9};
    //     return new Attack("Magic Missiles", hits, DamageType.MAGICAL);
    // }

    
        

    public void takeDamage(Attack attack) {
        double adjustment = 1.0;
        DamageType type = attack.getDamageType();
        if(type == DamageType.MAGICAL) {
            adjustment = 0.75;
        } else if(type == DamageType.PHYSICAL) {
            adjustment = 1.25;
        }
        takeDamage(attack, adjustment);
    }
}
