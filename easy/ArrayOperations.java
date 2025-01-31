package easy;

import java.util.*;

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
                p1 ++;
            }
            p2 ++;
        }
        return p1;
    }

    // Greedy algorithm with sorting
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int maxSum = 0;

        for (int i = 0; i < nums.length; i+=2) {
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
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};

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
}
