package graphs;
import java.io.ObjectInputFilter.Config;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import backtracker.Backtracker;
import backtracker.Configuration;

public class NQueens implements Configuration{
    private final Queen[] queens;
    private final int n;

    public NQueens(int n){
        this.n = n;
        queens = new Queen[0];
    }
    public NQueens(int n, Queen[] queens){
        this.n = n;
        this.queens = queens;
    }

    @Override
    public Collection<Configuration> getSuccessors() {
        // make an empty list of successors (configuration)
        List<Configuration> successors = new ArrayList<>(n);

        // figure out what the next row is
        int row = queens.length;
        // make sure the row isn't off the board
        if(row < n){
            // make on successor for each column in the next row
            for(int col=0; col<n; col++){
                // Make a queen at row,col
                Queen next = new Queen(row, col);
                // copy the array with room for one more
                Queen[] deepCopy = Arrays.copyOf(queens, queens.length +1);
                // put that queen in the last spot in the copy
                deepCopy[queens.length] = next;
                // make the new NQueens configuration
                NQueens successor = new NQueens(n, deepCopy);
                // add it to the list
                successors.add(successor);
            }
        }
        Queen[] new_queens = Arrays.copyOf(queens, queens.length + 1);
        return successors;
    }

    @Override
    public boolean isValid() {
        // compare the last queen (queens[length-1]) to the other
        // queens to see if it can be attacked by any of them, and if so
        // return false
        if(queens.length > 1){
            Queen last = queens[queens.length - 1];
            for(int i=0;i<queens.length-1; i++){
                Queen queen = queens[i];
                if(queen.canAttack(last)){
                    return false;
                }
            }
        }
        // otherwise
        return true;
    }

    @Override
    public boolean isGoal() {
        return this.isValid() && queens.length == n; 
    }

    @Override
    public String toString() {
        String[][] board = new String[n][n];
        for(int row=0; row<n;row++){
            for(int col=0; col<n; col++){
                board[row][col] = "[ ]";
            }
        }

        for(Queen queen : queens){
            board[queen.getRow()][queen.getCol()] = "[Q]";
        }

        StringBuilder builder = new StringBuilder();

        for(String[] row : board){
            for(String square : row){
                builder.append(square);
            }
            builder.append("\n");
        }

        return builder.toString();

        // return "n=" + n + ", " + Arrays.toString(queens);
    }

    public static void main(String[] args) {
        // NQueens config = new NQueens(4);
        // System.out.println(config);
        // for(Configuration successor : config.getSuccessors()){
        //     System.out.println(successor);
        // }
        NQueens config = new NQueens(3);
        Backtracker bt = new Backtracker(true);
        Configuration solution = bt.solve(config);
        if(solution == null){
            System.out.println("no solution");
        }else{
            System.out.println(solution);
        }
    }
}