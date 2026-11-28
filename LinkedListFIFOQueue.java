public class LinkedListFIFOQueue {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node front = null;
    Node rear = null;

    void enqueue(int data) {
        Node newNode = new Node(data);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println(data + " added");
    }

    void dequeue() {
        if (front == null) {
            System.out.println("Queue Underflow");
            return;
        }

        System.out.println(front.data + " removed");
        front = front.next;

        if (front == null) {
            rear = null;
        }
    }

    void peek() {
        if (front == null) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Front element: " + front.data);
        }
    }

    void display() {
        if (front == null) {
            System.out.println("Queue is empty");
            return;
        }

        Node current = front;
        System.out.println("Queue elements:");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListFIFOQueue queue = new LinkedListFIFOQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display();
        queue.peek();
        queue.dequeue();
        queue.display();
    }
}
