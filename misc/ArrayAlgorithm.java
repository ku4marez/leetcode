package misc;

import java.util.*;

public class ArrayAlgorithm {

    public static void main(String[] args) {
        // 1. Swap even and odd numbers
        int[] nums1 = {3, 2, 4, 1};
        System.out.println("1. Swap even and odd:");
        swapEvenOdd(nums1);
        System.out.println(Arrays.toString(nums1)); // Expect even numbers toward front

        // 2. Cyclic sort mapping
        int[] nums2 = {3, 4, -1, 1};
        System.out.println("2. Cyclic sort mapping:");
        cyclicSortMapping(nums2);
        System.out.println(Arrays.toString(nums2)); // Expect sorted placement where possible

        // 3. Find duplicates using negative marks
        int[] nums3 = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("3. Duplicates found:");
        System.out.println(findDuplicates(nums3)); // Expect [2, 3]

        // 4. Count letters frequency
        String s = "abcabc";
        System.out.println("4. Letter frequency count:");
        countLetters(s); // Expect printed letter counts

        // 5. Reverse a subarray
        int[] nums5 = {1, 2, 3, 4, 5};
        System.out.println("5. Reverse subarray from index 1 to 3:");
        reverseSubarray(nums5, 1, 3);
        System.out.println(Arrays.toString(nums5)); // Expect [1, 4, 3, 2, 5]

        // 6. Bucket sort count
        int[] nums6 = {1, 5, 5, 3, 0, 100};
        System.out.println("6. Bucket sort count:");
        bucketSortExample(nums6); // Expect printed bucket values

        // 7. Prefix product
        int[] nums7 = {1, 2, 3, 4};
        System.out.println("7. Prefix product array:");
        System.out.println(Arrays.toString(prefixProduct(nums7))); // Expect [1, 2, 6, 24]

        // 8. Early exit
        int[] nums8 = {1, 2, 3, 4};
        int target = 3;
        System.out.println("8. Early exit on finding target:");
        System.out.println(containsTarget(nums8, target)); // Expect true

        // ===============================
        // 1. BFS Traversal
        int[][] graph1 = {{1, 2}, {0, 3}, {0, 3}, {1, 2}};
        System.out.println("1. BFS Traversal:");
        bfsTraversal(graph1, 0); // Expect BFS order from node 0

        // 2. DFS Traversal
        boolean[] visited2 = new boolean[graph1.length];
        System.out.println("2. DFS Traversal:");
        dfsTraversal(graph1, 0, visited2);
//        dfsTraversal(graph1, 0);
        // Expect DFS order from node 0

        // 3. Binary Search Template
        int[] sorted = {1, 3, 5, 7, 9};
        System.out.println("3. Binary Search for 5:");
        System.out.println(binarySearch(sorted, 5)); // Expect index of 5

        // 4. Sliding Window Max Sum
        int[] nums4 = {2, 1, 5, 1, 3, 2};
        System.out.println("4. Max sum of size 3:");
        System.out.println(slidingWindowMaxSum(nums4, 3)); // Expect 9

        // 5. Fast & Slow Pointer (Detect cycle in array simulation)
        int[] nums9 = {1, 2, 4, 5, 1};
        System.out.println("5. Cycle detection:");
        System.out.println(hasCycle(nums9)); // Depends on simulation logic

        // 6. Prefix Sum
        int[] nums10 = {1, 2, 3, 4};
        System.out.println("6. Prefix sum:");
        System.out.println(Arrays.toString(prefixSum(nums10))); // Expect [1, 3, 6, 10]

        // 7. Backtracking Template (e.g., generate subsets)
        List<List<Integer>> subsets = new ArrayList<>();
        backtrackSubsets(new int[]{1, 2, 3}, 0, new ArrayList<>(), subsets);
        System.out.println("7. Backtracking subsets:");
        System.out.println(subsets);

        // 8. Greedy Interval Scheduling
        int[][] intervals = {{1, 3}, {2, 4}, {3, 5}};
        System.out.println("8. Max non-overlapping intervals:");
        System.out.println(maxNonOverlappingIntervals(intervals)); // Expect 2
    }

    // 1. Swap even and odd numbers in-place using two pointers
    // Used for: partitioning, reordering, greedy prep
    public static void swapEvenOdd(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 > nums[right] % 2) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            if (nums[left] % 2 == 0) left++;
            if (nums[right] % 2 == 1) right--;
        }
    }

    // 2. Cyclic sort mapping: place numbers where they belong (nums[i] → index i)
    // Used for: Finding missing numbers, smallest missing positive
    public static void cyclicSortMapping(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
    }

    // 3. Mark visited using negative sign to detect duplicates
    // Used for: In-place duplicate detection without extra space
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                duplicates.add(Math.abs(nums[i]));
            } else {
                nums[index] = -nums[index];
            }
        }
        return duplicates;
    }

    // 4. Frequency counting using char - 'a' mapping
    // Used for: Counting characters, frequency sort, histogram logic
    public static void countLetters(String s) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) {
                System.out.println("Letter " + (char)('a' + i) + ": " + counts[i]);
            }
        }
    }

    // 5. Reverse a subarray in-place
    // Used for: Rotations, palindrome check, array manipulation
    public static void reverseSubarray(int[] arr, int start, int end) {
        int i = start, j = end;
        while (i < j) {
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }

    // 6. Bucket sort / counting sort trick when values are bounded
    // Used for: Top K frequent, counting frequencies (0–100, etc.)
    public static void bucketSortExample(int[] nums) {
        int[] buckets = new int[101];
        for (int num : nums) {
            buckets[num]++;
        }

        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] > 0) {
                System.out.println("Number " + i + " appears " + buckets[i] + " time(s)");
            }
        }
    }

    // 7. Prefix product array (like prefix sum, but with multiplication)
    // Used for: Product of Array Except Self
    public static int[] prefixProduct(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }

        return result;
    }

    // 8. Early exit pattern (return early if condition is satisfied)
    // Used for: Brute-force optimizations, early cycle detection
    public static boolean containsTarget(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) return true;
        }
        return false;
    }

    // ============================
    public static void bfsTraversal(int[][] graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for(int neighbour : graph[node]) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }
    }

    public static void dfsTraversal(int[][] graph, int node, boolean[] visited) {
        if (visited[node]) return;

        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbour : graph[node]) {
            if (!visited[neighbour]) {
                dfsTraversal(graph, neighbour, visited);
            }
        }
    }

//    public static void dfsTraversal(int[][] graph, int start) {
//        Stack<Integer> stack = new Stack<>();
//        boolean[] visited = new boolean[graph.length];
//
//        stack.push(start);
//        visited[start] = true;
//
//        while (!stack.isEmpty()) {
//            int node = stack.pop();
//            System.out.print(node + " ");
//            for (int neighbour : graph[node]) {
//                if (!visited[neighbour]) {
//                    visited[neighbour] = true;
//                    stack.push(neighbour);
//                }
//            }
//        }
//    }

    public static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int slidingWindowMaxSum(int[] arr, int k) {
        int maxSum;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        maxSum = sum;

        for (int i = k; i < arr.length; i++) {
            sum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static boolean hasCycle(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length && nums[fast] < nums.length) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) return true;
        }
        return false;
    }

    public static int[] prefixSum(int[] arr) {
        int sum;
        for (int i = 1; i < arr.length; i++) {
            sum = arr[i] + arr[i - 1];
            arr[i] = sum;
        }
        return arr;
    }

    public static void backtrackSubsets(int[] nums, int start, List<Integer> temp, List<List<Integer>> result) {
        result.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrackSubsets(nums, i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    public static int maxNonOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int count = 0;
        int end = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            if (interval[0] > end) {
                count++;
                end = interval[1];
            }
        }

        return count;
    }
}
