package misc;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindowAlgorithm {

    public static void main(String[] args) {
        String input = "abcabcbb";
        System.out.println("Length of longest substring without repeating: " + longestSubstringNoRepeating(input));

        int[] nums1 = {2,3,1,2,4,3};
        int target = 7;
        System.out.println("Length of the smallest subarray with sum ≥ target: " + minSubArrSum(nums1, target));

        int[] nums2 = {1,2,3,4,5};
        int k = 3;
        System.out.println("Maximum sum of a subarray of size k: " + maxSubArrSum(nums2, k));


    }

    // Returns the length of the longest substring without repeating characters
    private static int longestSubstringNoRepeating(String s) {
        if (s == null || s.isEmpty()) return 0;

        Map<Character, Integer> map = new HashMap<>(); // Stores the last index of each character
        int left = 0;           // Left pointer of the sliding window
        int maxLength = 0;      // Tracks the maximum length of valid substring

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // If character already seen, move the left pointer right after the last occurrence
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }

            // Update the latest index of the current character
            map.put(c, right);

            // Update the maxLength if current window is longer
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    private static int minSubArrSum(int[] arr, int target) {
        if (arr == null || arr.length == 0) return 0;
        int left = 0, sum = 0;
        int minLength = Integer.MAX_VALUE;
        for (int right = 0; right < arr.length; right++) {
            int num = arr[right];
            // Expand the window
            sum += num;

            // Try to shrink the window while sum ≥ target
            while (sum >= target) {
                // Update minimum
                minLength = Math.min(minLength, right - left + 1);
                // Shrink from the left
                sum -= arr[left];
                left++;
            }
        }
        return minLength != Integer.MAX_VALUE ? minLength : 0;
    }

    private static int maxSubArrSum(int[] arr, int k) {
        if (arr == null || arr.length == 0) return 0;
        int left = 0, sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int right = 0; right < arr.length; right++) {
            int num = arr[right];
            // Expand the window
            sum += num;

            // Shrink the window if it's larger than size k
            if (right - left + 1 > k) {
                sum -= arr[left];
                left++;
            }

            // If window size == k, update maxSum
            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}
