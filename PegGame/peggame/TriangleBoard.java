package peggame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleBoard {
    private final int size;
    protected Location[][] myCoordinates;
    protected List<Location> pegs = new ArrayList<>();

    public TriangleBoard(int size){
        this.size = size;
        // makes a new 2d array based on size of the triangle board.
        this.myCoordinates = new Location[size][];
        // For loop for rows and columns, adding a new Row
        // to the 2d array, the iterating over it
        // to add new locations instead of null.
        for(int i=0; i<size; i++){
            myCoordinates[i] = new Location[i+1];
            for(int j=0; j<myCoordinates[i].length; j++){
                myCoordinates[i][j] = new Location(i, j);
            }
        }
    }

    public Location[][] getMyCoordinates() {
        return myCoordinates;
    }public List<Location> getPegList(){
        return pegs;
    }public int getSize() {
        return size;
    }

    /**
     * get locations
     * @param row amount of rows
     * @param col amount of columns
     * @return each possible location
     */
    public Location getLocation(int row, int col){
        for(Location[] j :myCoordinates){
            for(Location l : j){
                if(l.getRow() == row && l.getCol() == col){
                    return l;
                }
            }
        }
        return null;
    }

    // Puts a peg on the location
    public void setPeg(Location loc){
        loc.fill();
        pegs.add(loc);        
    }
    // clears a peg's location
    public void clearPeg(Location loc){
        loc.clear();
        pegs.remove(loc);
    }

    public void printBoard(){
        for(Location[] n : myCoordinates){
            System.out.println(Arrays.toString(n));
        }
    }

    // Make blank board
    // iterate through original board
    // get locations of original board and copy by i & j
    // fill copy if location is not empty on original board
    public TriangleBoard newBoard(){
        TriangleBoard copy = new TriangleBoard(this.size);
        for(Location[] j :myCoordinates){
            for(Location l : j){
                if(!l.getIsEmpty()){
                    Location loc = this.getLocation(l.getRow(), l.getCol());
                    Location loc2 = copy.getLocation(l.getRow(), l.getCol());
                    copy.setPeg(loc2);
                }
            }
        }
        return copy;
    }

    @Override
    public String toString() {
        String rowString = "";
        int rowNum = myCoordinates.length;
        for(Location[] j :myCoordinates){
            for(int i=0; i<rowNum; i++) {
                rowString += " ";
            }
            rowNum -= 1;
            for(Location l : j){
                if(!l.getIsEmpty()){
                    rowString += "o ";
                }else{
                    rowString += "- ";
                }
            }
            rowString += "\n";
        }
        return rowString;
    }

    public static void main(String[] args) {
        TriangleBoard triBoard = new TriangleBoard(5);
        //System.out.println(Arrays.toString(triBoard.getMyCoordinates()));
        triBoard.setPeg(triBoard.getLocation(2, 2));
        triBoard.printBoard();
        System.out.println(triBoard.getLocation(2, 2));
        System.out.println(triBoard);
        System.out.println(triBoard.newBoard());
        triBoard.setPeg(triBoard.getLocation(2, 1));
        System.out.println(triBoard.newBoard());
    }
}
