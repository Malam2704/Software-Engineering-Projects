package bt;

public class Pokedex {
    public static void main(String[] args) {
        BinaryNode pokedex = new BinaryNode(7);

        pokedex.binaryInsert(10);
        pokedex.binaryInsert(34);
        pokedex.binaryInsert(31);
        pokedex.binaryInsert(90);
        pokedex.binaryInsert(45);
        pokedex.binaryInsert(36);
        pokedex.binaryInsert(67);
        pokedex.binaryInsert(26);
        pokedex.binaryInsert(39);
        pokedex.binaryInsert(28);
        pokedex.binaryInsert(14);
        System.out.println(pokedex.infixTraversal());
    }
}
