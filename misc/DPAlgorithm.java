package misc;


import java.util.Arrays;

public class DPAlgorithm {
    public static void main(String[] args) {
        System.out.println(fib(3));

        System.out.println(climbStairs(5));

        System.out.println(minCostClimbingStairs(new int[]{10, 15, 20}));

        System.out.println(rob(new int[]{1, 2, 3, 1}));

        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

        System.out.println(canJump(new int[]{1, 1, 0, 1, 1}));

        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));

        System.out.println(coinChange(new int[]{1, 2, 5}, 11));

        System.out.println(change(5, new int[]{1, 2, 5}));
    }

    // Fibonacci
    public static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 2) + fib(n - 1);
    }

    // Climb stairs
    public static int climbStairs(int n) {
        if (n <= 1) return n;
        int one = 1, two = 1;
        for (int i = 2; i <= n; i++) {
            int temp = one;
            one = one + two;
            two = temp;
        }
        return one;
//        if (n <= 1) return n;
//        int[] dp = new int[n + 1];
//        dp[n] = 1;
//        dp[n - 1] = 1;
//        for(int i = n - 2; i >= 0; i--) {
//            dp[i] = dp[i + 1] + dp[i + 2];
//        }
//        return dp[0];
    }

    // Min cost climbing stairs
    public static int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) return 0;
        cost = Arrays.copyOf(cost, cost.length + 1);
        cost[cost.length - 1] = 0;
        for (int i = cost.length - 3; i >= 0; i--) {
            cost[i] = cost[i] + Math.min(cost[i + 1], cost[i + 2]);
        }
        return Math.min(cost[0], cost[1]);
    }

    // House rob
    public static int rob(int[] nums) {
//        if (nums == null || nums.length == 0) return 0;
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        dp[1] = Math.max(nums[0], nums[1]);
//        for (int i = 2; i < nums.length; i++) {
//            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
//        }
//        return dp[nums.length - 1];

        if (nums == null || nums.length == 0) return 0;
        int one = 0, two = 0;
        for (int num : nums) {
            int temp = Math.max(num + one, two);
            one = two;
            two = temp;
        }
        return two;
    }

    // Maximum subarray (Kadane)
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // jump game
    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int goal = nums.length - 1;
        for (int i = goal; i >= 0; i--) {
            if (i + nums[i] >= goal) goal = i;
        }
        return goal == 0;
    }

    // jump game 2
    public static int jump(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        return dp[nums.length - 1];
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount <= 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int c : coins) {
                if (i - c >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
                }
            }
        }
        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }

    //Bottom up coin change 2
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {            // outer: each coin once
            for (int i = coin; i <= amount; i++) {  // inner: build up ways
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
