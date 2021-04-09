// This is our actual game, the one we are
//  calling an instance of that the user is playing

package peggame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RectangleGame implements PegGame{
    // Parameters
    private GameState state;
    // private List<Move> possibleMoves;
    protected PegGame game;
    private Board board;

    public RectangleGame(Board board) {
        this.state = GameState.NOT_STARTED;
        this.board = board;
    }

    private RectangleGame(PegGame copyGame, Board copyBoard, GameState copyState) {
        this.state = copyState;
        this.board = copyBoard.newBoard();  
        this.game = copyGame;
    }

    // A helper function that take in a parameter for a location
    // then for loops through all the locations in a board
    // and checks if any locations are valid for moves
    // using the moves class's validmove function, adding it
    // to a possible moves array as a parameter.
    public void moverFunction(List<Move> possibleMoves, Location from){
        for(int toRow=0; toRow < board.getRow(); toRow++) {
            for(int toCol=0; toCol < board.getCol(); toCol++) {
                // Makes a move object with the from parameter
                // and to coordinates from it's nested for loop
                Location to = board.getLocation(toRow, toCol);
                Move myMove = new Move(from,to);
                if(validMove(from,to)){
                    possibleMoves.add(myMove);
                }
            }
        }
    }
    
    public Board getBoard(){
        return this.board;
    }

    @Override
    public String toString() {
        return this.board.toString();
    }

    // The overall fucntion, helped by the helper function
    // which goes trhough all the rows in the board and calls the
    // helper functions to get it's possible moves. Using a nested
    // for loop, to make to coordinates
    @Override
    public Collection<Move> getPossibleMoves() {
        List<Move> possibleMoves = new ArrayList<>();
        for(int row=0; row < board.getRow(); row++) {
            for(int col=0; col < board.getCol(); col++) {
                Location from = board.getLocation(row, col);
                if(!from.getIsEmpty()) {
                    moverFunction(possibleMoves, from);
                }
            }
        }

        return possibleMoves;
    }

    // gets and returns gamestate, used by command line.
    @Override
    public GameState getGameState() {
        return this.state;
    }
    public void changeGameState(GameState state){
        this.state = state;
    }

    // Valid move class, that is used to check
    // if the move class made by the user is valid or not
    // usually by going around in combinations of 2 and 0
    public boolean validMove(Location from, Location to) {
        if(to.getIsEmpty()){
            int rowDiff = Math.abs(to.getRow() - from.getRow());
            int colDiff = Math.abs(to.getCol() - from.getCol());
            // This one shows if the abs value difference is 2 for both
            // rows and columns, meaning it's a diagnol move.
            if(rowDiff == 2 && colDiff == 2){
                return true;
                // Below, is a change in rows, meaing the move is 2 spots
                // left or right.
            } else if(rowDiff == 0 && colDiff == 2){
                return true;
                // Below here is a change in rows of 2 meaning
                // it goes up or down 2
            } else if(rowDiff == 2 && colDiff == 0){
                return true;
            }else{
                return false;
            }
        }else{
            // Would mean not empty hole, so not valid.
            return false;
        } 
    }

    // The make move function which takes a move as a param.
    // Check is the move is valid or not, then makes Locations for
    // to and from in the myMove parameter. Get's the difference in rows
    // and columns to find the middle coordinate to be cleared.
    @Override
    public void makeMove(Move myMove) throws PegGameException {
        if(!validMove(myMove.getFrom(),myMove.getTo())){
            System.out.println("Not a valid move");
        }else{
            Location from = board.getLocation(myMove.getFrom().getRow(), myMove.getFrom().getCol());
            Location to = board.getLocation(myMove.getTo().getRow(), myMove.getTo().getCol());
            // Board function to clear the peg
            board.clearPeg(from);
            // adds the difference of to and from to the from coordinate to get
            // the middle coordinates
            int middleRowAdder = (myMove.getTo().getRow() - myMove.getFrom().getRow())/2;
            int middleColAdder = (myMove.getTo().getCol() - myMove.getFrom().getCol())/2;
            Location middle = board.getLocation(from.getRow()+middleRowAdder, from.getCol()+middleColAdder);
            board.clearPeg(middle);
            board.setPeg(to);
            // Always prints board, or says invalid move
            System.out.println(board);
            // Checks if there is 1 peg, so there's a winning game state,
            // or if there are more than 2 moves and 2 pegs, which leads to a 
            // stalemate.
            if(board.getPegList().size() == 1){
                state = GameState.WON;
            }else if(board.getPegList().size() == 2 && this.getPossibleMoves().size() > 2){
                state = GameState.STALEMATE;
            }
        }
    }
    @Override
    public PegGame deepCopy() {
        PegGame copy = new RectangleGame(this.game, this.board, this.getGameState());
        return copy;
    }

    public static void main(String[] args) {
        PegGame game = GameReader.readGame("data/5_5.txt");
        RectangleGame copy = (RectangleGame) game.deepCopy();
        System.out.println(copy.getBoard());
    }


}
