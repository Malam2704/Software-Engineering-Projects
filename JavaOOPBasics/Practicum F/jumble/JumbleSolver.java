package jumble;

import backtracker.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JumbleSolver implements Configuration{
    private static Set<String> allWords;
    private String currentString;
    private String remainingString;

    public JumbleSolver(String currentString, String remainingString){
        this.currentString = currentString;
        this.remainingString = remainingString;
    }

    @Override
    public Collection<Configuration> getSuccessors() {
        Collection<Configuration> successors = new ArrayList<>();

        // **********************************
        // ****** YOUR CODE GOES HERE *******
        // **********************************
        if(allWords.contains(currentString)){
            for(int i=32; i<=126; i++){
                String safety = currentString;
                safety +=  Character.toString((char)i);
                JumbleSolver succesor = new JumbleSolver(safety,remainingString);
                successors.add(succesor);
            }
        }
        return successors;
    }

    @Override
    public boolean isValid() {
        boolean result = false;

        // **********************************
        // ****** YOUR CODE GOES HERE *******
        // **********************************
        if(remainingString.startsWith(currentString)){
            result = true;
        }
        return result;
    }

    @Override
    public boolean isGoal() {
        boolean result = false;

        // **********************************
        // ****** YOUR CODE GOES HERE *******
        // **********************************
        if(remainingString.length() == currentString.length() && allWords.contains(remainingString)){
            result = true;
        }
        return result;
    }

    @Override
    public String toString() {
        return currentString;
    }

    public static void loadWords(String fileName){
        allWords = new HashSet<String>();
        try {
            Scanner file = new Scanner(new File(fileName));
            while(file.hasNext()){
                String line = file.nextLine();
                for (String word : line.split(" ")){
                    if (word.length() <= 7 && word.matches("[a-z]+")) {
                        allWords.add(word.toLowerCase());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("***** Word File Not Found ... Did you fix your path?  *****");
        }
    }

    public static void main(String[] args){

        // *****************************************************
        // ***** MODIFY THE PATH BELOW FOR YOUR ENVIRONMENT ****
        // *****************************************************
        loadWords("jumble/words.txt");

        String[] jumbles = new String[] {
            "zzz",
            "unf", 
            "wlyasa", 
            "rshtea", 
            "blscu",
            "dmersia",
            "seay",
            "foobar"  
        };

        Backtracker backtracker = new Backtracker(false);
        for (String jumble : jumbles){
            Configuration initconfig = new JumbleSolver("", jumble); 
            Configuration goal = backtracker.solve(initconfig);
            if(goal == null){
                System.out.println("No solution found for jumble: " + jumble);
            }
            else{
                System.out.println(jumble + " solution is: " + goal);
            }    
        }
    }
}
