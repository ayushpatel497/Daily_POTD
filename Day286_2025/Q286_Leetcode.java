import java.util.*;

class Q286_Leetcode {
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        res.add(words[0]);
        int n = words.length;

        for (int i = 1; i < n; i++) {
            if (isAnagram(words[i], words[i - 1])) {
                continue;
            }
            res.add(words[i]);
        }
        return res;
    }

    private boolean isAnagram(String s1, String s2) {
        int[] freq = new int[26];
        for (char c : s1.toCharArray()) freq[c - 'a']++;
        for (char c : s2.toCharArray()) freq[c - 'a']--;
        for (int f : freq) if (f != 0) return false;
        return true;
    }
}
