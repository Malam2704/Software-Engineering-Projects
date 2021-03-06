/* 
A different type of Toy that extends on the Toy class, and takes more 
parameters such as hair color and eye color. I uased a random generator
and the play function gets a random number form 0-4, and plays that index
of the pre made phrases, I used random seed for testing purposes
*/

package toys;

import java.util.Random;

public class Doll extends Toy {
    private static final Random RNG = new Random(1);
    private static final String[] phrases = {"a","b","c","d","e"};
    protected Colors hair_color;
    protected Colors eye_color;
    protected int plays_left;

    public Doll(String name, double MSRP, Colors hair_color, Colors eye_color){
        super(name,MSRP);
        this.hair_color = hair_color;
        this.eye_color = eye_color;
        this.plays_left = 10;
    }

    public Colors getEye_color() {
        return eye_color;
    }

    public Colors getHair_color() {
        return hair_color;
    }

    public int getPlays_left() {
        return plays_left;
    }

    // Just returns index of the phrases array
    @Override
    public String Play() {
        this.plays_left -= 1;
        int i = RNG.nextInt(5);
        return phrases[i];
    }

    @Override
    public String toString() {
        return ("Name: " + this.name +", Product Code: " + this.code + ", MSRP: " + this.MSRP + ", Hair Color: " + this.hair_color +", Eye Color: " + this.eye_color + ", Plays Left: " + this.plays_left);
    }
}
