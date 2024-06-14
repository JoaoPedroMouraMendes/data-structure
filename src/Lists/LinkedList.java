package Lists;

public class LinkedList<T> {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    public LinkedList(T data) {
        length = 1;
        Node newNode = new Node(data);
        head = newNode;
        tail = newNode;
    }

    public T getHead() {
        if (head == null) return null;
        return head.data;
    }

    public T getTail() {
        if (tail == null) return null;
        return tail.data;
    }

    public int getLength() {
        return length;
    }

    public void makeEmpty() {
        length = 0;
        head = null;
        tail = null;
    }

    public void print() {
        System.out.println("###############");
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("###############");
    }

    public void append(T data) {
        Node newNode = new Node(data);
        if (length == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        length++;
    }

    public T removeLast() {
        if (length == 0) return null;

        Node pre = head;
        Node temp = null;
        while (pre.next != tail && pre.next != null) {
            pre = pre.next;
        }

        temp = tail;
        tail = pre;
        tail.next = null;

        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }

        return temp.data;
    }

    public void prepend(T data) {
        Node newNode = new Node(data);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public T removeFirst() {
        if (length == 0) return null;

        Node temp = head;
        head = head.next;
        temp.next = null;

        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }

        return temp.data;
    }

    public T get(int index) {
        if (index < 0 || index >= length) return null;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public boolean set(T data, int index) {
        Node temp = getNode(index);
        if (temp != null) {
            temp.data = data;
            return true;
        }
        return false;
    }

    public boolean insert(T data, int index) {
        if (index < 0 || index > length) return false;

        if (index == 0) {
            prepend(data);
            return true;
        } else if (length == index) {
            append(data);
            return true;
        }

        Node temp = getNode(index - 1);
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;

        return true;
    }

    public T remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        else if (index == length - 1) return removeLast();

        Node prev = getNode(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;

        return temp.data;
    }

    // Internal methods
    private Node getNode(int index) {
        if (index < 0 || index >= length) return null;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

}
