import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Queue implemented using two stacks.
 * Enqueue is O(1); dequeue is amortized O(1).
 */
public class StackQueueEnqueueFriendly {
    private final Deque<Integer> inputStack = new ArrayDeque<>();
    private final Deque<Integer> outputStack = new ArrayDeque<>();

    public void enqueue(int value) {
        // Add new values to the input stack.
        inputStack.push(value);
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        moveElementsIfNeeded();
        return outputStack.pop();
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        moveElementsIfNeeded();
        return outputStack.peek();
    }

    public boolean isEmpty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    private void moveElementsIfNeeded() {
        // Reverse the input stack only when the output stack is empty.
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
    }

    public static void main(String[] args) {
        StackQueueEnqueueFriendly queue = new StackQueueEnqueueFriendly();

        queue.enqueue(3);
        queue.enqueue(6);
        queue.enqueue(12);

        System.out.println("Front element: " + queue.peek());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());

        queue.enqueue(24);

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
    }
}
