package archive_misc;

public class TreeAlgorithm {
    // Basic definition of singly linked list node
    static class TreeNode {
        int val;
        int height;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode insertBalancedBST(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        }

        if (value < node.val) {
            node.left = insertBalancedBST(node.left, value);
        } else if (value > node.val) {
            node.right = insertBalancedBST(node.right, value);
        } else {
            return node;
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        int balance = height(node.left) - height(node.right);

        if (balance > 1 && node.left.val > value) {
            return rotateRight(node);
        }

        if (balance < -1 && node.right.val < value) {
            return rotateLeft(node);
        }

        if (balance > 1 && node.left.val < value) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balance < -1 && node.right.val > value) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;

    }

    static TreeNode removeBalancedBST(TreeNode node, int value) {
        if (node == null) {
            return null;
        }

        if (value < node.val) {
            node.left = removeBalancedBST(node.left, value);
        } else if (value > node.val) {
            node.right = removeBalancedBST(node.right, value);
        } else {
            node = null;
        }

        return node;

    }

    static TreeNode rotateLeft(TreeNode x) {
        if (x == null) {
            return null;
        }
        TreeNode y = x.right;
        TreeNode t2 = y.left;

        y.left = x;
        x.right = t2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    static TreeNode rotateRight(TreeNode x) {
        if (x == null) {
            return null;
        }
        TreeNode y = x.left;
        TreeNode t2 = y.right;

        y.right = x;
        x.left = t2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

//    static int height(TreeNode node) {
//        if (node == null) return 0;
//        return 1 + Math.max(height(node.left), height(node.right));
//    }

    static int height(TreeNode node) {
        if (node == null) return 0;
        return node.height;
    }
}
