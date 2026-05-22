package archive_interview.preparation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day4Test {

    @Test
    void mergeSort() {
        int[] nums = {5, 2, 3, 1};
        Day4.mergeSort(nums);
        assertArrayEquals(new int[]{1, 2, 3, 5}, nums);
    }

    @Test
    void quickSort() {
        int[] nums = {5, 3, 8, 4, 2, 7, 1, 10};
        Day4.quickSort(nums);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 7, 8, 10}, nums);
    }

    @Test
    void binarySearch() {
        assertEquals(0, Day4.binarySearch(new int[]{1, 3, 5, 7, 9}, 1));
        assertEquals(-1, Day4.binarySearch(new int[]{1, 3, 5, 7, 9}, 4));
    }

    @Test
    void searchInsert() {
        assertEquals(1, Day4.searchInsert(new int[]{1, 3, 5, 6}, 2));
        assertEquals(2, Day4.searchInsert(new int[]{1, 3, 5, 6}, 5));
    }

    @Test
    void firstBadVersion() {
        assertEquals(2, Day4.firstBadVersion(5));
    }
}
