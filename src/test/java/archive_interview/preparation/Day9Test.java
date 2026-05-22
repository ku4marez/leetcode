package archive_interview.preparation;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day9Test {

    @Test
    void isBipartite() {
        assertTrue(Day9.isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}}));
        // Direct conflict: node 0 connects to 1, node 1 connects to 0 with same color assignment
        assertFalse(Day9.isBipartite(new int[][]{{1}, {0, 2}, {1, 0}}));
    }

    @Test
    void dijkstra() {
        int[] dist = Day9.dijkstra(5, new int[][]{
                {0, 1, 2}, {0, 2, 4}, {1, 2, 1}, {1, 3, 7}, {2, 4, 3}, {3, 4, 1}
        }, 0);
        assertEquals(0, dist[0]);
        assertEquals(2, dist[1]);
        assertEquals(3, dist[2]);
    }

    @Test
    void topKFrequent() {
        List<Integer> result = Day9.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        assertEquals(2, result.size());
        assertTrue(result.contains(1));
        assertTrue(result.contains(2));
    }

    @Test
    void kthLargest() {
        Day9.KthLargest kth = new Day9.KthLargest(3, new int[]{4, 5, 8, 2});
        assertEquals(4, kth.add(3));
        assertEquals(5, kth.add(5));
        assertEquals(5, kth.add(10));
        assertEquals(8, kth.add(9));
    }

    @Test
    void canFinish() {
        assertTrue(Day9.canFinish(4, new int[][]{{1, 0}, {2, 1}, {3, 2}}));
        assertFalse(Day9.canFinish(2, new int[][]{{0, 1}, {1, 0}}));
    }
}
