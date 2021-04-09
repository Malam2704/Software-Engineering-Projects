// Mohammed Alam 2.1, Practice practical
// Well I have to do a practice practical which I need to turns and array into a String format, and
// for the next part, read a text file, and check how many lines start with a specific letter.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Practice01 {
    public static String arrayToString(int[] my_array) {
        // It starts with a base string, and then a for loop
        // adds each value of index i form the int[] my_array
        // and also adds a comma until the length is 1 below the amount
        // of numbers in the array, so your alst number doens't have a comma
        // and then returns it
        String base = "[";
        for (int i=0; i<my_array.length; i++){
            base += my_array[i];
            while(i < (my_array.length -1)){
                base += ", ";
                break;
            }
        }
        base += "]";
        return base;
    }

    public static int printLines(String filename, char letter) throws IOException {
        // try catch for that huge Stirng error which means I ran into a blank line
        try{
            // Basic file reader scenario to read the file
            FileReader fr = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fr);
            int number = 0;
            boolean done = false;

            // While loop to read through the lines of the file
            while(done != true){
                // Turns the first line into a string
                String line = reader.readLine();
                // checks if that line exists in the file, and we didn't reach the end
                if(line == null){
                    done = true;
                }
                // try and catch so that if we don't have a blank line
                // and the first index of the letter(Uppercases are turned 
                // into lowercase) matches out parameter, we increment
                // our number by 1
                // If an error occurs, like if the line is a centered line with
                // empty characsters for the first index, we catch the exception
                // and set the line to read the next line. 
                try{
                    if(line.length() >= 1){
                        if (Character.toLowerCase(line.charAt(0)) == letter){
                            // System.out.println(line.charAt(0));
                            number++;
                        }
                    }
                }catch(Exception u){
                    line = reader.readLine();
                }
            }

            //  don't forget to close
            fr.close();
            reader.close();

            return number;
        }catch(StringIndexOutOfBoundsException j){
            System.err.println("eh");
            return 0;
        }
    }

    public static void main(String[] args) {
        // int[] an_array = {1,2,3};
        // System.out.println(arrayToString(an_array));

        try{
            System.out.println(printLines("assignment2/data/alice.txt", 'b'));
            System.out.println(printLines("assignment2/data/alice.txt", 'a'));
            System.out.println(printLines("assignment2/data/alice.txt", 'c'));
            System.out.println(printLines("assignment2/a_6_1.txt", '#'));
        } catch(IOException e){
            System.out.println("Error can't read File!");
        }
    }
}


