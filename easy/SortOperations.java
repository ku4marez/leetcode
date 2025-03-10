package easy;

import java.util.*;

public class SortOperations {
    // Two-Pointer Technique
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }

    // Boyer-Moore Voting Algorithm
    public static int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        int element = nums[0];
        for (int num : nums) {
            if (count == 0) {
                element = num;
            }
            count += (num == element) ? 1 : -1;
        }
        return element;
    }

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

    // Sorting-Based Anagram Check
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }

    // Two pointer approach to merge only values that exist in both arrays (unique)
    public static int[] intersection(int[] nums1, int[] nums2) {
        int p1 = 0;
        int p2 = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] == nums2[p2]) {
                set.add(nums1[p1]);
                p1++;
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            }
        }
        int[] res = new int[set.size()];
        int i = 0;
        for (int num : set) {
            res[i++] = num;
        }
        return res;
    }

    // Sorting string characters array
    public static char findTheDifference(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] != tChars[i]) {
                return tChars[i];
            }
        }
        return tChars[tChars.length - 1];
    }

    /* ==================================================== */
    // Merge sort algorithm (Great for sorting linked lists and large datasets)
    public static void sortMerge(int[] arr){
        if(arr.length == 0 || arr.length == 1){
            return;
        }
        int mid = arr[arr.length/2];
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        sortMerge(left); // Recursively sort the left half
        sortMerge(right); // Recursively sort the right half
        merge(arr, left, right); // Merge the two halves
    }

    // Quick sort algorithm (Best used when in-place sorting is preferred over extra memory usage)
    public static void sortQuick(int[] arr, int low, int high) {
        if (low < high) {
            // Partition logic
            int pivot = arr[high]; // Pivot is the last element
            int i = low - 1; // Index for smaller element

            for (int j = low; j < high; j++) {
                if (arr[j] < pivot) {
                    i++;
                    // Swap arr[i] and arr[j]
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            // Swap pivot to its correct position
            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;
            int pivotIndex = i + 1;

            // Recursive calls
            sortQuick(arr, low, pivotIndex - 1); // Sort left part
            sortQuick(arr, pivotIndex + 1, high); // Sort right part
        }
    }

    // Radix sort algorithm (sorting large datasets of uniform-length numbers (e.g., phone numbers, IP addresses)
    public void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt(); // Find max number

        for (int place = 1; max / place > 0; place *= 10) { // Process each digit
            int[] count = new int[10];

            // Count occurrences of digits
            for (int num : arr) count[(num / place) % 10]++;

            // Convert count array to cumulative count
            for (int i = 1; i < 10; i++) count[i] += count[i - 1];

            // Build output array in sorted order
            int[] output = new int[arr.length];
            for (int i = arr.length - 1; i >= 0; i--) {
                int digit = (arr[i] / place) % 10;
                output[--count[digit]] = arr[i];
            }

            // Copy output to original array
            System.arraycopy(output, 0, arr, 0, arr.length);
        }
    }

    // Heap sort algorithm (priority queue-based, in place sorting with good performance)
    public void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1, right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }
}
