package peggame;

public class Location{
    private int row;
    private int col;
    private boolean isEmpty;

    public Location(int row, int col){
        this.row = row;
        this.col = col;
        this.isEmpty = true;
    }

    public int getRow(){
        return this.row;
    }
    public int getCol() {
        return this.col;
    }
    
    // We added an empty field which tells us if a
    // Peg is on the location.
    public boolean getIsEmpty() {
        return this.isEmpty;
    }

    // Fill and clear methods which are called by the Board class
    // to change it if a locations gains a peg, or no longer has one.
    public void fill() {
        if(isEmpty) {
            this.isEmpty = false;
        }
    }

    public void clear() {
        if(!isEmpty) {
            this.isEmpty = true;
        }
    }

    @Override
    public int hashCode() {
        return (int) Math.pow(row, col);
    }

    @Override
    public String toString() {
        return "Location{row = " + row + ", col = " + col + " is empty: " + isEmpty + "}";
    }
}