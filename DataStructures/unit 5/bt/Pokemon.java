package bt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Pokemon implements Comparable<Pokemon>{
    private final int number;
    private String name;

    public Pokemon(int number, String name){
        this.number = number;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return number + ": " + name;
    }

    @Override
    public int compareTo(Pokemon other) {
        return (other.number - this.number);
    }
    public static void main(String[] args) {
        List<Pokemon> pokedex = new ArrayList<>();
        pokedex.add(new Pokemon(7, "Squirtle"));
        pokedex.add(new Pokemon(25, "Pikachu"));
        pokedex.add(new Pokemon(4, "Charmander"));
        pokedex.add(new Pokemon(1, "Bulbasaur"));

        Collections.sort(pokedex, new PokemonComparator());

        System.out.println(pokedex);
    }
}
