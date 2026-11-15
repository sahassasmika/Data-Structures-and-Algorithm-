/**
 * Stack implemented using a dynamically resizing array.
 * The array grows automatically when it becomes full.
 */
public class UnboundedArrayStack {
    private int[] elements;
    private int top;

    public UnboundedArrayStack() {
        elements = new int[2];
        top = -1;
    }

    public void push(int value) {
        if (top == elements.length - 1) {
            resize(elements.length * 2);
        }

        elements[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        int value = elements[top];
        elements[top] = 0;
        top--;

        // Reduce unused memory when the stack becomes small.
        if (elements.length > 2 && top + 1 <= elements.length / 4) {
            resize(Math.max(2, elements.length / 2));
        }

        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    private void resize(int newCapacity) {
        int[] newArray = new int[newCapacity];

        for (int i = 0; i <= top; i++) {
            newArray[i] = elements[i];
        }

        elements = newArray;
    }

    public static void main(String[] args) {
        UnboundedArrayStack stack = new UnboundedArrayStack();

        stack.push(08);
        stack.push(81);
        stack.push(39);
        stack.push(72);

        System.out.println("Top element: " + stack.peek());
        System.out.println("Stack size: " + stack.size());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Stack size: " + stack.size());
    }
}
