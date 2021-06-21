package knights;

import java.util.List;
import java.util.Scanner;

import graphs.AdjacencyGraph;
import graphs.Graph;

public class KnightMoves {
    public static Graph<Square> makeBoard(int rows, int cols) {
        Graph<Square> board = new AdjacencyGraph<>();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                Square square = new Square(i, j);
                board.add(square);
            }
        }
        return board;
    }

    // A function which is supposed to loop until we find all the coordinates possible for the 
    // Graph we are goign to fill, going, by 2 a combiantion of 1 and 2 rows fornt and back for
    //  each piece of the square
    public static void fillGraph(int row, int column, Graph<Square> board){
        Square an_square = new Square(row, column);
        board.add(an_square);
        while(true){
            Square a = new Square(row+1, column+2);
            Square b = new Square(row+1, column-2);
            Square c = new Square(row-1, column-2);
            Square d = new Square(row-1, column+2);
            if(!board.connected(an_square, a)){
                board.connectUndirected(an_square, a);
            }
            if(!board.connected(an_square, b)){
                board.connectUndirected(an_square, b);
            }
            if(!board.connected(an_square, c)){
                board.connectUndirected(an_square, c);
            }
            if(!board.connected(an_square, d)){
                board.connectUndirected(an_square, d);
            }

            Set<Vertex<Square>> neighbors = an_square.getNeighbors();
                for(Square n: neighbors){
                    Square a = new Square(row+1, column+2);
                    Square b = new Square(row+1, column-2);
                    Square c = new Square(row-1, column-2);
                    Square d = new Square(row-1, column+2);
                    if(!board.connected(an_square, a)){
                        board.connectUndirected(an_square, a);
                    }
                    if(!board.connected(an_square, b)){
                        board.connectUndirected(an_square, b);
                    }
                    if(!board.connected(an_square, c)){
                        board.connectUndirected(an_square, c);
                    }
                    if(!board.connected(an_square, d)){
                        board.connectUndirected(an_square, d);
                    }
                }

            an_square = an_square.getNeighbors();
        }
    }

    // Main function
    public static void main(String[] args) {
        // Beware fo looping and the Scanner, in an old terminal might just 
        // keep on repeatign the same function when you click run, so you might need
        //  to amke a new terminal after you fix your scanner.
        Scanner scanner = new Scanner(System.in);
        int size = 0;
        
        while(size < 3){
            System.out.println("Enter the baord size"); 
            size = scanner.nextInt() - 1; 
            System.out.println("Size needs to be above 3!"); 
        }  
        System.out.println("Size is: " + size);  
        // This is important, before you use the scanner function again 
        // you need the scanner.nextLine
        scanner.nextLine();

        // Inititalizes row and columns to be entered
        int row1 = 0;
        int column1 = 0;
        int row2 = 0;
        int column2 = 0;
        String line = "";
        while(line != "quit"){
            // If the person has not written quit, then a loop will be played
            //  to collect the coordinates of the origin coordiantes and the path
            System.out.println("Enter the coordinates"); 
            line = scanner.nextLine(); 
            String[] tokens = line.split(" ");
            row1 = Integer.parseInt(tokens[0]);
            column1 = Integer.parseInt(tokens[1]);
            row2 = Integer.parseInt(tokens[2]);
            column2 = Integer.parseInt(tokens[3]);
            // Below is a conditional that checks if any of our rows or columns are below 
            // 0 or above the size, if so then error adn loops again
            if(row1 < 0 || row1 > size || row2 < 0 || row2 > size || column1 < 0 || column1 > size || column2 < 0 || column2 > size){
                System.out.println("Error invalid coordinates");
            }else{
                break;
            }
        }

        Square start = new Square(row1, column1);
        Square end = new Square(row2, column2);
        Graph<Square> board = makeBoard(size, size);
        // Graph<Integer> board = new Square.makeBoard();
        // Graph<Square> graphs = new AdjacencyGraph<>();
        // List<Square> path = graphs.dfPath(start, end);

        System.out.println(path);
    }
}
