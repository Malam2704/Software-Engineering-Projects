package secret;

import backtracker.Backtracker;
import backtracker.Configuration;

/**
 * A main class used to manually test a backtracking algorithm for guessing
 * secret phrases.
 */
public class Main {
    public static void main(String[] args) {
        // change the phrase you are using as needed for testing
        // SecretPhrase phrase = new ShortPhrase();
        // SecretPhrase phrase = new MediumPhrase();
        SecretPhrase phrase = new LongPhrase();

        // replace null with a call to your constructor
        Configuration start = new SortWords(phrase);

        // change this to enable/disable debugging
        boolean debug = true;

        // do not modify below this line
        Backtracker backtracker = new Backtracker(debug);

        Configuration sol = backtracker.solve(start);

        if(sol == null) {
            System.out.println("There is no solution.");
        } else {
            System.out.println("Solution: " + sol);
        }
    }
}
