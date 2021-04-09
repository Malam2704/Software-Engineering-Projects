// Mohammed Alam, 5.,2 activity
// I tried to make a Binary Search Tree iwht the Pokemon comparators
// and replace the lsits funciton with Binary Search Trees which iomplemetn nodes
package bt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BinarySearchTree<E extends Comparable<E>>{
    private BinaryNode<E> root;
    private int size;

    // COmmon constructor
    public BinarySearchTree(E value){
        this.root = new BinaryNode<E>(value);
        this.size = 1;
    }

    // Basically the old infix notation but gives the Full version
    // along with the listed verison ordered by numbers
    @Override
    public String toString() {
        String eh = "";
        // left subtree into a string
        if(root != null){
            eh += root.infixTraversal();
        }
        // add the value, which is at teh middle
        eh += root + " ";

        // add the rights parts of the bianry tree
        if(root != null){
            eh += root.infixTraversal();
        }
        return eh;
    }

    // Basically takes the lenght of the stirng and divides by 2 to make up
    // for the empty spaces
    public int size(){
        return size;
    }

    // Search targets I tried doign both where I replaced my old code
    //  and used Bruce's function but its eh
    public boolean search(BinaryNode<E> node, E target){
        // if(target == node.getValue()){
        //     return true;
        // }else if(node.getValue().compareTo(target) < 1){
        //     return root != null ? node.search(target) : false;
        // }else{
        //     return root != null ? root.search(target) : false;
        // }
        if (node.getValue() == target) {
            return true;
        }
        if (node.getLeft() != null) {
            if (node.getLeft().search (target) == true) {
                return true;
            }
        }
        if (node.getRight() != null) {
            if (node.getRight().search (target)) {
                return true;
            }
        }
        return false;
    }

    public boolean search(E target){
        return search(root, target);
    }

    // Belwo are the insert methods that are organizngn by CompareTo-ing 
    // the node's values and the inserting value to see if they are less
    // or more so which specific node int eh binary tree can be predicted
    public void insert(BinaryNode<E> node, E value){
        if(node.getValue().compareTo(value) < 1){
            if(node.getLeft() != null){
                insert(node.getLeft(), value);
            }else{
                node.setLeft(new BinaryNode<E>(value));
                size++;
            }
        } else{
            if(node.getRight() != null){
                insert(node.getRight(), value);
            }else{
                node.setRight(new BinaryNode<E>(value));
                size++;
            }
        }
    }

    public void insert(E value){
        insert(root, value);
    }

    // Main function here turns the Lists to Bianry Search trees, and adds to inserts
    public static void main(String[] args) {
        BinarySearchTree<Pokemon> pokedex = new BinarySearchTree<>(new Pokemon(2, "Ivysaur"));
        pokedex.insert(new Pokemon(7, "Squirtle"));
        pokedex.insert(new Pokemon(25, "Pikachu"));
        pokedex.insert(new Pokemon(4, "Charmander"));
        pokedex.insert(new Pokemon(1, "Bulbasaur"));

        Pokemon eee = new Pokemon(7, "Squirtle");
        System.out.println(pokedex.size());
        System.out.println(pokedex.search(eee));
        System.out.println(pokedex);
    }
}
