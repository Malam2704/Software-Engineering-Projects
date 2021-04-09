import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

public class Files{
    public static void info(String filename) {
        // create a new file within the filename
        File file = new File(filename);
        // print the name of teh file - getName()
        System.out.println(file.getName());
        // print the absolute path to the file- getAbsoliutePath()
        System.out.println(" " + file.getAbsolutePath());
        // print whether or not the file exists - exists()
        if (file.exists()) {
            // if it exists, print the length (number of bytes of data) - length()
            System.out.println("file exists and contains " + file.length() + " bytes!");
        } else{
            System.out.println("  file does not exist!");
        }   
    }

    public static void printFile(String filename) throws IOException {
        // create a file reader
        FileReader fr = new FileReader(filename);
        // Use the file reader to make a buffered reader
        BufferedReader reader = new BufferedReader(fr);
        // use a loop and readline() to read and print line from the file
        // stop when readline turns null()
        boolean done = false;
        while(!done){
            String line = reader.readLine();
            if(line == null) {
                done = true;
            } else{
                System.out.println(line);
            }
        }

        //  don't forget to close
        fr.close();
        reader.close();
    }

    public static void main(String[] args) {
        try {
            printFile("data/sieve_5.txt");
        } catch(IOException x){
            System.err.println("Couldn't read file!");
        }
    }
}