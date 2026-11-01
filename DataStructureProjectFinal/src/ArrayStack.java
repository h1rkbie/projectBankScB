// Stack (LIFO) built from array (automatically enlarge size when full size)

public class ArrayStack {
    private Customer[] data = new Customer[10];
    private int top = -1;

    // 0(1)
    public void push(Customer cus) {
        if (top == data.length - 1) {
            Customer[] bigger = new Customer[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                bigger[i] = data[i];
            }
            data = bigger;
        }
        data[++top] = cus;
    }
}
