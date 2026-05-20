package collection;

import java.util.HashMap;
import java.util.Map;

public class MyTrie {
    MyTrieNode root;
    static class MyTrieNode {
        Map<Character, MyTrieNode> children = new HashMap<>();
        boolean isEnd;
    }

    public MyTrie() {
        root = new MyTrieNode();
    }

    public void insert(String word) {
        MyTrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new MyTrieNode());
            }
            node = node.children.get(ch);
        }
        node.isEnd = true;
    }

    public boolean search(String prefix) {
        MyTrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!node.children.containsKey(ch)) {
                return false;
            }
            node = node.children.get(ch);
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        MyTrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!node.children.containsKey(ch)) {
                return false;
            }
            node = node.children.get(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */