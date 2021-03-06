import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class CalculonTest {
    
    @Test
    public void testAdd() {
        // setup
        double x = 5.5;
        double y = 7.7;
        double expected = x + y;

        // invoke
        double actual = Calculon.add(x,y);

        // analyze
        assertEquals(expected, actual);
    }
}
