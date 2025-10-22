import algorithm.*;
import collection.*;

import java.util.List;

import static algorithm.TreeOperations.buildTree;

public class Main {
    public static void main(String[] args) {

        // =========================================================
        // PROBLEM SOLVING
        // =========================================================

        /*
        int[] nums = {3,2,2,3};
        int val = 3;
        int i = ArrayOperations.removeElement(nums, val);
        System.out.println(i);
        // ------------------------------
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int i = ArrayOperations.removeDuplicates(nums);
        System.out.println(i);
        // ------------------------------
        int[] nums = {3,2,3};
        int target = 6;
        System.out.println(Arrays.toString(ArrayOperations.twoSum(nums, target)));
        // ------------------------------
        ArraySorting.ListNode list1ListNode3 = new ArraySorting.ListNode(4);
        ArraySorting.ListNode list1ListNode2 = new ArraySorting.ListNode(2, list1ListNode3);
        ArraySorting.ListNode list1ListNode1 = new ArraySorting.ListNode(1, list1ListNode2);

        ArraySorting.ListNode list2ListNode3 = new ArraySorting.ListNode(4);
        ArraySorting.ListNode list2ListNode2 = new ArraySorting.ListNode(3, list2ListNode3);
        ArraySorting.ListNode list2ListNode1 = new ArraySorting.ListNode(1, list2ListNode2);

        System.out.println(ListOperations.mergeTwoLists(list1ListNode1, list2ListNode1));
        // ------------------------------
        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println(StringOperations.strStr(haystack, needle));
        // ------------------------------
        int x = 121;
        System.out.println(StringOperations.isPalindrome(x));
        // ------------------------------
        String roman = "MCMXCIV";
        System.out.println(StringOperations.romanToInt(roman));
        // ------------------------------
        String[] strs = {"flower","flow","flight"};
        System.out.println(ArrayOperations.commonPrefix(strs));
        // ------------------------------
        int[] digits = {2, 2, 1};
        System.out.println(Arrays.toString(ArrayOperations.plusOne(digits)));
        // ------------------------------
        int[] numbers = {2, 2, 1};
        System.out.println(ArrayOperations.singleNumber(numbers));
        // ------------------------------
        String brackets = "()[]{}";
        System.out.println(StringOperations.isValid(brackets));
        // ------------------------------
        int[] nums = {1,3,5,6};
        int target = 7;
        System.out.println(ArrayOperations.searchInsert(nums, target));
        // ------------------------------
        String string = "luffy is still joyboy";
        System.out.println(StringOperations.lengthOfLastWord(string));
        // ------------------------------
        String binary1 = "1010";
        String binary2 = "1011";
        System.out.println(StringOperations.addBinary(binary1, binary2));
        // ------------------------------
        Integer x = 8;
        System.out.println(ArithmeticOperations.mySqrt(x));
        // ------------------------------
        Integer x = 5;
        System.out.println(ArithmeticOperations.climbStairs(x));
        // ------------------------------

        ListOperations.ListNode node1 = new ListOperations.ListNode(1);
        ListOperations.ListNode node2 = new ListOperations.ListNode(1, node1);
        ListOperations.ListNode head = new ListOperations.ListNode(2, node2);

        System.out.println(ListOperations.deleteDuplicates(head));
        // ------------------------------
        ListOperations.ListNode node1 = new ListOperations.ListNode(2);
        ListOperations.ListNode node2 = new ListOperations.ListNode(4, node1);
        ListOperations.ListNode node3 = new ListOperations.ListNode(3, node2);
        ListOperations.ListNode node4 = new ListOperations.ListNode(2, node3);
        ListOperations.ListNode head = new ListOperations.ListNode(1, node4);

        System.out.println(ListOperations.hasCycle(head));
        // ------------------------------

        Integer[] values = {1,2,3,4,5,null,8,null,null,6,7,9};
        TreeOperations.TreeNode root = buildTree(values);
        System.out.println(TreeOperations.inorderTraversal(root));
        // ------------------------------
        Integer[] values1 = {6,7,9};
        Integer[] values2 = {1,2,3,4,5};
        TreeOperations.TreeNode root1 = buildTree(values1);
        TreeOperations.TreeNode root2 = buildTree(values2);
        System.out.println(TreeOperations.isSameTree(root1, root2));
        // ------------------------------

        Integer[] values = {2,3,3,4,5,null,4};
        TreeOperations.TreeNode root = buildTree(values);
        System.out.println(TreeOperations.isSymmetric(root));
        // ------------------------------
        Integer[] values = {2,3,3,4,5,null,4};
        TreeOperations.TreeNode root = buildTree(values);
        System.out.println(TreeOperations.isSymmetric(root));
        // ------------------------------

        Integer[] values = {2,3,3,4,5,null,4};
        TreeOperations.TreeNode root = buildTree(values);
        System.out.println(TreeOperations.maxDepth(root));
        // ------------------------------
        int[] values = {-10,-3,0,5,9};
        System.out.println(TreeOperations.sortedArrayToBST(values));
        // ------------------------------
        Integer[] values = {3,9,20,null,null,15,7};
        TreeOperations.TreeNode root = buildTree(values);
        System.out.println(TreeOperations.isBalanced(root));
        // ------------------------------

        Integer[] values = {3,9,20,null,null,15,7};
        TreeOperations.TreeNode root = buildTree(values);
        System.out.println(TreeOperations.minDepth(root));
        // ------------------------------
        Integer[] values = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeOperations.TreeNode root = buildTree(values);
        Integer targetSum = 22;
        System.out.println(TreeOperations.hasPathSum(root, targetSum));
        // ------------------------------
        String string = " ";
        System.out.println(StringOperations.isPalindrome(string));
        // ------------------------------
        Integer[] values = {1,2,3,4,5,null,8,null,null,6,7,9};
        TreeOperations.TreeNode root = buildTree(values);
        System.out.println(TreeOperations.preorderTraversal(root));
        // ------------------------------
        Integer[] values = {1,2,3,4,5,null,8,null,null,6,7,9};
        TreeOperations.TreeNode root = buildTree(values);
        System.out.println(TreeOperations.inorderTraversal(root));
        // ------------------------------
        Integer nums = 5;
        System.out.println(ListOperations.generate(nums));
        // ------------------------------
        Integer nums = 5;
        System.out.println(ListOperations.getRow(nums));
        // ------------------------------
        int[] nums = {7,1,5,3,6,4};
        System.out.println(ArithmeticOperations.maxProfit(nums));
        // ------------------------------
        ListOperations.ListNode a1 = new ListOperations.ListNode(2);
        ListOperations.ListNode a2 = new ListOperations.ListNode(4, a1);
        ListOperations.ListNode b1 = new ListOperations.ListNode(3);
        ListOperations.ListNode b2 = new ListOperations.ListNode(2, b1);
        ListOperations.ListNode b3 = new ListOperations.ListNode(1, b2);

        System.out.println(ListOperations.getIntersectionNode(a2, b3));
        // ------------------------------
        int[] values = {2,2,1,1,1,2,2};
        System.out.println(ArrayOperations.majorityElement(values));
         // ------------------------------
        ListOperations.ListNode b1 = new ListOperations.ListNode(3);
        ListOperations.ListNode b2 = new ListOperations.ListNode(2, b1);
        ListOperations.ListNode b3 = new ListOperations.ListNode(1, b2);

        System.out.println(ListOperations.removeElements(b3, 3));
        // ------------------------------
        System.out.println(StringOperations.isIsomorphic("foo", "bar"));
        // ------------------------------
        System.out.println(ArithmeticOperations.isHappy(15));
        // ------------------------------

        ListOperations.ListNode b1 = new ListOperations.ListNode(3);
        ListOperations.ListNode b2 = new ListOperations.ListNode(2, b1);
        ListOperations.ListNode b3 = new ListOperations.ListNode(1, b2);

        System.out.println(ListOperations.reverseList(b3));
        // ------------------------------
        int[] values = {1,2,3,1};
        System.out.println(ArrayOperations.containsDuplicate(values));
        // ------------------------------
        int[] values = {1,2,3,1};
        System.out.println(ArrayOperations.containsNearbyDuplicate(values, 1));
        // ------------------------------
        Integer[] values = {1,2,3,4,5,null,8,null,null,6,7,9};
        TreeOperations.TreeNode root = buildTree(values);
        System.out.println(TreeOperations.countNodes(root));
        // ------------------------------
        ListOperations.ListNode b1 = new ListOperations.ListNode(1);
        ListOperations.ListNode b2 = new ListOperations.ListNode(2, b1);
        ListOperations.ListNode b3 = new ListOperations.ListNode(1, b2);

        System.out.println(ListOperations.isPalindrome(b3));
        // ------------------------------
        Integer[] values = {1,2,3,4,5,null,8,null,null,6,7,9};
        TreeOperations.TreeNode root = buildTree(values);
        System.out.println(TreeOperations.invertTree(root));
        // ------------------------------
        MyStack.push(1);
        MyStack.push(2);
        MyStack.push(3);
        System.out.println(MyStack.top()); // 3
        System.out.println(MyStack.pop()); // 3
        System.out.println(MyStack.top()); // 2
        System.out.println(MyStack.empty());
        // ------------------------------
        MyQueue.push(1);
        MyQueue.push(2);
        System.out.println(MyQueue.peek()); // 1
        System.out.println(MyQueue.pop());  // 1
        System.out.println(MyQueue.empty()); // false
        // ------------------------------
        String s1 = "anagram";
        String s2 = "nagaram";
        System.out.println(StringOperations.isAnagram(s1, s2));
        // ------------------------------
        System.out.println(ArithmeticOperations.hammingWeight(7));
        // ------------------------------
        System.out.println(ArithmeticOperations.reverseBits(0b00000010100101000001111010011100));
        // ------------------------------
        System.out.println(ArithmeticOperations.isPowerOfTwo(4));
        // ------------------------------
        int[] nums = new int[]{0,1,2,4,5,7};
        System.out.println(ArrayOperations.summaryRanges(nums));
        // ------------------------------
        Integer[] values = {1,2,3,4,5,null,8,null,null,6,7,9};
        TreeOperations.TreeNode root = buildTree(values);
        System.out.println(TreeOperations.binaryTreePaths(root));
        // ------------------------------
        System.out.println(ArithmeticOperations.addDigits(236));
        // ------------------------------
        System.out.println(ArithmeticOperations.isUgly(15));
        // ------------------------------
        int[] nums = new int[]{9,6,4,2,3,5,7,0,1};
        System.out.println(ArrayOperations.missingNumber(nums));
        // ------------------------------
        int[] nums = new int[]{0,1,0,3,12};
        ArrayOperations.moveZeroes(nums);
        // ------------------------------
        System.out.print(BitOperations.countBits(5));
        // ------------------------------
        char[] str = new char[]{'h','e','l','l','o'};
        StringOperations.reverseString(str);
        // ------------------------------
        String input = "leetcode";
        System.out.println(StringOperations.reverseVowels(input));
        // ------------------------------
        System.out.println(BitOperations.isPowerOfThree(9));
        // ------------------------------
        System.out.println(BitOperations.isPowerOfFour(6));
        // ------------------------------
        int[] values1 = {1,2,2,1};
        int[] values2 = {2,2};
        System.out.println(SortOperations.intersection(values1, values2));
        // ------------------------------
        Integer[] values = {1,2,3,4,5};
        TreeOperations.TreeNode root = buildTree(values);
        System.out.println(TreeOperations.sumOfLeftLeaves(root));
        // ------------------------------
        System.out.print(DpOperations.fibIterative(6));
        // ------------------------------
        int[] values = {3,3,4,3,4,3,0,3,3};
        System.out.println(ArrayOperations.thirdMax(values));
        // ------------------------------
        String s = "abccccdd";
        System.out.println(StringOperations.longestPalindrome(s));
        // ------------------------------
        String s = "abcdd";
        String t = "abcddt";
        System.out.println(BitOperations.findTheDifference(s, t));
        // ------------------------------
        int n = 5;
        System.out.println(ArithmeticOperations.arrangeCoins(n));
        // ------------------------------
        int[] nums = {2,5};
        int target = 0;
        System.out.println(ArithmeticOperations.search(nums, target));
        // ------------------------------
        int[] nums = {4, 1, 3, 9, 7};
        SortOperations.sortQuick(nums, 0, nums.length - 1);
        // ------------------------------
        int[][] edges = {{1, 2}, {2, 3}, {4, 2}};
        System.out.print(GraphOperations.findCenter(edges));
        // ------------------------------
        int[][] edges = {{1, 3}, {2, 3}, {4, 3}};
        System.out.print(GraphOperations.findJudge(4, edges));
        // ------------------------------
        int[] numbers = {1, 2, 3};
        int[] s = {3};
        System.out.print(ArrayOperations.findContentChildren(numbers, s));
        // ------------------------------
        int[] numbers = {1, 4, 3, 2};
        System.out.print(ArrayOperations.arrayPairSum(numbers));
        // ------------------------------
        int[][] arrs = {{1, 3}, {2, 3}, {4, 3}};
        System.out.print(ArrayOperations.islandPerimeter(arrs));
        // ------------------------------

        TreeOperations.TreeNode root = new TreeOperations.TreeNode(4);
        root.left = new TreeOperations.TreeNode(2);
        root.right = new TreeOperations.TreeNode(6);
        root.left.left = new TreeOperations.TreeNode(1);
        root.left.right = new TreeOperations.TreeNode(3);
        // ------------------------------
        System.out.println(TreeOperations.getMinimumDifference(root));
        // ------------------------------
        String s = "aabbh";
        System.out.println(StringOperations.firstUniqChar(s));
        // ------------------------------
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        int source = 0;
        int dest = 2;
        int n = 3;
        System.out.println(GraphOperations.validPathBfs(n, edges, source, dest));
        // ------------------------------
        System.out.println(BitOperations.findComplement(5));
        // ------------------------------
        System.out.println(StringOperations.repeatedSubstringPattern("abcabc"));
        // ------------------------------
        // ------------------------------
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(ArrayOperations.findDisappearedNumbers(nums));
        // ------------------------------
        int x = 1; int y=4;
        System.out.println(BitOperations.hammingDistance(x ,y));
        // ------------------------------
        Integer[] values1 = {1,3,2,5};
        Integer[] values2 = {2,1,3,null,4,null,7};
        TreeOperations.TreeNode root1 = buildTree(values1);
        TreeOperations.TreeNode root2 = buildTree(values2);
        System.out.println(TreeOperations.mergeTrees2(root1, root2));
        // ------------------------------
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(DpOperations.isSubsequence(s, t));
        // ------------------------------
        String s = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] words = new String[]{"hit"};
        System.out.println(StringOperations.mostCommonWord(s, words));
        // ------------------------------
        int[] score = {50, 30, 40, 10, 20};
        System.out.println(ArrayOperations.findRelativeRanks(score));
        // ------------------------------
        int[] stones = {2,7,4,1,8,1};
        System.out.println(ArrayOperations.lastStoneWeight(stones));
        // ------------------------------
        int[] arr = {1,3,2,2,5,2,3,7};
        System.out.println(ArrayOperations.findLHS(arr));
        // ------------------------------
        ListOperations.ListNode b1 = new ListOperations.ListNode(1);
        ListOperations.ListNode b2 = new ListOperations.ListNode(0, b1);
        ListOperations.ListNode b3 = new ListOperations.ListNode(0);

        System.out.println(ListOperations.getDecimalValue(b3));
        // ------------------------------
        Integer[] values = {3,9,20,null,null,15,7};
        TreeOperations.TreeNode root = buildTree(values);
        System.out.println(TreeOperations.averageOfLevels(root));
        // ------------------------------
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int i = ArrayOperations.removeDuplicates(nums);
        System.out.println(i);
        // ------------------------------
        String s = "the sky is blue";
        System.out.println(StringOperations.reverseWords(s));
        // ------------------------------
        int[] nums = {7,1,5,3,6,4};
        System.out.println(ArrayOperations.maxProfit(nums));
        // ------------------------------
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(ArrayOperations.minSubArrayLen(target, nums));
        // ------------------------------
        System.out.println(StringOperations.canConstruct("ada", "aab"));
        // ------------------------------
        String pattern = "abba";
        String s = "dog dog dog dog";
        System.out.println(StringOperations.wordPattern(pattern, s));
        // ------------------------------
        ListOperations.ListNode a1 = new ListOperations.ListNode(2);
        ListOperations.ListNode a2 = new ListOperations.ListNode(4, a1);
        ListOperations.ListNode a3 = new ListOperations.ListNode(3, a2);

        ListOperations.ListNode b1 = new ListOperations.ListNode(5);
        ListOperations.ListNode b2 = new ListOperations.ListNode(6, b1);
        ListOperations.ListNode b3 = new ListOperations.ListNode(4, b2);

        System.out.println(ListOperations.addTwoNumbers(a3, b3));
        // ------------------------------
        int[] arr = new int[]{3,2,1,5,6,4};
        int k = 2;
        System.out.println(ArrayOperations.findKthLargest(arr, k));
        // ------------------------------
        int[] coins = new int[]{1,2,5};
        int money = 11;
        System.out.println(DpOperations.coinChange(coins, money));
        // ------------------------------
        int[] arr = new int[]{1,2,3,4,5,6,7};
        ArrayOperations.rotate(arr, 3);
        // ------------------------------
        ListOperations.ListNode b1 = new ListOperations.ListNode(1);
        ListOperations.ListNode b2 = new ListOperations.ListNode(2, b1);
        ListOperations.ListNode b3 = new ListOperations.ListNode(3, b2);
        ListOperations.ListNode b4 = new ListOperations.ListNode(4, b3);
        ListOperations.ListNode b5 = new ListOperations.ListNode(5, b4);
        System.out.println(ListOperations.rotateRight(b5, 2));
        // ------------------------------
        int num = 3749;
        System.out.println(StringOperations.intToRoman(num));
        // ------------------------------
        ArrayOperations.printNumbers();
        // ------------------------------
        int[] arr = new int[]{3,2,1,0,4};
        System.out.println(ArrayOperations.canJump(arr));
        // ------------------------------
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(SlidingWindowOperations.checkInclusion(s1, s2));
        // ------------------------------
        String s = "babad";
        System.out.println(TwoPointerOperations.longestPalindrome(s));
        // ------------------------------
        System.out.println(BitOperations.divide(10, 3));
        // ------------------------------
        System.out.println(ArithmeticOperations.isPerfectSquare(16));
        // ------------------------------
        System.out.println(StringOperations.convertToTitle(28));
        // ------------------------------
        System.out.println(StringOperations.titleToNumber("AB"));
        // ------------------------------
        ArrayOperations.printNumbers();
        // ------------------------------

        System.out.println(StringOperations.myAtoi("-21474836482"));
        // ------------------------------
        MyArray<Integer> myArray = new MyArray<>();
        myArray.add(1);
        myArray.add(2);
        myArray.add(3);
        myArray.add(4);
        myArray.remove(2);
        System.out.println(myArray);
        // ------------------------------

        MySinglyLinkedList.Node<Integer> head = new MySinglyLinkedList.Node<>(1);
        MySinglyLinkedList<Integer> mySinglyLinkedList = new MySinglyLinkedList<>(head, 1);
        mySinglyLinkedList.add(2);
        mySinglyLinkedList.add(3);
        mySinglyLinkedList.add(4);
        mySinglyLinkedList.removeFirst();
        mySinglyLinkedList.removeAt(2);
        mySinglyLinkedList.remove();
        System.out.println(mySinglyLinkedList);
        // ------------------------------

        ListOperations.ListNode node1 = new ListOperations.ListNode(3);
        ListOperations.ListNode node2 = new ListOperations.ListNode(2, node1);
        ListOperations.ListNode node3 = new ListOperations.ListNode(1, node2);
        System.out.println(ListOperations.reverseList2(node3));
        // ------------------------------

        ListOperations.ListNode node1 = new ListOperations.ListNode(3);
        ListOperations.ListNode node2 = new ListOperations.ListNode(1, node1);
        ListOperations.ListNode node3 = new ListOperations.ListNode(2, node2);
        ListOperations.ListNode node4 = new ListOperations.ListNode(4, node3);
        System.out.println(ListOperations.mergeSort(node4));

        // ------------------------------
        Integer[] values = {1, 2, 3, 4, 5, 6, 7};
        TreeOperations.TreeNode root = buildTree(values);
        System.out.println(TreeOperations.diameterOfBinaryTree(root));
        // ------------------------------

        KthLargest obj = new KthLargest(3, new int[]{4, 5, 8, 2});
        int largest = obj.add(9);
        System.out.println(largest);

        // ------------------------------
        int[] minCostClimbStairs = {10, 15, 20, 25, 10};
        System.out.println(DpGreedyOperations.minCostClimbingStairs(minCostClimbStairs));

        // ------------------------------
        CustomRandomizedCollection collection = new CustomRandomizedCollection();
        collection.insert(1);
        collection.remove(1);
        collection.insert(1);
//        collection.remove(1);
//        collection.insert(2);
        collection.getRandom();

        // ------------------------------
        System.out.println(ArrayOperations.longestConsecutive(new int[]{100, 1, 200, 2, 3, 4}));

        // ------------------------------
        System.out.println(BacktrackingOperations.combinationSum(new int[]{2,3,6,7}, 7));

        // ------------------------------
        System.out.println(BacktrackingOperations.combinationSum2(new int[]{10,1,2,7,6,5,1}, 8));

        // ------------------------------
        System.out.println(DpGreedyOperations.canJump(new int[]{2, 4, 0, 1, 4}));

        // ------------------------------
        System.out.println(DpGreedyOperations.jump2(new int[]{2, 4, 0, 1, 4}));

        // ------------------------------
        System.out.println(BacktrackingOperations.subsetsWithDup(new int[]{1,2,2}));

        // ------------------------------
        System.out.println(ArrayOperations.findDuplicate(new int[]{1,3,4,2,2}));

        // ------------------------------
        System.out.println(SlidingWindowOperations.characterReplacement("AABABBA", 1));

        // ------------------------------
        ListOperations.ListNode node1 = new ListOperations.ListNode(4);
        ListOperations.ListNode node2 = new ListOperations.ListNode(3, node1);
        ListOperations.ListNode node3 = new ListOperations.ListNode(2, node2);
        ListOperations.ListNode node4 = new ListOperations.ListNode(1, node3);
        ListOperations.reorderList(node4);

        // ------------------------------
        System.out.println(TwoPointerOperations.twoSumSorted(new int[]{2, 7, 11, 15}, 9));
        // ------------------------------
        ListOperations.ListNode list1Node1 = new ListOperations.ListNode(5);
        ListOperations.ListNode list1Node2 = new ListOperations.ListNode(3, list1Node1);
        ListOperations.ListNode list1Node3 = new ListOperations.ListNode(1, list1Node2);

        ListOperations.ListNode list2Node1 = new ListOperations.ListNode(6);
        ListOperations.ListNode list2Node2 = new ListOperations.ListNode(4, list2Node1);
        ListOperations.ListNode list2Node3 = new ListOperations.ListNode(2, list2Node2);
        ListOperations.mergeAlternating(list1Node3, list2Node3);
        // ------------------------------

        ListOperations.ListNode node1 = new ListOperations.ListNode(5);
        ListOperations.ListNode node2 = new ListOperations.ListNode(4, node1);
        ListOperations.ListNode node3 = new ListOperations.ListNode(3, node2);
        ListOperations.ListNode node4 = new ListOperations.ListNode(2, node3);
        ListOperations.ListNode node5 = new ListOperations.ListNode(1, node4);
        ListOperations.rotateLeft(node5, 2);

        // ------------------------------
        System.out.println(TwoPointerOperations.countSubstrings("aabcc"));
        // ------------------------------
        System.out.println(TwoPointerOperations.partitionLabels("ababcc"));
        // ------------------------------
        Integer[] values = {3, 1, 4, 3, null, 1, 5};
        TreeOperations.TreeNode root = buildTree(values);
        System.out.println(TreeOperations.goodNodes(root));
        // ------------------------------
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(BinarySearchOperations.searchMatrix(matrix, 3));
        // ------------------------------
        System.out.println(ArrayOperations.productExceptSelf(new int[]{1, 2, 3, 4}));
        // ------------------------------
        System.out.println(ArrayOperations.eraseOverlapIntervals(new int[][]{{1, 100}, {11, 22}, {1, 11}, {2, 12}}));
        // ------------------------------
        int[] piles = {3, 6, 7, 11};
        System.out.println(BinarySearchOperations.minEatingSpeed(piles, 8));
        // ------------------------------
        String word = new String("apple");
        MyTrie obj = new MyTrie();
        obj.insert(word);
        boolean param_2 = obj.search(word);
        boolean param_3 = obj.startsWith("app");
        System.out.println(String.format("param_2: %s, param_3: %s", param_2, param_3));
        // ------------------------------
        SortOperations.bubbleSort(new int[]{3, 2, 9, 4, 5, 6, 1, 8, 7});
        // ------------------------------
        System.out.println(SortOperations.sortQuick2(new int[]{5, 2, 3, 1}));
        // ------------------------------
        int[] coins2 = new int[]{1, 2, 5};
        int amount = 5;
        System.out.println(DpGreedyOperations.coinChange2(amount, coins2));
        // ------------------------------
        System.out.println(SlidingWindowOperations.maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3));
        // ------------------------------
        System.out.println(SlidingWindowOperations.minWindow("a", "aa"));
        // ------------------------------
        System.out.println(BinarySearchOperations.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        // ------------------------------
        MyTimeMap timeMap = new MyTimeMap();
        timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
        timeMap.get("foo", 1);         // return "bar"
        timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
        timeMap.get("foo", 4);         // return "bar2"
        timeMap.get("foo", 5);         // return "bar2"

        // ------------------------------
        MyLRUCache lRUCache = new MyLRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
        // ------------------------------
        System.out.println(TreeOperations.rightSideView(TreeOperations.buildTree(new Integer[]{1, 2, 3, null, 5, null, 4})));
        // ------------------------------
        System.out.println(TreeOperations.lowestCommonAncestor(TreeOperations.buildTree(new Integer[]{1, 2, 3, null, 5, null, 4}), new TreeOperations.TreeNode(2), new TreeOperations.TreeNode(8)));
        // ------------------------------
        GraphOperations.Node node1 = new GraphOperations.Node(1);
        GraphOperations.Node node2 = new GraphOperations.Node(2);
        GraphOperations.Node node3 = new GraphOperations.Node(3);
        GraphOperations.Node node4 = new GraphOperations.Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        GraphOperations.cloneGraph(node1);
        // ------------------------------
        GraphOperations.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}});
        // ------------------------------
        int n = 5;
        int[][] edges = {
                {0, 1},
                {1, 2},
                {3, 4}
        };

        System.out.println(GraphOperations.countComponents(n, edges)); // expect 2

        // ------------------------------
        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println(GraphOperations.findCircleNum(isConnected));
        // ------------------------------

        List<String> words = List.of("wrt", "wrf", "er", "ett", "rftt");
        System.out.println(GraphOperations.alienOrder(words));
        // ------------------------------
        int[][] shortestPath = {
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };
        System.out.println(GraphOperations.networkDelayTime(shortestPath, 4, 2));
        // ------------------------------
        System.out.println(GraphOperations.canFinish(2, new int[][]{{0, 1}, {1, 0}}));
        // ------------------------------
        System.out.println(GraphOperations.minCostConnectPoints(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}));

        // ------------------------------

        ListOperations.Node n0 = new ListOperations.Node(7);
        ListOperations.Node n1 = new ListOperations.Node(13);
        ListOperations.Node n2 = new ListOperations.Node(11);
        ListOperations.Node n3 = new ListOperations.Node(10);
        ListOperations.Node n4 = new ListOperations.Node(1);

        // next pointers
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        // random pointers
        n0.random = null;
        n1.random = n0;
        n2.random = n4;
        n3.random = n2;
        n4.random = n0;

        ListOperations.Node copied = ListOperations.copyRandomList(n0);
        System.out.println(copied);
        // ------------------------------

        MyTwitter obj = new MyTwitter();
        obj.postTweet(1, 5);
        obj.getNewsFeed(1);
        obj.follow(1, 2);
        obj.postTweet(2, 6);
        obj.getNewsFeed(1);
        obj.unfollow(1, 2);
        obj.getNewsFeed(1);
         */
        // ------------------------------
        System.out.println(BacktrackingOperations.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        // ------------------------------
        System.out.println(BacktrackingOperations.partition("aab"));
        // ------------------------------
        ListOperations.ListNode a1 = new ListOperations.ListNode(5);
        ListOperations.ListNode a2 = new ListOperations.ListNode(4, a1);
        ListOperations.ListNode a3 = new ListOperations.ListNode(3, a2);
        ListOperations.ListNode a4 = new ListOperations.ListNode(2, a3);
        ListOperations.ListNode a5 = new ListOperations.ListNode(1, a4);

        System.out.println(ListOperations.reverse(a5));
        // ------------------------------
        System.out.println(BacktrackingOperations.totalNumbers(new int[]{0, 2, 2}));
        // ------------------------------
        System.out.println(IntervalOperations.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8}));
        // ------------------------------
        System.out.println(DpGreedyOperations.minDistance(new String("horse"), new String("ros")));
    }
}
