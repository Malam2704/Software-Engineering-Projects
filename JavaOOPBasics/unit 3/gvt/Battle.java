package gvt;

public class Battle {
    public static void fight(Goat one, Goat two){
        while(one.isConscious() && two.isConscious()){
            Attack attackOne = one.attack();
            System.out.println(one.getName() + " attacks " + two.getName() + " with " + attackOne);
            two.takeDamage(attackOne);

            Attack attackTwo = two.attack();
            System.out.println(two.getName() + " attacks " + one.getName() + " with " + attackTwo);
            one.takeDamage(attackTwo);

            System.out.println("Current Hp: " + one.getName() + ": " +one.getCurrenthp() + "/" +one.getMaxHp());
            System.out.println("Current Hp: " + two.getName() + ": " +two.getCurrenthp() + "/" +two.getMaxHp());
        }

        if(one.isConscious()){
            System.out.println(one.getName() + " wins!");
        } else if(two.isConscious()) {
            System.out.println(two.getName() + " wins!");
        } else{
            System.out.println(" it's a draw!");
        }
    }
}
