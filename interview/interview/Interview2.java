package interview.interview;

import java.util.*;

public class Interview2 {

    public static void main(String[] args) {
        // 1. Count Connected Components (Graph)
        System.out.println("Connected Components:");
        System.out.println(countComponents(5, new int[][]{
                {0, 1}, {1, 2}, {3, 4}
        })); // 2

        // 2. Median from Stream (Heap-like)
        System.out.println("\nMedian from Stream:");
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        System.out.println("After adding 1 → median = " + mf.findMedian()); // 1.0
        mf.addNum(2);
        System.out.println("After adding 2 → median = " + mf.findMedian()); // 1.5
        mf.addNum(3);
        System.out.println("After adding 3 → median = " + mf.findMedian()); // 2.0
        mf.addNum(4);
        System.out.println("After adding 4 → median = " + mf.findMedian()); // 2.5
        mf.addNum(5);
        System.out.println("After adding 5 → median = " + mf.findMedian()); // 3.0


        // 3. Daily Temperatures (Stack)
        System.out.println("\nDaily Temperatures:");
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        // [1,1,4,2,1,1,0,0]

        // 4. Sliding Window Maximum (Queue/Deque)
        System.out.println("\nSliding Window Maximum:");
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{10, 3, -1, -3, 5, 3, 6, 7}, 3)));
        // [3,3,5,5,6,7]

        // 5. Generate Parentheses (Recursion)
        System.out.println("\nGenerate Parentheses:");
        System.out.println(generateParenthesis(3)); // ["((()))", "(()())", "(())()", "()(())", "()()()"]

        // Additional
        System.out.println("Top K Frequent:");
        System.out.println(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));  // [1, 2]
        System.out.println(topKFrequent(new int[]{1}, 1));            // [1]
        System.out.println(topKFrequent(new int[]{4, 4, 4, 4, 5, 5, 6}, 2)); // [4, 5]

        System.out.println("Dijkstra shortest paths:");
        System.out.println(Arrays.toString(dijkstra(5, new int[][]{
                {0, 1, 2}, {0, 2, 4}, {1, 2, 1}, {1, 3, 7}, {2, 4, 3}, {3, 4, 1}
        }, 0))); // [0,2,3,9,6]

        System.out.println(Arrays.toString(dijkstra(3, new int[][]{
                {0, 1, 5}, {1, 2, 2}, {0, 2, 9}
        }, 0))); // [0,5,7]

    }

    // 1. Count Connected Components
    public static int countComponents(int n, int[][] edges) {
        int res = 0;
        boolean[] visited = new boolean[n];
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.computeIfAbsent(a, x -> new HashSet<>()).add(b);
            graph.computeIfAbsent(b, x -> new HashSet<>()).add(a);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                visited[i] = true;

                while (!stack.isEmpty()) {
                    int cur = stack.pop();
                    for (int neighbor : graph.getOrDefault(cur, new HashSet<>())) {
                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            stack.push(neighbor);
                        }
                    }
                }

                res++;
            }
        }

        return res;
    }


    // 2. Median Finder
    static class MedianFinder {
        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;
        public MedianFinder() {
         minHeap = new PriorityQueue<>();
         maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        }

        public void addNum(int num) {
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }

            // Balance the heaps
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
        }

        public double findMedian() {
            if (minHeap.size() > maxHeap.size()) {
                return (double) (minHeap.peek() + maxHeap.peek()) / 2;
            }
            return (double) maxHeap.peek();
        }
    }

    // 3. Daily Temperatures
    public static int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[0];
        }
        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int topIndex = stack.pop();
                result[topIndex] = i - topIndex;
            }
            stack.push(i);
        }
        return result;
    }

    // 4. Sliding Window Maximum
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }
        return result;
    }

    // 5. Generate Parentheses
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private static void backtrack(List<String> res, StringBuilder curr, int open, int close, int max) {
        if (curr.length() == max * 2) {
            res.add(curr.toString());
            return;
        }

        if (open < max) {
            curr.append("(");
            backtrack(res, curr, open + 1, close, max);
            curr.deleteCharAt(curr.length() - 1);
        }

        if (close < open) {
            curr.append(")");
            backtrack(res, curr, open, close + 1, max);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    // Additional
    public static int[] dijkstra(int n, int[][] edges, int start) {
        if (edges == null || edges.length == 0) return new int[0];
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
        if (nums == null || nums.length == 0) return new ArrayList<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            res.add(entry.getKey());
        }
        return res.reversed();
    }
}
