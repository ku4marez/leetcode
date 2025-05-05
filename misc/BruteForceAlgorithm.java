package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteForceAlgorithm {

    public static void main(String[] args) {
        // 1. Subsets
        int[] nums1 = {1, 2, 3};
        System.out.println("Subsets:");
        for (List<Integer> subset : generateSubsets(nums1)) {
            System.out.println(subset);
        }

        // 2. Permutations
        int[] nums2 = {1, 2, 3};
        System.out.println("\\nPermutations:");
        for (List<Integer> perm : generatePermutations(nums2)) {
            System.out.println(perm);
        }

        // 3. All Pairs with Target Sum
        int[] nums3 = {2, 7, 11, 15};
        int target = 9;
        System.out.println("\\nPairs that sum to " + target + ":");
        for (int[] pair : findAllPairs(nums3, target)) {
            System.out.println(Arrays.toString(pair));
        }
    }

    // Generates all possible subsets (the power set) using bitmasking
    private static List<List<Integer>> generateSubsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int total = 1 << nums.length; // total number of subsets = 2^n

        for (int mask = 0; mask < total; mask++) {
            List<Integer> subset = new ArrayList<>();
            // For each bit, decide whether to include nums[j] in this subset
            for (int j = 0; j < nums.length; j++) {
                if ((mask & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }
        return result;
    }


    // Generates all possible permutations using backtracking
    private static List<List<Integer>> generatePermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, result);
        return result;
    }

    // Recursive helper to generate permutations
    private static void permute(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length) {
            // Base case: all positions are filled, save a copy of current permutation
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            result.add(permutation);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i); // Choose: swap current number into position
            permute(nums, index + 1, result); // Explore: recurse on the rest
            swap(nums, index, i); // Backtrack: undo the swap
        }
    }

    // Swaps two elements in the array
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Finds all index pairs (i, j) such that nums[i] + nums[j] == target
    private static List<int[]> findAllPairs(int[] nums, int target) {
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // Check if current pair sums to target
                if (nums[i] + nums[j] == target) {
                    result.add(new int[]{i, j});
                }
            }
        }
        return result;
    }
}
