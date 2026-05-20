package algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayOperationsTest {

    @Test
    void commonPrefix() {
        assertEquals("fl", ArrayOperations.commonPrefix(new String[]{"flower", "flow", "flight"}));
        assertEquals("", ArrayOperations.commonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    @Test
    void plusOne() {
        assertArrayEquals(new int[]{1, 2, 4}, ArrayOperations.plusOne(new int[]{1, 2, 3}));
        assertArrayEquals(new int[]{1, 0, 0, 0}, ArrayOperations.plusOne(new int[]{9, 9, 9}));
    }

    @Test
    void findDisappearedNumbers() {
        assertEquals(List.of(5, 6), ArrayOperations.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    @Test
    void findDuplicates() {
        assertEquals(List.of(2, 3), ArrayOperations.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    @Test
    void searchInsert() {
        assertEquals(2, ArrayOperations.searchInsert(new int[]{1, 3, 5, 6}, 5));
        assertEquals(4, ArrayOperations.searchInsert(new int[]{1, 3, 5, 6}, 7));
    }

    @Test
    void majorityElement() {
        assertEquals(3, ArrayOperations.majorityElement(new int[]{3, 2, 3}));
        assertEquals(2, ArrayOperations.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    @Test
    void thirdMax() {
        assertEquals(1, ArrayOperations.thirdMax(new int[]{3, 2, 1}));
        assertEquals(0, ArrayOperations.thirdMax(new int[]{3, 3, 4, 3, 4, 3, 0, 3, 3}));
    }

    @Test
    void findContentChildren() {
        assertEquals(1, ArrayOperations.findContentChildren(new int[]{1, 2, 3}, new int[]{3}));
    }

    @Test
    void arrayPairSum() {
        assertEquals(4, ArrayOperations.arrayPairSum(new int[]{1, 4, 3, 2}));
    }

    @Test
    void islandPerimeter() {
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        assertEquals(16, ArrayOperations.islandPerimeter(grid));
    }

    @Test
    void findRelativeRanks() {
        assertArrayEquals(
                new String[]{"Gold Medal", "5", "Bronze Medal", "Silver Medal", "4"},
                ArrayOperations.findRelativeRanks(new int[]{5, 1, 3, 4, 2})
        );
    }

    @Test
    void lastStoneWeight() {
        assertEquals(1, ArrayOperations.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }

    @Test
    void findKthLargest() {
        assertEquals(5, ArrayOperations.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    @Test
    void longestConsecutive() {
        assertEquals(4, ArrayOperations.longestConsecutive(new int[]{100, 1, 200, 2, 3, 4}));
    }

    @Test
    void findDuplicate() {
        assertEquals(2, ArrayOperations.findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }

    @Test
    void productExceptSelf() {
        assertArrayEquals(new int[]{24, 12, 8, 6}, ArrayOperations.productExceptSelf(new int[]{1, 2, 3, 4}));
    }

    @Test
    void findLengthOfLCIS() {
        assertEquals(3, ArrayOperations.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
    }

    @Test
    void nextPermutation() {
        int[] nums = {1, 3, 2};
        ArrayOperations.nextPermutation(nums);
        assertArrayEquals(new int[]{2, 1, 3}, nums);
    }

    @Test
    void findMaxConsecutiveOnes() {
        assertEquals(3, ArrayOperations.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }

    @Test
    void printNumbers() {
        // Just verify it doesn't throw
        assertDoesNotThrow(ArrayOperations::printNumbers);
    }
}
