public class CircularDoublyLinkedList {

    class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
        }
    }

    Node head = null;

    void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node last = head.prev;
            newNode.next = head;
            newNode.prev = last;
            last.next = newNode;
            head.prev = newNode;
        }
    }

    void delete(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        do {
            if (current.data == data) {
                if (current.next == current) {
                    head = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    if (current == head) {
                        head = current.next;
                    }
                }
                System.out.println(data + " deleted");
                return;
            }
            current = current.next;
        } while (current != head);

        System.out.println("Value not found");
    }

    void displayForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    void displayBackward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head.prev;
        Node last = current;
        do {
            System.out.print(current.data + " ");
            current = current.prev;
        } while (current != last);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        System.out.println("Forward:");
        list.displayForward();

        System.out.println("Backward:");
        list.displayBackward();

        list.delete(20);

        System.out.println("After deletion:");
        list.displayForward();
    }
}
