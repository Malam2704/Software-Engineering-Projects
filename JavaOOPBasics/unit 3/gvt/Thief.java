package gvt;

import java.util.Random;

public class Thief extends Goat {
    private static final Random RNG = new Random();
    private static final int MAX_HP = 125;
    private boolean stealth;

    public Thief(String name){
        super(name, MAX_HP);
        this.stealth = true;
    }

    @Override
    public Attack attack(){
        stealth = false;
        int[] hits = {10,10};
        return new Attack("Slash", hits, DamageType.Physical);
    }

    @Override
    public void takeDamage(Attack attack){
        if(!stealth){
            if(RNG.nextDouble() < 0.25){
                System.out.println("Thief dodges!");
            } else{
                int[] hits = attack.getHits();
                for(int i=0; i<hits.length; i++){
                    Currenthp -= hits[i];
                }
            }

            Currenthp = Currenthp > 0 ? Currenthp : 0;
        }
    }
}
