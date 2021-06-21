package secret;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

import backtracker.Backtracker;
import backtracker.Configuration;

@Testable
public class PhraseGuesserTest {
    public static Configuration getPhraseGuesser(SecretPhrase phrase) {
        // modify this to return an instance of your class
        return new SortWords(phrase);
    }

    @Test
    public void shortPhrase() {
        testGuesser(new ShortPhrase());
    }

    @Test
    public void mediumPhrase() {
        testGuesser(new MediumPhrase());
    }

    @Test
    public void longPhrase() {
        testGuesser(new LongPhrase());
    }

    private void testGuesser(SecretPhrase phrase) {
        // setup
        Configuration config = getPhraseGuesser(phrase);
        Backtracker backtracker = new Backtracker(false);

        // invoke
        Configuration sol = backtracker.solve(config);

        // analyze
        assertNotNull(sol);
        assertTrue(phrase.guess(sol.toString()));
    }
}
