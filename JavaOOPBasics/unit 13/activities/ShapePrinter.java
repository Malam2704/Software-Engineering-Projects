package activities;

public class ShapePrinter {
    public static void printShape(Shape shape){
        System.out.println(shape.getName());
        System.out.println("  area: " + shape.area());
        System.out.println("  area: " + shape.perimeter());
    }

    public static void main(String[] args) {
        Shape r = new Rectangle(5,4);
        printShape(r);

        Shape c = new Circle(5.7);
        printShape(c);
    }
}
