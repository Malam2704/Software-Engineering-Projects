package activities;

public class Rectangle implements Shape {
    private final double width;
    private final double height;

    public Rectangle(double height, double width){
        this.width = width;
        this.height = height;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Rectangle{ height=" + height + ", width=" + width;
    }

    @Override
    public double perimeter() {
        // TODO Auto-generated method stub
        return (height + width) * 2;
    }

    @Override
    public double area() {
        // TODO Auto-generated method stub
        return height * width;
    }
    
}
