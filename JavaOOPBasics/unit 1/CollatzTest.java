// Mohammed Alam 1.2
// 4 tests for all types even number, odd number, 0 and negative.

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class CollatzTest {
    
    @Test
    public void test6() {
        // setup
        String expected = "6 3 10 5 16 8 4 2 1 ";

        // invoke
        String actual = Collatz.Sequence(6);

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void testnegative() {
        // setup
        String expected = " ";

        // invoke
        String actual = Collatz.Sequence(-6);

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void test0() {
        // setup
        String expected = " ";

        // invoke
        String actual = Collatz.Sequence(0);

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        // setup
        String expected = "5 16 8 4 2 1 ";

        // invoke
        String actual = Collatz.Sequence(5);

        // analyze
        assertEquals(expected, actual);
    }
}