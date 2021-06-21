// Mohammed Alam 5.1
// FOr this one I had to create  panda class which takes in a wepaon
// as a parameter and stirng name. I had to construct the animal and make
// a strike function which returns an attack made by the panda depending on
// the wepon it has
package kfp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Panda<E>{
    private E weapon;
    private String name;

    // constructor
    public Panda(E weapon, String name){
        this.weapon = weapon;
        this.name = name;
    }

    // if flower returns tostring(), if Naginate returns it's static attack()
    // else if it's the Fist returns the static combo()
    public void strike() {
        if(weapon instanceof Naginata){
            System.out.println(Naginata.attack());
        }else if(weapon instanceof Fist){
            System.out.println(Arrays.toString(Fist.combo()) );
        }else if(weapon instanceof Flowers){
            System.out.println(weapon);
        }
    }

    // A unique fucntion we had to make using JCF, where we reutnr
    // an array list based on names we made a set from.
    // We used the set toget unique names and turn that hash set into
    // an array list
    public static ArrayList<String> unique(String[] names){
        HashSet new_list = new HashSet<>();
        for(String i: names){
            new_list.add(i);
        }
        ArrayList<String> my_list = new ArrayList<>(new_list);
        return my_list;
    }
}
