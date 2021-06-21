public abstract class menu_item{
    protected double price;

    protected menu_item(double price){
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public abstract String prepare();
}