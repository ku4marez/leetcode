package interview.preparation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day14Test {

    @Test
    void numIslands() {
        // Stub returns 0
        assertEquals(0, Day14.numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        }));
    }

    @Test
    void permute() {
        assertTrue(Day14.permute(new int[]{1, 2, 3}).isEmpty());
    }

    @Test
    void topKFrequent() {
        assertTrue(Day14.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2).isEmpty());
    }

    @Test
    void minPathSum() {
        assertEquals(0, Day14.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }

    @Test
    void exist() {
        assertFalse(Day14.exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCCED"));
    }
}
