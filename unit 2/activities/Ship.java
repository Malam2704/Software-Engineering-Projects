package activities;

public class Ship {
    // name
    private String name;
    // hull rating
    private int hull;
    // shields
    private int shields;
    // weapon
    private Weapon weapon;

    // make a constructor with parameters for all
    // of the fields
    // def __init__(self, x):
    //     self.__x = x
    public Ship(String name, int hull, int shields, Weapon weapon) {
        this.name = name;
        this.hull = hull;
        this.shields = shields;
        this.weapon = weapon;
    }

    public Ship(String name, int hull){
        // this.name = name;
        // this.hull = hullAmount;
        this(name,hull,0,null);
    }

    // Below is a basic ship with no parameters
    public Ship(){
        this("Target Practice", 10);
    }

    // Getters below
    public String getname(){
        return name;
    }
    public int gethull(){
        return hull;
    }
    public int getshields(){
        return shields;
    }
    public Weapon getwWeapon(){
        return weapon;
    }

    // Setters below, only for things you need to change
    public void setname(String name){
        this.name = name;
    }
    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    // Special Methods
    @Override
    public String toString(){
        return (this.name + "has " + this.hull + " damage and has " + 
            this.shields + " shield, with a weapon of " + this.weapon);
    }

    public static void main(String[] args) {
        Ship ship = new Ship("X-wing", 50, 15, new Weapon("Blaster","Normal",
         Weapon.NORMAL_DAMAGE_COLOR, 50));

        Weapon x = new Weapon(" Wolverine", "Claws", Weapon.HEAVY_DAMAGE_COLOR, 1000);
        System.out.println(x.HEAVY_DAMAGE_COLOR);
    }
}
