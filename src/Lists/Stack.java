package Lists;

public class Stack<T> {

    private Node top;
    private int height;

    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    public Stack(T data) {
        top = new Node(data);
        height = 1;
    }

    public T getTop() {
        return top.data;
    }

    public int getHeight() {
        return height;
    }

    public void print() {
        System.out.println("###############");
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("###############");
    }

    public void push(T data) {
        Node newNode = new Node(data);
        if (height == 0) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public T pop() {
        if (height == 0) return null;

        Node temp = top;
        top = top.next;
        temp.next = null;
        height--;

        return temp.data;
    }
}
