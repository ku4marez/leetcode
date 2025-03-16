package algorithm;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSOperations {

    // BFS-Based Tree left leafs sum
    public static int sumOfLeftLeaves(TreeOperations.TreeNode root) {
        if (root == null) return 0;
        Queue<TreeOperations.TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            TreeOperations.TreeNode currElem = queue.poll();
            if (currElem.left != null && currElem.left.left == null && currElem.left.right == null) {
                sum += currElem.left.val;
            }

            if (currElem.left != null) {
                queue.add(currElem.left);
            }

            if (currElem.right != null) {
                queue.add(currElem.right);
            }

        }
        return sum;
    }

    // BFS-Based Tree average sum of all nodes in the level
    public static List<Double> averageOfLevels(TreeOperations.TreeNode root) {
        List<Double> result = new LinkedList<>();
        if (root == null) return Collections.emptyList();
        Queue<TreeOperations.TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            long sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                TreeOperations.TreeNode currElem = queue.poll();
                if (currElem != null) {
                    sum += currElem.val;

                    if (currElem.left != null) {
                        queue.add(currElem.left);
                    }

                    if (currElem.right != null) {
                        queue.add(currElem.right);
                    }
                }
            }

            result.add(sum / (double) size);
        }

        return result;
    }

    // Merge trees using BFS approach
    public static TreeOperations.TreeNode mergeTrees2(TreeOperations.TreeNode root1, TreeOperations.TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        TreeOperations.TreeNode node = new TreeOperations.TreeNode(root1.val + root2.val);
        Queue<TreeOperations.TreeNode[]> queue = new LinkedList<>();
        Queue<TreeOperations.TreeNode> mergedQueue = new LinkedList<>();
        queue.offer(new TreeOperations.TreeNode[]{root1, root2});
        mergedQueue.offer(node);
        while (!queue.isEmpty()) {
            TreeOperations.TreeNode[] nodes = queue.poll();
            TreeOperations.TreeNode node1 = nodes[0], node2 = nodes[1];
            TreeOperations.TreeNode mergedNode = mergedQueue.poll();

            // Merge left children
            TreeOperations.TreeNode left1 = node1.left, left2 = node2.left;
            if (left1 != null || left2 != null) {
                if (left1 != null && left2 != null) {
                    mergedNode.left = new TreeOperations.TreeNode(left1.val + left2.val);
                    queue.offer(new TreeOperations.TreeNode[]{left1, left2});
                    mergedQueue.offer(mergedNode.left);
                } else {
                    mergedNode.left = left1 != null ? left1 : left2;
                }
            }

            // Merge right children
            TreeOperations.TreeNode right1 = node1.right, right2 = node2.right;
            if (right1 != null || right2 != null) {
                if (right1 != null && right2 != null) {
                    mergedNode.right = new TreeOperations.TreeNode(right1.val + right2.val);
                    queue.offer(new TreeOperations.TreeNode[]{right1, right2});
                    mergedQueue.offer(mergedNode.right);
                } else {
                    mergedNode.right = right1 != null ? right1 : right2;
                }
            }
        }
        return node;
    }
}
