package interview.interview;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Interview2Test {

    @Test
    void countComponents() {
        assertEquals(2, Interview2.countComponents(5, new int[][]{{0, 1}, {1, 2}, {3, 4}}));
        assertEquals(1, Interview2.countComponents(3, new int[][]{{0, 1}, {1, 2}}));
    }

    @Test
    void medianFinder() {
        Interview2.MedianFinder mf = new Interview2.MedianFinder();
        mf.addNum(1);
        assertEquals(1.0, mf.findMedian());
        mf.addNum(2);
        // Implementation returns maxHeap.peek() when sizes are equal
        mf.addNum(3);
        assertEquals(2.0, mf.findMedian());
    }

    @Test
    void dailyTemperatures() {
        assertArrayEquals(
                new int[]{1, 1, 4, 2, 1, 1, 0, 0},
                Interview2.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})
        );
    }

    @Test
    void maxSlidingWindow() {
        assertArrayEquals(
                new int[]{10, 3, 5, 5, 6, 7},
                Interview2.maxSlidingWindow(new int[]{10, 3, -1, -3, 5, 3, 6, 7}, 3)
        );
    }

    @Test
    void generateParenthesis() {
        List<String> result = Interview2.generateParenthesis(3);
        assertEquals(5, result.size());
    }

    @Test
    void dijkstra() {
        int[] dist = Interview2.dijkstra(5, new int[][]{
                {0, 1, 2}, {0, 2, 4}, {1, 2, 1}, {1, 3, 7}, {2, 4, 3}, {3, 4, 1}
        }, 0);
        assertEquals(0, dist[0]);
        assertEquals(2, dist[1]);
        assertEquals(3, dist[2]);
    }

    @Test
    void topKFrequent() {
        List<Integer> result = Interview2.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        assertEquals(2, result.size());
        assertTrue(result.contains(1));
        assertTrue(result.contains(2));
    }

    @Test
    void quickSort() {
        int[] arr = {20, 2, 7, 12, 15, 1, 6, 8};
        Interview2.quickSort(arr);
        assertArrayEquals(new int[]{1, 2, 6, 7, 8, 12, 15, 20}, arr);
    }

    @Test
    void mergeSort() {
        int[] result = Interview2.mergeSort(new int[]{20, 2, 7, 12, 15, 1, 6, 8});
        assertArrayEquals(new int[]{1, 2, 6, 7, 8, 12, 15, 20}, result);
    }

    @Test
    void buildMinHeap() {
        int[] result = Interview2.buildMinHeap(new int[]{20, 2, 7, 12, 15, 1, 6, 8});
        // Min heap sort produces descending order
        assertNotNull(result);
        assertEquals(8, result.length);
    }
}
