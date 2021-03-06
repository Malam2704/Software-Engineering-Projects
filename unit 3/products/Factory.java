package products;
import java.util.Random;

public class Factory{
    protected String name;
    protected Product our_product;
    protected int code_count = 1000000;
    private final int min_price;
    private final int max_price;
    private static final Random RNG = new Random(1);

    public Factory(String name, Product my_product, int min_price, int max_price){
        this.name = name;
        this.our_product = my_product;
        this.min_price = min_price;
        this.max_price = max_price;
    }

    // public Product make_product(String name){
    //     double MSRP = RNG.nextInt((this.max_price-this.min_price-1));
    //     Product a_product = new Product(name, MSRP+min_price+.99, this.code_count +1);
    //     this.code_count += 1;
    //     return a_product;
    // }
}
