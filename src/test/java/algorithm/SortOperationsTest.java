package algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortOperationsTest {

    @Test
    void sortMerge() {
        int[] arr = {5, 3, 8, 1, 2};
        SortOperations.sortMerge(arr);
        assertArrayEquals(new int[]{1, 2, 3, 5, 8}, arr);
    }

    @Test
    void sortQuick() {
        int[] arr = {4, 1, 3, 9, 7};
        SortOperations.sortQuick(arr, 0, arr.length - 1);
        assertArrayEquals(new int[]{1, 3, 4, 7, 9}, arr);
    }

    @Test
    void sortQuick2() {
        assertArrayEquals(new int[]{1, 2, 3, 5}, SortOperations.sortQuick2(new int[]{5, 2, 3, 1}));
    }

    @Test
    void bubbleSort() {
        int[] arr = {3, 2, 9, 4, 5, 6, 1, 8, 7};
        SortOperations.bubbleSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, arr);
    }

    @Test
    void firstMissingPositive() {
        assertEquals(3, SortOperations.firstMissingPositive(new int[]{1, 2, 0}));
        assertEquals(2, SortOperations.firstMissingPositive(new int[]{3, 4, -1, 1}));
    }
}
