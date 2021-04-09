package peggame;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int col;
    private final int row;
    protected List<Location> myCoordinates = new ArrayList<>();
    protected List<Location> pegs = new ArrayList<>();

    public Board(int row, int col){
        this.row = row;
        this.col= col;
        // makes an empty board
        for(int i=0; i<row;i++){
            for(int j=0; j<col;j++){
                myCoordinates.add(new Location(i, j));
            }
        }
    }

    public int getCol() {
        return col;
    }
    public int getRow() {
        return row;
    }
    public List<Location> getPegList(){
        return pegs;
    }
    /**
     * get locations
     * @param row amount of rows
     * @param col amount of columns
     * @return each possible location
     */
    public Location getLocation(int row, int col){
        for(Location j :myCoordinates){
            if(j.getRow() == row && j.getCol() == col){
                return j;
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


    // Make blank board
    // iterate through original board
    // get locations of original board and copy by i & j
    // fill copy if location is not empty on original board
    public Board newBoard(){
        Board copy = new Board(this.row, this.col);
        for(int i = 0; i < this.row; i++){
            for(int j = 0; j < this.col; j++){
                Location loc = this.getLocation(i, j);
                System.out.println(loc + " " + i + " " + j);
                Location loc2 = copy.getLocation(i, j);
                System.out.println(loc2 + " " + i + " " + j);
                if(!loc.getIsEmpty()){
                    copy.setPeg(loc2);
                }
            }
        }
        return copy;
    }


    @Override
    public String toString() {
        String rowString = "";
        int currentRow = 0;
        for(Location n : myCoordinates) {
            if(n.getRow() == currentRow) {
                if(pegs.contains(n)) {
                    rowString += " || ";
                    rowString += "o";
                } else {
                    rowString += " || ";
                    rowString += "-";
                }
            } else {
                rowString += " || ";
                String dotter = "";
                for(int j=0; j<row+(5*(row)); j++){
                    dotter += "=";
                }
                rowString += "\n" + dotter;
                rowString += "\n";
                currentRow = n.getRow();
                if(pegs.contains(n)) {
                    rowString += " || ";
                    rowString += "o";
                } else {
                    rowString += " || ";
                    rowString += "-";
                }
            }
        }

        return rowString + " || ";
    }
}
