package interview.preparation;

import java.util.*;

public class Day2 {

    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static boolean isValid(String s) {
        if (s == null || s.isEmpty()) return false;
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (map.get(top) != c) return false;
            }
        }
        return stack.isEmpty();
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().getKey();
        }
        return res;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peek() <= i - k) {
                deque.poll();
            }

            // Remove smaller elements (they’ll never be max)
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i); // Add current index

            // Add to result only when first window is done
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peek()];
            }
        }
        return res;
    }

    static class LRUCache {
        int capacity;
        HashMap<Integer, Integer> map;
        LinkedList<Integer> usage;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            this.usage = new LinkedList<>();
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;

            // Move key to most recently used
            usage.remove((Integer) key);
            usage.addFirst(key);

            return map.get(key);
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                // Update value and usage
                usage.remove((Integer) key);
            } else if (map.size() == capacity) {
                // Evict LRU key
                int lru = usage.removeLast();
                map.remove(lru);
            }

            map.put(key, value);
            usage.addFirst(key); // Most recently used
        }
    }

}
