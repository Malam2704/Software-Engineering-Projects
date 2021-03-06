package products;
import toys.*;

public class Action_Figure_Factory extends Factory{
    public Action_Figure_Factory(String name, Action_Figure figures){
        super(name, figures, 5, 15);
    }

    public Action_Figure make_product(String name,double msrp, Colors hair_color, Colors eye_color){
        Action_Figure a_robot = new Action_Figure(name, msrp, hair_color, eye_color);
        return a_robot;
    }
}
