package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BacktrackingOperations {
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

    // =================================================
    // Permutations
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }

    private void permute(int[] nums, List<Integer> temp, boolean[] used, List<List<Integer>> result) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp)); // Store valid order
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                temp.add(nums[i]);
                permute(nums, temp, used, result);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    // =================================================
    // Subsets (Power Set)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsets(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void subsets(int[] nums, int index, List<Integer> temp, List<List<Integer>> result) {
        result.add(new ArrayList<>(temp)); // Store current subset
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]); // Include nums[i]
            subsets(nums, i + 1, temp, result);
            temp.remove(temp.size() - 1); // Undo choice
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDup(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void subsetsWithDup(int[] nums, int index, List<Integer> temp, List<List<Integer>> result) {
        result.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);
            subsetsWithDup(nums, i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        combine(result, new ArrayList<>(), 0, candidates, target);
        return result;
    }

    private static void combine(List<List<Integer>> result, List<Integer> temp, int index, int canditates[], int target) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0) return;
        for (int i = index; i < canditates.length; i++) {
            temp.add(canditates[i]);
            combine(result, temp, i, canditates, target - canditates[i]);
            temp.removeLast();
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combine2(result, new ArrayList<>(), 0, candidates, target);
        return result;
    }

    private static void combine2(List<List<Integer>> result, List<Integer> temp, int index, int canditates[], int target) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0) return;
        for (int i = index; i < canditates.length; i++) {
            if (i > index && canditates[i] == canditates[i - 1]) continue;
            temp.add(canditates[i]);
            combine2(result, temp, i + 1, canditates, target - canditates[i]);
            temp.removeLast();
        }
    }

//    public static int findTargetSumWays(int[] nums, int target) {
//        if (nums == null || nums.length == 0) return 0;
//        int[] result = new int[1];
//        findTargetSumWays(nums, target, 0, 0, result);
//        return result[0];
//    }
//
//    private static void findTargetSumWays(int[] nums, int target, int sum, int idx, int[] result) {
//        if (idx == nums.length) {
//            if (sum == target) {
//                result[0]++;
//            }
//            return;
//        }
//        findTargetSumWays(nums, target, sum + nums[idx], idx + 1, result);
//        findTargetSumWays(nums, target, sum - nums[idx], idx + 1, result);
//    }

    public static int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWays(nums, target, 0, 0, 0);
    }

    private static int findTargetSumWays(int[] nums, int target, int sum, int idx, int depth) {
        String indent = "  ".repeat(depth);
        System.out.println(indent + "→ dfs(idx=" + idx + ", sum=" + sum + ")");

        if (idx == nums.length) {
            boolean hit = sum == target;
            System.out.println(indent + "✅ BASE CASE: sum=" + sum + " " + (hit ? "== target ✔️" : "≠ target ✖️"));
            return hit ? 1 : 0;
        }

        int add = findTargetSumWays(nums, target, sum + nums[idx], idx + 1, depth + 1);
        int subtract = findTargetSumWays(nums, target, sum - nums[idx], idx + 1, depth + 1);
        int total = add + subtract;

        System.out.println(indent + "← Return from idx=" + idx + " → total ways=" + total);
        return total;
    }


    public static List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) return new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        partition(result, temp, s, 0, 0);
        return result;
    }

    private static void partition(
            List<List<String>> result,
            List<String> temp,
            String s,
            int index,
            int depth // add a depth parameter for indentation
    ) {
        String indent = "  ".repeat(depth);
        System.out.println(indent + "→ Enter partition(index=" + index + ", temp=" + temp + ")");

        if (index == s.length()) {
            System.out.println(indent + "✅ BASE CASE: index == s.length(), add " + temp);
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1);
            System.out.println(indent + "Check substring \"" + sub + "\" (index=" + index + " to " + i + ")");
            if (isPalindrome(sub)) {
                System.out.println(indent + "✅ \"" + sub + "\" is palindrome → add and recurse");
                temp.add(sub);
                partition(result, temp, s, i + 1, depth + 1);
                temp.remove(temp.size() - 1);
                System.out.println(indent + "⬅️ Backtrack, remove \"" + sub + "\", temp=" + temp);
            } else {
                System.out.println(indent + "❌ \"" + sub + "\" is NOT palindrome → skip");
            }
        }

        System.out.println(indent + "← Exit partition(index=" + index + ")");
    }

    private static boolean isPalindrome(String s) {
        if (s.length() == 1) return true;
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
