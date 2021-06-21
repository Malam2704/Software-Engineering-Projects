package activities;

public class Circle implements Shape {
    private double radius;

    public Circle(double ra){
        this.radius = ra;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Circle";
    }

    @Override
    public double perimeter() {
        // TODO Auto-generated method stub
        return 2 * 3.14 * radius;
    }

    @Override
    public double area() {
        // TODO Auto-generated method stub
        return 3.14 * Math.pow(radius, 2);
    }
    
}
