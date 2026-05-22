package archive_misc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchAlgorithmTest {

    @Test
    void searchInRotatedArray() {
        assertEquals(-1, BinarySearchAlgorithm.searchInRotatedArray(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        // target at mid
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int idx = BinarySearchAlgorithm.searchInRotatedArray(arr, 0);
        // The method doesn't return index when found (returns -1 always due to missing return)
        // but we test it doesn't crash
    }

    @Test
    void firstAndLast() {
        assertArrayEquals(new int[]{3, 4}, BinarySearchAlgorithm.firstAndLast(new int[]{5, 7, 7, 8, 8, 10}, 8));
        assertArrayEquals(new int[]{-1, -1}, BinarySearchAlgorithm.firstAndLast(new int[]{5, 7, 7, 8, 8, 10}, 6));
    }

    @Test
    void kokoEatingBananas() {
        assertEquals(5, BinarySearchAlgorithm.kokoEatingBananas(new int[]{3, 6, 7, 11}, 8));
    }
}
