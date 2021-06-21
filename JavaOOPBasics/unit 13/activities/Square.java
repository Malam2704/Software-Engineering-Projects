package activities;

public class Square extends Rectangle{
    public Square(double h, double w){
        super(h, w);
    }

    @Override
    public String getName() {
        return "Square";
    }
}
