package archive_interview.preparation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day5Test {

    @Test
    void rangeSum() {
        assertArrayEquals(new int[]{9, 6}, Day5.rangeSum(new int[]{1, 2, 3, 4}, new int[][]{{1, 3}, {0, 2}}));
    }

    @Test
    void subarraySumEqualsK() {
        assertEquals(3, Day5.subarraySumEqualsK(new int[]{1, 2, 1, 3}, 3));
    }

    @Test
    void maxSumSubarray() {
        assertEquals(9, Day5.maxSumSubarray(new int[]{2, 1, 5, 1, 3, 2}, 3));
    }

    @Test
    void lengthOfLongestSubstring() {
        assertEquals(5, Day5.lengthOfLongestSubstring("bcdfabcbb"));
    }

    @Test
    void numSubarraysWithSum() {
        assertEquals(4, Day5.numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
    }
}
