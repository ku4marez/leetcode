package easy;

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
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            TreeNode currElem = queue.poll();
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

    // DFS-based min leaf difference in BST
    public static int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
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


    // Merge trees recursively
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null) return root2;
        if (root2 == null) return root1;
        root1 = new TreeNode(root1.val + root2.val);
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;

    }

    // Merge trees using BFS approach
    public static TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        TreeNode node = new TreeNode(root1.val + root2.val);
        Queue<TreeNode[]> queue = new LinkedList<>();
        Queue<TreeNode> mergedQueue = new LinkedList<>();
        queue.offer(new TreeNode[] {root1, root2});
        mergedQueue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode[] nodes = queue.poll();
            TreeNode node1 = nodes[0], node2 = nodes[1];
            TreeNode mergedNode = mergedQueue.poll();

            // Merge left children
            TreeNode left1 = node1.left, left2 = node2.left;
            if (left1 != null || left2 != null) {
                if (left1 != null && left2 != null) {
                    mergedNode.left = new TreeNode(left1.val + left2.val);
                    queue.offer(new TreeNode[]{left1, left2});
                    mergedQueue.offer(mergedNode.left);
                } else {
                    mergedNode.left = left1 != null ? left1 : left2;
                }
            }

            // Merge right children
            TreeNode right1 = node1.right, right2 = node2.right;
            if (right1 != null || right2 != null) {
                if (right1 != null && right2 != null) {
                    mergedNode.right = new TreeNode(right1.val + right2.val);
                    queue.offer(new TreeNode[]{right1, right2});
                    mergedQueue.offer(mergedNode.right);
                } else {
                    mergedNode.right = right1 != null ? right1 : right2;
                }
            }
        }
        return node;
    }

    // Find element in BST
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (root.val > val){
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
