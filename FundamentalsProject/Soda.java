public class Soda extends menu_item{
    protected soda_flavor flavor;
    protected item_size size;

    public Soda(soda_flavor flavor, item_size size){
        super(1.0);
        double x = 0;
        this.flavor = flavor;
        this.size = size;
        if(size == item_size.SMALL){
            x = 1.0;
        }else if(size == item_size.MEDIUM){
            x = 1.50;
        }else if(size == item_size.LARGE){
            x = 2.0;
        }
        this.price = x;
    }

    public soda_flavor getFlavor() {
        return flavor;
    }

    public item_size getSize() {
        return size;
    }

    @Override
    public String prepare() {
        return "Pour " + this.flavor + " into a " + this.size + " cup";
    }
}

