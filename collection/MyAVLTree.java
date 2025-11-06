package collection;

import algorithm.TreeOperations;

public class MyAVLTree {
    Node root;

    static class Node {
        int value;
        Node left;
        Node right;
        int height;


        public Node(int value) {
            this.value = value;
        }
    }

    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
            return;
        }
        root = insert(root, key);
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    private Node rotateLeft(Node z) {
        Node y = z.right;
        Node T2 = y.left;

        y.left = z;
        z.right = T2;

        z.height = 1 + Math.max(height(z.left), height(z.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));
        return y;
    }

    private Node rotateRight(Node z) {
        Node y = z.left;
        Node T3 = y.right;

        y.right = z;
        z.left = T3;

        z.height = 1 + Math.max(height(z.left), height(z.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));
        return y;
    }

    private Node rotateLeftRight(Node z) {
        z.left = rotateLeft(z.left);
        return rotateRight(z);
    }

    private Node rotateRightLeft(Node z) {
        z.right = rotateRight(z.right);
        return rotateLeft(z);
    }

    private int height(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    private Node insert(Node root, int key) {
        if (root == null) return new Node(key);
        if (key < root.value) {
            root.left = insert(root.left, key);
        } else if (key > root.value) {
            root.right = insert(root.right, key);
        } else {
            return root;
        }
        root.height = 1 + Math.max(height(root.left), height(root.right));
        int leftHeight = root.left != null ? root.left.height : 0;
        int rightHeight = root.right != null ? root.right.height : 0;

        int balance = leftHeight - rightHeight;

        if (balance > 1 && key < root.left.value) {
            return rotateRight(root);
        }

        if (balance < -1 && key > root.right.value) {
            return rotateLeft(root);
        }

        if (balance > 1 && key > root.left.value) {
            return rotateLeftRight(root);
        }

        if (balance < -1 && key < root.right.value) {
            return rotateRightLeft(root);
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
            if (root.left == null || root.right == null) {
                root = root.left != null ? root.left : root.right;
            } else {
                Node successor = minValueNode(root.right);
                root.value = successor.value;
                root.right = delete(root.right, successor.value);
            }
        }
        if (root != null) {
            root.height = 1 + Math.max(height(root.left), height(root.right));
            int leftHeight = root.left != null ? root.left.height : 0;
            int rightHeight = root.right != null ? root.right.height : 0;

            int balance = leftHeight - rightHeight;

            if (balance > 1 && key < root.left.value) {
                return rotateRight(root);
            }

            if (balance < -1 && key > root.right.value) {
                return rotateLeft(root);
            }

            if (balance > 1 && key > root.left.value) {
                return rotateLeftRight(root);
            }

            if (balance < -1 && key < root.right.value) {
                return rotateRightLeft(root);
            }
        }

        return root;
    }

    private Node minValueNode(Node root) {
        Node current = root;
        while (current != null) {
            current = current.left;
        }
        return current;
    }
}
