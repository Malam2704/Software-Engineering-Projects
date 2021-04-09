package peggame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import backtracker.Configuration;

public class TriangleConfig implements Configuration{
    private PegGame game;

    public TriangleConfig(PegGame game){
        this.game = game;
    }

    // Basically,trys and cathces make moves so no peg game
    // exception occurs, makes moves for succesesors,
    // while the list of get Possible moves is greater than 1.
    @Override
    public Collection<Configuration> getSuccessors() {
        List<Configuration> successors = new ArrayList<>();
        if(game.getPossibleMoves().size() >= 1){
            for(Move move : game.getPossibleMoves()){
                try{
                    game.makeMove(move);
                    TriangleConfig successor = new TriangleConfig(game);
                    successors.add(successor);
                } catch (PegGameException e) {
                    System.out.println("peg game exception");
                }
            }
        }
        return successors;
    }

    // Is valid and gaol just checks the gamestate.
    @Override
    public boolean isValid() {
        // return game.getPossibleMoves().size() >= 1;
        return game.getGameState() != GameState.STALEMATE;
    }

    @Override
    public boolean isGoal() {
        return game.getGameState() == GameState.WON;
        // return game.getBoard().getPegList().size() == 1;
    }

    @Override
    public String toString() {
        return game.toString();
    }
}
