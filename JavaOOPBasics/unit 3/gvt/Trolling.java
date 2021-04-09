package gvt;

import java.util.jar.Attributes.Name;

public class Trolling extends Troll{
    private static final String NAME = "Trolling";
    private static final int MAX_HP = 64;
    private static final double REGEN = 0.05;

    public Trolling(){
        super(NAME, MAX_HP, REGEN);
    }

    @Override
    public Attack attack(){
        int[] hits = {25};
        return new Attack("Fireball", hits, DamageType.Physical);
    }

    @Override
    public void takeDamage(Attack attack){
        double modifier = attack.getDamageType() == DamageType.Magical ? 1.25: 1.0;
        takeDamage(attack, modifier);
    }
    // Finish the whole thi9ng swathc the end of the video
}
