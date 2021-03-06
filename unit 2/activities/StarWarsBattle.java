package activities;

public class StarWarsBattle{
    public static void main(String[] args) {
        Weapon weapon = new Weapon();
        System.out.println(weapon.getname());
        System.out.println(weapon.getcolor());
        System.out.println(weapon.getDamage());

        Ship ship = new Ship("ISD", 1000, 500, weapon);
        System.out.println(ship.name);
        System.out.println(ship.hull);
        System.out.println(ship.shields);
        System.out.println(ship.weapon);

        ship.weapon = null;

        Ship wimpy = new Ship("Freighter", 500);
        System.out.println(wimpy.name);
        System.out.println(wimpy.hull);
        System.out.println(wimpy.shields);
        System.out.println(wimpy.weapon);
    }
}