package gvt;

import java.util.Scanner;

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

        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("Choose your Fighter");
        System.out.println("1-Wizard ");
        System.out.println("2-Fighter ");
        System.out.println("3-Paladin ");
        System.out.println("4-Wizard ");
        int myChoice = scanner.nextInt();
        System.out.println("What is their name?");
        String myName = scanner.nextLine();

        System.out.println("--------------------");
        System.out.println("Choose your Enemy");
        System.out.println("1-Wizard ");
        System.out.println("2-Fighter ");
        System.out.println("3-Paladin ");
        System.out.println("4-Wizard ");
        int enemyChoice = scanner.nextInt();
        System.out.println("What is their name?");
        String enemyName = scanner.nextLine();
    }
}
