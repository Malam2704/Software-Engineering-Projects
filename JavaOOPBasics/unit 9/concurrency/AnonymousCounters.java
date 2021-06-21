import java.util.Scanner;

public class AnonymousCounters{
    public static void counter(String name){
        for(int i=0; i<101; i++){
            System.out.println(name + ": " + i);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entert a nnumber: ");
        int number = scanner.nextInt();

        for(int j=0; j<number; j++){
            String name = "Counter " + j;
            Thread thread = new Thread(){
                @Override
                public void run() {
                    counter(name);
                };
            };
            //Thread thread = new Thread(() -> counter(name));
            thread.start();
        }
    }
}