package archive_misc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DPAlgorithmTest {

    @Test
    void fib() {
        assertEquals(0, DPAlgorithm.fib(0));
        assertEquals(1, DPAlgorithm.fib(1));
        assertEquals(8, DPAlgorithm.fib(6));
    }

    @Test
    void climbStairs() {
        assertEquals(2, DPAlgorithm.climbStairs(2));
        assertEquals(3, DPAlgorithm.climbStairs(3));
        assertEquals(5, DPAlgorithm.climbStairs(4));
    }

    @Test
    void minCostClimbingStairs() {
        assertEquals(15, DPAlgorithm.minCostClimbingStairs(new int[]{10, 15, 20}));
    }

    @Test
    void rob() {
        assertEquals(4, DPAlgorithm.rob(new int[]{1, 2, 3, 1}));
        assertEquals(12, DPAlgorithm.rob(new int[]{2, 7, 9, 3, 1}));
    }

    @Test
    void maxSubArray() {
        assertEquals(6, DPAlgorithm.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    @Test
    void canJump() {
        assertTrue(DPAlgorithm.canJump(new int[]{2, 3, 1, 1, 4}));
        assertFalse(DPAlgorithm.canJump(new int[]{3, 2, 1, 0, 4}));
    }

    @Test
    void jump() {
        assertEquals(2, DPAlgorithm.jump(new int[]{2, 3, 1, 1, 4}));
    }

    @Test
    void coinChange() {
        assertEquals(3, DPAlgorithm.coinChange(new int[]{1, 2, 5}, 11));
        assertEquals(4, DPAlgorithm.coinChange(new int[]{2}, 3)); // amount+1 returned when impossible
    }

    @Test
    void change() {
        assertEquals(4, DPAlgorithm.change(5, new int[]{1, 2, 5}));
    }

    @Test
    void longestCommonSubsequence() {
        assertEquals(3, DPAlgorithm.longestCommonSubsequence("abcde", "ace"));
    }

    @Test
    void minDistance() {
        assertEquals(3, DPAlgorithm.minDistance("horse", "ros"));
    }
}
