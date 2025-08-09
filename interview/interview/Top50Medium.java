package interview.interview;

import java.util.*;

public class Top50Medium {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

        //Array and strings
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));

        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

        System.out.println(lengthOfLongestSubstring("abcabcbb"));

        System.out.println(longestPalindrome("babad"));

        //Linked List
        ListNode head1 = new ListNode(9);
        head1.next = new ListNode(9);

        ListNode head2 = new ListNode(9);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(9);
        head2.next.next = new ListNode(9);

        System.out.println(addTwoNumbers(head1, head2));

        //Tree
        Integer[] inorderTraversal = new Integer[]{1, null, 2, 3};
        TreeNode inorderTraversalTree = buildTree(inorderTraversal);
        System.out.println(inorderTraversal(inorderTraversalTree));

        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        System.out.println(buildTree(preorder, inorder));

        //Backtracking
        int[] backtrackingArr = new int[]{1, 2, 3};
        System.out.println(permute(backtrackingArr));

        int[] subsetArr = new int[]{1, 2, 3};
        System.out.println(subsets(subsetArr));

        System.out.println(generateParenthesis(3));
        //Sorting and search
        int[] topKFreq = new int[]{1, 1, 1, 2, 2, 3};
        int k = 3;
        System.out.println(topKFrequent(topKFreq, k));

        int[][] mergeInts = new int[][]{{1, 2}, {2, 6}, {5, 6}, {8, 10}};
        System.out.println(Arrays.toString(merge(mergeInts)));

        int[] kLargest = new int[]{3, 2, 1, 5, 6, 4};
        k = 2;
        System.out.println(findKthLargest(kLargest, k));
    }

    //Array and strings
    private static void setZeroes(int[][] matrix) {
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                firstRowHasZero = true;
                break;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRowHasZero) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        if (firstColHasZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            ans.add(new ArrayList<>(entry.getValue()));
        }
        return ans;
    }

    private static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    private static String longestPalindrome(String s) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > right - left) {
                left = i - (len - 1) / 2;
                right = i + len / 2;
            }
        }
        return s.substring(left, right + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    //Tree
    public static TreeNode buildTree(Integer[] values) {
        if (values == null || values.length == 0) return null;

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < values.length) {
            TreeNode current = queue.poll();

            if (values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.add(current.left);
            }
            i++;

            if (i < values.length && values[i] != null) {
                current.right = new TreeNode(values[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        inorderTraversal(root, ans);
        return ans;
    }

    private static void inorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorderTraversal(root.left, res);
        res.add(root.val);
        inorderTraversal(root.right, res);
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;
        int pi = 0, ii = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[pi++]);
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.val != inorder[ii]) {
                TreeNode left = new TreeNode(preorder[pi++]);
                node.left = left;
                stack.push(left);
            } else {
                TreeNode popped = null;
                while (!stack.isEmpty() && stack.peek().val == inorder[ii]) {
                    popped = stack.pop();
                    ii++;
                }
                if (pi < preorder.length) {
                    TreeNode right = new TreeNode(preorder[pi++]);
                    popped.right = right;
                    stack.push(right);
                }
            }
        }
        return root;
    }

    //Backtracking
    private static List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        permute(nums, new ArrayList<>(), res, new boolean[nums.length]);
        return res;
    }

    private static void permute(int[] nums, List<Integer> temp, List<List<Integer>> res, boolean[] visited) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            temp.add(nums[i]);
            permute(nums, temp, res, visited);
            temp.removeLast();
            visited[i] = false;
        }
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, int index, List<Integer> temp, List<List<Integer>> result) {
        result.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(nums, i + 1, temp, result);
            temp.removeLast();
        }
    }

    private static List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        generateParenthesis(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private static void generateParenthesis(List<String> res, StringBuilder sb, int left, int right, int n) {
        if (sb.length() == n * 2) {
            res.add(sb.toString());
            return;
        }
        if (left < n) {
            sb.append('(');
            generateParenthesis(res, sb, left + 1, right, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right < left) {
            sb.append(')');
            generateParenthesis(res, sb, left, right + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    //Linked list
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = val1 + val2 + carry;
            carry = sum / 10;

            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return dummy.next;
    }

    //Sorting and search
    private static int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) pq.poll();
        }
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll().getKey();
        }
        return result;
    }

    private static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][0];
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int[] prev = result.getLast();
            if (prev[1] >= curr[0]) {
                prev[1] = Math.max(prev[1], curr[1]);
            } else {
                result.add(curr);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    private static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            pq.offer(num);
        }
        int res = -1;
        for (int i = 0; i < k; i++) {
            res = pq.poll();
        }
        return res;
    }

}
