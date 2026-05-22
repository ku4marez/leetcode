package archive_misc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashMapAlgorithmTest {

    @Test
    void twoSum() {
        assertArrayEquals(new int[]{0, 1}, HashMapAlgorithm.twoSum(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{-1, -1}, HashMapAlgorithm.twoSum(new int[]{1, 2, 3}, 10));
    }

    @Test
    void groupAnagrams() {
        var result = HashMapAlgorithm.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        assertEquals(3, result.size());
    }

    @Test
    void subArrSumEqualsK() {
        assertEquals(2, HashMapAlgorithm.subArrSumEqualsK(new int[]{1, 1, 1}, 2));
        assertEquals(2, HashMapAlgorithm.subArrSumEqualsK(new int[]{1, 2, 3}, 3));
    }
}
