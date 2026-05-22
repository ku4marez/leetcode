package archive_misc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SlidingWindowAlgorithmTest {

    @Test
    void longestSubstringNoRepeating() {
        assertEquals(3, SlidingWindowAlgorithm.longestSubstringNoRepeating("abcabcbb"));
        assertEquals(1, SlidingWindowAlgorithm.longestSubstringNoRepeating("bbbbb"));
        assertEquals(3, SlidingWindowAlgorithm.longestSubstringNoRepeating("pwwkew"));
        assertEquals(0, SlidingWindowAlgorithm.longestSubstringNoRepeating(""));
    }

    @Test
    void minSubArrSum() {
        assertEquals(2, SlidingWindowAlgorithm.minSubArrSum(new int[]{2, 3, 1, 2, 4, 3}, 7));
        assertEquals(0, SlidingWindowAlgorithm.minSubArrSum(new int[]{1, 1, 1, 1}, 100));
    }

    @Test
    void maxSubArrSum() {
        assertEquals(9, SlidingWindowAlgorithm.maxSubArrSum(new int[]{1, 2, 3, 4, 5}, 2));
    }
}
