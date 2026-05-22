package archive_interview.preparation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day13Test {

    @Test
    void knapsack() {
        // Stub returns 0 — placeholder for implementation
        assertEquals(0, Day13.knapsack(new int[]{1, 3, 4, 5}, new int[]{1, 4, 5, 7}, 7));
    }

    @Test
    void canPartition() {
        assertFalse(Day13.canPartition(new int[]{1, 5, 11, 5}));
    }

    @Test
    void countSubsetsWithSum() {
        assertEquals(0, Day13.countSubsetsWithSum(new int[]{1, 2, 3, 3}, 6));
    }

    @Test
    void findTargetSumWays() {
        assertEquals(0, Day13.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    @Test
    void coinChange() {
        assertEquals(0, Day13.coinChange(new int[]{1, 2, 5}, 11));
    }
}
