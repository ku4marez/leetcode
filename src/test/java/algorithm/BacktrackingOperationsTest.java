package algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BacktrackingOperationsTest {

    @Test
    void combinationSum() {
        List<List<Integer>> result = BacktrackingOperations.combinationSum(new int[]{2, 3, 6, 7}, 7);
        assertEquals(2, result.size());
    }

    @Test
    void combinationSum2() {
        List<List<Integer>> result = BacktrackingOperations.combinationSum2(new int[]{10, 1, 2, 7, 6, 5, 1}, 8);
        assertFalse(result.isEmpty());
    }

    @Test
    void subsetsWithDup() {
        List<List<Integer>> result = BacktrackingOperations.subsetsWithDup(new int[]{1, 2, 2});
        assertEquals(6, result.size());
    }

    @Test
    void findTargetSumWays() {
        assertEquals(5, BacktrackingOperations.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    @Test
    void partition() {
        List<List<String>> result = BacktrackingOperations.partition("aab");
        assertFalse(result.isEmpty());
    }

    @Test
    void totalNumbers() {
        int result = BacktrackingOperations.totalNumbers(new int[]{0, 2, 2});
        assertTrue(result >= 0);
    }

    @Test
    void solve() {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        BacktrackingOperations.solve(board);
        assertEquals('X', board[1][1]);
        assertEquals('X', board[1][2]);
        assertEquals('O', board[3][1]);
    }

    @Test
    void maxAreaOfIsland() {
        int[][] grid = {
                {0, 0, 1, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0},
        };
        assertEquals(3, BacktrackingOperations.maxAreaOfIsland(grid));
    }

    @Test
    void orangesRotting() {
        assertEquals(4, BacktrackingOperations.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
    }

    @Test
    void wordBreak() {
        assertTrue(BacktrackingOperations.wordBreak("leetcode", List.of("leet", "code")));
        assertFalse(BacktrackingOperations.wordBreak("leetcodex", List.of("leet", "code")));
    }
}
