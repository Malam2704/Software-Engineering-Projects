// Mohammed Alam 31., jsut literally a test case
// for all the methods, accessors, and mutators for the class
// Pokemon, soem tests have more pokemon

package Practice02;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

public class PokemonTest {
    
    @Test
    public void testType() {
        // setup
        PokemonType expected = PokemonType.Electric;

        // invoke
        Pokemon Pikachu = new Pokemon("Pikachu",PokemonType.Electric);
        PokemonType actual = Pikachu.getType();

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void testname() {
        // setup
        String expected = "Pikachu";

        // invoke
        Pokemon Pikachu = new Pokemon("Pikachu",PokemonType.Electric);
        String actual = Pikachu.getName();

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void testlevel() {
        // setup
        int expected = 25;

        // invoke
        Pokemon Pikachu = new Pokemon("Raichu",PokemonType.Electric,25);
        int actual = Pikachu.getLevel();

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void testrename() {
        // setup
        String expected = "Raichu";

        // invoke
        Pokemon Pikachu = new Pokemon("Pikachu",PokemonType.Electric);
        Pikachu.Rename("Raichu");
        String actual = Pikachu.getName();

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void testlevelup() {
        // setup
        int expected = 26;

        // invoke
        Pokemon Pikachu = new Pokemon("Raichu",PokemonType.Electric,25);
        Pikachu.Levelup();
        int actual = Pikachu.getLevel();

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void stringInterpretation() {
        // setup
        String expected = "Name: Pikachu, Type: Electric, Level: 1";
        String expected2 = "Name: Charizard, Type: Fire, Level: 50";

        // invoke
        Pokemon Pikachu = new Pokemon("Pikachu",PokemonType.Electric);
        Pokemon Charizard = new Pokemon("Charizard",PokemonType.Fire,50);
        String actual = Pikachu.toString();
        String actual2 = Charizard.toString();

        // analyze
        assertEquals(expected, actual);
        assertEquals(expected2, actual2);
    }

    @Test
    public void equalsfalse() {
        // setup
        Boolean expected = false;

        // invoke
        Pokemon Pikachu = new Pokemon("Pikachu",PokemonType.Electric);
        Pokemon Charizard = new Pokemon("Charizard",PokemonType.Fire,50);
        Boolean actual = Pikachu.equals(Charizard);

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void equalstrue() {
        // setup
        Boolean expected = true;

        // invoke
        Pokemon Pikachu = new Pokemon("Pikachu",PokemonType.Electric);
        Pokemon Minun = new Pokemon("Minun",PokemonType.Electric,1);
        Boolean actual = Pikachu.equals(Minun);

        // analyze
        assertEquals(expected, actual);
    }
}
