// Mohammed Alam, 1.1, I don't know how to make a docstring
// I was supposed to make a program that checks if a number
// is prime or not, by makign a for loop in main the goes form numbers 1 - 100
// and applies it into the isPrime function, which itself does a for loop
// from ranges 2 to n and checks if any of those numbers are divisible by n, if so
// it returns true, if it can be divided it's false

// Updated so the main asks the suer for the input and then goes to a while loop where
// the user is repeatedly asked for a number until they enter a number below 1
import java.util.Scanner;

public class Primes {

    public static boolean isPrime(int n) {
        // if (n % 2 == 0){
        //     return false;
        // } else if (n % 3 == 0){
        //     return false;
        // }
        if (n < 1){
            // System.out.println("false -" + n);
            return false;
        }
        if(n == 2){
            return true;
        }
        // Optimization - make an else if statement if n %2 == 0, then icrement by
        // 2 in the for loop.
        if((n+2) % 2 == 0){
            // System.out.println("false -" + n);
            return false;
        } else{
            for (int i = 3; i < n; i+=2){
                if (n % i == 0){
                    // System.out.println("false -" + n);
                    return false;
                }
            }
        }
        // System.out.println("true -" + n);
        return true;
    }
    public static void main(String[] args) {
        // System.out.println(isPrime(1));
        // System.out.println(isPrime(6));
        // System.out.println(isPrime(71));

        // for(int j = 1; j < 101; j++){
        //     isPrime(j);
        // }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int x = scanner.nextInt();

        while(x >= 1){
            System.out.println(isPrime(x));
            System.out.print("Enter a number: ");
            x = scanner.nextInt();
        }

        scanner.close();
        System.out.println("Goodbye!");
    }
}
