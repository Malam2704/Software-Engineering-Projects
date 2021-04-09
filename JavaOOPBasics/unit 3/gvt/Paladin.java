package gvt;

public class Paladin extends Goat{
    private static final int MAX_HP = 175;

    public Paladin(String name){
        super(name, MAX_HP);
    }

    @Override
    public Attack attack(){
        int[] hits = {13};
        return new Attack("Shield Bash", hits, DamageType.Physical);
    }

    @Override
    public void takeDamage(Attack attack){
        double modded = 0.75;
        for(int i=0; i< attack.getHits().length; i++){
            Currenthp -= (int)(modded * attack.getHits()[i]);
        }

        Currenthp = Currenthp > 0 ? Currenthp : 0;
    }
}
