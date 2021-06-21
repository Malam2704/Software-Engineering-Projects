package ds;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class abtTest {
    @Test
    public void testIntRange(){
        // setup
        IntRange my_range = new IntRange(2, 20, 3);
        int expected = 6;
        int expected2 = 8;

        // invoke
        int actual = my_range.size();
        int actual2 = my_range.get(2);

        // analyze
        assertEquals(expected, actual);
        assertEquals(expected2, actual2);
    }

    @Test
    public void testFibonacci(){
        // setup
        Fibonacci my_range = new Fibonacci(10);
        int expected = 10;
        int expected2 = 34;

        // invoke
        int actual = my_range.size();
        int actual2 = my_range.get(9);

        // analyze
        assertEquals(expected, actual);
        assertEquals(expected2, actual2);
    }
}
