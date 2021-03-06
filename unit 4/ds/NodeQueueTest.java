package ds;

import org.junit.platform.commons.annotation.Testable;

@Testable
public class NodeQueueTest extends QueueTest{
    @Override
    public Queue<String> makeQueue(){
        return new NodeQueue<String>();
    }
}
