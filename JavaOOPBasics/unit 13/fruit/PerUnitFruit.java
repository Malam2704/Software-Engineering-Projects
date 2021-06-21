package fruit;

public class PerUnitFruit extends Fruit {
    private int count;

    public PerUnitFruit(String name, Double price, int count){
        super(name, price);
        this.count = count;
    }

    @Override
    public Double price(){
        return price * count;
    }

    public String toString() {
        return name + ": " + price + " x " + count + "  " + price();
    };
}
