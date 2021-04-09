// Mohammed Alam assignment 7.1,
// For this I was supposed to find a mother vertex, or a vertex that can access
// all other vertices in a graph

// P.S. I tried finding all mother vertices, or all vertices that didn't break the 
//  loop and add them, but that never added the last index, so I just did the opposite.
package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mothers {

    public static List<String> findMothers(Graph<String> a_Graph, List<String> a_List){
        // I'm doing a list of letters that are not mothers
        List<String> not_mothers = new ArrayList<>();
        int num = 0;
        // I created an int, and made an iterable for loop
        // for the list parameter, which goes through another
        // for loop which checks if that orginal letter can be bf
        // search to all of the letters, if not then the whole loop will
        // break and add 1 to num, after the broken nested for loop
        // if num was added to, which means there was a bfsearchw hich didn't work out
        //  then ntoh mothers adds
        for(String n: a_List){
            for(String j: a_List){
                if(!a_Graph.bfSearch(n, j)){
                    System.out.println(n + j);
                    num = 1;
                    break;
                }
            }
            if(num == 1){
                not_mothers.add(n);
                num = 0;
            }
        }

        // goes through the parameter list, if they're all not in
        // not mothers it adds to mothers
        List<String> mothers = new ArrayList<>();
        for(String i: a_List){
            if(!not_mothers.contains(i)){
                mothers.add(i);
            }
        }

        return mothers;
    }

    public static void main(String[] args) {
        // Main function, here it just adds the first 5 letters
        //  and then connects it in teh way the diagram is shown
        Graph<String> first_list = new AdjacencyGraph<>();
        first_list.add("a");
        first_list.add("b");
        first_list.add("c");
        first_list.add("d");
        first_list.add("e");
        first_list.connectDirected("e","a");
        first_list.connectDirected("a","b");
        first_list.connectDirected("b","e");
        first_list.connectDirected("b","c");
        first_list.connectDirected("c","d");
        
        // Main function, here it just adds the last 7 letters
        // and then connects it in teh way the diagram is shown
        Graph<String> last_list = new AdjacencyGraph<>();
        last_list.add("z");
        last_list.add("y");
        last_list.add("x");
        last_list.add("w");
        last_list.add("v");
        last_list.add("t");
        last_list.add("u");
        last_list.connectDirected("x","t");
        last_list.connectDirected("x","u");
        last_list.connectDirected("t","v");
        last_list.connectDirected("z","u");
        last_list.connectDirected("z","y");
        last_list.connectDirected("y","w");
        last_list.connectDirected("y","x");
        last_list.connectDirected("w","t");


        List<String> a_lList = Arrays.asList("a","b","c","d","e");
        List<String> b_lList = Arrays.asList("t","u","v","w","x","y","z");
        System.out.println(Mothers.findMothers(first_list, a_lList));
        System.out.println(Mothers.findMothers(last_list, b_lList));
    }
}
