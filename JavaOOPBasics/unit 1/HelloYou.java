import java.util.Scanner;

public class HelloYou {
    public static void helloYou() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.println("Hello " + name + "!");
        scanner.close();
    }

    public static void main(String[] args) {
        helloYou();
    }
}
