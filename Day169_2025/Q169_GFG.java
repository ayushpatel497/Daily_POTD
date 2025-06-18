import java.util.*;

class Q169_GFG {
    public ArrayList<ArrayList<String>> palinParts(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        // Fill palindrome DP table
        for (int i = 0; i < n; i++) dp[i][i] = true;
        for (int i = 0; i < n - 1; i++)
            dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
            }
        }

        ArrayList<ArrayList<String>> res = new ArrayList<>();
        backtrack(0, s, new ArrayList<>(), res, dp);
        return res;
    }

    private void backtrack(int idx, String s, ArrayList<String> curr,
                           ArrayList<ArrayList<String>> res, boolean[][] dp) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            if (dp[idx][i]) {
                curr.add(s.substring(idx, i + 1));
                backtrack(i + 1, s, curr, res, dp);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
