package algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BitOperationsTest {

    @Test
    void missingNumber() {
        assertEquals(8, BitOperations.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }

    @Test
    void singleNumber() {
        assertEquals(1, BitOperations.singleNumber(new int[]{2, 2, 1}));
    }

    @Test
    void hammingWeight() {
        assertEquals(3, BitOperations.hammingWeight(7));
    }

    @Test
    void hammingDistance() {
        assertEquals(2, BitOperations.hammingDistance(1, 4));
    }

    @Test
    void reverseBits() {
        assertEquals(964176192, BitOperations.reverseBits(0b00000010100101000001111010011100));
    }

    @Test
    void isPowerOfTwo() {
        assertTrue(BitOperations.isPowerOfTwo(4));
        assertFalse(BitOperations.isPowerOfTwo(6));
    }

    @Test
    void isPowerOfThree() {
        assertTrue(BitOperations.isPowerOfThree(9));
        assertFalse(BitOperations.isPowerOfThree(10));
    }

    @Test
    void isPowerOfFour() {
        assertTrue(BitOperations.isPowerOfFour(4));
        assertFalse(BitOperations.isPowerOfFour(6));
    }

    @Test
    void findTheDifference() {
        assertEquals('t', BitOperations.findTheDifference("abcdd", "abcddt"));
    }

    @Test
    void findComplement() {
        assertEquals(2, BitOperations.findComplement(5));
    }

    @Test
    void divide() {
        assertEquals(3, BitOperations.divide(10, 3));
        assertEquals(Integer.MAX_VALUE, BitOperations.divide(Integer.MIN_VALUE, -1));
    }
}
