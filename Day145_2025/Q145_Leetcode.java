class Q145_Leetcode {
    public int longestPalindrome(String[] words) {
        int[][] count = new int[26][26];
        int ans = 0;

        for (String w : words) {
            int a = w.charAt(0) - 'a';
            int b = w.charAt(1) - 'a';

            if (count[b][a] > 0) {
                ans += 4;
                count[b][a]--;
            } else {
                count[a][b]++;
            }
        }

        // Check for one central palindromic word (like "aa", "bb", etc.)
        for (int i = 0; i < 26; i++) {
            if (count[i][i] > 0) {
                ans += 2;
                break;
            }
        }

        return ans;
    }
}
