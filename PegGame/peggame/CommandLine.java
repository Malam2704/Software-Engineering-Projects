/**
 * CommandLine class
 * handles user input to communicate with current Peg Game
 */

package peggame;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import backtracker.Backtracker;
import backtracker.Configuration;

public class CommandLine {
    public static void playGame(PegGame game, String filename) throws PegGameException {
        Random rng = new Random();

        game.changeGameState(GameState.IN_PROGRESS);

        Scanner scanner = new Scanner(System.in);

        /**
         * checks for new command until user types "quit"
         * other commands include
         *  
         */
        while(true) {
            System.out.print(">>");
            String command = scanner.nextLine();

            if(command.equals("quit")) {
                System.out.println("Are you sure (y/n): ");
                String confirm = scanner.nextLine();
                if(confirm.equals("y")) {
                    break;
                } else if(confirm.equals("n")) {
                    continue;
                }
            } else if(command.equals("help")) {
                //displays custom commands
                System.out.println("\nAvailable commands:" + "\n" +
                    "  help - displays this message"  + "\n" +
                    "  move r1 c1 r2 c2 - attempts to move a peg from r1 c1 to r2 c2 on the board."  + "\n" +
                    "  hint - displays an available successful move."  + "\n" +
                    "  quit - quits the game" + "\n" +
                    "  solve - runs a backtracking configuration to solve the files game"
                    );
            } else if(command.equals("hint")) {
                //gives user random possible move
                System.out.println("\nHINT:");
                List<Move> possibleMoves = (List<Move>) game.getPossibleMoves();
                int len = possibleMoves.size();
                if(len > 1) {
                    int randomIndex = rng.nextInt(len - 1);
                    Move hint = possibleMoves.get(randomIndex);
                    System.out.println(hint + "\n");
                } else {
                    System.out.println(possibleMoves);
                }
            } else if(command.equals("solve")) {
                // solves the puzzle for the user
                Configuration config = null;
                if(game instanceof TriangleGame){
                    config = new TriangleConfig(game);
                }
                else if(game instanceof RectangleGame){
                    config = new RectangleConfig(game);
                }
                Backtracker backtracker = new Backtracker(true);
                Configuration sol = backtracker.solve(config);
                if(sol == null) {
                    System.out.println("No solution.");
                } else {
                    System.out.println(sol);
                }
            } else {
                //checks for "move" as well as 4 following numbers
                //uses info to make move on PegGame
                String[] tokens = command.split(" ");
                if(tokens[0].equals("move") && tokens.length == 5){

                    int rowOne = Integer.parseInt(tokens[1]);
                    int rowTwo = Integer.parseInt(tokens[3]);
                    int colOne = Integer.parseInt(tokens[2]);
                    int colTwo = Integer.parseInt(tokens[4]);

                    Location from = new Location(rowOne, colOne);
                    Location to = new Location(rowTwo, colTwo);

                    Move playerMove = new Move(from, to);

                    game.makeMove(playerMove);
                    
                } else{
                    continue;
                }
            }

    
        }
        scanner.close();

        
    }
}
