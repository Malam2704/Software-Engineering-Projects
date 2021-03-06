import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class MiscellanyTest {
    
    @Test
    public void palindromeEmpty(){
        // setup
        String input = "";
        boolean expected = true;

        // invoke
        boolean actual = Miscellany.palindrome(input);

        // analyze
        assertEquals(expected,actual);
    }

    @Test
    public void testno() {
        // setup
        String input = "no";
        boolean expected = false;

        // invoke
        boolean actual = Miscellany.palindrome(input);

        // analyze
        assertEquals(expected,actual);
    }

    @Test
    public void testAdd() {
        // setup
        String input = "tacocat";
        boolean expected = true;

        // invoke
        boolean actual = Miscellany.palindrome(input);

        // analyze
        assertEquals(expected,actual);
    }
}
