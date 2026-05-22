package archive_interview.preparation;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day11Test {

    @Test
    void subsets() {
        List<List<Integer>> result = Day11.subsets(new int[]{1, 2, 3});
        assertEquals(8, result.size());
    }

    @Test
    void permute() {
        List<List<Integer>> result = Day11.permute(List.of(1, 2, 3));
        assertEquals(6, result.size());
    }

    @Test
    void exist() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        assertTrue(Day11.exist(board, "ABCCED"));
        assertFalse(Day11.exist(board, "ABCB"));
    }

    @Test
    void solveNQueens() {
        List<List<String>> result = Day11.solveNQueens(4);
        assertEquals(2, result.size());
    }

    @Test
    void restoreIpAddresses() {
        List<String> result = Day11.restoreIpAddresses("25525511135");
        assertFalse(result.isEmpty());
        assertTrue(result.contains("255.255.11.135"));
    }
}
