package peggame;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class MoveTest {
    
    @Test
    public void makeMove() {
        // setup
        Location from = new Location(0, 0);
        Location to = new Location(0, 1);
        // invoke
        Move move = new Move(from, to);
        // analyze
        assertEquals(from, move.getFrom());
        assertEquals(to, move.getTo());
    }
}
