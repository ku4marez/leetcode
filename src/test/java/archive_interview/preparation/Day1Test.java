package archive_interview.preparation;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day1Test {

    @Test
    void removeDuplicates() {
        assertEquals(3, Day1.removeDuplicates(new int[]{1, 1, 2, 2, 3}));
    }

    @Test
    void lengthOfLongestSubstring() {
        assertEquals(3, Day1.lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    void isPalindrome() {
        assertTrue(Day1.isPalindrome("A man, a plan, a canal: Panama"));
        assertFalse(Day1.isPalindrome("race a car"));
    }

    @Test
    void maxSumSubarrayOfSizeK() {
        assertEquals(22, Day1.maxSumSubarrayOfSizeK(new int[]{2, 1, 5, 1, 3, 2}, 3));
    }

    @Test
    void twoSum() {
        assertArrayEquals(new int[]{0, 1}, Day1.twoSum(new int[]{2, 7, 11, 15}, 9));
    }
}
