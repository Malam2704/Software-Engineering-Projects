package ds;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public abstract class QueueTest {
    
    public abstract Queue<String> makeQueue();
    
    @Test
    public void create(){
        // Setup - none

        // Invoke
        Queue q = makeQueue();

        // analyze
        assertEquals(0, q.size());
    }

    @Test
    public void EnqueueDequeueOne(){
        // Setup - none
        Queue q = makeQueue();
        String value = "abc";
        // Invoke
        q.enqueue(value);

        // analyze
        assertEquals(1, q.size());
        assertEquals(value, q.dequeue());
        assertEquals(0, q.size());
    }

    @Test
    public void EnqueueDequeueThree(){
        // Setup - none
        Queue q = makeQueue();
        String value = "abc";
        // Invoke
        q.enqueue(value);

        // analyze
        assertEquals(1, q.size());
        assertEquals(value, q.dequeue());
        assertEquals(0, q.size());
    }

    @Test
    public void EnqueDequqeLots(){
        // Setup - none
        Queue q = makeQueue();
        String[] values = {"abc","def","ghi","jkl","mno"};
        // Invoke
        q.enqueue(values[0]);
        q.enqueue(values[1]);
        q.enqueue(values[2]);
        q.enqueue(values[3]);
        q.enqueue(values[4]);

        // analyze
        assertEquals(5, q.size());
        assertEquals(values[0], q.dequeue());
        assertEquals(4, q.size());
        assertEquals(values[1], q.dequeue());
        assertEquals(3, q.size());
        assertEquals(values[2], q.dequeue());
        assertEquals(2, q.size());
        assertEquals(values[3], q.dequeue());
        assertEquals(1, q.size());
        assertEquals(values[4], q.dequeue());
        assertEquals(0, q.size());
    }
}
