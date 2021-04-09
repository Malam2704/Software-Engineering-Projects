package activities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import knapsack.Item;
import knapsack.Knapsack;
import knapsack.PPPComparator;

public class Greedy {
    public static List<Currency> makeChange(double price,double payment){
        // Take the price and subtract it, and then go through loops
        //  on how many ways we can subtract by 5 cents, or 1 dollar or anything what soever
        //  we go in order of hgihest bill, so 100 and then if our change is less than  that bill we stop using it,and
        //  we no longer add to our list
        // 
        // if cost > price:
        //      while(cost > price+100)
        //          cost - 100
        // Repeat this above with all denominattions
        double change = price - payment;
        List<Currency> currency = new ArrayList<>();

        while(Currency.DOLLAR.getValue() <= change){
            currency.add(Currency.DOLLAR);
            change -= Currency.DOLLAR.getValue();
        }
        while(Currency.QUARTER.getValue() <= change){
            currency.add(Currency.QUARTER);
            change -= Currency.QUARTER.getValue();
        }
        while(Currency.DIME.getValue() <= change){
            currency.add(Currency.DIME);
            change -= Currency.DIME.getValue();
        }
        while(Currency.NICKEL.getValue() <= change){
            currency.add(Currency.NICKEL);
            change -= Currency.NICKEL.getValue();
        }
        while(Currency.PENNY.getValue() <= change){
            currency.add(Currency.PENNY);
            change -= Currency.PENNY.getValue();
        }

        return currency;
    }

    public static void packItems(Knapsack knapsack, List<Item> items){
        // You get a spcific knapsack and you can make a metric,
        // such as dividing the price by weight, or weight per price
        //  and have whatever combiantion of items will give me the most.
        // by subtractign the cost each time the hgihest available weight per cost
        // item remains.

        // Sorts by weight
        Collections.sort(items, new PPPComparator());
        // while lsit si not empty
        while(items.size() > 0){
            // remove the first item in the list
            Item next = items.remove(0);
            // try to pack the next item
            knapsack.pack(next);
        }
    }
    public static void main(String[] args) {
        System.out.println(makeChange(5.65, 4.30));
    }
}
