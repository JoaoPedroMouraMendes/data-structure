import Lists.LinkedList;
import Lists.Queue;
import Lists.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue1 = new Queue<>(1);
        queue1.enqueue(2);
        queue1.enqueue(3);
        queue1.print();
        System.out.println(queue1.dequeue());
        queue1.print();
    }
}