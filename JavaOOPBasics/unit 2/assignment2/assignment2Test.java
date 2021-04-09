package assignment2;
// Your basics tests to check if the first 2 parts work.
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class assignment2Test {
    @Test
    public void testtitle(){
        // setup
        Book my_book = new Book("The Great Gatsby","F. Scott Fitzgerald");
        String expected = "The Great Gatsby";
        // invoke
        String actual = my_book.getTitle();
        // Setup
        assertEquals(expected, actual);
    }

    @Test
    public void testauthor(){
        // setup
        Book my_book = new Book("The Great Gatsby","F. Scott Fitzgerald");
        String expected = "F. Scott Fitzgerald";
        // invoke
        String actual = my_book.getAuthor();
        // Setup
        assertEquals(expected, actual);
    }

    @Test
    public void testStatus(){
        // setup
        Book my_book = new Book("The Great Gatsby","F. Scott Fitzgerald");
        Boolean expected = true;
        // invoke
        Boolean actual = my_book.getStatus();
        // Setup
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckout(){
        // setup
        Book my_book = new Book("The Great Gatsby","F. Scott Fitzgerald");
        Boolean expected = false;
        // invoke
        my_book.Checkout();
        Boolean actual = my_book.getStatus();
        // Setup
        assertEquals(expected, actual);
    }

    @Test
    public void testReturn(){
        // setup
        Book my_book = new Book("The Great Gatsby","F. Scott Fitzgerald");
        Boolean expected = true;
        // invoke
        my_book.Checkout();
        my_book.Return_book();
        Boolean actual = my_book.getStatus();
        // Setup
        assertEquals(expected, actual);
    }

    @Test
    public void testEquals(){
        // setup
        Book my_book = new Book("The Great Gatsby","F. Scott Fitzgerald");
        Book a_book = new Book("The Lightning Thief","Rick Riordan");
        Boolean expected = true;
        // invoke
        Boolean actual = my_book.equals(a_book);
        // Setup
        assertEquals(expected, actual);
    }

    @Test
    public void testPatronName(){
        // setup
        Patron dude = new Patron("Dave");
        String expected = "Dave";
        // invoke
        String actual = dude.getName();
        // Setup
        assertEquals(expected, actual);
    }

    @Test
    public void testPatronCheckout(){
        // setup
        Patron dude = new Patron("Dave", new Book("The Great Gatsby","F. Scott Fitzgerald"));
        String expected = "The Great Gatsby";
        // invoke
        String actual = dude.getChecked_out_book().getTitle();
        // Setup
        assertEquals(expected, actual);
    }

    @Test
    public void Librarycheck(){
        Book[] shelf = new Book[263];
        Library.makeLibrary(shelf);
        String title = "Money";
        String author = "Martin Amis";
        boolean expected = true;

        boolean actual = Library.Checkout(shelf, title, author);

        assertEquals(expected, actual);
    }

    @Test
    public void Libraryreturn(){
        Book[] shelf = new Book[263];
        Library.makeLibrary(shelf);
        String title = "Money";
        String author = "Martin Amis";
        boolean expected = true;

        boolean actual = Library.Return_book(shelf, title, author);

        assertEquals(expected, actual);
    }

    @Test
    public void Librarycheckfalse(){
        Book[] shelf = new Book[263];
        Library.makeLibrary(shelf);
        String title = "Money";
        String author = "Martin Amis";
        boolean expected = true;

        boolean actual = Library.Checkout(shelf, "title", "author");

        assertEquals(expected, actual);
    }

    @Test
    public void Libraryreturnfalse(){
        Book[] shelf = new Book[263];
        Library.makeLibrary(shelf);
        String title = "Money";
        String author = "Martin Amis";
        boolean expected = false;

        boolean actual = Library.Return_book(shelf, "title", "author");

        assertEquals(expected, actual);
    }
}
