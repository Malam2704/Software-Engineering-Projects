package products;
import toys.*;

public class Doll_Factory extends Factory {
    public Doll_Factory(String name, Robot robots){
        super(name, robots, 5, 30);
    }

    public Doll make_product(String name,double msrp, Colors hair_color, Colors eye_color){
        Doll a_doll = new Doll(name, msrp, hair_color, eye_color);
        return a_doll;
    }
}
