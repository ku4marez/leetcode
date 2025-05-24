package misc;

import java.util.Arrays;

public class BinarySearchAlgorithm {
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println("Find the minimum k so she can finish all in h hours: " + kokoEatingBananas(piles, h));

        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println("Given a rotated sorted array, search for a target value and return its index. If not found, return -1\n" +
                "\n: " + searchInRotatedArray(nums, target));

        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        System.out.println("Find the first and last index of a given target value: " + firstAndLast(nums1, target1));
    }

    private static int searchInRotatedArray(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[low] <= nums[mid]) {
                // Left half is sorted
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1; // search in left sorted half
                } else {
                    low = mid + 1; // search in right half
                }
            } else {
                // Right half is sorted
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1; // search in right sorted half
                } else {
                    high = mid - 1; // search in left half
                }
            }
        }
        return -1;
    }

    private static int[] firstAndLast(int[] nums, int target) {
        int first = -1;
        int last = -1;

        // First: find leftmost index
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if (nums[mid] == target) first = mid;
                high = mid - 1; // keep going left
            }
        }

        // Then: find rightmost index
        low = 0;
        high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                if (nums[mid] == target) last = mid;
                low = mid + 1; // keep going right
            }
        }

        return new int[]{first, last};

    }

    private static int kokoEatingBananas(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();

        while (low < high) {
            int mid = (low + high) / 2;

            // mid is the speed to test (bananas/hour)
            if (canFinish(piles, mid, h)) {
                high = mid; // try a smaller speed
            } else {
                low = mid + 1; // speed too slow, increase
            }
        }

        return low; // or high, both are equal here
    }

    private static boolean canFinish(int[] piles, int h, int k) {
        int hours = 0;
        for (int pile : piles) {
            hours += Math.ceil((double)pile / k); // time to finish this pile at speed k
        }
        return hours <= h; // can she finish in time?
    }
}
