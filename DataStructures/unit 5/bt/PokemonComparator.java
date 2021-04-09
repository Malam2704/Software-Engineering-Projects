package bt;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

public class PokemonComparator implements Comparator<Pokemon>{

    @Override
    public int compare(Pokemon o1, Pokemon o2) {
        String sym1 = o1.getName();
        String sym2 = o2.getName();
        return sym1.compareTo(sym2);
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
