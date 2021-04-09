// Mohammed Alam 4.1,
// ?This was a pain, intially I thoguht this was eays and got msot of it done
// all I had to do was make a fighter abstract class, and extend for different type fo fighter
// and added an enum for fun. But for some reason my mmain problem was the fact that I didn't
// protect the name variable so I had errors sayign FIghter.name is not visible. I fixed it

// Anyways the maiun fucntion here makes a fight method, so that until someone isn't conscious
// it goes on, when two people as athe parameters attack each other and keep on doing so.
package ssb;

public class Main {
    public static void fight(Fighter one, Fighter two) {
        while(one.isConscious() && two.isConscious()){
            // gets teh attack from the first fighter parameter,
            // then pritns out sayign attack is being done
            // then actually oes the take damage perosn on the second
            // parameter fighter
            int[] an_attack = one.attack();
            System.out.println(one.getName() + " attacks " + two.getName());
            two.takeDamage(an_attack);

            // just repeated abvoe but 2nd fighter attacks and first takes damage
            int[] other_attack = two.attack();
            System.out.println(two.getName() + " attacks " + one.getName());
            one.takeDamage(other_attack);

            // After eachround pritns user status
            System.out.println("Current Stats: " + one.getName() + ": " +one.getHealth() + "/" +one.getMaxhp());
            System.out.println("Current Stats: " + two.getName() + ": " +two.getHealth() + "/" +two.getMaxhp());
        }

        // Conditionals to check if the parameter one or two fighters have 0 health
        // if nto they win, if both have 0 it's a draw.
        if(one.isConscious()){
            System.out.println(one.getName() + " wins!");
        } else if(two.isConscious()) {
            System.out.println(two.getName() + " wins!");
        } else{
            System.out.println(" it's a draw!");
        }
    }

    public static void main(String[] args) {
        // makes both fighters, I pritned to chekc if name is available
        Manio Italian_man = new Manio(Names.Manio);
        Lonk elf_boy = new Lonk(Names.Lonk);
        System.out.println(Italian_man.getName());

        fight(Italian_man,elf_boy);
    }
}
