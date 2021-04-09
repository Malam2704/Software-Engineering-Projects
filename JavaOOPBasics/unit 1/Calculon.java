import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculon {
    
    public static double add(double x, double y) {
        return x + y;
    }
    public static double subtract(double x, double y) {
        return x - y;
    }
    public static double multiply(double x, double y) {
        return x * y;
    }
    public static double divide(double x, double y) {
        return x / y;
    }

    public static double Raise(double base, double exponent) {
        double result = 1;
        while(exponent != 0){
            result = base * result;
            exponent = exponent - 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter x: ");
            double x = scanner.nextDouble();
            System.out.print("Enter y: ");
            double y = scanner.nextDouble();
            System.out.println("x = " + x + " y = " + y + "!");
            scanner.close();
            System.out.println(add(x, y));
            System.out.println(subtract(x, y));
            System.out.println(multiply(x, y));
            System.out.println(divide(x, y));
            System.out.println(Raise(x, y));
        } catch(InputMismatchException e) {
            System.out.println("Invalid Integer");
        }
    }
}
