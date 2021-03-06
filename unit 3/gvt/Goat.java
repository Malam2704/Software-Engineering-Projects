package gvt;

// Abstract class here makes it so the Goat class cannot be instanciated
public abstract class Goat {
    private final String name;
    private final int Maxhp;
    protected int Currenthp;

    public Goat(String name, int MaxHp){
        this.name = name;
        this.Maxhp = MaxHp;
        this.Currenthp = MaxHp;
    }

    public String getName() {
        return name;
    }

    public int getMaxHp() {
        return Maxhp;
    }

    public int getCurrenthp() {
        return Currenthp;
    }

    public boolean isConscious(){
        return this.Currenthp > 0;
    }

    public void heal(int amount){
        this.Currenthp += amount;

        Currenthp = Currenthp < Maxhp ? Currenthp : Maxhp;
    }

    public Attack attack();

    public void takeDamage(Attack attack);

    // Cannot use new(make an instance of this class inside itself)
    // public static void main(String[] args) {
    //     Goat goat = new Goat("Foo",100);
    // }
}
