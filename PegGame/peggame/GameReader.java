package peggame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GameReader {
    public static PegGame readGame(String filename){
        PegGame game = null;
        try{
            FileReader reader = new FileReader(filename);
            BufferedReader lineReader = new BufferedReader(reader);
            
            // This just turns our chars into integer values
            // for our row and column, to make our board,checks 
            // Length, and turns the chars into board lengths based on 
            // filenamesize.
            int row = 0;
            int col = 0;
            int size = 0;
            if(filename.length() == 12 || filename.length() == 14) {
                if(filename.length() == 12){
                    char rowChar = filename.charAt(5);
                    row = Integer.parseInt(String.valueOf(rowChar));
                    char colChar = filename.charAt(7);
                    col = Integer.parseInt(String.valueOf(colChar));
                } else {
                    char rowChar = filename.charAt(5);
                    char rowChar2 = filename.charAt(6);
                    row = Integer.parseInt(String.valueOf(rowChar) + String.valueOf(rowChar2));
                    char colChar = filename.charAt(8);
                    char colChar2 = filename.charAt(9);
                    col = Integer.parseInt(String.valueOf(colChar) + String.valueOf(colChar2));
                }
                Board myBoard =  new Board(row, col);
                // System.out.println(myBoard);
                // Number of beginning file
                lineReader.readLine();
                // Used to help us change the entirely empty Board,
                // by making a variable used to get the row.
                int currentRow = 0; 
                // System.out.println(myBoard);
                while(true){
                    // Make a variable for the current row, and then use that
                    // for location, so we can setPeg the current row, and the token index for column.
                    String line = lineReader.readLine();
                    if(line == null){
                        break;
                    }
                    // Splits each row to tokens and iterates over tokens
                    // checking if it's empty or not, changing th myboard too.
                    String[] tokens = line.split("");
                    // System.out.println(myBoard.getRow());
                    // System.out.println(myBoard.getRow());
                    // System.out.println(Arrays.toString(tokens));
                    for(int i=0; i<tokens.length; i++){
                        if(tokens[i].equals("o")){
                            Location specific = myBoard.getLocation(currentRow,i);
                            myBoard.setPeg(specific);
                        }
                    }
                    // we finished iterating a line, which is treated as
                    //  a row, so we go on to the next row.
                    currentRow += 1;
                    game = new RectangleGame(myBoard);
                }


                // Prints board
                System.out.println(myBoard);
            } else if(filename.length() == 10) {
                char sizeChar = filename.charAt(5);
                size = Integer.parseInt(String.valueOf(sizeChar));
                TriangleBoard triBoard = new TriangleBoard(size);
                // System.out.println(myBoard);
                // Number of beginning file
                lineReader.readLine();
                // Used to help us change the entirely empty Board,
                // by making a variable used to get the row.
                int currentRow = 0; 
                // System.out.println(myBoard);
                while(true){
                    // Make a variable for the current row, and then use that
                    // for location, so we can setPeg the current row, and the token index for column.
                    String line = lineReader.readLine();
                    if(line == null){
                        break;
                    }
                    // Splits each row to tokens and iterates over tokens
                    // checking if it's empty or not, changing th myboard too.
                    String[] tokens = line.split("");
                    // System.out.println(myBoard.getRow());
                    // System.out.println(myBoard.getRow());
                    // System.out.println(Arrays.toString(tokens));
                    for(int i=0; i<tokens.length; i++){
                        if(tokens[i].equals("o")){
                            Location specific = triBoard.getLocation(currentRow,i);
                            triBoard.setPeg(specific);
                        }
                    }
                    // we finished iterating a line, which is treated as
                    //  a row, so we go on to the next row.
                    currentRow += 1;
                    game = new TriangleGame(triBoard);
                }


                // Prints board
                System.out.println(triBoard);
            }
            lineReader.close();
        } catch (IOException e) {
            System.out.println("IO exception with: " + filename);
        }      
        return game;
    }
}
