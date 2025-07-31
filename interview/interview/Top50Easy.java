package interview.interview;

import interview.preparation.Day3;

import java.util.*;

public class Top50Easy {
    static final int MOD = 1_000_000_007;

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

    static class NodeDepth {
        TreeNode node;
        int depth;

        NodeDepth(TreeNode n, int d) {
            node = n;
            depth = d;
        }
    }

    public static void main(String[] args) {
        // Arrays
        int[] rotateArr = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(rotateArr, 3);
        System.out.println(Arrays.toString(rotateArr));

        int[] duplicateArr = new int[]{1, 2, 3, 3, 5, 6, 7};
        System.out.println(containsDuplicate(duplicateArr));

        int[] signleArr = new int[]{4, 1, 2, 1, 2};
        System.out.println(singleNumber(signleArr));

        int[] twoSumArr = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(twoSumArr, 9)));

        int[] plusOneArr = new int[]{4, 9, 2, 8};
        System.out.println(Arrays.toString(plusOne(plusOneArr)));

        int[] maxProfit2 = new int[]{4, 9, 2, 8};
        System.out.println(maxProfit2(maxProfit2));

        int[] intersectionArr1 = new int[]{1, 2, 2, 1};
        int[] intersectionArr2 = new int[]{2, 2};
        System.out.println(Arrays.toString(intersect(intersectionArr1, intersectionArr2)));

        int[] moveZeroArr = new int[]{1, 2, 0, 0, 12};
        moveZeroes(moveZeroArr);
        System.out.println(Arrays.toString(moveZeroArr));

        // Strings
        char[] charArray = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseString(charArray);
        System.out.println(Arrays.toString(charArray));

        int reverseInt = 321;
        System.out.println(reverse(reverseInt));

        String atoi = "-92783";
        System.out.println(myAtoi(atoi));

        String anagramStr1 = "abcd";
        String anagramStr2 = "dbac";
        System.out.println(isAnagram(anagramStr1, anagramStr2));

        String palindromeStr1 = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(palindromeStr1));

        String[] commonPrefix = new String[]{"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(commonPrefix));

        String uniqueCharString = "leetcode";
        System.out.println(firstUniqChar(uniqueCharString));

        String aystack = "adbutsad", needle = "sad";
        System.out.println(strStr(aystack, needle));

        // LinkedList
        ListNode deleteHead = new ListNode(4);
        deleteHead.next = new ListNode(5);
        deleteHead.next.next = new ListNode(6);
        deleteHead.next.next.next = new ListNode(7);

        deleteNode(deleteHead.next);
        System.out.println(deleteHead);

        ListNode cycleHead = new ListNode(3);
        cycleHead.next = new ListNode(2);
        cycleHead.next.next = new ListNode(0);
        cycleHead.next.next.next = new ListNode(-4);
        System.out.println(hasCycle(cycleHead));

        System.out.println(mergeTwoLists(cycleHead, deleteHead));

        ListNode reverseHead = new ListNode(3);
        reverseHead.next = new ListNode(2);
        reverseHead.next.next = new ListNode(1);
        reverseHead.next.next.next = new ListNode(0);
        System.out.println(reverseList(reverseHead));

        ListNode removeNth = new ListNode(3);
        removeNth.next = new ListNode(2);
        removeNth.next.next = new ListNode(0);
        removeNth.next.next.next = new ListNode(1);
        System.out.println(removeNthFromEnd(removeNth, 2));

        ListNode palindromeList = new ListNode(1);
        palindromeList.next = new ListNode(2);
        palindromeList.next.next = new ListNode(2);
        palindromeList.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(palindromeList));

        //Trees
        Integer[] maxDepthArr = new Integer[]{1, 2, 3, 4, null, 5};
        System.out.println(maxDepth(buildTree(maxDepthArr)));

        Integer[] levelOrder = new Integer[]{3, 9, 20, null, null, 15, 7};
        System.out.println(levelOrder(buildTree(levelOrder)));

        Integer[] isValidBSTArr = new Integer[]{5, 1, 4, null, null, 3, 6};
        System.out.println(isValidBST(buildTree(isValidBSTArr)));

        Integer[] symmetricTreeArr = new Integer[]{1, 2, 2, 3, 4, 4, 3};
        System.out.println(isSymmetric(buildTree(symmetricTreeArr)));

        int[] sortedArrToBST = new int[]{-10, -3, 0, 5, 9};
        System.out.println(sortedArrayToBST(sortedArrToBST));

        //Sorting
        int[] mergeArr1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] mergeArr2 = new int[]{2, 5, 6};
        merge(mergeArr1, 3, mergeArr2, 3);
        System.out.println(Arrays.toString(mergeArr1));

        System.out.println(firstBadVersion(4));

        //DP
        System.out.println(climbStairs(4));
        System.out.println(maxProfit(new int[]{1, 2, 3, 4}));
        System.out.println(maxSubArray(new int[]{1, 2, -3, -5}));
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));

        //Design
        MinStack obj = new MinStack();
        obj.push(4);
        obj.push(3);
        obj.push(5);

        int[] solutionArr = new int[]{2, 7, 9, 3, 1};
        Solution solution = new Solution(solutionArr);
        solution.shuffle();
        System.out.println(Arrays.toString(solutionArr));
        solution.reset();
        System.out.println(Arrays.toString(solutionArr));

        //Other
        int count1s = 12;
        System.out.println(hammingWeight(count1s));

        int reverseBits = 43261596;
        System.out.println(reverseBits(reverseBits));

        String isValidStr = "]";
        System.out.println(isValid(isValidStr));

        System.out.println(hammingDistance(4, 7));

        int[] missingNumArr = new int[]{3, 0, 1};
        System.out.println(missingNumber(missingNumArr));
    }

    // Arrays
    private static void rotate(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        swap(nums, 0, length - 1);
        swap(nums, 0, k - 1);
        swap(nums, k, length - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    private static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return true;
        }
        return false;
    }

    private static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    private static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    private static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }

    private static int maxProfit2(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    private static int[] intersect(int[] nums1, int[] nums2) {
        int p1 = 0;
        int p2 = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> set = new ArrayList<>();
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] == nums2[p2]) {
                set.add(nums1[p1++]);
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            }
        }
        int[] result = new int[set.size()];
        int index = 0;
        for (Iterator<Integer> iterator = set.iterator(); iterator.hasNext(); ) {
            result[index] = iterator.next();
            index++;
        }
        return result;
    }

    private static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int lastNonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) nums[lastNonZeroIndex++] = nums[i];
        }
        for (int i = lastNonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    // Strings
    private static void reverseString(char[] s) {
        int start = 0, end = s.length - 1;
        while (start < end) {
            s[start] ^= s[end];
            s[end] ^= s[start];
            s[start] ^= s[end];
            start++;
            end--;
        }
    }

    private static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int y = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && y > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && y < -8)) return 0;

            rev = rev * 10 + y;
        }
        return rev;
    }

    private static int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;

        boolean negative = false;
        int i = 0;
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            negative = s.charAt(i) == '-';
            i++;
        }

        long res = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            if (res > Integer.MAX_VALUE / 10 ||
                    (res == Integer.MAX_VALUE / 10 && digit > (negative ? 8 : 7))) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            res = res * 10 + digit;
            i++;
        }

        return (int) (negative ? -res : res);
    }

    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return Arrays.equals(sArr, tArr);
    }

    private static boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    private static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String curr = strs[i];
            int j = 0;
            while (j < curr.length() && j < res.length() && res.charAt(j) == curr.charAt(j)) {
                j++;
            }
            res = res.substring(0, j);
            if (res.isEmpty()) return "";
        }
        return res;
    }

    private static int firstUniqChar(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (freq[ch - 'a'] == 1) return i;
        }
        return -1;
    }

    private static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    // LinkedList
    private static void deleteNode(ListNode node) {
        if (node == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }

    private static boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if (list1 != null) curr.next = list1;
        else curr.next = list2;
        return dummy.next;
    }

//    private static ListNode reverseList(ListNode head) {
//        if (head == null) return null;
//        ListNode current = head;
//        Stack<ListNode> stack = new Stack<>();
//        while (current != null) {
//            stack.push(current);
//            current = current.next;
//        }
//        ListNode newHead = stack.pop();
//        current = newHead;
//        while (!stack.isEmpty()) {
//            current.next = stack.pop();
//            current = current.next;
//        }
//        current.next = null;
//        return newHead;
//    }

    private static ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    private static boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reversed = reverseList(slow.next);
        ListNode curr = head;
        while (reversed != null) {
            if (reversed.val != curr.val) return false;
            reversed = reversed.next;
            curr = curr.next;

        }
        return true;
    }

    //Trees
    private static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0) return null;
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(arr[0]);
        queue.add(root);
        int i = 1;
        while (i < arr.length) {
            TreeNode node = queue.poll();
            if (i < arr.length && arr[i] != null) {
                node.left = new TreeNode(arr[i]);
                queue.add(node.left);
            }
            i++;
            if (i < arr.length && arr[i] != null) {
                node.right = new TreeNode(arr[i]);
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

//    private static int maxDepth(TreeNode root) {
//        if (root == null) return 0;
//        Integer left = maxDepth(root.left);
//        Integer right = maxDepth(root.right);
//        return Math.max(left, right) + 1;
//    }

    private static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Stack<NodeDepth> stack = new Stack<>();
        stack.push(new NodeDepth(root, 1));
        int maxDepth = 0;
        while (!stack.isEmpty()) {
            NodeDepth nodeDepth = stack.pop();
            TreeNode node = nodeDepth.node;
            int depth = nodeDepth.depth;
            maxDepth = Math.max(maxDepth, depth);
            TreeNode leftNode = node.left;
            if (leftNode != null) {
                stack.push(new NodeDepth(leftNode, depth + 1));
            }
            TreeNode rightNode = node.right;
            if (rightNode != null) {
                stack.push(new NodeDepth(rightNode, depth + 1));
            }
        }
        return maxDepth;
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(level);
        }
        return res;
    }

    private static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (min >= node.val) return false;
        if (max <= node.val) return false;
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    private static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        TreeNode root = new TreeNode(nums[nums.length / 2]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length / 2));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, nums.length / 2 + 1, nums.length));
        return root;
    }

//    private static boolean isSymmetric(TreeNode root) {
//        if (root == null) return true;
//        if (root.left == null && root.right == null) return true;
//        if (root.left == null || root.right == null) return false;
//        if (root.left.val != root.right.val) return false;
//        return isSymmetric(root.left, root.right);
//    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isSymmetric(left.left, right.right) && isSymmetric(right.left, left.right);
    }

    private static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            //ArrayDeque doesnt allow null elements
            if (left.left != null || right.right != null) {
                queue.add(left.left);
                queue.add(right.right);
            }
            if (left.right != null || right.left != null) {
                queue.add(left.right);
                queue.add(right.left);
            }
        }
        return true;
    }

    //Sorting
    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums1.length == 0) return;
        if (nums2 == null || nums2.length == 0) return;
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }

    private static int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean isBadVersion(int version) {
        return version >= 3;
    }

    //DP
    private static int climbStairs(int n) {
        if (n <= 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs2(int n) {
        long totalWays = 0;
        for (int k = 0; 2 * k <= n; k++) {
            totalWays = (totalWays + nCr(n - k, k)) % MOD;
        }
        return (int) totalWays;
    }

    private long nCr(int n, int r) {
        if (r > n || r < 0) return 0;

        long[] fact = new long[n + 1];
        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        long numerator = fact[n];
        long denominator = (fact[r] * fact[n - r]) % MOD;
        long inverse = modPow(denominator, MOD - 2, MOD);

        return (numerator * inverse) % MOD;
    }

    // Fast exponentiation for modular inverse
    private long modPow(long base, int exp, int mod) {
        long result = 1;
        base %= mod;

        while (exp > 0) {
            if ((exp & 1) == 1)
                result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }

        return result;
    }

    private static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    private static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], nums[i] + currentSum);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    private static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    //Design
    static class MinStack {
        Stack<Integer> minStack;
        Stack<Integer> stack;

        public MinStack() {
            minStack = new Stack<>();
            stack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            } else {
                minStack.push(minStack.peek());
            }
        }

        public void pop() {
            minStack.pop();
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    static class Solution {
        int[] arr;
        int[] shuffled;
        Random rand;

        public Solution(int[] nums) {
            rand = new Random();
            arr = nums.clone();
            shuffled = nums.clone();
        }

        public int[] reset() {
            shuffled = arr.clone();
            return arr;
        }

        public int[] shuffle() {
            for (int i = shuffled.length - 1; i >= 0; i--) {
                int index = rand.nextInt(i + 1);
                int temp = shuffled[index];
                shuffled[index] = shuffled[i];
                shuffled[i] = temp;
            }
            return shuffled;
        }
    }

    //Others
    private static int hammingWeight(int n) {
        System.out.println(Integer.toBinaryString(n));
        int sum = 0;
        while (n != 0) {
            n = n & (n - 1);
            sum++;
        }
        return sum;
    }

    private static int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            int bit = n & 1;
            result = (result << 1) | bit;
            n = n >> 1;
        }

        return result;
    }

    private static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('[', ']');
        map.put('{', '}');
        map.put('(', ')');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character top = stack.pop();
                if (!Objects.equals(map.get(top), c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static int hammingDistance(int x, int y) {
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(y));
        System.out.println(Integer.toBinaryString(x ^ y));
        return Integer.bitCount(x ^ y);
    }

    private static int missingNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i <= nums.length; i++) {
            xor ^= i;
        }
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }

}
