package activities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileIO {
    public static void main(String[] args) throws IOException, FileNotFoundException{
        String filename = "data/alice.txt";
        FileReader fr = new FileReader("data/alice.txt");
        BufferedReader bReader = new BufferedReader(fr);

        String line = bReader.readLine();
        while(true){
            line = bReader.readLine();
            if(line == null){
                break;
            }
            System.out.println(line);
        }
    }
}
