import easy.*;

import java.util.Arrays;
import java.util.List;

import static easy.TreeOperations.buildTree;

public class Main {
    public static void main(String[] args) {

        // =========================================================
        // EASY PROBLEM SOLVING
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
         */
        String s = "abccccdd";
        System.out.println(StringOperations.longestPalindrome(s));
    }
}
