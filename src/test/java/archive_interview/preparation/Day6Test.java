package archive_interview.preparation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day6Test {

    @Test
    void merge() {
        int[][] result = Day6.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        assertEquals(3, result.length);
        assertArrayEquals(new int[]{1, 6}, result[0]);
    }

    @Test
    void insert() {
        int[][] result = Day6.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8});
        assertEquals(3, result.length);
        assertArrayEquals(new int[]{3, 10}, result[1]);
    }

    @Test
    void dailyTemperatures() {
        assertArrayEquals(
                new int[]{1, 1, 4, 2, 1, 1, 0, 0},
                Day6.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})
        );
    }

    @Test
    void isValid() {
        assertTrue(Day6.isValid("({[]})"));
        assertFalse(Day6.isValid("(]"));
    }

    @Test
    void maxSlidingWindow() {
        assertArrayEquals(
                new int[]{3, 3, 5, 5, 6, 7},
                Day6.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)
        );
    }
}
