package algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SlidingWindowOperations {

    // Sliding Window
    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            } else map.put(nums[i], i);
        }
        return false;
    }

    // Sliding Window (harmonious array)
    public static int findLHS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (map.containsKey(entry.getKey() + 1)) {
                int length = map.get(entry.getKey() + 1) + map.get(entry.getKey());
                result = Math.max(result, length);
            }
        }
        return result;
    }

    // Sliding Window
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int prevIndex = map.get(nums[i]);
                if (i - prevIndex <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    // Sliding Window (fixed size)
    public int maxSumSlidingWindow(int[] arr, int k) {
        int maxSum = 0, windowSum = 0;

        // Compute first window sum
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        maxSum = windowSum;

        // Slide the window
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k]; // Add next element, remove first in window
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    // Sliding window
    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    // Sliding window dynamic size
    public int longestUniqueSubstring(String s) {
        Map<Character, Integer> charIndex = new HashMap<>();
        int maxLength = 0, left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // If duplicate character, move left pointer
            if (charIndex.containsKey(c)) {
                left = Math.max(left, charIndex.get(c) + 1);
            }

            charIndex.put(c, right); // Store latest index
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    // Sliding window (Frequency count, permutation)
    public static boolean checkInclusion(String s1, String s2) {
        int[] s1Freq = new int[26];
        int[] s2Window = new int[26];
        if (s2.length() < s1.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            s2Window[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1Freq, s2Window)) return true;

        for (int i = s1.length(); i < s2.length(); i++) {
            s2Window[s2.charAt(i) - 'a']++;
            s2Window[s2.charAt(i - s1.length()) - 'a']--;

            if (Arrays.equals(s1Freq, s2Window)) return true;
        }

        return false;
    }
}
