// -------------- Queue as a Linked List (FIFO) ----------------
public class LinkedQueue {
    private Node head, tail;
    private int size = 0;

    // Append queue 0(1)
    public void enqueue(Customer c) {
        Node n = new Node(c);
        if (tail == null) {
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
        size++;
    }

    // Add in front of queue 0(1)
    public void addFirst(Customer c) {
        Node n = new Node(c);
        n.next = head;
        head = n;
        if (tail == null) {
            tail = n;
        }
        size++;
    }

    // take cue tip out 0(1)
    public Customer dequeue() {
        if (head == null) {
            return null;
        }

        Customer c = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return c;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // Illustrate the whole queue 0(n)
    public void printEntireQueue() {
        if (head == null) {
            System.out.println("(Don't have any queue left..)");
            return;
        }
        Node cur = head;
        System.out.println("Next queue : " + cur.data);   // คิวแรก
        cur = cur.next;

        while (cur != null) {
            System.out.println("Pending    : " + cur.data); // คิวที่เหลือ
            cur = cur.next;
        }
    }
}