public class Customer {
    private int number;
    private String ticket;
    private boolean priority;

    public Customer (int number, String ticket, boolean priority) {
        this.number = number;
        this.ticket = ticket;
        this.priority = priority;
    }

    public int getNumber() {
        return number;
    }

    public boolean isPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return ticket + (priority ? " (Priority)" : " (Normal)");
    }
}
