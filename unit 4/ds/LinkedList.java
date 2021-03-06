// Mohammed Alam 4.2
// Well this activity was just a combiantion of the makign a List
// like the array list but using Nodes like we did to make Queues.
// I took a bit form both and combined them to get the List we've always used in Python

package ds;

import java.util.Iterator;

public class LinkedList<E> implements List<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    // Our consturctor belowe and our fields above
    public LinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public Iterator<E> iterator(){
        return new NodeIterator<>(head);
    }

    // Appending the value checks if size is 0 or not, if so
    // the head and tail nodes are that appended value
    // if not the tailvalue is goign to set a new node with our parameter
    // value, then the tail value will set it'self equal to that value by using tail.setNext()
    @Override
    public void append(E value){
        Node<E> node = new Node<>(value);
        if(size == 0){
            head = node;
            tail = node;
        }else{
            tail.setNext(node);
            // reference type is going to be set equal to the node we made
            // This node was initially set as the next node after the tail
            // it was always the last node, now it's jus tthe tail is being set to it.
            tail = node;
        }
        size++;
    }

    // Getting the value is primarily just a for loop that goes until
    // I is equal to the index, and returns whichever value that is.
    // I twill have a try and catch block where it will try to get the 
    // Next node, and if that's insufficeient an error is thrown. If that doens't happen
    // Then when I reaches the index it returns whichever value that it
    @Override
    public E get(int index) {
        Node<E> myval = head;
        for(int i=0; i<(index+1); i++){
            try{
                myval = myval.getNext();
            }catch(Exception j){
                throw new IndexOutOfBoundsException("Index doens't exist");
            }
        }
        return myval.getValue();
    }

    // For loop until index before our deisre one
    // We make a node out of our parameter value,
    //  and where the For loop ends, 1 index before, we do another set 
    //  next so we can set that node we initially made for that set next
    @Override
    public void set(int index, E value) {
        // Object value = elements[index];
        // E e = (E)value;
        // return e;
        Node<E> myval = head;
        Node<E> node = new Node<E>(value);
        for(int i=0; i<(index-1); i++){
            myval = myval.getNext();
        }
        myval.setNext(node);
    }

    // Just reutrns whatever the size of the list is
    @Override
    public int size(){
        return size;
    }
}
