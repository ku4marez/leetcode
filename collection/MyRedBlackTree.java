package collection;

public class MyRedBlackTree {
    enum Color {RED, BLACK}

    public MyRedBlackTree() {
    }

    static class Node {
        int value;
        Color color;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Color color) {
            this.value = value;
            this.color = color;
        }
    }

    Node root;

    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
            root.color = Color.BLACK;
        }
        root = insert(root, key);
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    private Node insert(Node root, int key) {
        if (root == null) return new Node(key, Color.RED);
        if (key < root.value) {
            root.left = insert(root.left, key);
        } else if (key > root.value) {
            root.right = insert(root.right, key);
        } else {
            return root;
        }

        if (root.left != null && root.left.color == Color.BLACK && root.right != null && root.right.color == Color.RED)  {
            root = rotateLeft(root);
        }
        if (root.left != null && root.left.color == Color.RED && root.left.left != null && root.left.left.color == Color.RED) {
            root = rotateRight(root);
        }
        if (root.left != null && root.left.color == Color.RED && root.right != null && root.right.color == Color.RED) {
            root = flipColors(root);
        }
        return root;

    }

    private Node delete(Node root, int key) {
        if (root == null) return null;
        if (key < root.value) {
            root.left = delete(root.left, key);
        } else if (key > root.value) {
            root.right = delete(root.right, key);
        } else {
            // move a red link down so that root.left or root.right will contain the key
            // standard BST delete
            // rebalance (same three checks as insert)
        }
        if (root.left != null && root.left.color == Color.BLACK && root.right != null && root.right.color == Color.RED)  {
            root = rotateLeft(root);
        }
        if (root.left != null && root.left.color == Color.RED && root.left.left != null && root.left.left.color == Color.RED) {
            root = rotateRight(root);
        }
        if (root.left != null && root.left.color == Color.RED && root.right != null && root.right.color == Color.RED) {
            root = flipColors(root);
        }
        return root;
    }

    private Node rotateLeft(Node z) {
        Node y = z.right;
        Node T2 = y.left;

        y.left = z;
        z.right = T2;

        y.color = z.color;
        z.color = Color.RED;

        return y;
    }

    private Node rotateRight(Node z) {
        Node y = z.left;
        Node T3 = y.right;

        y.right = z;
        z.left = T3;

        y.color = z.color;
        z.color = Color.RED;

        return y;
    }

    private Node flipColors(Node h) {
        h.color = (h.color == Color.RED) ? Color.BLACK : Color.RED;
        h.left.color = (h.left.color == Color.RED) ? Color.BLACK : Color.RED;
        h.right.color = (h.right.color == Color.RED) ? Color.BLACK : Color.RED;
        return h;
    }

}
