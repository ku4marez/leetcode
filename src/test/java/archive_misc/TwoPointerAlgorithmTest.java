package archive_misc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoPointerAlgorithmTest {

    @Test
    void twoSumSorted() {
        assertArrayEquals(new int[]{0, 3}, TwoPointerAlgorithm.twoSumSorted(new int[]{1, 2, 3, 4}, 5));
        assertArrayEquals(new int[]{0, 1}, TwoPointerAlgorithm.twoSumSorted(new int[]{2, 7, 11, 15}, 9));
    }

    @Test
    void removeDuplicatesSorted() {
        int[] nums = {1, 1, 2, 3, 3};
        assertEquals(3, TwoPointerAlgorithm.removeDuplicatesSorted(nums));
        assertEquals(1, nums[0]);
        assertEquals(2, nums[1]);
        assertEquals(3, nums[2]);
    }

    @Test
    void containerWithWater() {
        assertEquals(49, TwoPointerAlgorithm.containerWithWater(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
