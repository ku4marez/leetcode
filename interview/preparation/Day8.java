package interview.preparation;


import java.util.*;

public class Day8 {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int maxDepth = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        return maxDepth;
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        boolean leftHasSum;
        boolean rightHasSum;
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        } else {
            leftHasSum = hasPathSum(root.left, targetSum - root.val);
            rightHasSum = hasPathSum(root.right, targetSum - root.val);
        }
        return leftHasSum || rightHasSum;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    public static String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        list.add(root.val);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left != null) {
                queue.add(left);
                list.add(left.val);
            } else {
                list.add(null);
            }

            if (right != null) {
                queue.add(right);
                list.add(right.val);
            } else {
                list.add(null);
            }
        }

        while (list.getLast() == null) {
            list.removeLast();
        }
        return Arrays.toString(list.toArray());
    }

    public static TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        String clean = data.replaceAll("[\\[\\]\\s]", "");
        String[] tokens = clean.split(",");
        Integer[] arr = Arrays.stream(tokens)
                .map(s -> s.equals("null") ? null : Integer.valueOf(s))
                .toArray(Integer[]::new);
        TreeNode root = new TreeNode(arr[0]);
        queue.add(root);
        int i = 1;

        while (!queue.isEmpty() && i < tokens.length) {
            TreeNode node = queue.poll();
            if (i < arr.length) node.left = arr[i] != null ? new TreeNode(arr[i]) : null;
            if (node.left != null) queue.add(node.left);
            i++;
            if (i < arr.length) node.right = arr[i] != null ? new TreeNode(arr[i]) : null;
            if (node.right != null) queue.add(node.right);
            i++;
        }
        return root;
    }

    public static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {
            TreeNode node = queue.poll();

            if (i < arr.length && arr[i] != null) {
                node.left = new TreeNode(arr[i]);
                queue.offer(node.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                node.right = new TreeNode(arr[i]);
                queue.offer(node.right);
            }
            i++;
        }

        return root;
    }

    public static TreeNode find(TreeNode root, int value) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (value == node.val) {
                return node;
            } else {
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return null;
    }
}
