import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Stack implemented using two queues.
 * Push is O(1); pop and peek are O(n).
 */
public class QueueStackPushFriendly {
    private final Queue<Integer> queue1 = new ArrayDeque<>();
    private final Queue<Integer> queue2 = new ArrayDeque<>();

    public void push(int value) {
        queue1.offer(value);
    }

    public int pop() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }

        int removed = queue1.poll();

        // Swap the queue references' contents.
        while (!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }

        return removed;
    }

    public int peek() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }

        int top = queue1.peek();
        queue2.offer(queue1.poll());

        while (!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }

        return top;
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        QueueStackPushFriendly stack = new QueueStackPushFriendly();

        stack.push(80);
        stack.push(19);
        stack.push(28);

        System.out.println("Top element: " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
    }
}
