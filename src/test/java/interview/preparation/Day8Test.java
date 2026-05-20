package interview.preparation;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day8Test {

    @Test
    void maxDepth() {
        Day8.TreeNode root = Day8.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        assertEquals(3, Day8.maxDepth(root));
    }

    @Test
    void hasPathSum() {
        Day8.TreeNode root = Day8.buildTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        assertTrue(Day8.hasPathSum(root, 22));
    }

    @Test
    void inorderTraversal() {
        Day8.TreeNode root = Day8.buildTree(new Integer[]{1, null, 2, 3});
        assertEquals(List.of(1, 3, 2), Day8.inorderTraversal(root));
    }

    @Test
    void lowestCommonAncestor() {
        Day8.TreeNode root = Day8.buildTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        Day8.TreeNode p = Day8.find(root, 5);
        Day8.TreeNode q = Day8.find(root, 1);
        assertEquals(3, Day8.lowestCommonAncestor(root, p, q).val);
    }

    @Test
    void serializeDeserialize() {
        Day8.TreeNode root = Day8.buildTree(new Integer[]{1, 2, 3, null, null, 4, 5});
        String serialized = Day8.serialize(root);
        Day8.TreeNode deserialized = Day8.deserialize(serialized);
        assertEquals(1, deserialized.val);
    }
}
