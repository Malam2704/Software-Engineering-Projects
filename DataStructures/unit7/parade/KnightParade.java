// Mohammed Alam, assignment 7.3
// My goal for this assignment was to create  a Knight Parade
//  algorithm using the backtracker which can succesfully treack my
// succesful steps until the knight can go through every porrible option
// to finish going through all the squares on a chess board.
package parade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import backtracker.Backtracker;
import backtracker.Configuration;

public class KnightParade implements Configuration{
    private final Knight[] Knights;
    private final int size;
    private Chessboard cb;
    private int row;
    private int col;
    private boolean successful;

    // makings of the Kngiht parade class cosnturctor and another one
    //  which cna be used to copy it.
    public KnightParade(int n, Knight[] knights){
        this.size = n;
        this.Knights = knights;
    }
    public KnightParade(int n){
        this.size = n;
        this.Knights = new Knight[0];
    }

    // The getters of the module
    public int getCol() {
        return col;
    }
    public int getRow() {
        return row;
    }
    public Knight[] getKnights() {
        return Knights;
    }
    public int getSize() {
        return size;
    }
    
    // the getSuccessors 
    @Override
    public Collection<Configuration> getSuccessors() {
        List<Configuration> successors = new ArrayList<>(size);
        if(row<size){
            for(col=0; col< size; col++){
                Knight next = new Knight(row, col);
                Chessboard copy = new Chessboard(cb);
                Knight[] deepCopy = Knights;
                row +=1;
                if(cb.makeMove(row, col)){
                    KnightParade successor = new KnightParade(size,deepCopy);
                    successors.add(successor);
                }
            }
        }
        return successors;

    }

    // I know this is supposed to make it so that I can ge tthe last
    // correct move set.
    @Override
    public boolean isValid() {
        if(cb.makeMove(row, col)){
            return true;
        }
        return false;
    }

    // Is goal function
    @Override
    public boolean isGoal() {
        return this.isValid();
    }

    @Override
    public String toString() {
        return cb.toString();
    }

    // public void run(Chessboard board, int size){
    //     board.makeMove(0, 0);
    //     int row = 0;
    //     int col = 0;
    //     for(int i = 0; i<size*size; i++){
    //         if(board.makeMove(row+1, col+2)){
    //             row += 1;
    //             col += 2;
    //         }else if(board.makeMove(row+2, col+1)){
    //             row += 2;
    //             col += 1;
    //         }
    //     }
    // }

    // I attempted to use this, btu didn't know where ti should've gone, I tried
    // is valid, but that didn't work either.
    // if(cb.makeMove(row+1, col+2) && row+1 < size && col+2 <size){
    //     row += 1;
    //     col += 2;
    //     return true;
    // }else if(cb.makeMove(row+2, col+1) && row+2 < size && col+1 <size){
    //     row += 2;
    //     col += 1;
    //     return true;
    // }else if(cb.makeMove(row+2, col-1) && row+2 < size && col-1 > 0){
    //     row += 2;
    //     col -= 1;
    //     return true;
    // }else if(cb.makeMove(row-2, col+1) && row-2 > 0 && col+1 < size){
    //     row -= 2;
    //     col += 1;
    //     return true;
    // }else if(cb.makeMove(row-2, col-1) && row-2 > 0 && col-1 >0){
    //     row -= 2;
    //     col -= 1;
    //     return true;
    // }else if(cb.makeMove(row-1, col-2) && row-1 > 0 && col-2 >0){
    //     row -= 1;
    //     col -= 2;
    //     return true;
    // }else if(cb.makeMove(row+1, col-2) && row+1 < size && col-2 >0){
    //     row += 1;
    //     col -= 2;
    //     return true;
    // }else if(cb.makeMove(row-1, col+2) && row-1 > 0 && col+2 <size){
    //     row -= 1;
    //     col += 2;
    //     return true;
    // }
    // return true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size");
        int n = scanner.nextInt();

        KnightParade config = new KnightParade(n);
        Backtracker bt = new Backtracker(true);
        Configuration solution = bt.solve(config);
        if(solution == null){
            System.out.println("no solution");
        }else{
            System.out.println(solution);
        }
        
        scanner.close();
    }
}
