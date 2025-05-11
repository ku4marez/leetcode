package misc;

import java.util.HashMap;
import java.util.Map;

public class TwoPointerAlgorithm {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 6};
        int target = 6;
        System.out.println("Return the indices of the two numbers such that they add up to target: " + twoSumSorted(nums, target));

        int[] nums1 = {1, 1, 2, 2, 3};
        System.out.println("Remove the duplicates in-place such that each unique element appears only once: " + removeDuplicatesSorted(nums1));

        int[] nums2 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Return the maximum area of water a container can store between two lines: " + containerWithWater(nums2));
    }

    // Finds two indices in a sorted array such that their values sum to the target
    private static int[] twoSumSorted(int[] nums, int target) {
        int[] result = new int[2];
        int left = 0;                      // Start pointer from the beginning
        int right = nums.length - 1;      // Start pointer from the end

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                // Found the pair that adds to the target
                result[0] = left;
                result[1] = right;
                break;
            } else if (sum < target) {
                // Move left pointer right to increase the sum
                left++;
            } else {
                // Move right pointer left to decrease the sum
                right--;
            }
        }

        return result;
    }

    // Removes duplicates from a sorted array in-place
    // Returns the new length with unique elements at the front
    private static int removeDuplicatesSorted(int[] nums) {
        if (nums.length == 0) return 0;

        int slow = 0; // slow pointer marks the position of the last unique element

        for (int fast = 1; fast < nums.length; fast++) {
            // Only act when a new unique element is found
            if (nums[fast] != nums[slow]) {
                slow++;                      // move slow pointer to the next position
                nums[slow] = nums[fast];     // copy unique value forward
            }
        }

        return slow + 1; // the count of unique elements
    }


    // Calculates the maximum area of water that can be trapped between two lines
    private static int containerWithWater(int[] height) {
        int left = 0;                      // Left pointer at the beginning
        int right = height.length - 1;    // Right pointer at the end
        int maxArea = 0;                  // Tracks the maximum area found

        // Continue while the two pointers have not crossed
        while (left < right) {
            // Height is limited by the shorter line
            int currentHeight = Math.min(height[left], height[right]);

            // Width is the distance between the two lines
            int width = right - left;

            // Calculate the area and update maxArea if it's larger
            int area = currentHeight * width;
            maxArea = Math.max(maxArea, area);

            // Move the pointer pointing to the shorter line inward
            // because moving the taller one wouldn't increase height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea; // Return the largest area found
    }


}
