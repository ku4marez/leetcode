package interview.preparation;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day15Test {

    @Test
    void countIslands() {
        char[][] grid = {
                {'1', '1', '0', '0'},
                {'1', '0', '0', '1'},
                {'0', '0', '1', '1'}
        };
        assertEquals(2, Day15.countIslands(grid));
    }

    @Test
    void floodFill() {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] result = Day15.floodFill(image, 1, 1, 2);
        assertEquals(2, result[0][0]);
        assertEquals(2, result[1][0]);
        assertEquals(0, result[1][2]);
    }

    @Test
    void findAllPaths() {
        List<List<String>> paths = Day15.findAllPaths(2, 2);
        assertEquals(2, paths.size());
    }
}
