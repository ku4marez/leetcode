package algorithm;

import com.sun.source.tree.Tree;

import java.util.*;

public class TreeOperations {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Level Order Tree Construction Using a Queue
    public static TreeNode buildTree(Integer[] values) {
        if (values == null || values.length == 0) return null;

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < values.length) {
            TreeNode current = queue.poll();

            if (values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.add(current.left);
            }
            i++;

            if (i < values.length && values[i] != null) {
                current.right = new TreeNode(values[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    // Iterative Inorder Traversal Using a Stack
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }

    // Recursive Tree Comparison
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // Iterative Symmetry Check Using a Queue
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (right == null && left == null) continue;
            if (right == null || left == null) return false;
            if (left.val != right.val) return false;
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    // Recursive Depth Calculation
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Integer leftDepth = maxDepth(root.left);
        Integer rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    // Recursive Minimum Depth Calculation
    public static int minDepth(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null) return 1 + minDepth(root.right);
        if (root.right == null) return 1 + minDepth(root.left);

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    // Recursive Path Sum Calculation
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    // Iterative Preorder Traversal Using a Stack
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    // Iterative Postorder Traversal Using a Stack
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(result);
        return result;
    }

    // Recursive Count Nodes Using Depth
    public static int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = 0;
        TreeNode dummyLeft = root;
        while (dummyLeft != null) {
            leftHeight++;
            dummyLeft = dummyLeft.left;
        }

        int rightHeight = 0;
        TreeNode dummyRight = root;
        while (dummyRight != null) {
            rightHeight++;
            dummyRight = dummyRight.right;
        }

        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Recursive Tree Inversion
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    // Iterative Binary Tree Paths Construction
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        Stack<String> path = new Stack<>();
        stack.push(root);
        path.push("");

        while (!stack.isEmpty()) {
            TreeNode currElem = stack.pop();
            String currPath = path.pop();

            currPath += currElem.val;

            if (currElem.left == null && currElem.right == null) {
                result.add(currPath);
            } else {
                if (currElem.left != null) {
                    stack.push(currElem.left);
                    path.push(currPath + "->");
                }

                if (currElem.right != null) {
                    stack.push(currElem.right);
                    path.push(currPath + "->");
                }
            }
        }
        return result;
    }


    //  Morris Traversal (inorder traversal)
    public int[] findMode(TreeNode root) {
        // Initialize variables for tracking modes
        List<Integer> modes = new ArrayList<>();
        Integer currentValue = null;
        int currentCount = 0, maxCount = 0;

        // Helper for in-order traversal
        TreeNode current = root, predecessor;

        while (current != null) {
            if (current.left == null) {
                // Process the current node
                if (currentValue == null || current.val != currentValue) {
                    currentValue = current.val;
                    currentCount = 0;
                }
                currentCount++;

                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    modes.clear();
                    modes.add(current.val);
                } else if (currentCount == maxCount) {
                    modes.add(current.val);
                }

                // Move to the right subtree
                current = current.right;
            } else {
                // Find the inorder predecessor
                predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    // Link the current node to its predecessor
                    predecessor.right = current;
                    current = current.left;
                } else {
                    // Restore the tree structure
                    predecessor.right = null;

                    // Process the current node
                    if (currentValue == null || current.val != currentValue) {
                        currentValue = current.val;
                        currentCount = 0;
                    }
                    currentCount++;

                    if (currentCount > maxCount) {
                        maxCount = currentCount;
                        modes.clear();
                        modes.add(current.val);
                    } else if (currentCount == maxCount) {
                        modes.add(current.val);
                    }

                    // Move to the right subtree
                    current = current.right;
                }
            }
        }

        // Convert the list of modes to an array
        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }

    // Merge trees recursively
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null) return root2;
        if (root2 == null) return root1;
        root1 = new TreeNode(root1.val + root2.val);
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;

    }

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int[] diameter = new int[1];
        depth(root, diameter);
        return diameter[0];
    }

    private static int depth(TreeNode root, int[] diameter) {
        if (root == null) return 0;
        int left = depth(root.left, diameter);
        int right = depth(root.right, diameter);
        diameter[0] = Math.max(left + right, diameter[0]);
        return Math.max(left, right) + 1;
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (subRoot == null) return true;
        if (isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
