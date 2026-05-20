package interview.preparation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day5 {

    public static int[] rangeSum(int[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        int[] prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = nums[i] + prefix[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            res[i] = prefix[end + 1] - prefix[start];
        }
        return res;
    }

    public static int subarraySumEqualsK(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - goal)) {
                count += map.get(sum - goal);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static int maxSumSubarray(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        int max;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        max = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }
        return max;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        Set<Character> window = new HashSet<>();
        int left = 0, right = 0, maxLen = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);
            if (!window.contains(ch)) {
                window.add(ch);
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            } else {
                window.remove(s.charAt(left));
                left++;
            }
        }

        return maxLen;
    }

}
