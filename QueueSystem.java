import java.util.ArrayList;

public class QueueSystem {
    private LinkedQueue NormalQueue = new LinkedQueue();
    private LinkedQueue PriorityQueue = new LinkedQueue();
    private ArrayList<Customer> allTickets = new ArrayList();
    private int counter = 0;

    // Take a queue number -> Enqueue 0(1)
    public void takeTicket(boolean priority) {
        counter++;
        String ticket = (priority ? "P" : "A") + String.format("%03d", counter);
        Customer cus = new Customer(counter, ticket, priority);
        allTickets.add(cus);
        if (priority) {
            PriorityQueue.enqueue(cus);
        } else {
            NormalQueue.enqueue(cus);
        }
        System.out.println(">> Issue a queue number: " + ticket);
    }

    // Call a next queue -> dequeue 0(1) (If none queue are waiting, return null)
    public Customer callNextQueue() {
        Customer cus = !PriorityQueue.isEmpty() ? PriorityQueue.dequeue() : NormalQueue.dequeue();

        if (cus == null) {
            System.out.println(">> None waiting queue");
        } else {
            System.out.println(">> Next, in line " + cus + " at the service counter");
        }
        return cus;
    }

    // Input a customer back to front of queue (Use undo) 0(1)
    public void returnToFront(Customer cus) {
        if (cus.isPriority()) {
            PriorityQueue.addFirst(cus);
        } else {
            NormalQueue.addFirst(cus);
        }
    }

    // Input a customer back to lastest of queue 0(1)
    public void returnToBack(Customer cus) {
        if (cus.isPriority()) {
            PriorityQueue.enqueue(cus);
        } else {
            NormalQueue.enqueue(cus);
        }
    }

    //Illustrate awaiting queue 0(n)
    public void DisplayQueues() {
        System.out.println("--- Priority Queue (" + PriorityQueue.size() + ") ---");
        PriorityQueue.printEntireQueue();
        System.out.println("--- Normal Queue (" + NormalQueue.size() + ") ---");
        NormalQueue.printEntireQueue();
    }

    public ArrayList<Customer> getAllTickets() {
        return allTickets;
    }

}
