package archive_misc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathAlgorithmTest {

    @Test
    void gcd() {
        assertEquals(6, MathAlgorithm.gcd(12, 18));
        assertEquals(1, MathAlgorithm.gcd(7, 13));
    }

    @Test
    void lcm() {
        assertEquals(36, MathAlgorithm.lcm(12, 18));
    }

    @Test
    void sumOfN() {
        assertEquals(55, MathAlgorithm.sumOfN(10));
    }

    @Test
    void sumOfNSquares() {
        assertEquals(385, MathAlgorithm.sumOfNSquares(10));
    }

    @Test
    void nCoins() {
        assertEquals(3, MathAlgorithm.nCoins(6));  // 1+2+3=6
        assertEquals(4, MathAlgorithm.nCoins(10)); // 1+2+3+4=10
    }

    @Test
    void findUnique() {
        assertEquals(3, MathAlgorithm.findUnique(new int[]{1, 1, 2, 2, 3}));
    }

    @Test
    void count1s() {
        assertEquals(3, MathAlgorithm.count1s(7));  // 111
        assertEquals(1, MathAlgorithm.count1s(8));  // 1000
    }

    @Test
    void generateSubsetsBitmask() {
        int[] result = MathAlgorithm.generateSubsetsBitmask(3);
        assertEquals(8, result.length); // 2^3
    }
}
