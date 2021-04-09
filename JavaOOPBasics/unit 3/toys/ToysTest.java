/* 
A testing module, but I tested accesors mutators, and methods all
within the respected test, one test for each class to make things easier,
if the class has a new method the previous class in these tests didn't have
, then it will be tested, otherwise it would be redundant.
*/
package toys;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class ToysTest {
    @Test
    public void test_Toy_class(){
        // 
        Robot Calculon = new Robot("Orboto Roboto", 19.99, 1234567, "Oh yeah!");
        String expected1 = "Orboto Roboto";
        double expected2 = 19.99;
        int expected3 = 1234567;
        int expected4 = 0;
        String expected5 = null;
        int expected6 = 100;
        String expected7 = "Oh yeah!";
        int expected8 = 80;

        // Invoke
        String actual1 = Calculon.getName();
        double actual2 = Calculon.getMSRP();
        int actual3 = Calculon.getProductCode();
        int actual4 = Calculon.getCharge();
        String actual5 = Calculon.Play();
        Calculon.charge();
        int actual6 = Calculon.getCharge();
        String actual7 = Calculon.Play();
        int actual8 = Calculon.getCharge();

        // Analyze
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
        assertEquals(expected5, actual5);
        assertEquals(expected6, actual6);
        assertEquals(expected7, actual7);
        assertEquals(expected8, actual8);
    }

    @Test
    public void test_Doll_class(){
        // Setup
        Doll adoll = new Doll("American Girl", 29.99, 1223344, Colors.Blonde, Colors.Blue);
        String expected1 = "Canadian Girl";
        String expected2 = "a";
        int expected3 = 9;

        // Invoke
        adoll.Rename("Canadian Girl");
        String actual1 = adoll.getName();
        String actual2 = adoll.Play();
        int actual3 = adoll.getPlays_left();

        // Analyze
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }

    @Test
    public void test_Action_Figure_class(){
        // Setup
        Action_Figure Macho = new Action_Figure("Randy Savage", 34.99, 1223345, Colors.Red, Colors.Dark_Brown, true);
        String expected1 = "Hulk Hogan";
        String expected2 = "f";
        int expected3 = 8;
        boolean expected4 = true;

        // Invoke
        Macho.Rename("Hulk Hogan");
        String actual1 = Macho.getName();
        String actual2 = Macho.Play();
        Macho.Play();
        int actual3 = Macho.getPlays_left();
        boolean actual4 = Macho.getSwordStatus();

        // Analyze
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }
}
