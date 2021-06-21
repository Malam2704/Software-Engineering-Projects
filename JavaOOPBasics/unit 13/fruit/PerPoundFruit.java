package fruit;

public class PerPoundFruit extends Fruit{
    private Double weight;

    public PerPoundFruit(String name, Double price, Double weight){
        super(name, price);
        this.weight = weight;
    }

    @Override
    public Double price(){
        return price * weight;
    }

    public String toString() {
        return name + ": " + price + " x " + weight + "lbs" + "  " + price();
    };
}
