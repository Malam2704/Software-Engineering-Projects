package knapsack;

import java.util.Comparator;

public class PPPComparator implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        double pp1 = (double)o1.getValue() / o1.getWeight();
        double pp2 = (double)o2.getValue() / o2.getWeight();

        if(pp1 <= pp2){
            return -1;
        }else{
            return 1;
        }
    }
}
