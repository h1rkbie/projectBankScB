import java.util.ArrayList;

public class QueueSearch {

    private ArrayList<Customer> queue;

    public QueueSearch(ArrayList<Customer> queue) {
        this.queue = queue;
    }

    //Linear Search Best 0(1), Worst 0(n)
    public void LinearSearch(int number) {
        int steps = 0;

        for(int i = 0; i < queue.size(); i++) {
            steps++;

            if (queue.get(i).getNumber() == number) {
                System.out.println(">> [Found by Linear Search] : " + queue.get(i) + " (Using " + steps + " steps)");
                return;
            }
        }
        System.out.println(">> [(Linear Search) Queue number not found] : " + number + " (Using " + steps + " steps)");
    }

    // Binary Search 0(log n)
    public void BinarySearch(int number) {
        int low = 0, high = queue.size() - 1, steps = 0;

        while (low <= high) {
            steps++;
            int mid = (low + high) / 2;
            int midNumber = queue.get(mid).getNumber();

            if (midNumber == number) {
                System.out.println(">> [Found by Binary Search] : " + queue.get(mid) + " (Using " + steps + " steps)");
                return;
            } else if (midNumber < number) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(">> [(Binary Search) Queue number not found] : " + number + " (Using " + steps + " steps)");
    }
}
