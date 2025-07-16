package interview.preparation;


import java.util.*;

public class Day10 {
    // 1. Can attend all meetings? (Greedy)
    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int i = 1; i < intervals.length; i++) {
            int[] prev = intervals[i-1];
            int[] curr = intervals[i];
            if (curr[0] < prev[1]) {
                return false;
            }
        }
        return true;
    }

    // 2. Reconstruct Itinerary (Graph + DFS + Lexical Ordering)
    public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (List<String> ticket : tickets) {
            String start = ticket.get(0), end = ticket.get(1);
            map.computeIfAbsent(start, k -> new PriorityQueue<>()).add(end);
        }
        dfs("JFK", map, res);
        return res;
    }

    private static void dfs(String cur, Map<String, PriorityQueue<String>> map, List<String> res) {
        PriorityQueue<String> dests = map.get(cur);
        while (dests != null && !dests.isEmpty()) {
            dfs(dests.poll(), map, res);
        }
        res.addFirst(cur);
    }

    // 3. Pacific Atlantic Water Flow (DFS from both oceans)
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) return result;

        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0, heights[i][0]);         // Left edge
            dfs(heights, atlantic, i, n - 1, heights[i][n - 1]); // Right edge
        }

        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j, heights[0][j]);          // Top edge
            dfs(heights, atlantic, m - 1, j, heights[m - 1][j]); // Bottom edge
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }

        return result;
    }

    private static void dfs(int[][] heights, boolean[][] ocean, int i, int j, int prevHeight) {
        int m = heights.length, n = heights[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) return;
        if (ocean[i][j]) return;
        if (heights[i][j] < prevHeight) return;

        ocean[i][j] = true;

        dfs(heights, ocean, i + 1, j, heights[i][j]);
        dfs(heights, ocean, i - 1, j, heights[i][j]);
        dfs(heights, ocean, i, j + 1, heights[i][j]);
        dfs(heights, ocean, i, j - 1, heights[i][j]);
    }

    // 4. Minimum jumps to reach end (Greedy)
    public static int jump(int[] nums) {
        if (nums.length == 0) return 0;
        int jumps = 0;
        int end = 0;
        int farthest = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == end) {
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    }

    // 5. Accounts Merge (Graph DFS / Union-Find)
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        Set<String> visited = new HashSet<>();
        List<List<String>> res = new ArrayList<>();

        // Build graph
        for (List<String> acc : accounts) {
            String name = acc.get(0);
            String first = acc.get(1);
            for (int i = 1; i < acc.size(); i++) {
                String email = acc.get(i);
                emailToName.put(email, name);
                graph.computeIfAbsent(email, k -> new ArrayList<>());
                if (i > 1) {
                    graph.get(email).add(first);
                    graph.get(first).add(email);
                }
            }
        }

        // DFS for connected components
        for (String email : graph.keySet()) {
            if (!visited.contains(email)) {
                List<String> component = new ArrayList<>();
                dfs(email, graph, visited, component);
                Collections.sort(component);
                component.addFirst(emailToName.get(email)); // prepend name
                res.add(component);
            }
        }

        return res;
    }

    private static void dfs(String email, Map<String, List<String>> graph, Set<String> visited, List<String> comp) {
        visited.add(email);
        comp.add(email);
        for (String nei : graph.get(email)) {
            if (!visited.contains(nei)) {
                dfs(nei, graph, visited, comp);
            }
        }
    }
}
