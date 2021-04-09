public class Softy extends menu_item {
    protected item_size size;

    public Softy(item_size size){
        super(1.0);
        this.size = size;
        if(size == item_size.SMALL){
            this.price += 1.50;
        }else if(size == item_size.MEDIUM){
            this.price += 2;
        }else if(size == item_size.LARGE){
            this.price += 3;
        }
    }

    public item_size getSize() {
        return size;
    }

    @Override
    public String prepare() {
        return "Pour a delicious Softy into a " + this.size + " cup";
    }
}
