import java.util.Scanner;

public class Main {
    static final int NO_INPUT = Integer.MIN_VALUE;

    static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.println(prompt);

            if (!sc.hasNextLine()) {
                return NO_INPUT;
            }

            String line = sc.nextLine().trim();

            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println(">> Please, enter an integer number only.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueSystem system = new QueueSystem();
        CallQueueHistory history = new CallQueueHistory();
        QueueSearch searcher = new QueueSearch(system.getAllTickets());

        while (true) {
            System.out.println("\n==== Bank Queue System ====");
            System.out.println("1. Take a queue number (Normal)");
            System.out.println("2. Take a queue number (Priority)");
            System.out.println("3. Call next queue");
            System.out.println("4. Display awaiting queue");
            System.out.println("5. Return a recently called queue");
            System.out.println("6. Call recent queue once more");
            System.out.println("7. Find a queue number");
            System.out.println("8. Exit");
            int choice = readInt(sc, "Select an option: ");

            if (choice == NO_INPUT) {
                choice = 8;
            }

            switch (choice) {
                case 1:
                    system.takeTicket(false); break;
                case 2:
                    system.takeTicket(true); break;
                case 3:
                    Customer called = system.callNextQueue();
                    if (called != null) {
                        history.record(called);
                    }
                    break;
                case 4:
                    system.DisplayQueues(); break;
                case 5:
                    history.undoCall(system); break;
                case 6:
                    history.recallLast(); break;
                case 7:
                    int n = readInt(sc, "Fill queue number (integer) : ");
                    if (n != NO_INPUT) {
                        searcher.LinearSearch(n);
                        searcher.BinarySearch(n);
                    }
                    break;
                case 8:
                    System.out.println("===============================");
                    System.out.println("\t\"TERMINATED PROCESS\"");
                    System.out.println("===============================");
                    return;
                default:
                    System.out.println("==> Invalid choice");
            }
        }
    }
}
