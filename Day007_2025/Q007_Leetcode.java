import java.util.*;

class Q007_Leetcode {
    class TrieNode {
        int frequency;
        Map<Character, TrieNode> childNodes;

        TrieNode() {
            this.frequency = 0;
            this.childNodes = new HashMap<>();
        }
    }

    public List<String> stringMatching(String[] words) {
        // Q. String Matching in an Array
        TrieNode root = new TrieNode();
        List<String> matchingWords = new ArrayList<>();

        // Insert substrings into the Trie
        for (String word : words) {
            for (int startIndex = 0; startIndex < word.length(); startIndex++) {
                insertWord(root, word.substring(startIndex));
            }
        }

        // Check if each word is a substring of another word
        for (String word : words) {
            if (isSubstring(root, word)) {
                matchingWords.add(word);
            }
        }

        return matchingWords;
    }

    private void insertWord(TrieNode root, String word) {
        TrieNode currentNode = root;
        for (char c : word.toCharArray()) {
            currentNode.childNodes.putIfAbsent(c, new TrieNode());
            currentNode = currentNode.childNodes.get(c);
            currentNode.frequency++;
        }
    }

    private boolean isSubstring(TrieNode root, String word) {
        TrieNode currentNode = root;
        for (char c : word.toCharArray()) {
            if (!currentNode.childNodes.containsKey(c)) {
                return false;
            }
            currentNode = currentNode.childNodes.get(c);
        }
        return currentNode.frequency > 1;
    }

    public static void main(String[] args) {
        Q007_Leetcode solution = new Q007_Leetcode();
        String[] words = {"mass", "as", "hero", "superhero"};
        System.out.println(solution.stringMatching(words)); // Output: [as, hero]
    }
}
