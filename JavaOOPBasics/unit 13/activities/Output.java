import java.util.Scanner;

public class Output{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        String nLine = scanner.next();
        System.out.println("Hello " + nLine);
    }
}