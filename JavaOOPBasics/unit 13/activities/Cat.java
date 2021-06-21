package activities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Cat implements Comparable<Cat>{
    private final String name;
    private final String furColor;
    private int evilRating;

    public Cat(String name, String furColor, int evilRating){
        this.name = name;
        this.evilRating = evilRating;
        this.furColor = furColor;

        if(evilRating < 9){
            throw new IllegalArgumentException("Invalid evil rating");
        }
    }

    public int getEvilRating() {
        return evilRating;
    }

    @Override
    public int compareTo(Cat o) {
        // Return < 0 if this comes before o
        // return == 0 if is equal to o
        // return > 0 if this come after o
        return name.toLowerCase().compareTo(o.name.toLowerCase());
    }

    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Cutie", "Calico", 9));
        cats.add(new Cat("Butie", "Calizo", 10));
        cats.add(new Cat("Sutie", "Calido", 9));
        cats.add(new Cat("Autie", "Calito", 10));

        Collections.sort(cats);
        for(Cat cat: cats){
            System.out.println(cat.name);
        }
    }
}
