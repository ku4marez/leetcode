package algorithm;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HashMapOperationsTest {

    @Test
    void twoSum() {
        assertArrayEquals(new int[]{0, 2}, HashMapOperations.twoSum(new int[]{3, 2, 3}, 6));
    }

    @Test
    void mostCommonWord() {
        assertEquals("ball", HashMapOperations.mostCommonWord(
                "Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
    }

    @Test
    void wordPattern() {
        assertTrue(HashMapOperations.wordPattern("abba", "dog cat cat dog"));
        assertFalse(HashMapOperations.wordPattern("abba", "dog dog dog dog"));
    }

    @Test
    void longestPalindrome() {
        assertEquals(7, HashMapOperations.longestPalindrome("abccccdd"));
    }

    @Test
    void isIsomorphic() {
        assertTrue(HashMapOperations.isIsomorphic("egg", "add"));
        assertFalse(HashMapOperations.isIsomorphic("foo", "bar"));
    }

    @Test
    void canConstruct() {
        assertTrue(HashMapOperations.canConstruct("aa", "aab"));
        assertFalse(HashMapOperations.canConstruct("ada", "aab"));
    }

    @Test
    void findAnagrams() {
        assertEquals(List.of(0, 1, 2, 3, 4), HashMapOperations.findAnagrams("ababab", "ab"));
    }
}
