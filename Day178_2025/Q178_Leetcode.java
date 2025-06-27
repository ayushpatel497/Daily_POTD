import java.util.*;

class Q178_Leetcode {
    private boolean isKRepeatedSubsequence(String s, String t, int k) {
        int pos = 0, matched = 0;
        int m = t.length();
        for (char ch : s.toCharArray()) {
            if (ch == t.charAt(pos)) {
                pos++;
                if (pos == m) {
                    matched++;
                    if (matched == k) return true;
                    pos = 0;
                }
            }
        }
        return false;
    }

    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        List<Character> candidate = new ArrayList<>();
        for (int i = 25; i >= 0; i--) {
            if (freq[i] >= k) {
                candidate.add((char) ('a' + i));
            }
        }

        Queue<String> queue = new LinkedList<>();
        for (char ch : candidate) {
            queue.offer("" + ch);
        }

        String ans = "";
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (curr.length() > ans.length()) {
                ans = curr;
            }
            for (char ch : candidate) {
                String next = curr + ch;
                if (isKRepeatedSubsequence(s, next, k)) {
                    queue.offer(next);
                }
            }
        }

        return ans;
    }
}
