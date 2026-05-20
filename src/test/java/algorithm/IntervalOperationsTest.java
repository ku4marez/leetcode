package algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntervalOperationsTest {

    @Test
    void eraseOverlapIntervals() {
        assertEquals(2, IntervalOperations.eraseOverlapIntervals(new int[][]{{1, 100}, {11, 22}, {1, 11}, {2, 12}}));
    }

    @Test
    void insert() {
        int[][] result = IntervalOperations.insert(
                new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}},
                new int[]{4, 8}
        );
        assertEquals(3, result.length);
        assertArrayEquals(new int[]{1, 2}, result[0]);
        assertArrayEquals(new int[]{3, 10}, result[1]);
        assertArrayEquals(new int[]{12, 16}, result[2]);
    }
}
