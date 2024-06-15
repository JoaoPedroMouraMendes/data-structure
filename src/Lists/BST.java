package Lists;

import java.util.Objects;

public class BST<T extends Number> {

    Node root;

    class Node {
        T data;
        Node left;
        Node right;

        Node(T data) {
            this.data = data;
        }
    }

    public void insert(T data) {
        if (root == null) {
            root = new Node(data);;
        } else {
            insert(root, data);
        }
    }

    private void insert(final Node root, T data) {
        if (root == null) return;
        if (Objects.equals(data, root.data)) return;
        if (data.doubleValue() > root.data.doubleValue()) {
            if (root.right == null) root.right = new Node(data);
            else insert(root.right, data);
        } else {
            if (root.left == null) root.left = new Node(data);
            else insert(root.left, data);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(final Node root) {
        // Left Root Right
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    public boolean contains(T data) {
        return contains(root, data);
    }

    private boolean contains(final Node root, T data) {
        if (root == null) return false;
        if (Objects.equals(root.data, data)) return true;
        if (data.doubleValue() > root.data.doubleValue()) return contains(root.right, data);
        else return contains(root.left, data);
    }

    private T minValue(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.data;
    }

    public void deleteNode(T data) {
        root = deleteNode(root, data);
    }

    private Node deleteNode(final Node root, final T data) {
        if (root == null)  return null;

        if (data.doubleValue() < root.data.doubleValue()) {
            root.left = deleteNode(root.left, data);
        } else if (data.doubleValue() > root.data.doubleValue()) {
            root.right = deleteNode(root.right, data);
        } else {
            if (root.left == null && root.right == null) return null;
            else if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {
                T minValue = minValue(root.right);
                root.data = minValue;
                root.right = deleteNode(root.right, minValue);
            }
        }
        return root;
    }
}
