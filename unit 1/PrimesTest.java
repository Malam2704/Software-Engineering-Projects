// Mohammed Alam 1.2
// 4 tests for all types fo cases, 0 , negative, not prime, and prime

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class PrimesTest {
    
    @Test
    public void test5() {
        // setup
        boolean expected = true;

        // invoke
        boolean actual = Primes.isPrime(5);

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void testnegative() {
        // setup
        boolean expected = false;

        // invoke
        boolean actual = Primes.isPrime(-5);

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void test0() {
        // setup
        boolean expected = false;

        // invoke
        boolean actual = Primes.isPrime(0);

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void test9() {
        // setup
        boolean expected = false;

        // invoke
        boolean actual = Primes.isPrime(9);

        // analyze
        assertEquals(expected, actual);
    }
}