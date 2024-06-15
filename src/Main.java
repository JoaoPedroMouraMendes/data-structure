import Lists.Tree;

public class Main {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);

        tree.BFS();
    }
}