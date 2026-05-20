package algorithm;

import java.util.*;

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

    public static int characterReplacement(String s, int k) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> charCount = new HashMap<>();
        int maxCount = 0;
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            charCount.put(s.charAt(right), charCount.getOrDefault(s.charAt(right), 0) + 1);
            maxCount = Math.max(maxCount, charCount.get(r));
            while ((right - left + 1) - maxCount > k) {
                charCount.put(s.charAt(left), charCount.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.peekFirst() <= i - k) {
                queue.poll();
            }
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[queue.peek()];
            }
        }
        return res;
    }

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) return "";
        HashMap<Character, Integer> tCount = new HashMap<>();
        HashMap<Character, Integer> windowCount = new HashMap<>();
        int start = 0, end = 0;
        int formed = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int minEnd = 0;
        for (int i = 0; i < t.length(); i++) {
            tCount.put(t.charAt(i), tCount.getOrDefault(t.charAt(i), 0) + 1);
        }
        int required = tCount.size();
        while (end < s.length()) {
            char c = s.charAt(end);
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);
            if (tCount.containsKey(c) &&
                    windowCount.get(c).equals(tCount.get(c))) {
                formed++;
            }

            while (formed == required) {
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    minStart = start;
                    minEnd = end;
                }
                windowCount.put(s.charAt(start), windowCount.getOrDefault(s.charAt(start), 0) - 1);
                if (tCount.containsKey(s.charAt(start)) &&
                        windowCount.get(s.charAt(start)) < tCount.get(s.charAt(start))) {
                    formed--;
                }

                start++;
            }
            end++;
        }
        return minLen != Integer.MAX_VALUE ? s.substring(minStart, minEnd + 1) : "";
    }
}
