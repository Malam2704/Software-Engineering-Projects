// Mohammed Alam, I tired my hardest, 2.2
// This one here I tried to make a Book array of the elngth of the library book list file
// then I 
/*
Idk, Im just too tired, ntohign's working, my scanner is glithcign otu for some reason adn so my tests failed
also Everythign should work, the onyl probelm there really is, is the fact that the scanner
isn't reading ym stuff as correctly.
*/
package assignment2;

import Book;
import java.util.Scanner;
import java.io.BufferedReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.io.FileReader;
import java.io.IOException;

public class Library {

    /* Below here takes the Book array amd ethrough main and sets it sot that
    it reads every line, and adds a instance of teh Book class create by the 
    file split string by comma*/
    public static void makeLibrary(Book[] shelf) throws IOException{
        try{
            // Remember use absolute filenames
            FileReader fr = new FileReader("assignment2/data/book_list.txt");
            BufferedReader reader = new BufferedReader(fr);
            int count_liner = -1;
            boolean done = false;

            while(done != true){
                String str_line = reader.readLine();
                if(str_line != null){
                    String[] line = str_line.split(",");
                    // System.out.println(Arrays.toString(line));
                    count_liner++;
                    if(line.length >= 2){
                        shelf[count_liner] = new Book(line[0],line[1]);
                    }else if(line.length == 1){
                        shelf[count_liner] = new Book(line[0]);
                    }
                    // System.out.println(shelf[count_liner]);
                }else{
                    done = true;
                }
            }

            // Remember when you're pritning an array itself use teh Arrays.toString
            // method, but if you are trying to print an index of a String or int array,
            // take it out.
            fr.close();
            reader.close();
        }catch(Exception j){
            System.err.println("uhoh");
        }
    }

    /* Below here si the checkout class, so that it checks the tital and author orvided
    with the shelves for parameters, and the getters are activated for the book shelf books, and if any of those
    books match the title and author in the parameter, the book will eb set the checked out and false, but this
    fucntion will return true becuase the book is allowed to be checked out */
    public static boolean Checkout(Book[] shelf,String title, String author){
        for(int i =0; i<shelf.length; i++){
            if((shelf[i].getTitle() == title) && (shelf[i].getAuthor() == author)){
                if(shelf[i].getStatus() == true){
                    shelf[i].Checkout();
                    System.out.println("Checked out!");
                    return true;
                }else{
                    System.out.println("This book is already borrowed");
                    return false;
                }
            }
        }
    }

    // Similar to the one abvoe just for returning, returs true if it can be returned
    // and false if it can't. Turns the check-out status fo the book to true, which means available
    public static boolean Return_book(Book[] shelf, String title, String author){
        for(int i =0; i<shelf.length; i++){
            if((shelf[i].getTitle() == title) && (shelf[i].getAuthor() == author)){
                shelf[i].Return_book();
                return true;
            }
        }
        return false;
    }

    // Important main fucntion where the book shelves of all the books is made
    // and the stupid scnnaer doesn't frickin work. 
    // ?Other than that it's supposed toa sk the user if they want to reutrn or checkout a book
    // and asks for the title and author. It then searches for them usign the checkout or return fucntions
    // which also ahve built in actions such as the return funcitons error ahdnlign incase a book
    // can't be reutrned again
    public static void main(String[] args) {
        // Important
        // Remember this
        // For the array of books dont use Object[], use the Book[]
        // becuase you are amkgin alost fo those
        Book[] shelf = new Book[263];
        try{
            makeLibrary(shelf);
        }catch(Exception j){
            System.out.println("Aghshs");
        }
        // System.out.println(Arrays.toString(shelf));
        Scanner scanner = new Scanner(System.in);
        System.out.println("What will you be doing? 1 for checkout, 2 for return: ");
        int answer = scanner.nextInt();
        System.out.println(answer);

        if(answer == 1){
            System.out.println("What's your first name, last name: ");
            String name = scanner.nextLine();
            Patron dude = new Patron("Dave");
            System.out.println("Enter the title: ");
            String answer_title = scanner.nextLine();
            System.out.println("Enter the author: ");
            String answer_author = scanner.nextLine();
            Checkout(shelf,answer_title,answer_author);
        }else if(answer == 2){
            System.out.println("Enter the title: ");
            String answer_title = scanner.nextLine();
            System.out.println("Enter the author: ");
            String answer_author = scanner.nextLine();
            Checkout(shelf,answer_title,answer_author);
        }
        
    }
}
