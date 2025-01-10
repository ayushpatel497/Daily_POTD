import java.util.*;

class Q010_Leetcode {
    private int[] count(String s) {
        int[] ans = new int[26];
        for (char c : s.toCharArray()) {
            ans[c - 'a']++;
        }
        return ans;
    }

    public List<String> wordSubsets(String[] words1, String[] words2) {
        // Q. Word Subsets
        int[] bmax = new int[26];
        for (String b : words2) {
            int[] bCount = count(b);
            for (int i = 0; i < 26; i++) {
                bmax[i] = Math.max(bmax[i], bCount[i]);
            }
        }

        List<String> result = new ArrayList<>();
        for (String a : words1) {
            int[] aCount = count(a);
            boolean isUniversal = true;
            for (int i = 0; i < 26; i++) {
                if (aCount[i] < bmax[i]) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal) {
                result.add(a);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Q010_Leetcode sol = new Q010_Leetcode();
        String[] words1 = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] words2 = {"e", "o"};
        System.out.println(sol.wordSubsets(words1, words2));
    }
}