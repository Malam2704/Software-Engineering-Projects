// I used a LinkedList form the JCF to make a queue
// and this queue has the enqueue function which is made to sort by 
// priority order with my mods
package ds;

import java.util.LinkedList;

public class ListPQ implements Queue<Integer>{
    LinkedList<Integer> my_list;
    Integer prior_val;

    public ListPQ(){
        this.my_list = new LinkedList<>();
    }

    // sets the priority order and adds all the values when asked in that order.
    // if it's empty the first enqueue value is the midrange value comaprin th priority
    // then the list will appends to the end if the new vlaue is greater than tha priority value
    //  or add to the first when that value is  less than it.
    @Override
    public void enqueue(Integer value) {
        if(my_list.isEmpty()){
            prior_val = value;
        }
        // this.my_list.add(value);
        if(value >= prior_val){
            my_list.add(my_list.size(), value);
        }else{
            // my_list.add(my_list.indexOf(prior_val) + 1, prior_val);
            my_list.add(my_list.indexOf(prior_val), value);
        }
    }

    // returns the first value whcih was sorted in priority order with the enque method
    @Override
    public Integer dequeue() {
        return this.my_list.removeFirst();
    }

    // returns the length of the linked list
    @Override
    public int size() {
        return my_list.size();
    }

    // To string returns the list version of the to string method
    @Override
    public String toString() {
        return my_list.toString();    
    }

    // Main method
    public static void main(String[] args) {
        ListPQ mine = new ListPQ();
        System.out.println(mine);
        mine.enqueue(5);
        System.out.println(mine);
        mine.enqueue(1);
        System.out.println(mine);
        mine.enqueue(2);
        System.out.println(mine);
        mine.enqueue(4);
        System.out.println(mine);
        mine.enqueue(7);
        System.out.println(mine);
        mine.enqueue(3);
        System.out.println(mine);
        mine.enqueue(1);
        System.out.println(mine);
        System.out.println("size is " + mine.size());
        System.out.println(mine.dequeue());
        System.out.println(mine.dequeue());
        System.out.println(mine.dequeue());
        System.out.println(mine.dequeue());
        System.out.println(mine.dequeue());
    }
}
