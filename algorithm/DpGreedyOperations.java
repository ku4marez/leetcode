package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DpGreedyOperations {

    // Knapsack to calculate sum by using min coins
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

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

    public static int minCostClimbingStairs(int[] cost) {
        for (int i = cost.length - 3; i >= 0; i--) {
            cost[i] += Math.min(cost[i + 1], cost[i + 2]);
        }
        return Math.min(cost[0], cost[1]);
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

    // Edit Distance (min distance) (Levenshtein Distance)
    public static int editDistance(String word1, String word2) {
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

    // Greedy
    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        int pointer = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= pointer) {
                pointer = i;
            }
        }
        return pointer == 0;
    }

    public static int jump2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = 0;
        int res = 0;
        while (right < nums.length - 1) {
            int farthest = 0;
            for (int i = left; i <= right; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            left = right + 1;
            right = farthest;
            res += 1;
        }
        return res;
    }

    // Longest Common Subsequence Algorithm
    public static boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[m][n] == m;
    }

    public static int coinChange2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = coins.length - 1; i >= 0; i--) {
            int[] nextDp = new int[amount + 1];
            nextDp[0] = 1;

            for (int j = 1; j <= amount; j++) {
                nextDp[j] = dp[j];
                if (j - coins[i] >= 0) {
                    nextDp[j] += nextDp[j - coins[i]];
                }
            }
            dp = nextDp;
        }
        return dp[amount];
    }

    // Greedy with two pointers
    public static boolean checkValidString(String s) {
        int low = 0, high = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                low ++;
                high ++;
            } else if (c == ')') {
                low --;
                high --;
            } else if (c == '*') {
                low --;
                high ++;
            }
            if (high < 0) return false;
            if (low < 0) low = 0;
        }
        return low == 0;
    }

    public static int maxProduct(int[] nums) {
        int[] maxProduct = new int[nums.length];
        int[] minProduct = new int[nums.length];

        maxProduct[0] = nums[0];
        minProduct[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxProduct[i] = Math.max(nums[i], Math.max(maxProduct[i - 1] * nums[i], minProduct[i - 1] * nums[i]));
            minProduct[i] = Math.min(nums[i], Math.min(maxProduct[i - 1] * nums[i], minProduct[i - 1] * nums[i]));
            max = Math.max(max, maxProduct[i]);
        }
        return max;
    }
}
