// Mohammed Alam, Zach Mongomery, Derian Stenglein
// Our Group, named Bobby's group of course made
//  a peg game with our combined knowledge of java
// classes and functions from our intesive class routine.

package peggame;

import java.util.Scanner;

public class Project1Main {
    // Below is a main function which asks for a filename
    //  to start with, the runs an in stance of our game.
    public static void main(String[] args) throws PegGameException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER FILENAME: ");
        String userInput = scanner.nextLine();
        PegGame game = GameReader.readGame(userInput);
        CommandLine.playGame(game, userInput);
        scanner.close();
    }
}
