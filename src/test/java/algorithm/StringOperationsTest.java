package algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringOperationsTest {

    @Test
    void strStr() {
        assertEquals(0, StringOperations.strStr("sadbutsad", "sad"));
        assertEquals(-1, StringOperations.strStr("leetcode", "leeto"));
    }

    @Test
    void intToRoman() {
        assertEquals("MMMDCCXLIX", StringOperations.intToRoman(3749));
    }

    @Test
    void romanToInt() {
        assertEquals(1994, StringOperations.romanToInt("MCMXCIV"));
    }

    @Test
    void convertToTitle() {
        assertEquals("AB", StringOperations.convertToTitle(28));
    }

    @Test
    void titleToNumber() {
        assertEquals(28, StringOperations.titleToNumber("AB"));
    }

    @Test
    void isValid() {
        assertTrue(StringOperations.isValid("()[]{}"));
        assertFalse(StringOperations.isValid("(]"));
    }

    @Test
    void lengthOfLastWord() {
        assertEquals(6, StringOperations.lengthOfLastWord("luffy is still joyboy"));
    }

    @Test
    void addBinary() {
        assertEquals("10101", StringOperations.addBinary("1010", "1011"));
    }

    @Test
    void isPalindromeString() {
        assertTrue(StringOperations.isPalindrome("A man, a plan, a canal: Panama"));
        assertTrue(StringOperations.isPalindrome(" "));
    }

    @Test
    void reverseWords() {
        assertEquals("blue is sky the", StringOperations.reverseWords("the sky is blue"));
    }

    @Test
    void firstUniqChar() {
        assertEquals(4, StringOperations.firstUniqChar("aabbh"));
    }

    @Test
    void repeatedSubstringPattern() {
        assertTrue(StringOperations.repeatedSubstringPattern("abcabc"));
        assertFalse(StringOperations.repeatedSubstringPattern("abc"));
    }

    @Test
    void myAtoi() {
        assertEquals(-2147483648, StringOperations.myAtoi("-21474836482"));
        assertEquals(42, StringOperations.myAtoi("42"));
    }

    @Test
    void isAnagram() {
        assertTrue(StringOperations.isAnagram("anagram", "nagaram"));
        assertFalse(StringOperations.isAnagram("rat", "car"));
    }

    @Test
    void findTheDifference() {
        assertEquals('t', StringOperations.findTheDifference("abcdd", "abcddt"));
    }

    @Test
    void countKeyChanges() {
        assertEquals(1, StringOperations.countKeyChanges("abB"));
    }

    @Test
    void convert() {
        assertEquals("ABCED", StringOperations.convert("ABCDE", 4));
    }

    @Test
    void toLowerCase() {
        assertEquals("aab", StringOperations.toLowerCase("AaB"));
    }

    @Test
    void computeLPS() {
        int[] lps = StringOperations.computeLPS("AABAACAABAA");
        assertNotNull(lps);
        assertEquals(11, lps.length);
    }
}
