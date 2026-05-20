package algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchOperationsTest {

    @Test
    void mySqrt() {
        assertEquals(2, BinarySearchOperations.mySqrt(8));
        assertEquals(3, BinarySearchOperations.mySqrt(9));
    }

    @Test
    void isPerfectSquare() {
        assertTrue(BinarySearchOperations.isPerfectSquare(16));
        assertFalse(BinarySearchOperations.isPerfectSquare(14));
    }

    @Test
    void arrangeCoins() {
        assertEquals(2, BinarySearchOperations.arrangeCoins(5));
    }

    @Test
    void search() {
        assertEquals(-1, BinarySearchOperations.search(new int[]{2, 5}, 0));
    }

    @Test
    void searchMatrix() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertTrue(BinarySearchOperations.searchMatrix(matrix, 3));
        assertFalse(BinarySearchOperations.searchMatrix(matrix, 10));
    }

    @Test
    void minEatingSpeed() {
        assertEquals(4, BinarySearchOperations.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
    }

    @Test
    void findMin() {
        assertEquals(0, BinarySearchOperations.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }
}
