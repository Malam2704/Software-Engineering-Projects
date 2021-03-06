import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable

public class SieveValidatorTest {
    
    @Test
    public void test5(){
        int expected = 0;
        int[] my_array = {0,0,0,1,0};

        int actual = SieveValidator.repairSieve(my_array);
        System.out.print(actual);

        assertEquals(expected, actual);
    }

    @Test
    public void test10(){
        int expected = 3;
        int[] my_array = {0,0,1,1,0,1,0,1,0,0};

        int actual = SieveValidator.repairSieve(my_array);
        System.out.print(actual);

        assertEquals(expected, actual);
    }
}
