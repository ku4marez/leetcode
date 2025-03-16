package algorithm;

import java.util.Stack;

public class DFSOperations {
    // DFS-Based Tree Balance Check
    public static boolean isBalanced(TreeOperations.TreeNode root) {
        return isBalancedTree(root) != -1;
    }

    private static int isBalancedTree(TreeOperations.TreeNode node) {
        if (node == null) return 0;

        int leftHeight = isBalancedTree(node.left);
        if (leftHeight == -1) return -1;

        int rightHeight = isBalancedTree(node.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return 1 + Math.max(leftHeight, rightHeight);
    }

    // DFS-based min leaf difference in BST
    public static int getMinimumDifference(TreeOperations.TreeNode root) {
        Stack<TreeOperations.TreeNode> stack = new Stack<>();
        TreeOperations.TreeNode curr = root;
        Integer prev = null;
        int minDiff = Integer.MAX_VALUE;

        // In-Order Traversal (LNR) using stack
        while (curr != null || !stack.isEmpty()) {
            // Traverse left subtree
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // Process the node
            curr = stack.pop();
            if (prev != null) {
                minDiff = Math.min(minDiff, Math.abs(curr.val - prev));
            }
            prev = curr.val;

            // Traverse right subtree
            curr = curr.right;
        }

        return minDiff;
    }
}
