// This is a square class, the data structure that will store our coordiantes in the baord
package knights;
import java.lang.Math;
import java.util.HashMap;
import java.util.Map;

import graphs.Graph;
import graphs.AdjacencyGraph;

public class Square {
    private int row;
    private int col;

    public Square(int row, int col) {
        this.row = row;
        this.col = col;
    }

    // The equals fucntion to comapre squares, and check if they ahve the rsame
    // row or column coordinates
    @Override
    public boolean equals(Object o) {
        if(o instanceof Square) {
            Square other = (Square)o;
            return this.row == other.row && this.col == other.col;
        } else{
        return false;
        }
    }

    // Hash fucntion which just returns the row to the power of the column
    @Override
    public int hashCode() {
        return row^col;
    } 

    // Main fucniton Bobby said to test the Squares function, it works
    public static void main(String[] args) {
        Map<Square,String> squares = new HashMap<>();
        Square one = new Square(4, 5);
        squares.put(one, "whatever");

        Square two = new Square(4, 5);
        // should be true
        System.out.println(squares.containsKey(two));
    }

}
