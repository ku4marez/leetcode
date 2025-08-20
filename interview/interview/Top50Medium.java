package interview.interview;

import interview.preparation.Day8;

import java.util.*;

public class Top50Medium {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;

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

    static class RandomizedSet {
        List<Integer> list;
        Map<Integer, Integer> map;
        Random random;

        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int index = map.get(val);
            int last = list.getLast();

            list.set(index, last);
            map.put(last, index);

            list.removeLast();
            map.remove(val);
            return true;
        }

        public int getRandom() {
            int index = random.nextInt(list.size());
            return list.get(index);
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

        int[] peakArr = new int[]{1, 2, 3, 1};
        System.out.println(findPeakElement(peakArr));

        System.out.println(countAndSay(4));

        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));

        System.out.println(increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));

        //Linked List
        ListNode head1 = new ListNode(9);
        head1.next = new ListNode(9);

        ListNode head2 = new ListNode(9);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(9);
        head2.next.next = new ListNode(9);

        System.out.println(addTwoNumbers(head1, head2));

        ListNode shared = new ListNode(8);
        shared.next = new ListNode(4);
        shared.next.next = new ListNode(5);

        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = shared;

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = shared;
        System.out.println(getIntersectionNode(headA, headB));

        ListNode headEvenOdd = new ListNode(1);
        headEvenOdd.next = new ListNode(2);
        headEvenOdd.next.next = new ListNode(3);
        headEvenOdd.next.next.next = new ListNode(4);
        headEvenOdd.next.next.next.next = new ListNode(5);
        headEvenOdd.next.next.next.next.next = new ListNode(6);
        System.out.println(oddEvenList(headEvenOdd));

        //Tree
        Integer[] inorderTraversal = new Integer[]{1, null, 2, 3};
        TreeNode inorderTraversalTree = buildTree(inorderTraversal);
        System.out.println(inorderTraversal(inorderTraversalTree));

        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        System.out.println(buildTree(preorder, inorder));

        Integer[] kthSmallest = new Integer[]{5, 3, 6, 2, 4, null, null, 1};
        System.out.println(kthSmallest(buildTree(kthSmallest), 3));

        Integer[] zigzag = new Integer[]{3, 9, 20, null, null, 15, 7};
        System.out.println(zigzagLevelOrder(buildTree(zigzag)));

        System.out.println(connect(buildTreeNode(new Integer[]{1, 2, 3, 4, 5, 6, 7})));

        System.out.println(numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '1', '1'},
                {'0', '0', '0', '1', '0'},
                {'0', '1', '1', '0', '0'},
                {'0', '0', '0', '0', '0'}
        }));

        //Backtracking
        int[] backtrackingArr = new int[]{1, 2, 3};
        System.out.println(permute(backtrackingArr));

        int[] subsetArr = new int[]{1, 2, 3};
        System.out.println(subsets(subsetArr));

        System.out.println(generateParenthesis(3));

        char[][] wordSearch = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(wordSearch, "BCE"));

        System.out.println(letterCombinations(""));

        //DP
        int[] coinsChangeArr = new int[]{1, 2, 5};
        System.out.println(coinChange(coinsChangeArr, 11));

        int[] canJumpArr = new int[]{1, 0, 1};
        System.out.println(canJump(canJumpArr));

        //Sorting and search
        int[] topKFreq = new int[]{1, 1, 1, 2, 2, 3};
        int k = 3;
        System.out.println(topKFrequent(topKFreq, k));

        int[][] mergeInts = new int[][]{{1, 2}, {2, 6}, {5, 6}, {8, 10}};
        System.out.println(Arrays.toString(merge(mergeInts)));

        int[] kLargest = new int[]{3, 2, 1, 5, 6, 4};
        k = 2;
        System.out.println(findKthLargest(kLargest, k));

        int[] rotateArr = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(rotateArr, 0));

        int[] rangeArr = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(searchRange(rangeArr, 8));

        int[] colorArr = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(colorArr);
        System.out.println(Arrays.toString(colorArr));

        int[][] matrix2 = {
                {1, 4},
                {2, 5}
        };
        System.out.println(searchMatrix(matrix2, 2)); // true

        //Design
        Integer[] serializeArr = new Integer[]{1, 2, 3, null, null, 4, 5};
        System.out.println(serialize(buildTree(serializeArr)));

        String deserializeStr = "[1,2,3,null,null,4,5]";
        System.out.println(deserialize(deserializeStr));

        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(0);
        randomizedSet.insert(1);
        randomizedSet.remove(0);
        randomizedSet.insert(2);
        randomizedSet.remove(1);
        randomizedSet.getRandom();

        //Math
        System.out.println(isHappy(19));

        System.out.println(divide(2147483647, -1));

        System.out.println(myPow(2, 3));

        System.out.println(mySqrt(8));

        System.out.println(trailingZeroes(2));

        //Others
        System.out.println(getSum(2, 3));

        int[] majoriteArr = new int[]{1, 1, 2, 3, 4};
        System.out.println(majorityElement(majoriteArr));

        char[] taskScheduler = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(leastInterval(taskScheduler, 2));
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

    private static int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    private static String countAndSay(int n) {
        String res = "1";
        if (n == 1) return res;
        for (int i = 1; i < n; i++) {
            List<int[]> matrix = groupDigits(res);
            res = buildNext(matrix);
        }
        return res;
    }

    private static List<int[]> groupDigits(String n) {
        List<int[]> result = new ArrayList<>();
        int i = 0;

        while (i < n.length()) {
            char ch = n.charAt(i);
            int count = 1;
            while (i + 1 < n.length() && ch == n.charAt(i + 1)) {
                count++;
                i++;
            }

            result.add(new int[]{ch - '0', count});
            i++;
        }
        return result;
    }

    private static String buildNext(List<int[]> nums) {
        StringBuilder res = new StringBuilder();
        for (int[] num : nums) {
            res.append(num[1]).append(num[0]);
        }
        return res.toString();
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    private static boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }

        }
        return false;
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

    public static Node buildTreeNode(Integer[] values) {
        if (values == null || values.length == 0) return null;

        Node root = new Node(values[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < values.length) {
            Node current = queue.poll();

            if (values[i] != null) {
                current.left = new Node(values[i]);
                queue.add(current.left);
            }
            i++;

            if (i < values.length && values[i] != null) {
                current.right = new Node(values[i]);
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

    private static int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int count = 0;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (++count == k) {
                return curr.val;
            }
            curr = curr.right;
        }
        return -1;
    }

    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        boolean isLeft = true;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (isLeft) {
                    level.add(node.val);
                } else {
                    level.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(level);
            isLeft = !isLeft;
        }
        return result;
    }

    private static Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                if (prev != null) {
                    prev.next = current;
                }
                prev = current;

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            prev.next = null;
        }
        return root;
    }

    private static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    countIslands(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private static void countIslands(char[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] == '0') {
            return;
        }
        visited[i][j] = true;
        countIslands(grid, i + 1, j, visited);
        countIslands(grid, i - 1, j, visited);
        countIslands(grid, i, j + 1, visited);
        countIslands(grid, i, j - 1, visited);
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

    private static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private static boolean exist(char[][] board, String word, int x, int y, int index) {
        if (index == word.length()) return true;
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) return false;
        if (board[x][y] != word.charAt(index)) return false;

        char temp = board[x][y];
        board[x][y] = '#';
        boolean exist = exist(board, word, x + 1, y, index + 1)
                || exist(board, word, x - 1, y, index + 1)
                || exist(board, word, x, y + 1, index + 1)
                || exist(board, word, x, y - 1, index + 1);
        board[x][y] = temp;

        return exist;
    }

    private static List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return new ArrayList<>();
        String[] mapping = {null, null, "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        backtrackLetterCombinations(digits, 0, new StringBuilder(), mapping, result);
        return result;
    }

    private static void backtrackLetterCombinations(String digits, int index, StringBuilder sb, String[] mapping, List<String> result) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String letters = mapping[digits.charAt(index) - '0'];
        for (char letter : letters.toCharArray()) {
            sb.append(letter);
            backtrackLetterCombinations(digits, index + 1, sb, mapping, result);
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

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode posA = headA;
        ListNode posB = headB;

        while (posA != posB) {
            posA = posA == null ? headB : posA.next;
            posB = posB == null ? headA : posB.next;
        }
        return posA;
    }

    private static ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode even = head.next;
        ListNode odd = head;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            even.next = odd.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    //DP
    private static int coinChange(int[] coins, int amount) {
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

    private static boolean canJump(int[] nums) {
        int index = 0;
        int farthest = nums[0];
        int size = nums.length;
        while (index < size) {
            if (index > farthest) {
                return false;
            }
            farthest = Math.max(farthest, index + nums[index]);
            if (farthest >= size - 1) {
                return true;
            }
            index = index + 1;
        }
        return true;
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

    private static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target <= nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (target >= nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }

    private static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) return result;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (nums[left] == target) {
            result[0] = left;
        }

        left = 0;
        right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] == target) {
                left = mid;
            } else if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (nums[right] == target) {
            result[1] = right;
        }

        return result;
    }

    //Dutch national flag
    private static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                mid++;
                low++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            int val = matrix[row][col];
            if (val == target) return true;
            else if (val < target) row++;
            else col--;
        }
        return false;
    }

    //Design
    private static String serialize(TreeNode root) {
        if (root == null) return "";
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            res.add(node != null ? node.val : null);

            if (node != null) queue.add(node.left);
            if (node != null) queue.add(node.right);
        }

        while (!res.isEmpty() && res.getLast() == null) {
            res.removeLast();
        }

        return Arrays.toString(res.toArray());
    }

    private static TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String clean = data.replaceAll("[\\[\\]\\s]", "");
        String[] tokens = clean.split(",");
        Integer[] nums = Arrays.stream(tokens).map(string -> string.equals("null") ? null : Integer.parseInt(string)).toArray(Integer[]::new);
        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < tokens.length) {
            TreeNode node = queue.poll();

            if (i < nums.length) node.left = nums[i] != null ? new TreeNode(nums[i]) : null;
            i++;

            if (i < nums.length) node.right = nums[i] != null ? new TreeNode(nums[i]) : null;
            i++;

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return root;
    }

    //Math
    private static boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    private static int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    private static int divide(int dividend, int divisor) {
        if (divisor == 0) throw new ArithmeticException("Divide by zero");
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (divisor == 1) {
            return dividend;
        }
        boolean isNegative = (dividend < 0) ^ (divisor < 0);
        long dividendLong = Math.abs((long) dividend);
        long divisorLong = Math.abs((long) divisor);
        int res = 0;
        while (dividendLong >= divisorLong) {
            dividendLong -= divisorLong;
            res++;
        }
        return isNegative ? -res : res;
    }

    private static double myPow(double x, int n) {
        long power = n;
        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        double result = 1.0;
        while (power > 0) {
            if ((power & 1) == 1) {
                result *= x;
            }
            x *= x;
            power >>= 1;
        }

        return result;
    }

    private static int mySqrt(int x) {
        if (x < 2) return x;

        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if ((long) mid * mid == x) {
                return mid;
            } else if ((long) mid * mid < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static int trailingZeroes(int n) {
        int count = 0;
        for (int i = 5; i <= n; i *= 5) {
            count += n / i;
        }
        return count;
    }

    //Others
    private static int getSum(int a, int b) {
        while (b != 0) {
            int carry = a & b;     // where both bits are 1 → need to carry
            a = a ^ b;             // add without carry
            b = carry << 1;        // move carry to the next left bit
        }
        return a;
    }

    private static int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int count = 0;
        int element = nums[0];
        for (int num : nums) {
            if (count == 0) {
                element = num;
            }
            count += num == element ? 1 : -1;
        }
        return element;
    }

    private static int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return -1;
        int time = 0;
        Queue<int[]> cooldownQueue = new LinkedList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char c : tasks) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        maxHeap.addAll(freqMap.values());
        while (!cooldownQueue.isEmpty() || !maxHeap.isEmpty()) {
            if (!cooldownQueue.isEmpty() && cooldownQueue.peek()[1] == time) {
                maxHeap.offer(cooldownQueue.poll()[0]);
            }
            if (!maxHeap.isEmpty()) {
                int remaining = maxHeap.poll() - 1;
                if (remaining > 0) {
                    cooldownQueue.offer(new int[]{remaining, time + n + 1});
                }
            }
            time++;
        }
        return time;
    }
}
