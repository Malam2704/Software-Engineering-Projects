package gvt;

public abstract class Troll {
    private final String name;
    private final int maxHP;
    private int CurrentHP;
    private final double regen;

    public Troll(String name, int maxHP, double regen){
        this.name = name;
        this.maxHP = maxHP;
        this.CurrentHP = maxHP;
        this.regen = regen;
    }

    public String getName() {
        return name;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getCurrentHP() {
        return CurrentHP;
    }

    public boolean isVanquished(){
        return CurrentHP > 0;
    }

    public void regenerate(){
        if(isVanquished()){
            int amount = (int)(maxHP * regen);
            CurrentHP += amount;
            if(CurrentHP > maxHP){
                CurrentHP = maxHP;
            }
        }
    }

    public abstract Attack attack();

    public abstract void takeDamage(Attack attack);

    protected void takeDamage(Attack attack, double modifier){
        int[] hits = attack.getHits();
        for(int i=0; i<hits.length; i++) {
            int amount = (int)(hits[i] * modifier);
            CurrentHP -= amount;
        }

        CurrentHP = CurrentHP > 0 ? CurrentHP : 0;
    }
}
