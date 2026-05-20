package interview.preparation;

import java.util.HashMap;

public class Day1 {

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int p = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[p] = nums[i];
                p++;
            }
        }
        return p;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                start = Math.max(start, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - start + 1);
        }
        return max;
    }

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static int maxSumSubarrayOfSizeK(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int max, sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        max = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] + nums[i - k];
            max = Math.max(max, sum);
        }
        return max;
    }

    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) return new int[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]), i};
            }
            map.put(numbers[i], i);
        }
        return new int[]{-1, -1};
    }

}
