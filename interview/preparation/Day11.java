package interview.preparation;


import java.util.ArrayList;
import java.util.List;

public class Day11 {

    // 1. Generate all subsets (Power Set)
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsets(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private static void subsets(List<List<Integer>> res, List<Integer> temp, int[] nums, int start) {
        res.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            subsets(res, temp, nums, i + 1);
            temp.removeLast();
        }
    }

    // 2. Permutations of list
    public static List<List<Integer>> permute(List<Integer> nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.size()];
        permute(res, new ArrayList<>(), nums, used);
        return res;
    }

    private static void permute(List<List<Integer>> res, List<Integer> temp, List<Integer> nums, boolean[] used) {
        if (temp.size() == nums.size()) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < nums.size(); i++) {
            if (!used[i]) {
                used[i] = true;
                temp.add(nums.get(i));
                permute(res, temp, nums, used);
                used[i] = false;
                temp.removeLast();
            }
        }
    }

    // 3. Word Search (Backtracking in grid)
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exists(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    private static boolean exists(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if (board[i][j] != word.charAt(index)) return false;

        char temp = board[i][j];
        board[i][j] = '#'; // mark visited

        boolean found = exists(board, i + 1, j, word, index + 1)
                || exists(board, i - 1, j, word, index + 1)
                || exists(board, i, j + 1, word, index + 1)
                || exists(board, i, j - 1, word, index + 1);

        board[i][j] = temp; // restore after backtracking
        return found;
    }

    // 4. N-Queens problem
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        solveNQueens(res, new ArrayList<>(), 0, n);
        return res;
    }

    private static void solveNQueens(List<List<String>> res, List<String> temp, int index, int n) {
        if (index == n) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (!isValid(index, col, temp)) continue;
            String row = ".".repeat(n);
            char[] rowChars = row.toCharArray();
            rowChars[col] = 'Q';
            temp.add(String.valueOf(rowChars));
            solveNQueens(res, temp, index + 1, n);
            temp.removeLast();
        }
    }

    private static boolean isValid(int index, int col, List<String> temp) {
        for (int i = 0; i < index; i++) {
            String row = temp.get(i);
            int prevCol = row.indexOf('Q');

            // Same column
            if (prevCol == col) return false;

            // Same diagonal
            if (Math.abs(index - i) == Math.abs(col - prevCol)) return false;
        }
        return true;
    }


    // 5. Restore valid IP addresses from a string
    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        restoreIpAddresses(res, new StringBuilder(), s, 0, 0);
        return res;
    }

    private static void restoreIpAddresses(List<String> res, StringBuilder temp, String ip, int index, int partCount) {
        if (partCount == 4 && index == ip.length()) {
            res.add(temp.toString());
            return;
        }
        if (partCount == 4 || index == ip.length()) {
            return;
        }

        for (int len = 1; len <= 3; len++) {
            if (index + len > ip.length()) break; // prevent out-of-bounds

            String segment = ip.substring(index, index + len);

            if (!isValidSegment(segment)) continue;

            int beforeAppend = temp.length();
            temp.append(segment);
            if (partCount < 3) temp.append('.');
            restoreIpAddresses(res, temp, ip, index + len, partCount + 1);
            temp.setLength(beforeAppend);
        }

    }

    private static boolean isValidSegment(String s) {
        if (s.isEmpty() || s.length() > 3) return false;
        if (s.startsWith("0") && s.length() > 1) return false;
        int val = Integer.parseInt(s);
        return val >= 0 && val <= 255;
    }

}
