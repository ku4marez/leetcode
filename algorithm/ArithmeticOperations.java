package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ArithmeticOperations {

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
            } else if (square< num) {
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

    // Mathematical Reverse and Comparison
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int reversed_n = 0;
        int bufferX = x;

        while (bufferX > 0) {
            reversed_n = reversed_n * 10 + bufferX % 10;
            bufferX = bufferX / 10;
        }

        return reversed_n == x;
    }

    // HashSet to Detect Cycles
    public static boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();

        while (n != 1) {
            if (seen.contains(n)) {
                return false;
            }
            seen.add(n);

            int local = n;
            int sum = 0;
            while (local > 0) {
                int digit = local % 10;
                sum += digit * digit;
                local /= 10;
            }
            n = sum;
        }

        return true;
    }

    // Recursive Digit Addition (Digital Root)
    public static int addDigits(int num) {
        if (num / 10 == 0) {
            return num;
        }

        AtomicInteger sum = new AtomicInteger();
        int buffer = num;
        List<Integer> digits = new ArrayList<>();
        while (buffer > 0) {
            digits.add(buffer % 10);
            buffer = buffer / 10;
        }

        digits.forEach(sum::addAndGet);
        return addDigits(sum.get());
    }

    // Prime Factorization
    public static boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }

        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }

        return n == 1;
    }
}
