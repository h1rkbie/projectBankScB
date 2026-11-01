import java.util.Scanner;

public class SCB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueSystem system = new QueueSystem();

        while (true) {
            System.out.println("\n==== SCB Bank Queue System ====");
            System.out.println("1. Take a queue number (Normal)");
            System.out.println("2. Take a queue number (Priority)");
            System.out.println("3. Call next queue");
            System.out.println("4. Display awaiting queue");
            System.out.println("5. Exit");
            int choice = readInt(sc);

            switch (choice) {
                case 1:
                    system.takeTicket(false); break;
                case 2:
                    system.takeTicket(true); break;
                case 3:
                    system.callNextQueue();
                    break;
                case 4:
                    system.DisplayQueues(); break;
                case 5:
                    System.out.println("\n==============================");
                    System.out.println("\t \"TERMINATED PROCESS\"");
                    System.out.println("==============================");
                    return;
                default:
                    System.out.println("\n=== \"INVALID CHOICE\" ===");
            }
        }
    }

    static int readInt(Scanner sc) {
        while (true) {
            System.out.print("Select an option: ");

            if (!sc.hasNextLine()) {
                return 5;
            }

            String line = sc.nextLine().trim();

            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println(">> Please, enter an integer number only.");
            }
        }
    }
}
