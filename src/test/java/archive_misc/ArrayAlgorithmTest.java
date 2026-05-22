package archive_misc;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayAlgorithmTest {

    @Test
    void swapEvenOdd() {
        int[] nums = {3, 2, 4, 1, 5, 6};
        ArrayAlgorithm.swapEvenOdd(nums);
        // All evens should come before odds
        boolean seenOdd = false;
        for (int n : nums) {
            if (n % 2 == 0) assertFalse(seenOdd);
            else seenOdd = true;
        }
    }

    @Test
    void cyclicSortMapping() {
        int[] nums = {3, 1, 2};
        ArrayAlgorithm.cyclicSortMapping(nums);
        assertArrayEquals(new int[]{1, 2, 3}, nums);
    }

    @Test
    void findDuplicates() {
        List<Integer> result = ArrayAlgorithm.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        assertTrue(result.contains(2));
        assertTrue(result.contains(3));
        assertEquals(2, result.size());
    }

    @Test
    void reverseSubarray() {
        int[] arr = {1, 2, 3, 4, 5};
        ArrayAlgorithm.reverseSubarray(arr, 1, 3);
        assertArrayEquals(new int[]{1, 4, 3, 2, 5}, arr);
    }

    @Test
    void prefixProduct() {
        assertArrayEquals(new int[]{24, 12, 8, 6}, ArrayAlgorithm.prefixProduct(new int[]{1, 2, 3, 4}));
    }

    @Test
    void containsTarget() {
        assertTrue(ArrayAlgorithm.containsTarget(new int[]{1, 2, 3}, 2));
        assertFalse(ArrayAlgorithm.containsTarget(new int[]{1, 2, 3}, 5));
    }

    @Test
    void binarySearch() {
        assertEquals(2, ArrayAlgorithm.binarySearch(new int[]{1, 3, 5, 7, 9}, 5));
        assertEquals(-1, ArrayAlgorithm.binarySearch(new int[]{1, 3, 5, 7, 9}, 4));
    }

    @Test
    void slidingWindowMaxSum() {
        assertEquals(9, ArrayAlgorithm.slidingWindowMaxSum(new int[]{1, 2, 3, 4, 5}, 2));
    }

    @Test
    void prefixSum() {
        assertArrayEquals(new int[]{1, 3, 6, 10}, ArrayAlgorithm.prefixSum(new int[]{1, 2, 3, 4}));
    }

    @Test
    void backtrackSubsets() {
        List<List<Integer>> result = new ArrayList<>();
        ArrayAlgorithm.backtrackSubsets(new int[]{1, 2}, 0, new ArrayList<>(), result);
        assertEquals(4, result.size()); // [], [1], [1,2], [2]
    }

    @Test
    void maxNonOverlappingIntervals() {
        int[][] intervals = {{1, 2}, {3, 5}, {2, 4}};
        assertEquals(2, ArrayAlgorithm.maxNonOverlappingIntervals(intervals));
    }
}
