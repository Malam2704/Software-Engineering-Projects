import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class PracticumTest {
    @Test
    public void testMenuItem(){
        // setup
        Soda coke = new Soda(soda_flavor.COLA, item_size.LARGE);
        soda_flavor expected1 = soda_flavor.COLA;
        item_size expected2 = item_size.LARGE;
        String expected3 = "Pour COLA into a LARGE cup";
        double expected4 = 2;

        // invoke
        soda_flavor actual1 = coke.getFlavor();
        item_size actual2 = coke.getSize();
        String actual3 = coke.prepare();
        double actual4 = coke.getPrice();

        // analyze
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4, 0.01);
    }

    @Test
    public void testCombo(){
        // setup
        Soda coke = new Soda(soda_flavor.COLA, item_size.LARGE);
        Fries french = new Fries(item_size.LARGE);
        Softy frosty = new Softy(item_size.SMALL);
        Combo my_order = new Combo(coke, french, frosty);
        double expected1 = 6.8;
        String expected2 = "Pour COLA into a LARGE cup and Fry a LARGE batch of fries until they're crispy and Pour a delicious Softy into a SMALL cup";

        // invoke
        double actual1 = my_order.getTotal_price();
        String actual2 = my_order.prepare();

        // analyze
        assertEquals(expected1, actual1, 0.01);
        assertEquals(expected2, actual2);
    }

    @Test
    public void testComboTwo(){
        // setup
        Soda coke = new Soda(soda_flavor.COLA, item_size.LARGE);
        Grilled_Cheese cheezers = new Grilled_Cheese(breads.WHEAT, cheeses.AMERICAN, true);
        Cherry_Pie pied = new Cherry_Pie();
        Combo my_order = new Combo(coke, cheezers, pied);
        double expected1 = 8.5;
        String expected2 = "Pour COLA into a LARGE cup and Put two slices of AMERICAN cheese between two slices of buttered WHEAT bread and add bacon before grilling to golden brown perfection and Add a cherry pie to the bag";

        // invoke
        double actual1 = my_order.getTotal_price();
        String actual2 = my_order.prepare();

        // analyze
        assertEquals(expected1, actual1, 0.01);
        assertEquals(expected2, actual2);
    }
}
