package collection;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
    WordDictionaryNode root;

    static class WordDictionaryNode {
        Map<Character, WordDictionaryNode> children = new HashMap<>();
        boolean isEndOfWord;
    }

    public WordDictionary() {
        root = new WordDictionaryNode();
    }

    public void addWord(String word) {
        WordDictionaryNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new WordDictionaryNode());
            }
            node = node.children.get(c);
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        WordDictionaryNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node == null) return false;
            char c = word.charAt(i);
            if (!node.children.containsKey(c) && c != '.') {
                return false;
            }
            if (c == '.') {
                return search(node, word, i);
            }
            node = node.children.get(c);
        }
        return node.isEndOfWord;
    }

    private static boolean search(WordDictionaryNode root, String word, int i) {
        if(i == word.length()) return root.isEndOfWord;
        char c = word.charAt(i);
        if (c != '.') {
            if (root.children.containsKey(c)) {
                return search(root.children.get(c), word, i + 1);
            } else return false;
        } else {
            for (WordDictionaryNode child : root.children.values()) {
                if (search(child, word, i + 1)) return true;
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */