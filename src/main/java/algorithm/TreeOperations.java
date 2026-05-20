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

    // Recursive Sorted Array to Balanced BST Conversion
    public static TreeOperations.TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        TreeOperations.TreeNode root = new TreeOperations.TreeNode(nums[nums.length / 2]);

        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length / 2));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, nums.length / 2 + 1, nums.length));

        return root;
    }

    // Find element in BST
    public static TreeOperations.TreeNode searchBST(TreeOperations.TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

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

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (subRoot == null) return true;
        if (isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static int goodNodes(TreeNode root) {
        if (root == null) return 0;
        return dfsGoodNodes(root, root.val);
    }

    private static int dfsGoodNodes(TreeNode node, int maxNode) {
        if (node == null) return 0;
        int count = node.val >= maxNode ? 1 : 0;
        return count + dfsGoodNodes(node.left, Math.max(node.val, maxNode)) + dfsGoodNodes(node.right, Math.max(node.val, maxNode));
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

    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> result = new LinkedList<>();
        rightSideView(root, result, 0);
        return result;
    }

    private static void rightSideView(TreeNode root, List<Integer> result, int depth) {
        if (root == null) return;
        if (depth == result.size()) result.add(root.val);
        rightSideView(root.right, result, depth + 1);
        rightSideView(root.left, result, depth + 1);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
