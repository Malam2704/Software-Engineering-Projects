package parade;

public class Knight {
    private int row;
    private int col;
    private int number;

    public Knight(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int getCol() {
        return col;
    }
    public int getRow() {
        return row;
    }

    @Override
    public String toString() {
        return "Knight{ " + row + ", " + col + "}";
    }
}
