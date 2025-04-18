import java.util.*;

class Trie {

    private class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;

        TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    private TrieNode root;

    public Trie() {
        // Implement Trie
        root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            cur.children.putIfAbsent(ch, new TrieNode());
            cur = cur.children.get(ch);
        }
        cur.isEndOfWord = true;
    }

    // Search for a word in the Trie
    public boolean search(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            if (!cur.children.containsKey(ch)) return false;
            cur = cur.children.get(ch);
        }
        return cur.isEndOfWord;
    }

    // Check if a prefix exists in the Trie
    public boolean isPrefix(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            if (!cur.children.containsKey(ch)) return false;
            cur = cur.children.get(ch);
        }
        return true;
    }
}
