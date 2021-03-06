package products;

// I copied and pasted the entire TOy command but changed a few features
// becuase nto all products can be palyed with
public class Product {
    protected int code = 1000000;
    protected double MSRP;
    protected String name;

    // makes the actual toy, but is used for others toys purposefullt
    public Product(String name, double MSRP){
        this.name = name;
        this.MSRP = MSRP;
        this.code++;
    }

    // Your getters
    public int getProductCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getMSRP() {
        return MSRP;
    }

    // Incase you want to reanme the name of the toy
    public void Rename(String name){
        this.name = name;
    }

    // Stirng method
    @Override
    public String toString() {
        return ("Name: " + this.name +", Product Code: " + this.code + ", MSRP: " + this.MSRP);
    }
}
