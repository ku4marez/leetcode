package algorithm;

import java.util.*;

public class HashMapOperations {

    // HashMap for Complement Search
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    // Hashing-based frequency count.
    public static String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        paragraph = paragraph.replaceAll("[^a-zA-Z]", " ");
        String[] words = paragraph.split("\\s+");
        HashSet<String> bannedWords = new HashSet<>(Arrays.asList(banned));

        HashMap<String, Integer> bannedWordCount = new HashMap<>();

        for (String word : words) {
            if (!bannedWords.contains(word)) {
                bannedWordCount.put(word, bannedWordCount.getOrDefault(word, 0) + 1);
            }
        }

        String res = "";
        int maxFrequency = 0;
        for (Map.Entry<String, Integer> entry : bannedWordCount.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                res = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }

        return res;
    }

    // HashMap for one to one matching
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.trim().split("\\s+");
        Map<Character, String> mapCharWord = new HashMap<>();
        Map<String, Character> mapWordChar = new HashMap<>();

        if (pattern.length() != words.length) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            // If the pattern char exists but doesn't match the current word, return false
            if (mapCharWord.containsKey(c) && !mapCharWord.get(c).equals(word)) {
                return false;
            }

            // If the word exists but doesn't match the current char, return false
            if (mapWordChar.containsKey(word) && !mapWordChar.get(word).equals(c)) {
                return false;
            }

            // Add both mappings at the same time
            mapCharWord.put(c, word);
            mapWordChar.put(word, c);
        }
        return true;
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

    // HashMap for constructing one string from another
    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.isEmpty() || magazine.isEmpty()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }
        return true;
    }
}
