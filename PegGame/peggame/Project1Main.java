// Mohammed Alam, Zach Mongomery, Derian Stenglein
// Our Group, named Bobby's group of course made
//  a peg game with our combined knowledge of java
// classes and functions from our intesive class routine.

package peggame;

import java.util.Scanner;

public class Project1Main {
    // Below is a main function which asks for a filename
    // to start with, the runs an in stance of our game.
    public static void main(String[] args) throws PegGameException{
        System.out.println("Welcome to the Peg Game, a game made a board of pegs, " +
            "where you have to take each peg out by moving 2 spaces in any direction " +
            "just like checkers\nNow in the data directory there are many board sizes, so " + 
            "take your pick.\n");
        System.out.println("type 'help' anytime for more information\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("ENTER FILENAME: ");
        String userInput = scanner.nextLine();
        PegGame game = GameReader.readGame(userInput);
        CommandLine.playGame(game, userInput);
        scanner.close();
    }
}
