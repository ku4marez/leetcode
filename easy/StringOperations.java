package easy;

import java.util.*;

public class StringOperations {

    // String Matching (Built-in Java String Search)
    public static int strStr(String haystack, String needle) {
        if (haystack.contains(needle)) {
            return haystack.indexOf(needle);
        } else {
            return -1;
        }
    }

    // Greedy Algorithm with Roman Numerals
    public static int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            char currentChar = s.charAt(i);
            char nextChar = s.charAt(i + 1);
            int currentValue = romanCharToInt(currentChar);
            int nextValue = romanCharToInt(nextChar);
            if (currentValue < nextValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
        }
        result += romanCharToInt(s.charAt(s.length() - 1));
        return result;
    }

    private static int romanCharToInt(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

    // Stack-Based Valid Parentheses Check
    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        Stack<Character> brackets = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                char topElement = !brackets.isEmpty() ? brackets.pop() : '#';
                if (topElement != map.get(c)) {
                    return false;
                }
            } else {
                brackets.push(c);
            }
        }
        return brackets.isEmpty();
    }

    // Iterative Backward Traversal
    public static int lengthOfLastWord(String s) {
        int currentLength = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                currentLength++;
            } else if (currentLength > 0 && s.charAt(i) == ' ') {
                break;
            }
        }
        return currentLength;
    }

    // Binary Addition Simulation
    public static String addBinary(String a, String b) {
        Integer carry = 0;
        StringBuilder sb = new StringBuilder();
        Integer aLength = a.length() - 1;
        Integer bLength = b.length() - 1;

        while (aLength >= 0 || bLength >= 0) {
            int digit1 = aLength >= 0 ? a.charAt(aLength) - '0' : 0;
            int digit2 = bLength >= 0 ? b.charAt(bLength) - '0' : 0;

            Integer sum = digit1 + digit2 + carry;
            carry = sum / 2;
            sb.append(sum % 2);
            aLength--;
            bLength--;
        }

        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    // String Reversal
    public static boolean isPalindrome(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return true;
        }

        String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    // Longest Palindrome by Frequency Count
    public static int longestPalindrome(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        int palindromeLength = 0;
        boolean hasOdd = false;

        if (s.isEmpty() || s.length() == 1) {
            return 1;
        }

        // Count frequencies
        for (int i = 0; i < s.length(); i++) {
            charCount.put(s.charAt(i), charCount.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int count : charCount.values()) {
            if (count % 2 == 0) {
                palindromeLength += count;
            } else {
                palindromeLength += count - 1;
                hasOdd = true;
            }
        }

        // Add 1 if we can place a single odd character in the center
        if (hasOdd) {
            palindromeLength++;
        }
        return palindromeLength;
    }

    // HashMap for One-to-One Character Mapping
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Check s -> t mapping
            if (mapST.containsKey(charS)) {
                if (mapST.get(charS) != charT) return false;
            } else {
                mapST.put(charS, charT);
            }

            // Check t -> s mapping
            if (mapTS.containsKey(charT)) {
                if (mapTS.get(charT) != charS) return false;
            } else {
                mapTS.put(charT, charS);
            }
        }
        return true;
    }

    // Two-Pointer Iterative Approach
    public static void reverseString(char[] s) {
        int start = 0, end = s.length - 1;
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    // Two-Pointer Iterative Approach
    public static String reverseVowels(String s) {
        int start = 0, end = s.length() - 1;
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        while (start < end) {
            char sChar = s.charAt(start);
            char tChar = s.charAt(end);
            while (start < end && vowels.indexOf(sChar) == -1) {
                start++;
            }
            while (start < end && vowels.indexOf(tChar) == -1) {
                end--;
            }
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end++;
        }
        return new String(chars);
    }
}
