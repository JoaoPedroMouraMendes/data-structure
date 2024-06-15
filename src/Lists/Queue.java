package Lists;

public class Queue<T> {

    private Node first;
    private Node last;
    private int length;

    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    public  Queue() {}

    public Queue(T data) {
        Node newNode = new Node(data);
        first = newNode;
        last = newNode;
        length = 1;
    }

    public T getFirst() {
        if (first == null) return null;

        return first.data;
    }

    public T getLast() {
        if (last == null) return null;

        return last.data;
    }

    public int getLength() {
        return length;
    }

    public void print() {
        System.out.println("###############");
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("###############");
    }

    public void enqueue(T data) {
        Node newNode = new Node(data);

        if (length == 0) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        length++;
    }

    public T dequeue() {
        if (length == 0) return null;

        Node temp = first;
        if (length == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            temp.next = null;
        }
        length--;
        return temp.data;
    }
}
