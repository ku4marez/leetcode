package interview.preparation;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day7Test {

    @Test
    void permute() {
        List<List<Integer>> result = Day7.permute(new int[]{1, 2, 3});
        assertEquals(6, result.size());
    }

    @Test
    void subsets() {
        List<List<Integer>> result = Day7.subsets(new int[]{1, 2, 3});
        assertEquals(8, result.size());
    }

    @Test
    void multiply() {
        assertEquals(15, Day7.multiply(5, 3));
        assertEquals(-15, Day7.multiply(5, -3));
    }

    @Test
    void wordBreak() {
        assertTrue(Day7.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        assertFalse(Day7.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }

    @Test
    void combinationSum() {
        List<List<Integer>> result = Day7.combinationSum(new int[]{2, 3, 6, 7}, 7);
        assertEquals(2, result.size());
    }
}
