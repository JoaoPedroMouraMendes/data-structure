package Lists;

public class Tree<T> {

    Node root;

    class Node {
        public T data;
        public Node left;
        public Node right;

        Node(T data) {
            this.data = data;
        }

        public boolean isLeaf() {
            return this.left == null && this.right == null;
        }
    }

    public void insert(T data) {
        if (root == null) {
            root = new Node(data);
        } else {
            Node newNode = new Node(data);
            Queue<Node> queue = new Queue<>();
            queue.enqueue(root);
            while (queue.getLength() > 0) {
                Node currentNode = queue.dequeue();
                if (currentNode.left == null) {
                    currentNode.left = newNode;
                    break;
                } else {
                    queue.enqueue(currentNode.left);
                }
                if (currentNode.right == null) {
                    currentNode.right = newNode;
                    break;
                } else {
                    queue.enqueue(currentNode.right);
                }
            }
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(final Node node) {
        // Root Left Right
        if (node == null) return;
        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(final Node node) {
        // Left Root Right
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }

    public void posOrder() {
        posOrder(root);
    }

    private void posOrder(final Node node) {
        // Left Right Root
        if (node == null) return;
        posOrder(node.left);
        posOrder(node.right);
        System.out.println(node.data);
    }

    public void BFS() {
        if (root == null) return;

        Queue<Node> queue = new Queue<>(root);
        while (queue.getLength() > 0) {
            Node node = queue.dequeue();
            if (node.left != null) queue.enqueue(node.left);
            if (node.right != null) queue.enqueue(node.right);

            System.out.println(node.data);
        }
    }
}
