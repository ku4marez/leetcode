package algorithm;

import java.util.Arrays;
import java.util.List;

public class BinarySearchOperations {

    // Binary Search Algorithm
    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int low = 0;
        int high = x;
        int candidate = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long square = (long) mid * mid;
            if (square == x) {
                return mid;
            } else if (square < x) {
                candidate = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return candidate;
    }

    // Binary Search Algorithm
    public static boolean isPerfectSquare(int num) {
        if (num == 0) {
            return false;
        }
        long low = 0;
        long high = num;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long square = mid * mid;
            if (square == num) {
                return true;
            } else if (square < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    // Binary Search Algorithm
    public static int arrangeCoins(int n) {
        long left = 0, right = n;
        int result = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long coinsUsed = mid * (mid + 1) / 2; // Coins required for 'mid' rows

            if (coinsUsed == n) {
                return (int) mid; // Exact match
            } else if (coinsUsed < n) {
                result = (int) mid; // Save the potential result
                left = mid + 1; // Try for a larger 'k'
            } else {
                right = mid - 1; // Try for a smaller 'k'
            }
        }

        return result;
    }

    // Binary Search Algorithm (return closest target if doesn't exist)
    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        Integer candidate = null;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int value = nums[mid];
            if (value == target) {
                return mid;
            } else if (value < target) {
                candidate = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (candidate == null || candidate != target) {
            candidate = -1;
        }
        return candidate;
    }

    // Standard Binary Search
    public int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // Binary search target in the rotated array
    public int searchRotated(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            // Determine if left half is sorted
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            }
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }

        return -1; // Not found
    }

    // Binary search 2d matrix
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int foundRow = -1;

        int top = 0;
        int bottom = rows - 1;
        while (top <= bottom) {
            int row = (top + bottom) / 2;
            if (target > matrix[row][cols - 1]) {
                top = row + 1;
            } else if (target < matrix[row][0]) {
                bottom = row - 1;
            } else {
                foundRow = row;
                break;
            }
        }

        if (foundRow == -1) return false;
        int foundCol = -1;
        int left = 0, right = cols - 1;
        while (left <= right) {
            int col = (left + right) / 2;
            if (target > matrix[foundRow][col]) {
                left = col + 1;
            } else if (target < matrix[foundRow][col]) {
                right = col - 1;
            } else {
                foundCol = col;
                break;
            }
        }

        return foundCol != -1;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        if (piles == null || piles.length == 0) return 0;
        int min = Integer.MAX_VALUE;
        Arrays.sort(piles);
        int left = 1, right = piles[piles.length - 1];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean canEat = canEat(piles, mid, h);
            if (canEat) {
                min = Math.min(min, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return min;
    }

    private static boolean canEat(int[] piles, int speed, int allowedHours) {
        if (piles == null || piles.length == 0) return false;
        int time = 0;
        for (int pile : piles) {
            time += Math.ceil((double) pile / speed);
        }
        return time <= allowedHours;
    }
}
