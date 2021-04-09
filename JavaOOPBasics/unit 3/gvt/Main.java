package gvt;

public class Main {
    public static void main(String[] args) {
        Goat Pot = new Mage("Harry Potter");
        Goat Fot = new Fighter("Po");
        Goat Trot = new Thief("Yaga");
        Goat Yot = new Paladin("Artix");
        System.out.println(Pot.getName());
        System.out.println(Pot.getMaxHp());
        System.out.println(Pot.attack());

        // int[] hits = {1000000000};
        // Attack attack = new Attack("Laser Beam", hits, DamageType.Elemental);
        // goat.takeDamage(attack);
        // System.out.println(Pot.getCurrenthp());
        // System.out.println(Pot.isConscious());

        Battle.fight(Pot, Fot);
        System.out.println("--------------------");
        Battle.fight(Fot, Trot);
        System.out.println("--------------------");
        Battle.fight(Yot, Trot);
    }
}
