// Mohammed Alam, assignemnt 7.2
// My goal for this assignemnt is to make 2 modules, add
// all of the modules to make it so that a travleing Salesman can
// find the best path to take going form city to city usign the Nearest
// Neighbors algorithm
package graphs;

public class City {
    // fields
    private final String name;
    private final String state;
    private final double latitude;
    private final double longitude;

    // implements city,a dn a default so that I can have empty cities
    //  so that I can have empty cities to set into different cities form the list,
    // i.e. comapre cities without the lat and lon being entered.
    public City(String name, String state, double lat, double lon){
        this.name = name;
        this.state = state;
        this.latitude = lat;
        this.longitude = lon;
    }
    public City(){
        this.name = null;
        this.state = null;
        this.latitude = 0;
        this.longitude = 0;
    }

    // Getters
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public String getName() {
        return name;
    }
    public String getState() {
        return state;
    }

    // Hasign adn equal to functions,
    // al9ogn with the distance formula finder
    // which just returns the distance formula of thsi city adn another city.
    @Override
    public int hashCode() {
        return (int) Math.pow(latitude, longitude);
    }

    public double distanceFrom(City other){
        double first = Math.pow((latitude - other.getLatitude()), 2);
        double second = Math.pow((longitude - other.getLongitude()), 2);
        return Math.pow((first + second), 0.5);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof City){
            return ((City)obj).getLatitude() == latitude && ((City)obj).getLongitude() == longitude;
        }
        return false;
    }

    // Tostirng like asked
    @Override
    public String toString() {
        return "[" + name + ", " + state + "]";
    }

}
