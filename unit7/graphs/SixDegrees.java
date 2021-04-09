// Mohammed Alam, assignment 7.1,
// I amde a module that basically make 4 movies
//  with a bunch of actors, and atleast 1 actor is in multiple movies.
// I connect all actors to a movie they're in, and then run paths to see
// if a connection exists
package graphs;

import java.util.Arrays;
import java.util.List;

public class SixDegrees {
    public static void main(String[] args) {
        // Makes a graph that's empty
        Graph<String> movies = new AdjacencyGraph<>();
        
        // This is just repetitive, but takes in actors, and movies
        // connects the actors if they're in the movie
        // Before that adds all movies and actors to the graph
        String movie1 = "The Great Gatsby";
        String actor1 = "Tobey Maguire";
        String actor2 = "Leonardo Dicaprio";
        String actor3 = "Carey Mulligan";
        movies.add(movie1);
        movies.add(actor1);
        movies.add(actor2);
        movies.add(actor3);
        movies.connectUndirected(movie1, actor1);
        movies.connectUndirected(movie1, actor2);
        movies.connectUndirected(movie1, actor3);

        String movie2 = "Spider-man 2";
        String actor4 = "James Franco";
        String actor5 = "Stan Lee";
        movies.add(movie2);
        movies.add(actor4);
        movies.add(actor5);
        movies.connectUndirected(movie2, actor1);
        movies.connectUndirected(movie2, actor4);
        movies.connectUndirected(movie2, actor5);

        String movie3 = "Iron Man";
        String actor6 = "Robert Downey Jr.";
        String actor7 = "Mark Ruffalo";
        movies.add(movie3);
        movies.add(actor6);
        movies.add(actor7);
        movies.connectUndirected(movie3, actor5);
        movies.connectUndirected(movie3, actor6);
        movies.connectUndirected(movie3, actor7);

        String movie4 = "Black Panther";
        String actor8 = "Chadwick Boseman";
        String actor9 = "Michael B. Jordan";
        movies.add(movie4);
        movies.add(actor8);
        movies.add(actor9);
        movies.connectUndirected(movie4, actor5);
        movies.connectUndirected(movie4, actor8);
        movies.connectUndirected(movie4, actor9);

        System.out.println(movies.bfPath(actor1, actor9));
        System.out.println(movies.bfPath(actor4, actor8));
        System.out.println(movies.bfPath(actor7, actor4));
        System.out.println(movies.bfPath(actor5, actor2));

        // List<String> a_lList = Arrays.asList(actor1,actor9,actor8,actor5,actor4,actor6,actor7);
        // System.out.println(Mothers.findMothers(movies, a_lList));
    }
}
