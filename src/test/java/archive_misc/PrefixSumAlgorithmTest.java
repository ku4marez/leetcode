package archive_misc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrefixSumAlgorithmTest {

    @Test
    void rangeSumQuery() {
        assertEquals(9, PrefixSumAlgorithm.rangeSumQuery(new int[]{1, 2, 3, 4, 5}, 1, 3));
    }

    @Test
    void subArrSumEqualsK() {
        assertEquals(2, PrefixSumAlgorithm.subArrSumEqualsK(new int[]{1, 1, 1}, 2));
    }

    @Test
    void findPivotIndex() {
        assertEquals(3, PrefixSumAlgorithm.findPivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        assertEquals(-1, PrefixSumAlgorithm.findPivotIndex(new int[]{1, 2, 3}));
    }
}
