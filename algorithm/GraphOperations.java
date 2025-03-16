package algorithm;

import java.util.*;

public class GraphOperations {

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


}
