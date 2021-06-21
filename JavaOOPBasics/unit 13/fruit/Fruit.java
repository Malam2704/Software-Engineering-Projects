package fruit;

public abstract class Fruit implements Cost{
    protected Double price;
    protected String name;

    public Fruit(String name, Double price){
        this.name = name;
        this.price = price;
    }

    public abstract Double price();
}
