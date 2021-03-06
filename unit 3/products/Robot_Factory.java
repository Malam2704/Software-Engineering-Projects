package products;
import toys.*;

// Factory to initialzie a factory that can amke robots, and does the same 
// for all the other factories
public class Robot_Factory extends Factory {

    public Robot_Factory(String name, Robot robots){
        super(name, robots, 30, 100);
    }

    public Robot make_product(String name,double msrp,String sound){
        Robot a_robot = new Robot(name, msrp, sound);
        return a_robot;
    }
}
