public class Customer {
    private String ticket;
    private boolean priority;

    public Customer (int number, String ticket, boolean priority) {
        this.ticket = ticket;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return ticket + (priority ? " (Priority)" : " (Normal)");
    }
}
