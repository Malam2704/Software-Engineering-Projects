/* 
This is the action figure class, it extends eveyrhting form the DOll class,
except it overirdes the paly fucntion for different phrases, and also a sword field
for true and false are made incase the Action FIgure I made came with a sword.
*/
package toys;

import javax.swing.Action;

import java.util.Random;

public class Action_Figure extends Doll {
    private static final Random RNG = new Random(1);
    private static final String[] phrases = {"f","g","h","i","j"};

    protected Boolean sword;

    public Action_Figure(String name, double MSRP, Colors hair_color, Colors eye_color){
        super(name,MSRP,hair_color,eye_color);
        this.plays_left = 10;
        this.sword = RNG.nextBoolean();
    }

    public Boolean getSwordStatus() {
        return sword;
    }

    @Override
    public String Play() {
        this.plays_left -= 1;
        int i = RNG.nextInt(5);
        return phrases[i];
    }

    @Override
    public String toString() {
        return ("Name: " + this.name +", Product Code: " + this.code + ", MSRP: " + this.MSRP + ", Hair Color: " + this.hair_color +", Eye Color: " + this.eye_color + ", Sword Equipped: " + this.sword + ", Plays Left: " + this.plays_left);
    }
}
