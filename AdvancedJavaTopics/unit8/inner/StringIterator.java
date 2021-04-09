package inner;

import java.util.Iterator;

public class StringIterator implements Iterator<Character>{
    public String myString;
    private int index;

    public StringIterator(String string){
        this.myString = string;
        this.index = 0;
    }

    

    @Override
    public boolean hasNext() {
        // Has next will show us if there is anything next left
        // to iteratre, done so by checking if the current index
        // is  below the length of the stirng, which we are taking
        // a piece of.
        return index < myString.length();
    }

    @Override
    public Character next() {
        char c = myString.charAt(index);
        index++;
        return c;
    }

    public static Iterable<Character> iterableString(String string){
        return new Iterable<Character>(){
            @Override
            public Iterator<Character> iterator() {
                return new StringIterator(string);
            }
        };
    }

    public static void main(String[] args) {
        for( char c: iterableString("Foojdj")){
            System.out.println(c);
        }
    }
}
