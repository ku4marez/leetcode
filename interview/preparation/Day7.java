package interview.preparation;


import java.util.*;

public class Day7 {

    public static List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(res, new ArrayList<>(), used, nums);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> temp, boolean[] visited, int[] nums) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp.add(nums[i]);
                backtrack(res, temp, visited, nums);
                temp.remove(temp.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        backtrack(res, new ArrayList<>(), 0, nums);
        return res;
    }


    public static void backtrack(List<List<Integer>> res, List<Integer> temp, int start, int[] nums) {
        res.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(res, temp, i + 1, nums);
            temp.remove(temp.size() - 1);
        }
    }

    public static int multiply(int a, int b) {
        if (b == 0) return 0;
        if (b < 0) return -multiply(a, -b);
        return a + multiply(a, b - 1);
    }

    public static int multiplyBitwise(int a, int b) {
        int result = 0;
        while (b > 0) {
            if ((b & 1) == 1) result += a;
            a <<= 1;
            b >>= 1;
        }
        return result;
    }

    public static int multiplyDivideAndConquer(int a, int b) {
        if (b == 0) return 0;
        if (b < 0) return -multiply(a, -b);

        int half = multiply(a, b / 2);

        if (b % 2 == 0) {
            return half + half;
        } else {
            return half + half + a;
        }
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || wordDict == null || wordDict.size() == 0) return false;
        return wordBreak(s, new HashSet<>(wordDict), new HashMap<>());
    }

    private static boolean wordBreak(String s, Set<String> wordDict, Map<String, Boolean> memo) {
        if (s.isEmpty()) return true;
        if (memo.containsKey(s)) return memo.get(s);

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            String suffix = s.substring(i);
            if (wordDict.contains(prefix) && wordBreak(suffix, wordDict, memo)) {
                memo.put(s, true);
                return true;
            }
        }

        memo.put(s, false);
        return false;
    }

        public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSum(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    public static void combinationSum(List<List<Integer>> result, List<Integer> temp, int[] candidates, int remain, int start) {
        if (remain == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (remain < 0) return;
        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            combinationSum(result, temp, candidates, remain - candidates[i], i);
            temp.remove(temp.size() - 1);
        }
    }
}
