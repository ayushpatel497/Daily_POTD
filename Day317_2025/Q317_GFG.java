class Q317_GFG {
    private boolean helper(int i, int j, int k, String s1, String s2, String s3, Boolean[][][] dp) {
        if (i == s1.length() && j == s2.length() && k == s3.length())
            return true;
        if (dp[i][j][k] != null)
            return dp[i][j][k];

        boolean ans = false;
        if (i < s1.length() && k < s3.length() && s1.charAt(i) == s3.charAt(k))
            ans |= helper(i + 1, j, k + 1, s1, s2, s3, dp);
        if (!ans && j < s2.length() && k < s3.length() && s2.charAt(j) == s3.charAt(k))
            ans |= helper(i, j + 1, k + 1, s1, s2, s3, dp);

        return dp[i][j][k] = ans;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        Boolean[][][] dp = new Boolean[s1.length() + 1][s2.length() + 1][s3.length() + 1];
        return helper(0, 0, 0, s1, s2, s3, dp);
    }
}
