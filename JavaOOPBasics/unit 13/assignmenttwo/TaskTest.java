package assignmenttwo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class TaskTest {
    // A big test that jsut checks if the greedly algorithm 
    // takes in all the elements of a lsit first come first server based
    // on it's amount of time left available

    // It asserts each index of the list we get from running the greedy algorithm is
    // the same as teh expected list.
    @Test
    public void testTask(){
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Sweep", 1));
        tasks.add(new Task("project", 3));
        tasks.add(new Task("eat", 2));
        tasks.add(new Task("Sleep", 8));
        tasks.add(new Task("anime", 3));
        tasks.add(new Task("jog", 2));
        tasks.add(new Task("walk", 3));

        List<Task> expected = new ArrayList<>();
        expected.add(new Task("Sweep", 1));
        expected.add(new Task("project", 3));
        expected.add(new Task("eat", 2));
        expected.add(new Task("jog", 2));

        List<Task> actual = Task.greedy(tasks, 8);
        assertEquals(expected.get(0).toString(), actual.get(0).toString());
        assertEquals(expected.get(1).toString(), actual.get(1).toString());
        assertEquals(expected.get(2).toString(), actual.get(2).toString());
        assertEquals(expected.get(3).toString(), actual.get(3).toString());
    }
}
