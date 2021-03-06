package activities;

public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public String getName() {
      return "rectangle";
    }

    @Override
    public double getArea() {
      return width * height;
    }

    @Override
    public double getPerimeter() {
      return 
        width * 2 + height * 2;
    }
}
  

