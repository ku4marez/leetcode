package archive_misc;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphAlgorithmTest {

    @Test
    void topologicalSort() {
        // 0 → 1, 0 → 2, 1 → 3, 2 → 3
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {2, 3}};
        List<Integer> result = GraphAlgorithm.topologicalSort(4, edges);
        assertEquals(4, result.size());
        // 0 must come before 1 and 2; 1 and 2 must come before 3
        assertTrue(result.indexOf(0) < result.indexOf(1));
        assertTrue(result.indexOf(0) < result.indexOf(2));
        assertTrue(result.indexOf(1) < result.indexOf(3));
    }

    @Test
    void shortestPathUnweighted() {
        // 0-1, 1-2, 0-2, 2-3
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}, {2, 3}};
        assertEquals(2, GraphAlgorithm.shortestPathUnweighted(4, edges, 0, 3));
        assertEquals(0, GraphAlgorithm.shortestPathUnweighted(4, edges, 0, 0));
    }

    @Test
    void hasCycleUndirected() {
        // Triangle: 0-1, 1-2, 0-2
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        assertTrue(GraphAlgorithm.hasCycleUndirected(3, edges));
    }
}
