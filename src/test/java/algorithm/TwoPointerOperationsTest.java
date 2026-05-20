package algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TwoPointerOperationsTest {

    @Test
    void removeElement() {
        int[] nums = {3, 2, 2, 3};
        assertEquals(2, TwoPointerOperations.removeElement(nums, 3));
    }

    @Test
    void removeDuplicates() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        assertEquals(5, TwoPointerOperations.removeDuplicates(nums));
    }

    @Test
    void removeDuplicates2() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        assertEquals(5, TwoPointerOperations.removeDuplicates2(nums));
    }

    @Test
    void twoSumSorted() {
        assertArrayEquals(new int[]{1, 2}, TwoPointerOperations.twoSumSorted(new int[]{2, 7, 11, 15}, 9));
    }

    @Test
    void rotate() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        TwoPointerOperations.rotate(arr, 3);
        assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, arr);
    }

    @Test
    void merge() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        TwoPointerOperations.merge(nums1, 3, new int[]{2, 5, 6}, 3);
        assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, nums1);
    }

    @Test
    void intersection() {
        int[] result = TwoPointerOperations.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        assertEquals(1, result.length);
        assertEquals(2, result[0]);
    }

    @Test
    void summaryRanges() {
        assertEquals(
                List.of("0->2", "4->5", "7"),
                TwoPointerOperations.summaryRanges(new int[]{0, 1, 2, 4, 5, 7})
        );
    }

    @Test
    void longestPalindrome() {
        String result = TwoPointerOperations.longestPalindrome("babad");
        assertTrue(result.equals("bab") || result.equals("aba"));
    }

    @Test
    void moveZeroes() {
        int[] nums = {0, 1, 0, 3, 12};
        TwoPointerOperations.moveZeroes(nums);
        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, nums);
    }

    @Test
    void reverseString() {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        TwoPointerOperations.reverseString(s);
        assertArrayEquals(new char[]{'o', 'l', 'l', 'e', 'h'}, s);
    }

    @Test
    void reverseVowels() {
        assertEquals("AceCreIm", TwoPointerOperations.reverseVowels("IceCreAm"));
    }

    @Test
    void countSubstrings() {
        assertEquals(7, TwoPointerOperations.countSubstrings("aabcc"));
    }

    @Test
    void partitionLabels() {
        assertEquals(List.of(4, 2), TwoPointerOperations.partitionLabels("ababcc"));
    }

    @Test
    void fourSum() {
        List<List<Integer>> result = TwoPointerOperations.fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296);
        assertTrue(result.isEmpty());
    }
}
