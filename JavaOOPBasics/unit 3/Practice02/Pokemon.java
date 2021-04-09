// Mohammed Alam, 3.1
/* My job here was to make a pokemon class that would simply follwo the isntructiosn of
the document provided,all I need to do is haev your accesors and mutators for changeable fields
such as names and levels, and only accesors for permanent fields such as the pokemon's type. 
It's also includign an enumeration for the Pokemon Type so it's as limited as it gets, protecting
the changeable fields.
*/

package Practice02;

import java.lang.System.Logger.Level;

public class Pokemon {
    // fields below, changeable are just protected, nto privatized and finalized.
    protected String name;
    private final PokemonType type;
    protected int level;

    // Instances of a poekmon class can be made with or without a level.
    public Pokemon(String name, PokemonType type, int level){
        this.name = name;
        this.type = type;
        this.level = level;
    }

    public Pokemon(String name, PokemonType type){
        this.name = name;
        this.type = type;
        this.level = 1;
    }

    // Your accesors here for all your necessary fields, and mutators
    // incase you want to level up your porkemnon or change their name
    public String getName() {
        return name;
    }

    public void Rename(String name){
        this.name = name;
    }

    public PokemonType getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public void Levelup(){
        this.level++;
    }

    // Over ride fucntion shoudln't have to be empyty becuase this is all it should
    // do when trying to pritn a stringified verison of the Class
    @Override
    public String toString() {
        return ("Name: " + this.name
            + ", Type: " + this.type + ", Level: " + this.level);
    }

    // This is just your boolean equals to check if the parameter is an instance
    // of the Pokemon class, if not prints out a message and automatically returns false
    // If it is an instance, then it will return whatever both of the Pokemons you're comparing
    // class types and levels
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Pokemon){
            Pokemon other = (Pokemon)obj;

            return ((this.getType() == other.getType()) && (this.getLevel() == other.getLevel()));
        }else{
            System.out.println("Not pokemon!");
            return false;
        }
    }

}
