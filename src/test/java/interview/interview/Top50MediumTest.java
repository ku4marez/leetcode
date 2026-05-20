package interview.interview;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Top50MediumTest {

    @Test
    void setZeroes() {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        Top50Medium.setZeroes(matrix);
        assertArrayEquals(new int[]{1, 0, 1}, matrix[0]);
        assertArrayEquals(new int[]{0, 0, 0}, matrix[1]);
    }

    @Test
    void groupAnagrams() {
        List<List<String>> result = Top50Medium.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        assertEquals(3, result.size());
    }

    @Test
    void lengthOfLongestSubstring() {
        assertEquals(3, Top50Medium.lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    void longestPalindrome() {
        String result = Top50Medium.longestPalindrome("babad");
        assertTrue(result.equals("bab") || result.equals("aba"));
    }

    @Test
    void findPeakElement() {
        int peak = Top50Medium.findPeakElement(new int[]{1, 2, 3, 1});
        assertEquals(2, peak);
    }

    @Test
    void threeSum() {
        List<List<Integer>> result = Top50Medium.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        assertFalse(result.isEmpty());
    }

    @Test
    void increasingTriplet() {
        assertTrue(Top50Medium.increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        assertFalse(Top50Medium.increasingTriplet(new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    void numIslands() {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        assertEquals(3, Top50Medium.numIslands(grid));
    }

    @Test
    void permute() {
        List<List<Integer>> result = Top50Medium.permute(new int[]{1, 2, 3});
        assertEquals(6, result.size());
    }

    @Test
    void subsets() {
        List<List<Integer>> result = Top50Medium.subsets(new int[]{1, 2, 3});
        assertEquals(8, result.size());
    }

    @Test
    void generateParenthesis() {
        List<String> result = Top50Medium.generateParenthesis(3);
        assertEquals(5, result.size());
    }

    @Test
    void exist() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        assertTrue(Top50Medium.exist(board, "ABCCED"));
    }

    @Test
    void coinChange() {
        assertEquals(3, Top50Medium.coinChange(new int[]{1, 2, 5}, 11));
        assertEquals(-1, Top50Medium.coinChange(new int[]{2}, 3));
    }

    @Test
    void canJump() {
        assertTrue(Top50Medium.canJump(new int[]{2, 3, 1, 1, 4}));
        assertFalse(Top50Medium.canJump(new int[]{3, 2, 1, 0, 4}));
    }

    @Test
    void uniquePaths() {
        assertEquals(28, Top50Medium.uniquePaths(3, 7));
    }

    @Test
    void lengthOfLIS() {
        assertEquals(4, Top50Medium.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    @Test
    void merge() {
        int[][] result = Top50Medium.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        assertEquals(3, result.length);
    }

    @Test
    void findKthLargest() {
        assertEquals(5, Top50Medium.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    @Test
    void search() {
        assertEquals(4, Top50Medium.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    @Test
    void sortColors() {
        int[] nums = {2, 0, 2, 1, 1, 0};
        Top50Medium.sortColors(nums);
        assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, nums);
    }

    @Test
    void searchMatrix() {
        assertTrue(Top50Medium.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}}, 3));
        assertFalse(Top50Medium.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}}, 13));
    }

    @Test
    void isHappy() {
        assertTrue(Top50Medium.isHappy(19));
        assertFalse(Top50Medium.isHappy(2));
    }

    @Test
    void divide() {
        assertEquals(3, Top50Medium.divide(10, 3));
    }
}
