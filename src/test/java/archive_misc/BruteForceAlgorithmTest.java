package archive_misc;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BruteForceAlgorithmTest {

    @Test
    void generateSubsets() {
        List<List<Integer>> result = BruteForceAlgorithm.generateSubsets(new int[]{1, 2});
        assertEquals(4, result.size()); // 2^2 = 4 subsets
    }

    @Test
    void generatePermutations() {
        List<List<Integer>> result = BruteForceAlgorithm.generatePermutations(new int[]{1, 2, 3});
        assertEquals(6, result.size()); // 3! = 6
    }

    @Test
    void findAllPairs() {
        List<int[]> result = BruteForceAlgorithm.findAllPairs(new int[]{1, 2, 3, 4}, 5);
        assertEquals(2, result.size()); // (0,3) and (1,2)
    }
}
