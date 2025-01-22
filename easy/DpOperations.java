package easy;

import java.util.ArrayList;
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
}
