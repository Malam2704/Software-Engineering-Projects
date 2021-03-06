public class Fries extends menu_item{
    protected item_size size;

    public Fries(item_size size){
        super(1.0);
        double x = 0;
        this.size = size;
        if(size == item_size.SMALL){
            x = 2.0;
        }else if(size == item_size.MEDIUM){
            x = 2.50;
        }else if(size == item_size.LARGE){
            x = 3.50;
        }
        this.price = x;
    }

    public item_size getSize() {
        return size;
    }

    @Override
    public String prepare() {
        return "Fry a " + this.size + " batch of fries until they're crispy";
    }
}