package algorithm;

import algorithm.TreeOperations.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TreeOperationsTest {

    @Test
    void buildTree() {
        TreeNode root = TreeOperations.buildTree(new Integer[]{1, 2, 3});
        assertNotNull(root);
        assertEquals(1, root.val);
        assertEquals(2, root.left.val);
        assertEquals(3, root.right.val);
    }

    @Test
    void inorderTraversal() {
        TreeNode root = TreeOperations.buildTree(new Integer[]{1, 2, 3, 4, 5, null, 8});
        List<Integer> result = TreeOperations.inorderTraversal(root);
        assertEquals(List.of(4, 2, 5, 1, 3, 8), result);
    }

    @Test
    void isSameTree() {
        TreeNode t1 = TreeOperations.buildTree(new Integer[]{1, 2, 3});
        TreeNode t2 = TreeOperations.buildTree(new Integer[]{1, 2, 3});
        assertTrue(TreeOperations.isSameTree(t1, t2));
    }

    @Test
    void isSymmetric() {
        TreeNode root = TreeOperations.buildTree(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        assertTrue(TreeOperations.isSymmetric(root));
    }

    @Test
    void maxDepth() {
        TreeNode root = TreeOperations.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        assertEquals(3, TreeOperations.maxDepth(root));
    }

    @Test
    void minDepth() {
        TreeNode root = TreeOperations.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        assertEquals(2, TreeOperations.minDepth(root));
    }

    @Test
    void hasPathSum() {
        TreeNode root = TreeOperations.buildTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        assertTrue(TreeOperations.hasPathSum(root, 22));
    }

    @Test
    void preorderTraversal() {
        TreeNode root = TreeOperations.buildTree(new Integer[]{1, 2, 3});
        assertEquals(List.of(1, 2, 3), TreeOperations.preorderTraversal(root));
    }

    @Test
    void countNodes() {
        TreeNode root = TreeOperations.buildTree(new Integer[]{1, 2, 3, 4, 5, 6});
        assertEquals(6, TreeOperations.countNodes(root));
    }

    @Test
    void invertTree() {
        TreeNode root = TreeOperations.buildTree(new Integer[]{4, 2, 7, 1, 3, 6, 9});
        TreeNode inverted = TreeOperations.invertTree(root);
        assertEquals(7, inverted.left.val);
        assertEquals(2, inverted.right.val);
    }

    @Test
    void sortedArrayToBST() {
        TreeNode root = TreeOperations.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        assertNotNull(root);
        assertEquals(0, root.val);
    }

    @Test
    void isBalanced() {
        TreeNode root = TreeOperations.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        assertTrue(TreeOperations.isBalanced(root));
    }

    @Test
    void getMinimumDifference() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        assertEquals(1, TreeOperations.getMinimumDifference(root));
    }

    @Test
    void sumOfLeftLeaves() {
        TreeNode root = TreeOperations.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        assertEquals(24, TreeOperations.sumOfLeftLeaves(root));
    }

    @Test
    void averageOfLevels() {
        TreeNode root = TreeOperations.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        List<Double> result = TreeOperations.averageOfLevels(root);
        assertEquals(3.0, result.get(0));
    }

    @Test
    void binaryTreePaths() {
        TreeNode root = TreeOperations.buildTree(new Integer[]{1, 2, 3, null, 5});
        List<String> paths = TreeOperations.binaryTreePaths(root);
        assertFalse(paths.isEmpty());
    }

    @Test
    void diameterOfBinaryTree() {
        TreeNode root = TreeOperations.buildTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        assertEquals(4, TreeOperations.diameterOfBinaryTree(root));
    }

    @Test
    void goodNodes() {
        TreeNode root = TreeOperations.buildTree(new Integer[]{3, 1, 4, 3, null, 1, 5});
        assertEquals(4, TreeOperations.goodNodes(root));
    }

    @Test
    void rightSideView() {
        TreeNode root = TreeOperations.buildTree(new Integer[]{1, 2, 3, null, 5, null, 4});
        assertEquals(List.of(1, 3, 4), TreeOperations.rightSideView(root));
    }

    @Test
    void lowestCommonAncestor() {
        TreeNode root = TreeOperations.buildTree(new Integer[]{6, 2, 8, 0, 4, 7, 9});
        TreeNode result = TreeOperations.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8));
        assertEquals(6, result.val);
    }
}
