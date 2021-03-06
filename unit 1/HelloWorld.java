public class HelloWorld {
    public static void helloname(String first, String last) {
        System.out.println("Hello, " + first + last + "!");
        return;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        helloname("My","Name");
    }
}