import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Stack implemented using two queues.
 * Push is O(n); pop and peek are O(1).
 */
public class QueueStackPopFriendly {
    private Queue<Integer> queue1 = new ArrayDeque<>();
    private Queue<Integer> queue2 = new ArrayDeque<>();

    public void push(int value) {
        // Add the new value to the empty second queue.
        queue2.offer(value);

        // Move all older values behind the new value.
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }

        // Swap the queues.
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue1.poll();
    }

    public int peek() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue1.peek();
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        QueueStackPopFriendly stack = new QueueStackPopFriendly();

        stack.push(17);
        stack.push(09);
        stack.push(102);

        System.out.println("Top element: " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
    }
}
