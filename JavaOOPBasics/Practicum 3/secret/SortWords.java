// Mohammed Alam, Practicum 2, I barely made it boogaloo
package secret;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import backtracker.Configuration;

public class SortWords implements Configuration {
    private final SecretPhrase goalPhrase;
    private String myGuess = "";

    public SortWords(SecretPhrase phrase){
        this.goalPhrase = phrase;
    }
    public SortWords(SecretPhrase phrase, String myGuess){
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
                SortWords succesor = new SortWords(goalPhrase,safety);
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
        return goalPhrase.onTrack(myGuess);
    }

    @Override
    public boolean isGoal() {
        // TODO Auto-generated method stub
        return goalPhrase.guess(myGuess);
    }

    @Override
    public String toString() {
        return myGuess;
    }
    
}
