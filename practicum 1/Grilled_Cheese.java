public class Grilled_Cheese extends menu_item{
    protected breads bread_type;
    protected cheeses cheese_type;
    protected boolean with_bacon;

    public Grilled_Cheese(breads my_bread, cheeses my_cheese, boolean bearcan){
        super(5.0);
        this.bread_type = my_bread;
        this.cheese_type = my_cheese;
        this.with_bacon = bearcan;
        if(bearcan == true){
            this.price += 1;
        }
    }

    public breads getBread_type() {
        return bread_type;
    }

    public cheeses getCheese_type() {
        return cheese_type;
    }

    @Override
    public String prepare() {
        return "Put two slices of " + this.cheese_type + " cheese between two slices of buttered " + this.bread_type + " bread and add bacon before grilling to golden brown perfection";
    }
}
