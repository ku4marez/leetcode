package easy;

import java.util.*;

public class TreeOperations {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
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

    // Recursive Sorted Array to Balanced BST Conversion
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        TreeNode root = new TreeNode(nums[nums.length / 2]);

        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length / 2));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, nums.length / 2 + 1, nums.length));

        return root;
    }

    // DFS-Based Tree Balance Check
    public static boolean isBalanced(TreeNode root) {
        return isBalancedTree(root) != -1;
    }

    private static int isBalancedTree(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = isBalancedTree(node.left);
        if (leftHeight == -1) return -1;

        int rightHeight = isBalancedTree(node.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return 1 + Math.max(leftHeight, rightHeight);
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

    // BFS-Based Tree left leafs sum
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        int sum = 0;
        while (!stack.isEmpty()) {
            TreeNode currElem = stack.poll();
            if (currElem.left != null && currElem.left.left == null && currElem.left.right == null) {
                sum += currElem.left.val;
            }

            if (currElem.left != null) {
                stack.add(currElem.left);
            }

            if (currElem.right != null) {
                stack.add(currElem.right);
            }

        }
        return sum;
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
}
