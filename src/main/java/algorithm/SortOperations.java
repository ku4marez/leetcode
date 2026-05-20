package algorithm;

import java.util.*;

public class SortOperations {

    /* ==================================================== */
    // Merge sort algorithm (Great for sorting linked lists and large datasets)
    public static void sortMerge(int[] arr) {
        if (arr.length == 0 || arr.length == 1) {
            return;
        }
        int mid = arr.length / 2;
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

    // Cycle sort algorithm
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Place numbers in the correct index using swaps
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                // Swap nums[i] with nums[nums[i] - 1] to place it correctly
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        // Step 2: Find the first missing positive number
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;  // First missing positive
            }
        }

        // Step 3: If all numbers are placed correctly, return n + 1
        return n + 1;
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

    public static void bubbleSort(int[] arr) {
        int n = arr.length - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static int[] sortQuick2(int[] arr) {
        sortQuick2(arr, 0, arr.length - 1);
        return arr;
    }

    private static void sortQuick2(int[] arr, int low, int high) {
        if (low >= high) return;

        // pick random pivot
        int pivotIndex = low + (int)(Math.random() * (high - low + 1));
        int pivot = arr[pivotIndex];

        // move pivot to end
        int temp = arr[pivotIndex];
        arr[pivotIndex] = arr[high];
        arr[high] = temp;

        int i = low - 1;
        int j = low;
        while (j < high) {
            if (arr[j] < pivot) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
            j++;
        }

        // place pivot in its correct position
        int tmp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = tmp;

        int mid = i + 1;
        sortQuick2(arr, low, mid - 1);
        sortQuick2(arr, mid + 1, high);
    }
}
