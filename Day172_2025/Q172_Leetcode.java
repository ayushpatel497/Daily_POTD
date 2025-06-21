import java.util.*;

class Q172_Leetcode {
    public int minimumDeletions(String word, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : word.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        int res = word.length();

        for (int a : freq.values()) {
            int deleted = 0;
            for (int b : freq.values()) {
                if (a > b) {
                    deleted += b;
                } else if (b > a + k) {
                    deleted += b - (a + k);
                }
            }
            res = Math.min(res, deleted);
        }

        return res;
    }
}
