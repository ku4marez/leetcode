package algorithm;

import java.util.*;
import java.util.stream.Collectors;

public class GraphOperations {

    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    // Star Graph center
    public static int findCenter(int[][] edges) {
        // Compare the first two edges
        int u1 = edges[0][0];
        int v1 = edges[0][1];
        int u2 = edges[1][0];
        int v2 = edges[1][1];

        // The center is the node that appears in both edges
        if (u1 == u2 || u1 == v2) {
            return u1;
        } else {
            return v1;
        }
    }

    // Find judge who is being trusted by everyone, but doesn't trust anyone
    public static int findJudge(int n, int[][] trust) {
        // If there's only one person and no trust, they're the judge
        if (n == 1 && trust.length == 0) {
            return 1;
        }

        // Array to track trust scores
        int[] trustScore = new int[n + 1];

        // Process the trust array
        for (int[] t : trust) {
            int a = t[0]; // person who trusts
            int b = t[1]; // person being trusted
            trustScore[a]--; // outgoing trust
            trustScore[b]++; // incoming trust
        }

        // Check for the judge
        for (int i = 1; i <= n; i++) {
            if (trustScore[i] == n - 1) {
                return i;
            }
        }

        // No judge found
        return -1;
    }

    // BFS if source and destination exist in the subgraph
    public static boolean validPathBfs(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == destination) return true;

            for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        return false; // No path found
    }

    // DFS if source and destination exist in the subgraph
    public static boolean validPathDfs(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        stack.push(source);
        visited.add(source);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (node == destination) return true;

            for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    stack.push(neighbor);
                }
            }
        }

        return false;
    }

    // BFS find the shortest path between cities
    public int bfsShortestPath(Map<Integer, List<Integer>> graph, int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                if (node == target) return steps;

                for (int neighbor : graph.get(node)) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            steps++;
        }

        return -1; // No path found
    }

    // DFS detect cycle in graph
    public boolean hasCycle(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited, Set<Integer> recStack) {
        if (recStack.contains(node)) return true;
        if (visited.contains(node)) return false;

        visited.add(node);
        recStack.add(node);

        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (hasCycle(graph, neighbor, visited, recStack)) return true;
        }

        recStack.remove(node);
        return false;
    }

    // Dijkstra’s Algorithm (Shortest Path in Weighted Graph)
    public int dijkstra(Map<Integer, List<int[]>> graph, int start, int target) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Map<Integer, Integer> dist = new HashMap<>();
        pq.add(new int[]{start, 0});
        dist.put(start, 0);

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0], cost = current[1];

            if (node == target) return cost;

            for (int[] neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                int nextNode = neighbor[0], nextCost = neighbor[1];
                int newDist = cost + nextCost;

                if (newDist < dist.getOrDefault(nextNode, Integer.MAX_VALUE)) {
                    dist.put(nextNode, newDist);
                    pq.add(new int[]{nextNode, newDist});
                }
            }
        }

        return -1; // No path
    }

    // A* Algorithm (Optimized Pathfinding)
    public int aStar(Map<Integer, List<int[]>> graph, int start, int target, Map<Integer, Integer> heuristic) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1] + heuristic.get(a[0])));
        Map<Integer, Integer> dist = new HashMap<>();
        pq.add(new int[]{start, 0});
        dist.put(start, 0);

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0], cost = current[1];

            if (node == target) return cost;

            for (int[] neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                int nextNode = neighbor[0], nextCost = neighbor[1];
                int newDist = cost + nextCost;

                if (newDist < dist.getOrDefault(nextNode, Integer.MAX_VALUE)) {
                    dist.put(nextNode, newDist);
                    pq.add(new int[]{nextNode, newDist});
                }
            }
        }

        return -1; // No path
    }

    public static Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        cloneGraph(node, map);
        return map.get(node);
    }

    public static Node cloneGraph(Node node, Map<Node, Node> map) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);
        Node clone = new Node(node.val);
        map.put(node, clone);
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor, map));
        }
        return clone;
    }

    public static int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length == 0) return null;
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            if (findRedundantConnection(adjacencyList, u, v, new HashSet<>())) {
                return edges[i];
            }
            adjacencyList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adjacencyList.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        return new int[]{-1, -1};
    }

    private static boolean findRedundantConnection(Map<Integer, List<Integer>> adjacencyList, int current, int target, HashSet<Integer> visited) {
        if (current == target) return true;
        visited.add(current);
        for (Integer neighbor : adjacencyList.getOrDefault(current, new ArrayList<>())) {
            if (!visited.contains(neighbor) && findRedundantConnection(adjacencyList, neighbor, target, visited))
                return true;
        }
        return false;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.putIfAbsent(i, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int u = prerequisite[0], v = prerequisite[1];
            adjacencyList.get(v).add(u);
        }
        int[] visited = new int[numCourses]; // 0 - unvisited, 1 - visiting, 2 - done
        for (int i = 0; i < numCourses; i++) {
            if (!canFinish(i, visited, adjacencyList)) return false;
        }
        return true;
    }

    private static boolean canFinish(Integer current, int[] visited, Map<Integer, List<Integer>> adjacencyList) {
        if (visited[current] == 1) return false;
        if (visited[current] == 2) return true;

        visited[current] = 1;
        for (Integer neighbour : adjacencyList.getOrDefault(current, new ArrayList<>())) {
            if (!canFinish(neighbour, visited, adjacencyList)) return false;
        }
        visited[current] = 2;
        return true;
    }

    // Union find (connected nodes)
    public static int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            union(u, v, parent, size);
        }

        Set<Integer> unique = new HashSet<>();
        for (int i = 0; i < n; i++) {
            unique.add(find(i, parent));
        }
        return unique.size();
    }

    private static void union(int u, int v, int[] parent, int[] size) {
        int px = find(u, parent);
        int py = find(v, parent);
        if (px == py) return;

        if (size[px] < size[py]) {
            parent[px] = py;
            size[py] += size[px];
        } else {
            parent[py] = px;
            size[px] += size[py];
        }
    }

    private static int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }

    // Union find (connected nodes)
    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parent = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j, parent, size);
                }
            }
        }

        Set<Integer> unique = new HashSet<>();
        for (int i = 0; i < n; i++) {
            unique.add(find(i, parent));
        }
        return unique.size();
    }

    // Topological sort
    public static String alienOrder(List<String> words) {
        HashMap<Character, List<Character>> adjacency = new HashMap<>();
        // Step 1: ensure every char exists in the adjacency list
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adjacency.putIfAbsent(c, new ArrayList<>());
            }
        }

        // Step 2: build directed edges
        for (int i = 0; i < words.size() - 1; i++) {
            String w1 = words.get(i);
            String w2 = words.get(i + 1);
            int minLength = Math.min(w1.length(), w2.length());

            // Invalid case: prefix ordering conflict
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }

            for (int j = 0; j < minLength; j++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if (c1 != c2) {
                    adjacency.get(c1).add(c2); // directed edge
                    break;
                }
            }
        }

        Map<Character, Integer> visited = new HashMap<>();
        List<Character> res = new ArrayList<>();
        for (Map.Entry<Character, List<Character>> entry : adjacency.entrySet()) {
            if (alienOrder(entry.getKey(), visited, adjacency, res)) return "";
        }

        Collections.reverse(res);
        StringBuilder sb = new StringBuilder();
        for (char c : res) sb.append(c);
        return sb.toString();
    }

    private static boolean alienOrder(Character c, Map<Character, Integer> visited, Map<Character, List<Character>> adjacency, List<Character> res) {
        int state = visited.getOrDefault(c, 0);
        if (state == 1) return true;   // currently visiting → cycle
        if (state == 2) return false;  // already processed → skip

        visited.put(c, 1); //visiting

        for (char neighbor : adjacency.getOrDefault(c, new ArrayList<>())) {
            if (alienOrder(neighbor, visited, adjacency, res)) return true;
        }

        visited.put(c, 2);  // done
        res.add(c);
        return false;
    }

    // Djikstra sortest path
    public static int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> adjacency = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            int u = times[i][0], v = times[i][1], w = times[i][2];
            adjacency.putIfAbsent(u, new HashMap<>());
            adjacency.get(u).put(v, w);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], cost = curr[1];
            if (cost > dist[node]) continue;

            for (Map.Entry<Integer, Integer> entry : adjacency.getOrDefault(node, Collections.emptyMap()).entrySet()) {
                int next = entry.getKey();
                int newCost = cost + entry.getValue();
                if (newCost < dist[next]) {
                    dist[next] = newCost;
                    pq.offer(new int[]{next, newCost});
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}
