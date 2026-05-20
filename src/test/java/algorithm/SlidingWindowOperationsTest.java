package algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SlidingWindowOperationsTest {

    @Test
    void containsDuplicate() {
        assertTrue(SlidingWindowOperations.containsDuplicate(new int[]{1, 2, 3, 1}));
        assertFalse(SlidingWindowOperations.containsDuplicate(new int[]{1, 2, 3, 4}));
    }

    @Test
    void findLHS() {
        assertEquals(5, SlidingWindowOperations.findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
    }

    @Test
    void containsNearbyDuplicate() {
        assertTrue(SlidingWindowOperations.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        assertFalse(SlidingWindowOperations.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    @Test
    void minSubArrayLen() {
        assertEquals(2, SlidingWindowOperations.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    @Test
    void checkInclusion() {
        assertTrue(SlidingWindowOperations.checkInclusion("ab", "eidbaooo"));
        assertFalse(SlidingWindowOperations.checkInclusion("ab", "eidboaoo"));
    }

    @Test
    void characterReplacement() {
        assertEquals(4, SlidingWindowOperations.characterReplacement("AABABBA", 1));
    }

    @Test
    void maxSlidingWindow() {
        assertArrayEquals(
                new int[]{3, 3, 2, 5},
                SlidingWindowOperations.maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3)
        );
    }

    @Test
    void minWindow() {
        assertEquals("", SlidingWindowOperations.minWindow("a", "aa"));
        assertEquals("BANC", SlidingWindowOperations.minWindow("ADOBECODEBANC", "ABC"));
    }
}
