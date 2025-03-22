package algorithm;

import java.util.*;

public class ArrayOperations {


    // Print numbers from 0 to 100 in a random order (Fisher–Yates shuffle or Knuth shuffle)
    public static void printNumbers() {
        int[] nums = new int[100];

        // Step 1: Fill the array with numbers 1 to 100
        for (int i = 0; i < 100; i++) {
            nums[i] = i + 1;
        }

        // Step 2: Shuffle the array using Fisher-Yates algorithm
        Random rand = new Random();
        for (int i = nums.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1); // Random index from 0 to i
            // Swap nums[i] and nums[j]
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // Step 3: Print shuffled numbers
        for (int num : nums) {
            System.out.print(num + " ");
        }
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

    // Index Marking (Negation Trick)
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;  // Get correct index

            if (nums[index] < 0) {
                // If already negative, it means the number is duplicate
                duplicates.add(index + 1);
            } else {
                // Mark as visited by making it negative
                nums[index] *= -1;
            }
        }

        return duplicates; // Return list of duplicates
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

    // Greedy algorithm with one pointer
    public static boolean canJump(int[] nums) {
        int index = 0;
        int farthest = nums[0];
        int size = nums.length;
        while (index < size) {
            if (index > farthest) {
                return false;
            }
            farthest = Math.max(farthest, index + nums[index]);
            if (farthest >= size - 1) {
                return true;
            }
            index = index + 1;
        }
        return true;
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
