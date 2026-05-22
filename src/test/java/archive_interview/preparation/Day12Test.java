package archive_interview.preparation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day12Test {

    @Test
    void hasCycle() {
        assertFalse(Day12.hasCycle(5, new int[][]{{0, 1}, {1, 2}, {3, 4}}));
        assertTrue(Day12.hasCycle(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}));
    }

    @Test
    void lengthOfLongestSubstring() {
        assertEquals(3, Day12.lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    void maxSlidingWindow() {
        assertArrayEquals(
                new int[]{3, 3, 5, 5, 6, 7},
                Day12.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)
        );
    }

    @Test
    void minWindow() {
        assertEquals("BANC", Day12.minWindow("ADOBECODEBANC", "ABC"));
    }

    @Test
    void findCircleNum() {
        assertEquals(2, Day12.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }
}
