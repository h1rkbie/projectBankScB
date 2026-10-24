import java.util.ArrayList;

public class CallQueueHistory {
    private ArrayStack stack = new ArrayStack();

    //Record the queue that has just been called -> push 0(1)
    public void record(Customer cus) {
        stack.push(cus);
    }

    public void undoCall(QueueSystem system) {
        Customer cus = stack.pop();

        if (cus == null) {
            System.out.println(">> No history to look back on.");
            return;
        }

        system.returnToBack(cus);
        System.out.println(">> Backslide: Queue " + cus + " back to the last of the queue again.");
    }

    // Recall the latest queue item -> peek 0(1)
    public void recallLast() {
        Customer cus = stack.peek();
        if (cus == null) {
            System.out.println(">> No queue number has been called yet.");
            return;
        }
        System.out.println(">> Repeat: Please, Queue Number:" + cus + " at the service counter");
    }
}
