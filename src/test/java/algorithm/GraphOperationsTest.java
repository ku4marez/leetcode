package algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphOperationsTest {

    @Test
    void findCenter() {
        assertEquals(2, GraphOperations.findCenter(new int[][]{{1, 2}, {2, 3}, {4, 2}}));
    }

    @Test
    void findJudge() {
        assertEquals(3, GraphOperations.findJudge(4, new int[][]{{1, 3}, {2, 3}, {4, 3}}));
    }

    @Test
    void validPathBfs() {
        assertTrue(GraphOperations.validPathBfs(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2));
    }

    @Test
    void validPathDfs() {
        assertTrue(GraphOperations.validPathDfs(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2));
    }

    @Test
    void cloneGraph() {
        GraphOperations.Node node1 = new GraphOperations.Node(1);
        GraphOperations.Node node2 = new GraphOperations.Node(2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);

        GraphOperations.Node clone = GraphOperations.cloneGraph(node1);
        assertNotNull(clone);
        assertEquals(1, clone.val);
        assertNotSame(node1, clone);
    }

    @Test
    void findRedundantConnection() {
        assertArrayEquals(new int[]{2, 3}, GraphOperations.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}}));
    }

    @Test
    void canFinish() {
        assertTrue(GraphOperations.canFinish(2, new int[][]{{1, 0}}));
        assertFalse(GraphOperations.canFinish(2, new int[][]{{0, 1}, {1, 0}}));
    }

    @Test
    void countComponents() {
        assertEquals(2, GraphOperations.countComponents(5, new int[][]{{0, 1}, {1, 2}, {3, 4}}));
    }

    @Test
    void findCircleNum() {
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        assertEquals(2, GraphOperations.findCircleNum(isConnected));
    }

    @Test
    void alienOrder() {
        List<String> words = List.of("wrt", "wrf", "er", "ett", "rftt");
        String result = GraphOperations.alienOrder(words);
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    void networkDelayTime() {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        assertEquals(2, GraphOperations.networkDelayTime(times, 4, 2));
    }

    @Test
    void minCostConnectPoints() {
        assertEquals(20, GraphOperations.minCostConnectPoints(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}));
    }

    @Test
    void findOrder() {
        int[] order = GraphOperations.findOrder(4, new int[][]{{1, 0}, {2, 1}, {3, 2}});
        assertEquals(4, order.length);
        assertEquals(0, order[0]);
    }
}
