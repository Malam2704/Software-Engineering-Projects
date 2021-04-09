// Just a test
package ds;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class myTest {
    @Test
    public void testHeapPQ(){
        // setup
        HeapPQ mine = new HeapPQ();
        int expected = 7;
        int expected2 = 1;
        int expected3 = 2;

        // invoke
        mine.enqueue(5);
        mine.enqueue(1);
        mine.enqueue(2);
        mine.enqueue(4);
        mine.enqueue(7);
        mine.enqueue(3);
        mine.enqueue(1);

        int actual = mine.size();
        int actual2 = mine.dequeue();
        int actual3 = mine.dequeue();

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void testlistPQ(){
        // setup
        ListPQ mine = new ListPQ();
        int expected = 7;
        int expected2 = 1;
        int expected3 = 2;

        // invoke
        mine.enqueue(5);
        mine.enqueue(1);
        mine.enqueue(2);
        mine.enqueue(4);
        mine.enqueue(7);
        mine.enqueue(3);
        mine.enqueue(1);

        int actual = mine.size();
        int actual2 = mine.dequeue();
        int actual3 = mine.dequeue();

        // analyze
        assertEquals(expected, actual);
    }
}
