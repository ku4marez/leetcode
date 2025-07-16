package interview.preparation;


import java.util.*;

public class Day9 {
    public static boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == 0) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                colors[i] = colors[i] % 2 == 0 ? 1 : -1;
                while (!q.isEmpty()) {
                    Integer currNode = q.poll();
                    for (int neighbor : graph[currNode]) {
                        if (colors[neighbor] == 0) {
                            colors[neighbor] = -colors[currNode];
                        } else if (colors[neighbor] == colors[currNode]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static int[] dijkstra(int n, int[][] edges, int start) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], weight = edge[2];
            graph.computeIfAbsent(from, x -> new ArrayList<>()).add(new int[]{to, weight});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, start});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currDist = curr[0];
            int currNode = curr[1];

            if (currDist > dist[currNode]) continue;

            if (!graph.containsKey(currNode)) continue;

            for (int[] neighbor : graph.get(currNode)) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                int newDist = currDist + weight;

                if (newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    pq.offer(new int[]{newDist, nextNode});
                }
            }
        }
        return dist;
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        // Step 1: Count frequency
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Build min-heap of size k based on frequency
        PriorityQueue<Map.Entry<Integer, Integer>> heap =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            heap.offer(entry);
            if (heap.size() > k) {
                heap.poll(); // remove least frequent
            }
        }

        // Step 3: Extract elements from the heap
        List<Integer> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            result.add(heap.poll().getKey());
        }

        // Optional: reverse to get most frequent first
        Collections.reverse(result);
        return result;
    }

    static class KthLargest {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int size;

        public KthLargest(int k, int[] nums) {
            size = k;
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            pq.offer(val);
            if (pq.size() > size) {
                pq.poll();
            }
            return pq.peek();
        }
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : prerequisites) {
            graph[edge[0]].add(edge[1]);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, graph, visited)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(int course, List<Integer>[] graph, int[] visited) {
        if (visited[course] == 1) return true;
        if (visited[course] == 2) return false;
        visited[course] = 1;
        for (int neighbor : graph[course]) {
            if (dfs(neighbor, graph, visited)) return true;
        }
        visited[course] = 2;
        return false;
    }
}
