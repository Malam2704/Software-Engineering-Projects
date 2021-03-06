package gvt;

public class Mage extends Goat{
    private static final int MAX_HP = 100;

    public Mage(String name){
        super(name,MAX_HP);
    }

    @Override
    public Attack attack(){
        // Magic Millsiles hits 4 times for 9 poitns of damage
        int[] missiles = {9,9,9,9};
        return new Attack("Magic Missiles", missiles,DamageType.Magical);
    }

    @Override
    public void takeDamage(Attack attack){
        double modifier = 1.0;
        if(attack.getDamageType() == DamageType.Magical){
            modifier = 0.75;
        } else if(attack.getDamageType() == DamageType.Physical){
            modifier = 1.25;
        }

        int[] hits = attack.getHits();
        for(int i=0; i<hits.length; i++) {
            int amount = (int)(hits[i] * modifier);
            Currenthp -= amount;
        }

        Currenthp = Currenthp > 0 ? Currenthp : 0;
    }
}
