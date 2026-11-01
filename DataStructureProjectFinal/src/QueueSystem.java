public class QueueSystem {
    private LinkedQueue normalQueue = new LinkedQueue();
    private LinkedQueue priorityQueue = new LinkedQueue();
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
        Customer cus = new Customer(ticket, priority);

        System.out.println("\n>> Issue a queue number: " + ticket);

        if (priority) {
            priorityQueue.enqueue(cus);
        } else {
            normalQueue.enqueue(cus);
        }
    }

    public void callNextQueue() {
        Customer cus = !priorityQueue.isEmpty() ? priorityQueue.dequeue() : normalQueue.dequeue();

        if (cus == null) {
            System.out.println("\n>> None waiting queue");
        } else {
            System.out.println("\n>> Next, in line " + cus + " at the service counter");

            pause(2000);

            System.out.println(">> Repeat: Please, Queue Number : " + cus + " at the service counter");
        }
    }

    //Illustrate awaiting queue 0(n)
    public void DisplayQueues() {
        System.out.println("\n--- Priority Queue (" + priorityQueue.size() + ") ---");
        priorityQueue.printEntireQueue();
        System.out.println("--- Normal Queue (" + normalQueue.size() + ") ---");
        normalQueue.printEntireQueue();
    }

}
