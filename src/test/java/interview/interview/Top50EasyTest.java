package interview.interview;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Top50EasyTest {

    @Test
    void containsDuplicate() {
        assertTrue(Top50Easy.containsDuplicate(new int[]{1, 2, 3, 1}));
        assertFalse(Top50Easy.containsDuplicate(new int[]{1, 2, 3, 4}));
    }

    @Test
    void singleNumber() {
        assertEquals(1, Top50Easy.singleNumber(new int[]{2, 2, 1}));
    }

    @Test
    void twoSum() {
        assertArrayEquals(new int[]{0, 1}, Top50Easy.twoSum(new int[]{2, 7, 11, 15}, 9));
    }

    @Test
    void plusOne() {
        assertArrayEquals(new int[]{1, 0, 0}, Top50Easy.plusOne(new int[]{9, 9}));
    }

    @Test
    void moveZeroes() {
        int[] nums = {0, 1, 0, 3, 12};
        Top50Easy.moveZeroes(nums);
        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, nums);
    }

    @Test
    void maxProfit() {
        assertEquals(5, Top50Easy.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    @Test
    void maxSubArray() {
        assertEquals(6, Top50Easy.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    @Test
    void reverseString() {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        Top50Easy.reverseString(s);
        assertArrayEquals(new char[]{'o', 'l', 'l', 'e', 'h'}, s);
    }

    @Test
    void reverse() {
        assertEquals(321, Top50Easy.reverse(123));
        assertEquals(-321, Top50Easy.reverse(-123));
    }

    @Test
    void isAnagram() {
        assertTrue(Top50Easy.isAnagram("anagram", "nagaram"));
        assertFalse(Top50Easy.isAnagram("rat", "car"));
    }

    @Test
    void isPalindromeString() {
        assertTrue(Top50Easy.isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    void longestCommonPrefix() {
        assertEquals("fl", Top50Easy.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    @Test
    void firstUniqChar() {
        assertEquals(0, Top50Easy.firstUniqChar("leetcode"));
    }

    @Test
    void strStr() {
        assertEquals(0, Top50Easy.strStr("sadbutsad", "sad"));
    }

    @Test
    void isValid() {
        assertTrue(Top50Easy.isValid("()[]{}"));
        assertFalse(Top50Easy.isValid("(]"));
    }

    @Test
    void maxDepth() {
        Top50Easy.TreeNode root = Top50Easy.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        assertEquals(3, Top50Easy.maxDepth(root));
    }

    @Test
    void isSymmetric() {
        Top50Easy.TreeNode root = Top50Easy.buildTree(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        assertTrue(Top50Easy.isSymmetric(root));
    }

    @Test
    void climbStairs() {
        assertEquals(3, Top50Easy.climbStairs(3));
    }

    @Test
    void rob() {
        assertEquals(4, Top50Easy.rob(new int[]{1, 2, 3, 1}));
    }

    @Test
    void isPowerOfThree() {
        assertTrue(Top50Easy.isPowerOfThree(27));
        assertFalse(Top50Easy.isPowerOfThree(10));
    }

    @Test
    void romanToInt() {
        assertEquals(1994, Top50Easy.romanToInt("MCMXCIV"));
    }

    @Test
    void hammingWeight() {
        assertEquals(3, Top50Easy.hammingWeight(7));
    }

    @Test
    void hammingDistance() {
        assertEquals(2, Top50Easy.hammingDistance(1, 4));
    }

    @Test
    void fizzBuzz() {
        List<String> result = Top50Easy.fizzBuzz(15);
        assertEquals(15, result.size());
        assertEquals("FizzBuzz", result.get(14));
    }

    @Test
    void merge() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        Top50Easy.merge(nums1, 3, new int[]{2, 5, 6}, 3);
        assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, nums1);
    }

    @Test
    void rotate() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        Top50Easy.rotate(nums, 3);
        assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, nums);
    }
}
