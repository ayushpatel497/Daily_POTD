import java.util.*;

class Q064_GFG {
    public int longestStringChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Map<String, Integer> dp = new HashMap<>();
        int maxLength = 1;
        
        for (String word : words) {
            int length = 1;
            for (int i = 0; i < word.length(); i++) {
                String sub = word.substring(0, i) + word.substring(i + 1);
                length = Math.max(length, dp.getOrDefault(sub, 0) + 1);
            }
            dp.put(word, length);
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
}
