package graphs;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// Question5 JavaDoc: So the reason why Dijkstra's algorithm can't be used 
// becuase time complexity, we jsut want to get from point a to point B,
// and the fact that we have so many cities, we'd have to gon on form eahc fo the cities
// and have to count the weight of all the cities in the path, adn ti would be exponenetial
// in time complexity, so the fact that it wuld cost a lot more would ahve an effect
// on the Dijkstra, and Nearest Neighbors is fine with it.
public class TravelingSalesman {
    public static void main(String[] args){
        // Try and cathc to check if the file can be read
        try{
            // Step 3a
            // Buffered reader beign made to add allt eh cities
            // in the CSV to a linked List of all cities.
            FileReader fr = new FileReader("graphs/52cities.csv");
            BufferedReader reader = new BufferedReader(fr);
            List<City> cities = new ArrayList<>();
            reader.readLine();

            // Brekas if the lien is null
            while(true){
                String line = reader.readLine();
                if(line == null){
                    break;
                }
                // Parameterizes by doubling the 3rd and 4th token
                String[] tokens = line.split(",");
                double lat = Double.parseDouble(tokens[2]);
                double lon = Double.parseDouble(tokens[3]);
                City aCity = new City(tokens[0], tokens[1], lat, lon);
                cities.add(aCity);
            }

            // Step 3b
            // Makes a weighted graph and adds all of the cities
            // in our list of cities to that graph
            WGraph<City> myGraph = new WAdjacencyGraph<>();
            for(City n: cities){
                myGraph.add(n);
            }

            // does this for connecting all the cities,
            // but with conditionals to check if the cities aren't already
            // connected, or if it's the same city.
            for(City i: cities){
                for(City j: cities){
                    if(!myGraph.connected(i, j) || i == j){
                        myGraph.connect(i, j, i.distanceFrom(j));
                    }
                }
            }

            // Step 4
            // Loop to mathc the expected output, so that the 
            // scanner reads the origin city and destination city.
            while(true){
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter the origin city");
                String oCity = scanner.next();
                System.out.println("Enter the destination city");
                String dCity = scanner.next();
                if(oCity.isBlank() || dCity.isBlank()){
                    System.out.println("Goodbye!");
                    break;
                }else{
                    // Splites the input into a list of city name and state
                    // and sets up booleans that make it if the list of cities
                    // contains either the origin city or destination city.
                    String[] tokenO = oCity.split(",");
                    String[] tokenD = dCity.split(",");
                    boolean containsO = false;
                    boolean containsD = false;
                    City originCity = new City();
                    City destinationCity = new City();
                    // for loop around cities, but checks if and of the cities
                    // are the origin or destination
                    for(City k : cities){
                        System.out.println(k);
                        System.out.println(Arrays.toString(tokenO));
                        if(k.getName() == tokenO[0].toString() && k.getState() == tokenO[1].toString()){
                            containsO = true;
                            originCity = k;
                        }else if(k.getName() == tokenD[0] && k.getState() == tokenD[1]){
                            containsD = true;
                            destinationCity = k;
                        }
                    }
                    // for(int e=0; e<cities.size(); e++){
                    //     if(cities[e].getName() == tokenO[0] && cities[e].getState() == tokenO[1]){
                    //         containsO = true;
                    //         originCity = cities[e];
                    //     }else if(cities[e].getName() == tokenD[0] && cities[e].getState() == tokenD[1]){
                    //         containsD = true;
                    //         destinationCity = cities[e];
                    //     }
                    // }

                    // After the whoel for loop going through all the cities
                    // The contains booleans are checked and if the city was not
                    // found a message is given out, to try again.
                    if(containsO == false){
                        System.out.println(oCity + " is not found. Try again.");
                    }else if(containsD == false){
                        System.out.println(dCity + " is not found. Try again.");
                    }else{
                        System.out.println(myGraph.nearestNeighbors(originCity, destinationCity));
                    }
                }
            }

            // Closes
            fr.close();
            reader.close();
        }catch(IOException j){
            System.out.println("dude, file can't be read");
        }
        
    }
}
