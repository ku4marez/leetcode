package algorithm;

import java.util.Arrays;

public class BSTOperations {

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
}
