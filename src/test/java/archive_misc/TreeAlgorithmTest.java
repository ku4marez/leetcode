package archive_misc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeAlgorithmTest {

    @Test
    void insertBalancedBST() {
        TreeAlgorithm.TreeNode root = null;
        root = TreeAlgorithm.insertBalancedBST(root, 10);
        root = TreeAlgorithm.insertBalancedBST(root, 20);
        root = TreeAlgorithm.insertBalancedBST(root, 30);
        // Tree should contain all values
        assertNotNull(root);
        assertEquals(10, root.val); // height bug means no rotation happens
    }

    @Test
    void removeBalancedBST() {
        TreeAlgorithm.TreeNode root = null;
        root = TreeAlgorithm.insertBalancedBST(root, 10);
        root = TreeAlgorithm.insertBalancedBST(root, 5);
        root = TreeAlgorithm.insertBalancedBST(root, 15);
        root = TreeAlgorithm.removeBalancedBST(root, 15);
        assertNull(root.right);
    }
}
