package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DpOperations {

    // Dynamic Programming (Fibonacci Sequence)
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        int array[] = new int[n];
        array[0] = 1;
        array[1] = 2;
        for (int i = 2; i <= n - 1; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[array.length - 1];
    }

    // Pascal's Triangle Construction
    public static List<List<Integer>> generate(int numRows) {
        if (numRows == 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(List.of(1)));
        if (numRows == 1) return result;
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            List<Integer> prev = result.get(i - 1);

            list.add(1);
            for (int j = 1; j < prev.size(); j++) {
                list.add(prev.get(j - 1) + prev.get(j));
            }
            list.add(1);
            result.add(list);
        }
        return result;
    }

    // Pascal's Triangle Row Calculation Using Combination Formula
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        long current = 1;

        for (int k = 0; k <= rowIndex; k++) {
            row.add((int) current);
            current = current * (rowIndex - k) / (k + 1);
        }

        return row;
    }

    // DP Iterative bit count for every number
    public static int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }

    // Iterative Linear Scan for Min and Max
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

    // DP Fibonacci sequence recursive
    public static int fibRecursively(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return fibRecursively(n - 1) + fibRecursively(n - 2);
    }

    // DP Fibonacci sequence iterative ( O(n) time and O(1) space )
    public static int fibIterative(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int sum = 0;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }

    // Edit Distance (Levenshtein Distance)
    public int editDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) dp[i][j] = j;
                else if (j == 0) dp[i][j] = i;
                else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                }
            }
        }

        return dp[m][n];
    }

    // 0/1 Knapsack
    public int knapsack(int[] weights, int[] values, int W) {
        int n = weights.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], values[i - 1] + dp[i - 1][w - weights[i - 1]]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][W];
    }

    // =================================================
    // Subsets (Power Set)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int index, List<Integer> temp, List<List<Integer>> result) {
        result.add(new ArrayList<>(temp)); // Store current subset
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]); // Include nums[i]
            backtrack(nums, i + 1, temp, result);
            temp.remove(temp.size() - 1); // Undo choice
        }
    }

    // =================================================
    // Permutations
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> temp, boolean[] used, List<List<Integer>> result) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp)); // Store valid order
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                temp.add(nums[i]);
                backtrack(nums, temp, used, result);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    // =================================================
    // N-Queens
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        backtrack(board, 0, result);
        return result;
    }

    private void backtrack(char[][] board, int row, List<List<String>> result) {
        if (row == board.length) {
            List<String> validBoard = new ArrayList<>();
            for (char[] line : board) validBoard.add(new String(line));
            result.add(validBoard);
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(board, row + 1, result);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) if (board[i][col] == 'Q') return false;
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) if (board[i][j] == 'Q') return false;
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) if (board[i][j] == 'Q') return false;
        return true;
    }
}
