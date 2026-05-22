package archive_interview.preparation;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day10Test {

    @Test
    void canAttendMeetings() {
        assertFalse(Day10.canAttendMeetings(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
        assertTrue(Day10.canAttendMeetings(new int[][]{{0, 5}, {5, 10}, {15, 20}}));
    }

    @Test
    void findItinerary() {
        List<String> result = Day10.findItinerary(List.of(
                List.of("JFK", "SFO"),
                List.of("JFK", "ATL"),
                List.of("SFO", "ATL"),
                List.of("ATL", "JFK"),
                List.of("ATL", "SFO")
        ));
        assertEquals("JFK", result.get(0));
        assertEquals(6, result.size());
    }

    @Test
    void pacificAtlantic() {
        List<List<Integer>> result = Day10.pacificAtlantic(new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        });
        assertFalse(result.isEmpty());
    }

    @Test
    void jump() {
        assertEquals(2, Day10.jump(new int[]{2, 3, 1, 1, 4}));
    }

    @Test
    void accountsMerge() {
        List<List<String>> result = Day10.accountsMerge(List.of(
                List.of("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                List.of("John", "johnsmith@mail.com", "john00@mail.com"),
                List.of("Mary", "mary@mail.com"),
                List.of("John", "johnnybravo@mail.com")
        ));
        assertFalse(result.isEmpty());
    }
}
