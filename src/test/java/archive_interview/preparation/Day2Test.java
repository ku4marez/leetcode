package archive_interview.preparation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day2Test {

    @Test
    void containsDuplicate() {
        assertTrue(Day2.containsDuplicate(new int[]{15, 7, 11, 15}));
        assertFalse(Day2.containsDuplicate(new int[]{1, 2, 3, 4}));
    }

    @Test
    void isValid() {
        assertTrue(Day2.isValid("({[]})"));
        assertFalse(Day2.isValid("(]"));
    }

    @Test
    void topKFrequent() {
        int[] result = Day2.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        assertEquals(2, result.length);
    }

    @Test
    void maxSlidingWindow() {
        assertArrayEquals(
                new int[]{3, 3, 5, 5, 6, 7},
                Day2.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)
        );
    }

    @Test
    void lruCache() {
        Day2.LRUCache cache = new Day2.LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1));
        cache.put(3, 3);
        assertEquals(-1, cache.get(2));
    }
}
