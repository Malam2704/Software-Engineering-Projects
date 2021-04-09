import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Arrays;

// Mohammed Alam , 1.3
// Well I read the text files usign the code and add them to an array
// based on the size form teh first line, this new array, reads it and then
// another functions is used to create another sieve or erathosenes, to comapre the prime to

public class SieveValidator {
    public static int[] readSieve(String filename) throws IOException {
        try{
            // reads the file and 
            FileReader fr = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fr);
            String size_line = reader.readLine();

            int[] numbers = new int[Integer.parseInt(size_line)];
            int index = 0;
            boolean done = false;
            while(!done){
                String line = reader.readLine();
                // System.out.println(line);
                if(line == null) {
                    done = true;
                } else{
                    for( int i=0; i < line.length(); i++){
                        // System.out.println(line.charAt(i));
                        numbers[index] = line.charAt(i);
                        index ++;
                    }
                }
            }
            fr.close();
            reader.close();

            for(int j = 0; j<Integer.parseInt(size_line); j++){
                if (numbers[j] == 48){
                    numbers[j] = 1;
                } else if(numbers[j] == 49){
                    numbers[j] = 0;
                }
            }

            return numbers;
        } catch(Exception j){
            return null;
        }
    }

    public static int repairSieve(int[] number_array){
        System.out.println("Validating a sieve of length " + number_array.length );
        int errors = 0;

        // Checks if the number which is i is ahead of the index 0, so it's added by 1
        // and checks to see if it mathc es the prime 0 and true of not prime 1 and false,
        // if it doens't amtch all teh above, it fixes it so.
        for(int i=1; i<= number_array.length; i++){
            if ((Primes.isPrime(i) == true) && (number_array[i-1] != 0)){
                System.out.println(i + " is not correct! it's marked as Not Prime");
                number_array[i-1] = 0;
                errors++;
            } else if ((Primes.isPrime(i) == false) && (number_array[i-1] != 1)){
                System.out.println(i + " is not correct! it's marked as Prime");
                number_array[i-1] = 1;
                errors++;
            }
        }

        return errors;
    }

    public static void main(String[] args) {
        // try {
        //     System.out.println(Arrays.toString(readSieve("data/sieve_5.txt")));;
        // } catch(IOException x){
        //     System.err.println("Couldn't read file!");
        // }
        try{
            int[] my_array_one = (readSieve("data/sieve_5.txt"));
            int my_errors_one = repairSieve(my_array_one);
            System.out.print(my_errors_one);

            int[] my_array_two = (readSieve("data/sieve_10.txt"));
            int my_errors_two = repairSieve(my_array_two);
            System.out.print(my_errors_two);

            int[] my_array_three = (readSieve("data/sieve_55.txt"));
            int my_errors_three = repairSieve(my_array_three);
            System.out.print(my_errors_three);

            // int[] my_array_four = (readSieve("data/sieve_100.txt"));
            // int my_errors_four = repairSieve(my_array_four);

            // int[] my_array_five = (readSieve("data/sieve_1000.txt"));
            // int my_errors_five = repairSieve(my_array_five);

            // int[] my_array_six = (readSieve("data/sieve_10000.txt"));
            // int my_errors_six = repairSieve(my_array_six);
        } catch(IOException j){
            System.err.println("Couldn't read file!");
        }
    }
}
