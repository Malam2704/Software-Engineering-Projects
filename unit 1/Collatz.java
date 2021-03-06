// I don't know how that import came out, I didn't do it
// I have a base string in teh Sequence function and it adds the integers
// that are going into the sequence, also the number n is modded by dividing by2
// if even, and multip[lied by 3 and added by 1, if n is odd. A while loop is done
// until n is finally equal to 1, then the loop ends, and the stirng is returned.

// Updated so the main asks the suer for the input and then goes to a while loop where
// the user is repeatedly asked for a number until they enter a number below 1
import javax.sound.midi.Sequence;
import java.util.Scanner;

public class Collatz {
    public static String Sequence(int n) {
        // if (n < 1) {
        //     return (" ");
        // } else if (n % 2 == 0){
        //     Sequence(n / 2);
        // } else {
        //     Sequence((3*n)+1);
        // }
        String return_string = "";
        if (n < 1) {
            return " ";
        }
        return_string += n ;
        return_string += " " ;
        while (n != 1){
            if (n % 2 == 0){
                return_string += (n/2);
                return_string += " ";
                n = n/2;
            } else{
                return_string += (1 + (n * 3));
                return_string += " ";
                n = 3 * n + 1;
            }
        }

        return return_string;
    }

    public static void main(String[] args) {
        // System.out.println(Sequence(13));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int x = scanner.nextInt();

        while(x >= 1){
            System.out.print(Sequence(x));
            System.out.print("\nEnter a number: ");
            x = scanner.nextInt();
        }

        scanner.close();
        System.out.println("Goodbye!");
    }
}
