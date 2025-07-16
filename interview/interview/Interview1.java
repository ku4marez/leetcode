package interview.interview;

import java.util.*;

public class Interview1 {

    public static void main(String[] args) {
        // 1. Two Sum
        System.out.println("Two Sum:");
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));         // [0, 1]
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));              // [1, 2]
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));                 // [0, 1]

        // 2. Longest Substring Without Repeating Characters
        System.out.println("\nLongest Substring Without Repeating Characters:");
        System.out.println(lengthOfLongestSubstring("abcabcbb"));   // 3
        System.out.println(lengthOfLongestSubstring("bbbbb"));      // 1
        System.out.println(lengthOfLongestSubstring("pwwkew"));     // 3

        // 3. Merge Intervals
        System.out.println("\nMerge Intervals:");
        int[][] merged = merge(new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        });
        for (int[] interval : merged) {
            System.out.println(Arrays.toString(interval));  // [1,6], [8,10], [15,18]
        }

        // 4. Top K Frequent Elements
        System.out.println("\nTop K Frequent Elements:");
        System.out.println(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)); // [1, 2]
        System.out.println(topKFrequent(new int[]{1}, 1));               // [1]

        // 5. Search Insert Position
        System.out.println("\nSearch Insert Position:");
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));  // 2
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));  // 1
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));  // 4
    }

    // Placeholder method definitions
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(target - num)) {
                return new int[]{map.get(target - num), i};
            }
            map.put(num, i);
        }
        return new int[]{-1, -1};
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;
        for (int end = 0; end < s.length(); end++) {
            char cur = s.charAt(end);
            if (map.containsKey(cur)) {
                start = Math.max(start, map.get(cur) + 1);
            }
            map.put(s.charAt(end), end);
            max = Math.max(max, end - start + 1);
        }
        return max;
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][0];

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int[][] merged = new int[intervals.length][2];
        int pos = 0;

        merged[0] = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] last = merged[pos];
            int[] current = intervals[i];

            if (last[1] >= current[0]) {
                last[1] = Math.max(last[1   ], current[1]); // merge
            } else {
                merged[++pos] = current; // move to next slot
            }
        }

            return Arrays.copyOf(merged, pos + 1);
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            buckets[value].add(key);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
            result.addAll(buckets[i]);
        }
        return result.subList(0, k);
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
