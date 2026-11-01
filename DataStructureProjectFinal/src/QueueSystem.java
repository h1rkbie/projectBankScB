import java.util.ArrayList;

public class QueueSystem {
    private LinkedQueue NormalQueue = new LinkedQueue();
    private LinkedQueue PriorityQueue = new LinkedQueue();
    private ArrayList<Customer> allTickets = new ArrayList();
    private int counter = 0;

    public void pause(int ms) { // ms คือ หน่วย milliseconds
        try {
            Thread.sleep(ms);
        } catch (Exception ignored) {
        }
    }

    // Take a queue number -> Enqueue 0(1)
    public void takeTicket(boolean priority) {
        counter++;
        String ticket = (priority ? "P" : "A") + String.format("%03d", counter);
        Customer cus = new Customer(counter, ticket, priority);
        allTickets.add(cus);

        System.out.println("\n>> Issue a queue number: " + ticket);

        if (priority) {
            PriorityQueue.enqueue(cus);
        } else {
            NormalQueue.enqueue(cus);
        }
    }

    // Call a next queue -> dequeue 0(1) (If none queue are waiting, return cus)
    public Customer callNextQueue() {
        Customer cus = !PriorityQueue.isEmpty() ? PriorityQueue.dequeue() : NormalQueue.dequeue();

        if (cus == null) {
            System.out.println("\n>> None waiting queue");
        } else {
            System.out.println("\n>> Next, in line " + cus + " at the service counter");

            pause(2000);

            System.out.println(">> Repeat: Please, Queue Number : " + cus + " at the service counter");
        }
        return cus;
    }

    //Illustrate awaiting queue 0(n)
    public void DisplayQueues() {
        System.out.println("\n--- Priority Queue (" + PriorityQueue.size() + ") ---");
        PriorityQueue.printEntireQueue();
        System.out.println("--- Normal Queue (" + NormalQueue.size() + ") ---");
        NormalQueue.printEntireQueue();
    }

}
