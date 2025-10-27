package misc;

import java.util.*;

public class GraphAlgorithm {

    // 1. Build graph from edge list
    private static Map<Integer, List<Integer>> buildAdjList(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        return adjList;
    }

    // 2. DFS traversal (recursive)
    private static void dfs(int node, boolean[] visited, Map<Integer, List<Integer>> graph) {
        visited[node] = true;
        for (int adj : graph.get(node)) {
            if (!visited[adj]) {
                dfs(adj, visited, graph);
            }
        }
    }

    // 3. BFS traversal (iterative)
    private static void bfs(int start, Map<Integer, List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = true;
            for (int adj : graph.get(node)) {
                if (!visited[adj]) {
                    queue.add(adj);
                }
            }
        }
    }

    // 4. Count connected components in undirected graph
    private static int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = buildAdjList(n, edges);
        int count = countComponents(0, new boolean[n], graph, 0);
        return count;
    }

    private static int countComponents(int node, boolean[] visited, Map<Integer, List<Integer>> graph, int count) {
        visited[node] = true;
        for (int adj : graph.get(node)) {
            if (!visited[adj]) {
                return countComponents(adj, visited, graph, count + 1);
            }
        }
        return count;
    }

    // 5. Detect cycle in undirected graph
    private static boolean hasCycleUndirected(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> graph = buildAdjList(n, edges);
        for (int i = 0; i < n; i++) {
            if (!visited[i] && hasCycleUndirected(i, -1, visited, graph)) return true;
        }
        return false;
    }

    private static boolean hasCycleUndirected(int node, int parent, boolean[] visited, Map<Integer, List<Integer>> graph) {
        visited[node] = true;
        for (int adj : graph.get(node)) {
            if (!visited[adj]) {
                return hasCycleUndirected(adj, parent, visited, graph);
            } else if (adj != parent) return true;
        }
        return false;
    }

    // 6. Detect cycle in directed graph
    private static boolean hasCycleDirected(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = buildAdjList(n, edges);
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] != 0 && hasCycleDirected(i, visited, graph)) return true;
        }
        return false;
    }

    private static boolean hasCycleDirected(int n, int[] visited, Map<Integer, List<Integer>> graph) {
        if (visited[n] == 1) return true;
        visited[n] = 1;
        for (int adj : graph.get(n)) {
            if (hasCycleDirected(adj, visited, graph)) return true;
            else visited[n] = 2;
        }
        return false;
    }

    // 7. Topological sort (Kahn’s algorithm - BFS)
    private static List<Integer> topologicalSort(int n, int[][] edges) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        List<Integer> topologicalOrder = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) topologicalSort(i, visited, graph, stack);
        }
        while (!stack.isEmpty()) {
            topologicalOrder.add(stack.pop());
        }
        return topologicalOrder;
    }

    private static void topologicalSort(int n, boolean[] visited, Map<Integer, List<Integer>> graph, Stack<Integer> stack) {
        visited[n] = true;
        for (int adj : graph.get(n)) {
            if (!visited[adj]) {
                topologicalSort(adj, visited, graph, stack);
            }
        }
        stack.push(n);
    }

    // 8. Shortest path in unweighted graph (BFS)
    private static int shortestPathUnweighted(int n, int[][] edges, int src, int dest) {
        Map<Integer, List<Integer>> graph = buildAdjList(n, edges);
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited.add(src);
        int count = 0;
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                Integer node = queue.poll();

                if (node == dest) return count;

                for (int adj : graph.get(node)) {
                    if (!visited.contains(adj)) {
                        queue.add(adj);
                        visited.add(adj);
                    }
                }
            }
            count++;
        }
        return -1;
    }

    // 9. Union-Find (Disjoint Set)
    private static class UnionFind {
        int[] parent;
        int[] rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            // TODO: implement path compression
            return 0;
        }

        void union(int a, int b) {
            // TODO: union by rank
        }
    }

    // 10. Connected components using Union-Find
    private static int countComponentsUnionFind(int n, int[][] edges) {
        // TODO: use UnionFind class
        return 0;
    }

    // 11. Shortest path in binary matrix (multi-source BFS style)
    private static int shortestPathBinaryMatrix(int[][] grid) {
        // TODO: BFS in 8 directions
        return -1;
    }

    // 12. Clone graph (DFS or BFS)
    private static class Node {
        int val;
        List<Node> neighbors;

        Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }
    }

    private static Node cloneGraph(Node node) {
        // TODO: use DFS or BFS with hashmap of visited nodes
        return null;
    }

    // 13. Number of Islands (DFS on grid)
    private static int numIslands(char[][] grid) {
        // TODO: DFS flood-fill
        return 0;
    }

    // 14. Course Schedule (can finish? -> topological sort)
    private static boolean canFinish(int numCourses, int[][] prerequisites) {
        // TODO: build graph + indegree array + Kahn’s algo
        return false;
    }

    // 15. Graph bipartite check (coloring BFS/DFS)
    private static boolean isBipartite(int[][] graph) {
        // TODO: color nodes and check for conflicts
        return false;
    }

    // 16. All paths from source to target (DFS backtracking)
    private static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // TODO: simple backtracking DFS
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        // Quick sample calls
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}, {3, 4}};
        Map<Integer, List<Integer>> graph = buildAdjList(5, edges);
        dfs(0, new boolean[5], graph);
        bfs(0, graph);
        countComponents(5, new int[][]{{0, 1}, {1, 2}, {3, 4}});
        hasCycleUndirected(3, new int[][]{{0, 1}, {1, 2}, {2, 0}});
        hasCycleDirected(3, new int[][]{{0, 1}, {1, 2}, {2, 1}});
        topologicalSort(4, new int[][]{{0, 1}, {1, 2}, {2, 3}});
        shortestPathUnweighted(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2);
    }
}
