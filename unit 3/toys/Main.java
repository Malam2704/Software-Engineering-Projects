package toys;
import products.*;

// Mohammed Alam
// ?Main java, follows allt eh aprts of step 7
// where I make a new complex, and make a new truck at the Complex
// The compelx makes a product and loads and unlaods it printing it
public class Main {
    public static void main(String[] args) {
        Complex my_Complex = new Complex("Mohammed's Complex");
        Truck my_Truck = new Truck("Mohammed's Truck", 5);
        Robot my_robot = new Robot("Mohammed's Robot",15.99,"Oh no!");
        my_Truck.load_truck(my_robot);
        my_Truck.unload_truck(my_robot);
    }
}
