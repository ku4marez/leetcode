package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static List<List<Integer>> subsetsWithDup(int[] nums){
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
}
