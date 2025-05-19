package misc;

import java.util.HashMap;
import java.util.Map;

public class PrefixSumAlgorithm {

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        int i = 0;
        int j = 2;
        System.out.println("Returns the sum of the elements between indices i and j (inclusive): " + rangeSumQuery(nums, i, j));

        int[] nums1 = {1, 2, 1, 2, 1};
        int k = 3;
        System.out.println("Return the total number of continuous subarrays whose sum equals k: " + subArrSumEqualsK(nums1, k));

        int[] nums2 = {1, 7, 3, 6, 5, 6};
        System.out.println("Return the pivot index where the sum of the elements to the left equals the sum to the right: " + findPivotIndex(nums2));
    }

    // 1. Range Sum Query (brute-force version)
    // Returns the sum of elements from index i to j (inclusive)
    private static int rangeSumQuery(int[] nums, int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += nums[k];
        }
        return sum;
    }

    // 2. Subarray Sum Equals K
    // Counts the number of continuous subarrays whose sum equals k
    private static int subArrSumEqualsK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;

        map.put(0, 1); // To handle subarrays starting from index 0

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]; // current prefix sum

            // Check if there exists a prefix sum such that sum - prefix = k
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k); // Add the number of such occurrences
            }

            // Record this prefix sum into the map
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    // 3. Find Pivot Index
    // Returns the index where the sum of elements to the left == sum to the right
    private static int findPivotIndex(int[] nums) {
        int totalSum = 0;
        int sum = 0;

        // Compute total sum of array
        for (int num : nums) {
            totalSum += num;
        }

        // Iterate to find the pivot index
        for (int i = 0; i < nums.length; i++) {
            int diff = totalSum - sum - nums[i]; // right sum
            if (diff == sum) {                   // left sum
                return i;
            }
            sum += nums[i]; // accumulate left sum
        }

        return -1; // No pivot index found
    }
}
