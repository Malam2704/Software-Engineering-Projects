package assignment;
import org.graalvm.compiler.graph.Graph;

import graphs.*;

public class Word {

    // Function to make the actual weighted graph of
    // letters, and just returns it with adding all the letters
    // A - Z
    public static WGraph<String> makeLetters(){
        WGraph<String> letters = new WAdjacencyGraph<>();
        letters.add("A");
        letters.add("B");
        letters.add("C");
        letters.add("D");
        letters.add("E");
        letters.add("F");
        letters.add("G");
        letters.add("H");
        letters.add("I");
        letters.add("J");
        letters.add("K");
        letters.add("L");
        letters.add("M");
        letters.add("N");
        letters.add("O");
        letters.add("P");
        letters.add("Q");
        letters.add("R");
        letters.add("S");
        letters.add("T");
        letters.add("U");
        letters.add("V");
        letters.add("W");
        letters.add("X");
        letters.add("Y");
        letters.add("Z");
        return letters;
    }

    public static void main(String[] args) {
        WGraph<String> letters = makeLetters();
        // I'm using the word COBALT
        // Connects the words we are going to use
        // in cobalt, C,O,B,A,L,T, to three other
        // letters of different wiehgts, where
        // each fo the letters are connected to each
        // other as the minimal weighted option fo all three.
        letters.connect("C", "O", 1);
        letters.connect("C", "Z", 2);
        letters.connect("C", "D", 3);
        letters.connect("O", "B", 1);
        letters.connect("O", "R", 2);
        letters.connect("O", "T", 10);
        letters.connect("B", "A", 1);
        letters.connect("B", "E", 2);
        letters.connect("B", "I", 3);
        letters.connect("A", "L", 1);
        letters.connect("A", "B", 2);
        letters.connect("A", "T", 3);
        letters.connect("L", "T", 1);
        letters.connect("L", "G", 2);
        letters.connect("L", "F", 3);

        // Prints the result formt eh dijkstra's algorithm for the 
        // first nd last words C and T.
        System.out.println(letters.dijkstrasPath("C", "T"));
    }
}
