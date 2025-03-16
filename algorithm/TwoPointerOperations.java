package algorithm;

import java.util.ArrayList;
import java.util.List;

public class TwoPointerOperations {

    // Two-Pointer Technique
    public static int removeElement(int[] nums, int val) {
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[p] = nums[i];
                p++;
            }
        }
        return p;
    }

    // Two-Pointer Technique
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int p = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[p] = nums[i];
                p++;
            }
        }
        return p;
    }

    // Two-Pointer Technique
    public static int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;
        int p = 1;
        for (int i = 1; i < nums.length; i++) {
            if (p < 2 || nums[i] != nums[p - 2]) {
                nums[p] = nums[i];
                p++;
            }
        }
        return p;
    }

    // Two-pointer (opposite direction)
    public int[] twoSumSorted(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1}; // 1-based index
            } else if (sum < target) {
                left++; // Increase sum
            } else {
                right--; // Decrease sum
            }
        }

        return new int[]{-1, -1}; // Not found
    }


    // Two-pointer to rotate array
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n; // Ensure k is within bounds

        // Step 1: Reverse entire array
        reverse(nums, 0, n - 1);

        // Step 2: Reverse first k elements
        reverse(nums, 0, k - 1);

        // Step 3: Reverse remaining n-k elements
        reverse(nums, k, n - 1);
    }

    // XOR Swap Reverse Function
    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            nums[left] ^= nums[right];
            nums[right] ^= nums[left];
            nums[left] ^= nums[right];
            left++;
            right--;
        }
    }

    // Two-pointer (same direction)
    public int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int n = arr1.length, m = arr2.length;
        int[] result = new int[n + m];
        int i = 0, j = 0, k = 0;

        // Merge arrays
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        // Copy remaining elements
        while (i < n) result[k++] = arr1[i++];
        while (j < m) result[k++] = arr2[j++];

        return result;
    }

    // Two-Pointer Approach
    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result; // Handle empty input
        }

        int start = nums[0]; // Start of the current range

        for (int i = 1; i < nums.length; i++) {
            // Check if the current number is not consecutive
            if (nums[i] != nums[i - 1] + 1) {
                // Add the range to the result
                if (start == nums[i - 1]) {
                    result.add(String.valueOf(start)); // Single number
                } else {
                    result.add(start + "->" + nums[i - 1]); // Range
                }
                // Update the start of the next range
                start = nums[i];
            }
        }

        // Add the last range
        if (start == nums[nums.length - 1]) {
            result.add(String.valueOf(start));
        } else {
            result.add(start + "->" + nums[nums.length - 1]);
        }

        return result;
    }

    // Two-Pointer Technique
    public static void moveZeroes(int[] nums) {
        if (nums != null && nums.length != 0) {
            int lastNonZeroIndex = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[lastNonZeroIndex] = nums[i];
                    lastNonZeroIndex++;
                }
            }
            for (int i = lastNonZeroIndex; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }

    // Two-Pointer Iterative Approach
    public static void reverseString(char[] s) {
        int start = 0, end = s.length - 1;
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    // Two-Pointer Iterative Approach
    public static String reverseVowels(String s) {
        int start = 0, end = s.length() - 1;
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        while (start < end) {
            char sChar = s.charAt(start);
            char tChar = s.charAt(end);
            while (start < end && vowels.indexOf(sChar) == -1) {
                start++;
            }
            while (start < end && vowels.indexOf(tChar) == -1) {
                end--;
            }
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end++;
        }
        return new String(chars);
    }
}
