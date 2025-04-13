package algorithm;

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

    // Greedy Algorithm for Integer to Roman Conversion
    public static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder romanStr = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                romanStr.append(symbols[i]);
                num -= values[i];
            }
        }

        return romanStr.toString();
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

    // Excel Column Title (base 26 charset) (Integer - Character)
    public static String convertToTitle(int columnNumber) {
        StringBuilder title = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            int remainder = columnNumber % 26;
            char letter = (char) ('A' + remainder);
            // add to front of result
            columnNumber /= 26;
            title.append(letter);
        }
        return title.reverse().toString();
    }

    // Excel Column Title (base 26 charset) (Character - Integer)
    public static int titleToNumber(String columnTitle) {
        int result = 0;
        while (!columnTitle.isEmpty()) {
            char currentChar = columnTitle.charAt(0);
            int remainder = currentChar - 'A' + 1;
            columnTitle = columnTitle.substring(1);
            // append remainder
            result = result * 26 + remainder;
        }
        return result;
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
        return str.contentEquals(new StringBuilder(str).reverse());
    }

    // Reverse words in a string
    public static String reverseWords(String s) {
//        List<String> words = Arrays.asList(s.trim().split("\\s+")).reversed();
//        return String.join(" ", words);

        List<String> words = new ArrayList<>();
        int n = s.length();
        StringBuilder word = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != ' ') {
                word.append(c);
            } else if (!word.isEmpty()) {
                words.add(word.reverse().toString());
                word.setLength(0);
            }
        }

        // Add the last word (if any)
        if (!word.isEmpty()) {
            words.add(word.reverse().toString());
        }

        return String.join(" ", words);
    }

    // Frequency Count + Single Pass
    public static int firstUniqChar(String s) {
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (chars[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    // String Doubling Trick
    public static boolean repeatedSubstringPattern(String s) {
        String doubledString = s + s;
        doubledString = doubledString.substring(1, doubledString.length() - 1);
        return doubledString.contains(s);
    }

    // Knuth-Morris-Pratt Algorithm (KMP)
    public static int[] computeLPS(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];
        int len = 0; // Length of previous longest prefix suffix
        int i = 1;

        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1]; // Reduce len and try again
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

}
