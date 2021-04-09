package gvt;

import java.util.Arrays;

public class Attack {
    private String name;
    private int[] hits;
    private DamageType type;

    Attack(String name, int[] hits, DamageType type){
        this.name = name;
        this.hits = hits;
        this.type = type;
    }

    public String getName(){
        return this.name;
    }

    public int[] getHits(){
        return this.hits;
    }

    public DamageType getDamageType(){
        return this.type;
    }

    @Override
    public String toString(){
        return "Attack Name: " + this.name + ", " + "Hits: " + Arrays.toString(this.hits) + ", " + "Damage Type: " + this.type;
    }
}
