package archive_misc;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GreedyAlgorithmTest {

    @Test
    void mergeIntervals() {
        List<int[]> intervals = new ArrayList<>(List.of(new int[]{1, 3}, new int[]{2, 6}, new int[]{8, 10}));
        List<int[]> result = GreedyAlgorithm.mergeIntervals(intervals);
        assertEquals(2, result.size());
        assertArrayEquals(new int[]{1, 6}, result.get(0));
        assertArrayEquals(new int[]{8, 10}, result.get(1));
    }

    @Test
    void canJump() {
        assertTrue(GreedyAlgorithm.canJump(new int[]{2, 3, 1, 1, 4}));
        assertFalse(GreedyAlgorithm.canJump(new int[]{3, 2, 1, 0, 4}));
    }

    @Test
    void maxMeetings() {
        List<int[]> meetings = new ArrayList<>(List.of(new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}, new int[]{1, 4}));
        assertEquals(3, GreedyAlgorithm.maxMeetings(meetings));
    }
}
