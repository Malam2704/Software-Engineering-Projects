package activities;

import java.util.Comparator;

public class EvilComparator implements Comparator<Cat> {

    @Override
    public int compare(Cat o1, Cat o2) {
        // TODO Auto-generated method stub
        return o2.getEvilRating() - o1.getEvilRating();
    }
    
}
