package interview.preparation;

import java.util.*;

public class Day12 {

    // Union-Find: Detect if undirected graph has a cycle
    public static boolean hasCycle(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) {
                return true; // cycle found
            }
        }
        return false; // no cycles
    }

    // Union-Find: Number of friend circles / provinces
    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }

        Set<Integer> roots = new HashSet<>();
        for (int i = 0; i < n; i++) {
            roots.add(uf.find(i));
        }
        return roots.size();
    }

    // Sliding Window: Longest substring without repeating characters
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            while (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start));
                start++;
            }
            set.add(s.charAt(end));
            max = Math.max(max, set.size());
        }
        return max;
    }

    // Sliding Window: Max value in each sliding window of size k
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }

    // Sliding Window: Minimum window substring (classic hard problem)
    public static String minWindow(String s, String t) {
        Map<Character, Integer> tFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> windowFreq = new HashMap<>();
        int start = 0, end = 0;
        int formed = 0;
        int required = tFreq.size();
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);
            end++;
            if (tFreq.containsKey(c) &&
                    windowFreq.get(c).intValue() == tFreq.get(c).intValue()) {
                formed++;
            }
            while (formed == required) {
                char b = s.charAt(start);
                windowFreq.put(b, windowFreq.getOrDefault(b, 0) - 1);
                if (windowFreq.get(b) < tFreq.getOrDefault(b, 0)) {
                    formed--;
                }
                if (end - start < minLen) {
                    minLen = end - start;
                    minStart = start;
                }
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }


    // ============================
    static class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n]; // optional optimization
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // path compression
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int px = find(x), py = find(y);
            if (px == py) return false; // already connected (cycle)
            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[py] = px;
                rank[px]++;
            }
            return true;
        }
    }
}

