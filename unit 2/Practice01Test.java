// Your basics tests to check if the first 2 parts work.
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class Practice01Test {
    
    @Test
    public void testbasic() {
        // setup
        String expected = "[1, 2, 3]";
        int[] an_array = {1,2,3};

        // invoke
        String actual = Practice01.arrayToString(an_array);

        // analyze
        System.out.println(actual);
        System.out.println(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void testrepeat() {
        // setup
        String expected = "[5, 5, 5]";
        int[] an_array = {5,5,5};

        // invoke
        String actual = Practice01.arrayToString(an_array);

        // analyze
        System.out.println(actual);
        System.out.println(expected);
        assertEquals(expected, actual);
    }
}