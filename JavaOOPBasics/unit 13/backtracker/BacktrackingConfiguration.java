package backtracker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BacktrackingConfiguration implements Configuration {
    private final String goalPhrase;
    private String myGuess = "";

    public BacktrackingConfiguration(String phrase){
        this.goalPhrase = phrase;
    }
    public BacktrackingConfiguration(String phrase,String myGuess){
        this.goalPhrase = phrase;
        this.myGuess = myGuess;
    }

    @Override
    public Collection<Configuration> getSuccessors() {
        // TODO Auto-generated method stub
        List<Configuration> successors = new ArrayList<>();
        if(myGuess.length() < goalPhrase.length()){
            for(int i=32; i<=126; i++){
                // Well over here, it gets the successor as long as the lengths
                // are not equal
                String safety = myGuess;
                safety +=  Character.toString((char)i);
                // System.out.println(safety);
                BacktrackingConfiguration succesor = new BacktrackingConfiguration(goalPhrase,safety);
                successors.add(succesor);
                // if(!goalPhrase.guess(safety)){
                    
                // }
            }
        }
        return successors;
    }

    @Override
    public boolean isValid() {
        // TODO Auto-generated method stub
        return goalPhrase.contains(myGuess);
    }

    @Override
    public boolean isGoal() {
        // TODO Auto-generated method stub
        return goalPhrase.equals(myGuess);
    }

    @Override
    public String toString() {
        return myGuess;
    }
    
    public static void main(String[] args) {
        // replace null with a call to your constructor
        Configuration start = new BacktrackingConfiguration("Here we are Maties.");

        // change this to enable/disable debugging
        boolean debug = true;

        // do not modify below this line
        Backtracker backtracker = new Backtracker(debug);

        Configuration sol = backtracker.solve(start);

        if(sol == null) {
            System.out.println("There is no solution.");
        } else {
            System.out.println("Solution: " + sol);
        }
    }
}
