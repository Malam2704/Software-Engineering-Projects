package peggame;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class RectangleGameTest {  

    @Test
    public void testPossbilbeMoves() {
        // This test makes an empty board, and sets pegs
        // then makes a move class with those locations
        // then gets a list of possible moves, and the obvious move
        // we manually can make is checked by being located in 
        // possible moves.
        // setup
        Board board = new Board(5, 5);
        Location from = board.getLocation(3, 3);
        Location middle = board.getLocation(2, 2);
        Location to = board.getLocation(1, 1);
        board.setPeg(middle);
        board.setPeg(from);
        RectangleGame myRect = new RectangleGame(board);
        // invoke
        Move move = new Move(from, to);
        Collection<Move> myMoves = myRect.getPossibleMoves();
        // analyze

        System.out.println(board);
        System.out.println(myMoves);
        assertTrue(myMoves.contains(move));
        assertEquals(board.toString(), myRect.getBoard().toString());
        assertEquals(myRect.deepCopy().toString(), myRect.getBoard().toString());
    }

    @Test
    public void testmakeMoves() {
        // So what we need here is just makeing moves similar to
        // the setup from Possuible Moves test, and jsut run the Move
        // from to and from, and check if form and middle is cleared
        // while to, is filled with a peg.
        // setup
        Board board = new Board(5, 5);
        Location from = board.getLocation(3, 3);
        Location middle = board.getLocation(2, 2);
        Location to = board.getLocation(1, 1);
        board.setPeg(middle);
        board.setPeg(from);
        RectangleGame myRect = new RectangleGame(board);
        // invoke
        Move move = new Move(from, to);
        try{
            myRect.makeMove(move);
        }catch(PegGameException j){
            System.out.println("Peg Game Exception");
        }
        Collection<Move> myMoves = myRect.getPossibleMoves();
        // analyze

        System.out.println(board);
        System.out.println(myMoves);
        assertTrue(from.getIsEmpty());
        assertTrue(middle.getIsEmpty());
        assertTrue(!to.getIsEmpty());
    }
}
