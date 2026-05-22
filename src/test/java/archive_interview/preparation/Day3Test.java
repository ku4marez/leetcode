package archive_interview.preparation;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day3Test {

    @Test
    void permute() {
        List<List<Integer>> result = Day3.permute(new int[]{1, 2, 3});
        assertEquals(6, result.size());
    }

    @Test
    void ladderLength() {
        assertEquals(5, Day3.ladderLength("hit", "cog",
                Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }

    @Test
    void floodFill() {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] result = Day3.floodFill(image, 1, 1, 2);
        assertEquals(2, result[0][0]);
        assertEquals(0, result[1][2]);
    }

    @Test
    void generateParenthesis() {
        List<String> result = Day3.generateParenthesis(3);
        assertEquals(5, result.size());
    }

    @Test
    void cloneGraph() {
        Day3.Node node1 = new Day3.Node(1);
        Day3.Node node2 = new Day3.Node(2);
        node1.neighbors = Arrays.asList(node2);
        node2.neighbors = Arrays.asList(node1);

        Day3.Node clone = Day3.cloneGraph(node1);
        assertNotNull(clone);
        assertEquals(1, clone.val);
        assertNotSame(node1, clone);
    }
}
