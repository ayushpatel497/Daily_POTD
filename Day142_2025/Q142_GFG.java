import java.util.Arrays;

class Q142_GFG {
    private static int lcs(int i, int j, String s, String s2, int[][] dp) {
        if (i < 0 || j < 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];

        if (s.charAt(i) == s2.charAt(j))
            return dp[i][j] = 1 + lcs(i - 1, j - 1, s, s2, dp);
        
        return dp[i][j] = Math.max(lcs(i - 1, j, s, s2, dp), lcs(i, j - 1, s, s2, dp));
    }

    public static int minDeletions(String s) {
        int n = s.length();
        String s2 = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[n][n];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return n - lcs(n - 1, n - 1, s, s2, dp);
    }
}
