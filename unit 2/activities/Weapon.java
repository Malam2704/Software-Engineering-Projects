package activities;

import java.util.jar.Attributes.Name;

public class Weapon {
    public static final String NORMAL_DAMAGE_COLOR = "Red";
    public static final String HEAVY_DAMAGE_COLOR = "Green";
    public static final String ION_DAMAGE_COLOR = "Blue";

    private String name;
    private DamageType type;
    private int damage;

    public Weapon(String name, String type, int damage){
        this.name = name;
        this.type = type;
        this.damage = damage;
    }

    // Getters below
    public String getname(){
        return name;
    }
    ppublic DamageType gettype(){
        return type;
    }
    public String getcolor(){
        return type.getColor();
    }
    public int getDamage(){
        return damage;
    }

    // Setters below, only for things you need to change
    public void setname(String name){
        this.name = name;
    }

    // The equals override is gvien for free
    @Override
    public String toString(){
        return (this.name + "has " + this.type.getColor() + " color and has " + 
            this.damage + " damage");
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Weapon){
            Weapon other = (Weapon)obj;

            // Finish the code here
            return this.DamageType.getColor().equals(other.type.getColor()) && this.damage == other.damage;
        }
        return false;
    }    

    public static void main(String[] args) {
        Weapon one = new Weapon("Blaster",DamageType.NORMAL, NORMAL_DAMAGE_COLOR, 100);
        Weapon two = new Weapon("Blaster2",DamageType.NORMAL, NORMAL_DAMAGE_COLOR, 100);
        Weapon three = new Weapon("Blaster3",DamageType.ION, ION_DAMAGE_COLOR, 200);

        System.out.println(one == one);
        System.out.println(one == two);
        System.out.println(one == three);
        System.out.println("------------");
        System.out.println(one.equals(one));
        System.out.println(one.equals(two));
        System.out.println(one.equals(three));
    }
}
