// Just your basic classfication, heheh, "class"ification of the Patron who 
// will enter the library and get ready to checkout a book, there is a getter
// for the name and book that is checked out, fi there is no book checked out it prints
// and error line
package assignment2;

public class Patron {
    private String name;
    private Book checked_out_Book;

    public Patron(String name){
        this.name = name;
        this.checked_out_Book = null;
    }
    public Patron(String name, Book my_book){
        this.name = name;
        this.checked_out_Book = my_book;
    }

    // check out a book, setting the book to the Book class type form null
    public void checkout(Book a_book){
        this.checked_out_Book = a_book;
    }

    // if the checked_out_Book field is not empty/null it will trun it so,
    // if it's already null, then an error will be pritned.
    public void return_book(Book a_book){
        if((a_book instanceof Book) && (a_book == this.checked_out_Book)){
            this.checked_out_Book = null;
        }else{
            System.err.println("IllegalArgumentException");;
        }
    }

    // Getters and Setters
    public String getName(){
        return this.name;
    } 
    public Book getChecked_out_book(){
        return checked_out_Book;
    }

    @Override
    public String toString(){
        if(this.checked_out_Book != null){
            return ("Name: " + this.name +
            "Book: " + this.checked_out_Book.getTitle());
        }else{
            return ("Name: " + this.name +
            " has no book");
        }
    }
}
