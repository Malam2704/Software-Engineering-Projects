package gvt;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Fighter extends Goat {
    /**
     * Example of using the Ability interface
     */
    private static class BasicAttack implements Ability {
        @Override
        public void use(List<Troll> enemies, List<Goat> party) {
            Goat.basicAttack(enemies, party);
        }
    }

    /**
     * Fighter ability list. There is one list for all fighters.
     */
    private static final Map <String, Ability> abilities = new HashMap<> ();

    static {
        /**
         * Add new abilities in here
         */
        // Punch ability wiht an anonymous class.
        abilities.put ("Punch", new Ability(){
            @Override
            public void use(List<Troll> enemies, List<Goat> party) {
                Goat.basicAttack(enemies, party);
            }
        });

        // Cleave
        // So it can attack up to thre enemies, one with 25 attack, and two
        // others with 13 attack. If there are less than 3 enemies, just doens't attack.
        // Then it will get all those targets in the List I always make for the enemies being
        // attacks, and then just attacks them with a Swing of the Cleave, or a mini attack
        // which does Physical damage to the enemies, attacking with a for loop.
        abilities.put("Cleave", (List<Troll> enemies, List<Goat> party) -> {
                List<Troll> targets = new ArrayList<>();
                while(targets.size() != 3 || (enemies.size() < 3 && targets.size() != enemies.size())){
                    Troll adder = getRandomTarget(enemies);
                    if(!targets.contains(adder)){
                        targets.add(adder);
                    }
                }

                int[][] hits = {{25},{13},{13}};
                for(int i=0; i<targets.size();i++){
                    Attack attack = new Attack ("Swing", hits[i], DamageType.PHYSICAL);
                    targets.get(i).takeDamage(attack);
                    removeVanquished (enemies, targets.get(i));
                }
        });

        // Bash
        // The bash attack I made, think of it as a sort of shield bash
        // This attack basically just has a 50 percents chance of attacking
        // two enemies which are in a targets array. Then it has a random attack
        // value from 0 to 100 as an int, and then attacks all fo the targets
        // in the array with that attack.
        abilities.put("Bash", (List<Troll> enemies, List<Goat> party) -> {
            Random RNG = new Random();
            int target_size = 0;
            if(RNG.nextInt(100)>50){
                target_size = 2;
            }else{
                target_size = 1;
            }

            List<Troll> targets = new ArrayList<>();
            while(targets.size() != target_size){
                Troll adder = getRandomTarget(enemies);
                if(!targets.contains(adder)){
                    targets.add(adder);
                }
            }
            
            int damage = RNG.nextInt(100);

            int[] damageArray = {(int)damage};
            Attack bashAttack = new Attack("Fire ball", damageArray, DamageType.PHYSICAL);
            
            for(int i=0; i<targets.size(); i++){
                targets.get(i).takeDamage(bashAttack);
                removeVanquished (enemies, targets.get(i));
            }
        });
    }

    public Fighter(String name) {
        super(name, 150, abilities);
    }
    
    // @Override
    // public Attack attack() {
    //     int[] hits = {25};
    //     return new Attack("Cleave", hits, DamageType.PHYSICAL);
    // }

    @Override
    public void takeDamage(Attack attack) {
        double adjustment = 1.0;
        DamageType type = attack.getDamageType();
        if(type == DamageType.MAGICAL) {
            adjustment = 1.25;
        } else if(type == DamageType.PHYSICAL) {
            adjustment = 0.75;
        }
        takeDamage(attack, adjustment);
    }
}
