class Q155_GFG {
    int lcsOf3(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        int[][][] dp = new int[n1 + 1][n2 + 1][n3 + 1];

        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                for (int k = n3 - 1; k >= 0; k--) {
                    if (s1.charAt(i) == s2.charAt(j) && s2.charAt(j) == s3.charAt(k)) {
                        dp[i][j][k] = 1 + dp[i + 1][j + 1][k + 1];
                    } else {
                        dp[i][j][k] = Math.max(
                            Math.max(dp[i + 1][j][k], dp[i][j + 1][k]),
                            Math.max(dp[i][j][k + 1],
                            Math.max(dp[i + 1][j + 1][k], 
                            Math.max(dp[i + 1][j][k + 1], 
                            Math.max(dp[i][j + 1][k + 1], dp[i + 1][j + 1][k + 1]))))
                        );
                    }
                }
            }
        }

        return dp[0][0][0];
    }
}
