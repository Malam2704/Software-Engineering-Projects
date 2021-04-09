// // Mohammed Alam 2.2, just your avg Book class
// with privatized fields and other settings incase some parameters
// are not met, I haev getters setters, adn a testing moduel for this and patron class
// p.s. the count for numbe rof copies in the book, will eb used later
package assignment2;

import java.util.Scanner;

public class Book {
    private String title;
    private String author;
    private Boolean status;
    // Use this later
    private int count;

    // When a book is created by default it's already not checkout out
    public Book(String title, String author,int count){
        this.title = title;
        this.author = author;
        this.status = true;
        this.count = count;
    }
    public Book(String title, String author){
        this.title = title;
        this.author = author;
        this.status = true;
        this.count = 1;
    }
    public Book(String title){
        this.title = title;
        this.author = null;
        this.status = true;
        this.count = 1;
    }

    // your getters
    public String getTitle(){
        return this.title;
    }
    public String getAuthor(){
        return this.author;
    }
    public boolean getStatus(){
        return this.status;
    }
    // later
    public int getCount(){
        return this.count;
    }

    // your setters
    public boolean Return_book(){
        if(this.status == true){
            System.err.println("Book is not borrowed!");
            return false;
        }else{
            this.status = true;
            return true;
        }
    }
    public boolean Checkout(){
        this.status = false;
        return true;
    }
    // Use for later
    public void add_book(){
        this.count++;
    }
    public void subtract_book(){
        this.count = this.count - 1;
    }

    // Key methods
    @Override
    public String toString(){
        return (this.title + " by " + this.author+ " " + 
            this.count + " copies.");
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Book){
            Book other = (Book)obj;

            // Finish the code here
            return this.status.equals(other.status);
        }
        return false;
    }   
}
