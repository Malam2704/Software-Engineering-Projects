package graphs;

public class Queen {
    private int row;
    private int col;

    public Queen(int row, int col){
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
        return "Queen{ " + row + ", " + col + "}";
    }

    public boolean canAttack(Queen enemy){
        // Can tell us if they're in the same row
        int rowDiff = this.row - enemy.row;
        // Can tell us if they're in the same column
        int colDiff = this.col - enemy.col;

        return rowDiff == 0 || colDiff == 0 || rowDiff == colDiff || rowDiff == -colDiff;
    }
}
