package interview.preparation;

import java.util.Arrays;

public class Day4 {

    public static void mergeSort(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return;
        }
        int mid = nums.length / 2;
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);
        mergeSort(left);
        mergeSort(right);
        merge(nums, left, right);
    }

    private static void merge(int[] nums, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                nums[k++] = left[i++];
            } else {
                nums[k++] = right[j++];
            }
        }
        while (i < left.length) {
            nums[k++] = left[i++];
        }
        while (j < right.length) {
            nums[k++] = right[j++];
        }
    }

    public static void quickSort(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return;
        }
        int low = 0, high = nums.length - 1;
        sort(nums, low, high);

    }

    private static void sort(int[] nums, int low, int high) {
        if (low < high) {
            int pivot = nums[high];
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if (nums[j] < pivot) {
                    i++;
                    swap(nums, i, j);
                }
            }
            swap(nums, i + 1, high);
            int pivotIndex = i + 1;
            sort(nums, low, pivotIndex - 1);
            sort(nums, pivotIndex + 1, high);
        }
    }

    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static int firstBadVersion(int n) {
        int low = 1, high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static boolean isBadVersion(int version) {
        return version >= 2;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
