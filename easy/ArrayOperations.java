package easy;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayOperations {

    // Two-Pointer Technique
    public static int removeElement(int[] nums, int val) {
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[p] = nums[i];
                p++;
            }
        }
        return p;
    }

    // Two-Pointer Technique
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int p = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[p] = nums[i];
                p++;
            }
        }
        return p;
    }

    // Two-Pointer Technique
    public static int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;
        int p = 1;
        for (int i = 1; i < nums.length; i++) {
            if (p < 2 || nums[i] != nums[p - 2]) {
                nums[p] = nums[i];
                p++;
            }
        }
        return p;
    }

    // HashMap for Complement Search
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    // Character-by-Character Comparison
    public static String commonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String current = strs[i];
            int j = 0;
            while (j < result.length() && j < current.length() && result.charAt(j) == current.charAt(j)) {
                j++;
            }
            result = result.substring(0, j);
            if (result.isEmpty()) {
                return "";
            }
        }
        return result;
    }

    // Reverse Traversal with Carry Propagation
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }

    // In-place array marking
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int complement = Math.abs(nums[i]);
            nums[complement - 1] = -Math.abs(nums[complement - 1]);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                int index = i + 1;
                result.add(index);
            }
        }

        return result;
    }

    // Iterative Linear Search
    public static int searchInsert(int[] nums, int target) {
        int resultIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            } else if (i + 1 < nums.length && nums[i] < target && nums[i + 1] > target) {
                resultIndex = i + 1;
            } else if (nums[i] < target) {
                resultIndex = i + 1;
            }
        }
        return resultIndex;
    }

    // Sliding Window (harmonious array)
    public static int findLHS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (map.containsKey(entry.getKey() + 1)) {
                int length = map.get(entry.getKey() + 1) + map.get(entry.getKey());
                result = Math.max(result, length);
            }
        }
        return result;
    }

    // Sliding Window
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int prevIndex = map.get(nums[i]);
                if (i - prevIndex <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    // Sliding Window (fixed size)
    public int maxSumSlidingWindow(int[] arr, int k) {
        int maxSum = 0, windowSum = 0;

        // Compute first window sum
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        maxSum = windowSum;

        // Slide the window
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k]; // Add next element, remove first in window
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    // Sliding window
    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    // Sliding window dynamic size
    public int longestUniqueSubstring(String s) {
        Map<Character, Integer> charIndex = new HashMap<>();
        int maxLength = 0, left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // If duplicate character, move left pointer
            if (charIndex.containsKey(c)) {
                left = Math.max(left, charIndex.get(c) + 1);
            }

            charIndex.put(c, right); // Store latest index
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    // Two-pointer (opposite direction)
    public int[] twoSumSorted(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1}; // 1-based index
            } else if (sum < target) {
                left++; // Increase sum
            } else {
                right--; // Decrease sum
            }
        }

        return new int[]{-1, -1}; // Not found
    }

    // Two-pointer (same direction)
    public int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int n = arr1.length, m = arr2.length;
        int[] result = new int[n + m];
        int i = 0, j = 0, k = 0;

        // Merge arrays
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        // Copy remaining elements
        while (i < n) result[k++] = arr1[i++];
        while (j < m) result[k++] = arr2[j++];

        return result;
    }

    // Two-Pointer Approach
    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result; // Handle empty input
        }

        int start = nums[0]; // Start of the current range

        for (int i = 1; i < nums.length; i++) {
            // Check if the current number is not consecutive
            if (nums[i] != nums[i - 1] + 1) {
                // Add the range to the result
                if (start == nums[i - 1]) {
                    result.add(String.valueOf(start)); // Single number
                } else {
                    result.add(start + "->" + nums[i - 1]); // Range
                }
                // Update the start of the next range
                start = nums[i];
            }
        }

        // Add the last range
        if (start == nums[nums.length - 1]) {
            result.add(String.valueOf(start));
        } else {
            result.add(start + "->" + nums[nums.length - 1]);
        }

        return result;
    }

    // Two-Pointer Technique
    public static void moveZeroes(int[] nums) {
        if (nums != null && nums.length != 0) {
            int lastNonZeroIndex = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[lastNonZeroIndex] = nums[i];
                    lastNonZeroIndex++;
                }
            }
            for (int i = lastNonZeroIndex; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }

    // Integer by integer comparison
    public static int thirdMax(int[] nums) {

        Integer first = null, second = null, third = null;
        for (int num : nums) {
            if ((first != null && num == first) ||
                (second != null && num == second) ||
                (third != null && num == third)) {
                continue;
            }
            if (first == null || num > first) {
                third = second;
                second = first;
                first = num;
            } else if (second == null || num > second) {
                third = second;
                second = num;
            } else if (third == null || num > third) {
                third = num;
            }
        }
        return third != null ? third : first;
    }

    // Greedy strategy with two pointer
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int p1 = 0, p2 = 0;
        while (p1 < g.length && p2 < s.length) {
            if (g[p1] <= s[p2]) {
                p1++;
            }
            p2++;
        }
        return p1;
    }

    // Greedy algorithm with sorting
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int maxSum = 0;

        for (int i = 0; i < nums.length; i += 2) {
            maxSum += nums[i];
        }
        return maxSum;
    }

    // BFS traversal
    public static int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        // Directions: right, left, down, up
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // Find first land cell to start BFS
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    break; // Start BFS from the first found land cell
                }
            }
            if (!queue.isEmpty()) break; // Stop searching once we find land
        }

        int perimeter = 0;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            // Check all 4 neighbors
            for (int[] dir : directions) {
                int nr = r + dir[0]; // New row
                int nc = c + dir[1]; // New col

                // If out of bounds OR water, add to perimeter
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || grid[nr][nc] == 0) {
                    perimeter++;
                }
                // If land and not visited, continue BFS
                else if (!visited[nr][nc]) {
                    queue.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }

        return perimeter;
    }

    // Max-heap approach
    public static String[] findRelativeRanks(int[] score) {
        String gold = "Gold Medal";
        String silver = "Silver Medal";
        String bronze = "Bronze Medal";
        if (score == null || score.length == 0) {
            return new String[0];
        }
        String[] result = new String[score.length];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        for (int i = 0; i < score.length; i++) {
            maxHeap.offer(new int[]{score[i], i});
        }

        int rank = 1;
        int heapSize = maxHeap.size();
        for (int i = 0; i < heapSize; i++) {
            int[] top = maxHeap.poll();
            int index = top[1];
            switch (rank) {
                case 1 -> result[index] = gold;
                case 2 -> result[index] = silver;
                case 3 -> result[index] = bronze;
                default -> result[index] = String.valueOf(rank);
            }
            rank++;
        }
        return result;
    }

    // Max-heap approach
    public static int lastStoneWeight(int[] stones) {
        int result = 0;
        if (stones == null || stones.length == 0) {
            return result;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int x = maxHeap.poll();
            int y = maxHeap.poll();
            if (x != y) {
                maxHeap.offer(x - y);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    // Min-heap approach
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
        }

        while (minHeap.size() > k) {
            minHeap.poll();
        }

        return minHeap.isEmpty() ? 0 : minHeap.peek();
    }

    // Greedy (or iterative linear) algorithm for Min and Max
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            int profit = price - minPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }

    // Iterative Linear Scan for Min and Max
    public static int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
