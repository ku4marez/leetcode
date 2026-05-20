package algorithm;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DpGreedyOperationsTest {

    @Test
    void coinChange() {
        assertEquals(3, DpGreedyOperations.coinChange(new int[]{1, 2, 5}, 11));
        assertEquals(-1, DpGreedyOperations.coinChange(new int[]{2}, 3));
    }

    @Test
    void climbStairs() {
        assertEquals(3, DpGreedyOperations.climbStairs(3));
        assertEquals(5, DpGreedyOperations.climbStairs(4));
    }

    @Test
    void minCostClimbingStairs() {
        assertEquals(15, DpGreedyOperations.minCostClimbingStairs(new int[]{10, 15, 20}));
    }

    @Test
    void generate() {
        List<List<Integer>> result = DpGreedyOperations.generate(5);
        assertEquals(5, result.size());
        assertEquals(List.of(1, 3, 3, 1), result.get(3));
    }

    @Test
    void getRow() {
        assertEquals(List.of(1, 4, 6, 4, 1), DpGreedyOperations.getRow(4));
    }

    @Test
    void countBits() {
        assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, DpGreedyOperations.countBits(5));
    }

    @Test
    void fibIterative() {
        assertEquals(8, DpGreedyOperations.fibIterative(6));
    }

    @Test
    void fibRecursively() {
        assertEquals(8, DpGreedyOperations.fibRecursively(6));
    }

    @Test
    void editDistance() {
        assertEquals(3, DpGreedyOperations.editDistance("horse", "ros"));
    }

    @Test
    void canJump() {
        assertTrue(DpGreedyOperations.canJump(new int[]{2, 4, 0, 1, 4}));
        assertFalse(DpGreedyOperations.canJump(new int[]{3, 2, 1, 0, 4}));
    }

    @Test
    void jump2() {
        assertEquals(2, DpGreedyOperations.jump2(new int[]{2, 4, 0, 1, 4}));
    }

    @Test
    void isSubsequence() {
        assertTrue(DpGreedyOperations.isSubsequence("abc", "ahbgdc"));
        assertFalse(DpGreedyOperations.isSubsequence("axc", "ahbgdc"));
    }

    @Test
    void coinChange2() {
        assertEquals(4, DpGreedyOperations.coinChange2(5, new int[]{1, 2, 5}));
    }

    @Test
    void checkValidString() {
        assertTrue(DpGreedyOperations.checkValidString("(*))"));
        assertFalse(DpGreedyOperations.checkValidString("((("));
    }

    @Test
    void maxProduct() {
        assertEquals(108, DpGreedyOperations.maxProduct(new int[]{-1, -2, -9, -6}));
    }

    @Test
    void rob() {
        assertEquals(4, DpGreedyOperations.rob(new int[]{1, 2, 3, 1}));
    }

    @Test
    void rob2() {
        assertEquals(4, DpGreedyOperations.rob2(new int[]{1, 2, 3, 1}));
    }

    @Test
    void maxProfit() {
        assertEquals(3, DpGreedyOperations.maxProfit(new int[]{1, 2, 3, 0, 2}));
    }

    @Test
    void canPartition() {
        assertTrue(DpGreedyOperations.canPartition(new int[]{1, 5, 11, 5}));
        assertFalse(DpGreedyOperations.canPartition(new int[]{1, 2, 3, 5}));
    }

    @Test
    void canCompleteCircuit() {
        assertEquals(3, DpGreedyOperations.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
    }

    @Test
    void minPathSum() {
        assertEquals(7, DpGreedyOperations.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
}
