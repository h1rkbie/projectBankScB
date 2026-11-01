import java.util.ArrayList;

public class CallQueueHistory {
    private ArrayStack stack = new ArrayStack();

    //Record the queue that has just been called -> push 0(1)
    public void record(Customer cus) {
        stack.push(cus);
    }

}
