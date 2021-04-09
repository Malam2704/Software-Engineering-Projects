public class Combo {
    protected menu_item uno;
    protected menu_item dos;
    protected menu_item tres;
    protected double total_price;

    public Combo(menu_item one, menu_item two, menu_item three){
        this.uno = one;
        this.dos = two;
        this.tres = three;
        this.total_price = (one.price + two.price + three.price) * 0.85;
    }

    public double getTotal_price() {
        return total_price;
    }

    public String prepare(){
        return this.uno.prepare() + " and " + this.dos.prepare() + " and " + this.tres.prepare();
    }
}
