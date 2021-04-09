package peggame;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class LocationTest {
    
    @Test
    public void makeLocation() {
        // setup - none
        // invoke
        Location loc = new Location(0, 0);
        // analyze
        assertEquals(loc.getRow(), 0);
        assertEquals(loc.getCol(), 0);
        assertEquals(loc.getIsEmpty(), true);
    }

    @Test
    public void fillLocation() {
        // setup
        Location loc = new Location(0, 0);
        // invoke
        loc.fill();
        // analyze
        assertEquals(loc.getIsEmpty(), false);
    }

    @Test
    public void clearLocation() {
        // setup
        Location loc = new Location(0, 0);
        // invoke
        loc.clear();
        // analyze
        assertEquals(loc.getIsEmpty(), true);
    }
}
