package peggame;

import java.util.Collection;

public interface PegGame {
    Collection<Move> getPossibleMoves();
    GameState getGameState();
    void makeMove(Move myMove) throws PegGameException;
    void changeGameState(GameState state);
    default PegGame deepCopy(){
        throw new UnsupportedOperationException("deepCopy is not implemented");
    }


    /**
     * IMPLEMENTATION
     * 
     * get row from from and to then divide by 2
     * 
     * repeat for cols
     * 
     * returns coords of in between peg
     * 
     */
}
