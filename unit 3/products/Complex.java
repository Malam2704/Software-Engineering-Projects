package products;

public class Complex {
    protected String name;

    public Complex(String name){
        this.name = name;
    }

    public Factory make_factory(String name, Product my_product, int min_price, int max_price){
        Factory my_factory = new Factory(name, my_product, min_price, max_price);

        return my_factory;
    }
}
