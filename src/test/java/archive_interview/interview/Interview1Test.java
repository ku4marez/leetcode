package archive_interview.interview;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Interview1Test {

    @Test
    void twoSum() {
        assertArrayEquals(new int[]{0, 1}, Interview1.twoSum(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{1, 2}, Interview1.twoSum(new int[]{3, 2, 4}, 6));
    }

    @Test
    void lengthOfLongestSubstring() {
        assertEquals(3, Interview1.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, Interview1.lengthOfLongestSubstring("bbbbb"));
    }

    @Test
    void merge() {
        int[][] result = Interview1.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        assertEquals(3, result.length);
        assertArrayEquals(new int[]{1, 6}, result[0]);
    }

    @Test
    void topKFrequent() {
        List<Integer> result = Interview1.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        assertEquals(2, result.size());
        assertTrue(result.contains(1));
        assertTrue(result.contains(2));
    }

    @Test
    void searchInsert() {
        assertEquals(2, Interview1.searchInsert(new int[]{1, 3, 5, 6}, 5));
        assertEquals(1, Interview1.searchInsert(new int[]{1, 3, 5, 6}, 2));
        assertEquals(4, Interview1.searchInsert(new int[]{1, 3, 5, 6}, 7));
    }
}
