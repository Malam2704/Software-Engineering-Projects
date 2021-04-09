/*
Mohammed Alam 6.2, activity, 
This one is the hardest one yet and I don't undertand most of it, especially the 2nd half 
*/

package graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class GraphReader {
    public static Graph<String> readGraph(String filename) throws IOException{
        // Something stupid is going on with Buffered Reader, sometimes I 
        //  type it the exact same and ti decided not to work and throw an IO exception
        //  I wasted an hour for it, so now I'm jsut gonna use the template I created form assignment
        //  2.1 for Buffered Readers
        FileReader fr = new FileReader(filename);
        BufferedReader reader = new BufferedReader(fr);
        int number = 0;
        boolean done = false;
        Graph<String> a_graph = new AdjacencyGraph<String>();

        // While loop to read through the lines of the file
        while(done != true){
            // Turns the first line into a string
            String line = reader.readLine();
            // checks if that line exists in the file, and we didn't reach the end
            /*
            Really Important here, all fo this has to be in if else statements
            because buffered reader si going to go through all of ti no matter 
            what.

            If the line starts with # oir is null it skips the loops or ends it respecctively
            other wise ti will go on to connect values
            */
            if(line == null){
                done = true;
            }else if(line.charAt(0) == '#'){
                line = reader.readLine();
            }else{
                // System.out.println(line.charAt(0));

                try{
                    String[] tokens = line.split(" ");
                    // System.out.println(Arrays.toString(tokens));
                    String connector = tokens[0];
                    for(int i=1; i<tokens.length; i++){
                        a_graph.connectUndirected(connector, tokens[i]);
                    }
                }catch(Exception j){
                    line = reader.readLine();
                }
            }
        }

        fr.close();
        reader.close();

        return a_graph;
    }
}
