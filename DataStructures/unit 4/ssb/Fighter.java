package ssb;

import java.util.jar.Attributes.Name;

public abstract class Fighter {
    // Skyler is it okay if I always use protected ?
    protected Names name;
    protected int health;
    private final int maxhp;

    // makes the actual fighter, gets accesors and mutators below
    public Fighter(Names name, int MaxHp){
        this.name = name;
        this.maxhp = MaxHp;
        this.health = MaxHp;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxhp() {
        return maxhp;
    }

    // just retunrs a boolean to make my Main's while loop easier
    public boolean isConscious(){
        return (getHealth() > 0);
    }

    public Names getName() {
        return name;
    }
    
    // abstract classes different for each fighter will be overided
    public abstract int[] attack();

    public abstract void takeDamage(int[] damage);

    // Stirng interpretation
    @Override
    public String toString() {
        return ("Name: " + this.name + "Health: " + this.health);
    }


}
