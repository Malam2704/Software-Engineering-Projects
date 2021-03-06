package gvt;
public class Fighter extends Goat{
    private static final int MAX_HP = 150;

    // private String name;
    // private int Maxhp;
    // private int Currenthp;

    public Fighter(String name){
        super(name,MAX_HP);
        // this.name = name;
        // this.Maxhp = MAX_HP;
        // this.Currenthp = this.Maxhp;
    }

    @Override
    public Attack attack(){
        // Magic Millsiles hits 4 times for 9 poitns of damage
        int[] cleave = {25};
        return new Attack("Cleave", cleave,DamageType.Physical);
    }

    @Override
    public void takeDamage(Attack attack){
        double modifier = 1.0;
        if(attack.getDamageType() == DamageType.Physical){
            modifier = 0.75;
        } else if(attack.getDamageType() == DamageType.Magical){
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
