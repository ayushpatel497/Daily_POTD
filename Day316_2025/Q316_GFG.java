class Q316_GFG {
    private int solve(String s, String p, int i, int j, int[][] dp) {
        if (i == s.length() && j == p.length()) return 1;
        if (j == p.length()) return 0;

        if (i == s.length()) {
            while (j < p.length()) {
                if (p.charAt(j) != '*') return 0;
                j++;
            }
            return 1;
        }

        if (dp[i][j] != -1) return dp[i][j];

        char sc = s.charAt(i);
        char pc = p.charAt(j);

        if (pc == '?') {
            dp[i][j] = solve(s, p, i + 1, j + 1, dp);
        } else if (pc == '*') {
            int a = solve(s, p, i + 1, j + 1, dp);
            int b = solve(s, p, i, j + 1, dp);
            int c = solve(s, p, i + 1, j, dp);
            dp[i][j] = (a | b | c);
        } else {
            dp[i][j] = (sc == pc) ? solve(s, p, i + 1, j + 1, dp) : 0;
        }
        return dp[i][j];
    }

    public boolean wildCard(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) java.util.Arrays.fill(row, -1);
        return solve(txt, pat, 0, 0, dp) == 1;
    }
}
