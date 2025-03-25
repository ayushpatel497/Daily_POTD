class Q084_GFG {
    static int countWays(String s) {
        int n = s.length();
        int[][][] dp = new int[n][n][2];

        // Initialize base cases
        for (int i = 0; i < n; i += 2) {
            dp[i][i][1] = (s.charAt(i) == 'T') ? 1 : 0;
            dp[i][i][0] = (s.charAt(i) == 'F') ? 1 : 0;
        }

        // Iterate over increasing lengths of subexpressions
        for (int length = 2; length < n; length += 2) {
            for (int i = 0; i < n - length; i += 2) {
                int j = i + length;
                dp[i][j][0] = dp[i][j][1] = 0;

                for (int k = i + 1; k < j; k += 2) {
                    char op = s.charAt(k);

                    int leftTrue = dp[i][k - 1][1];
                    int leftFalse = dp[i][k - 1][0];
                    int rightTrue = dp[k + 1][j][1];
                    int rightFalse = dp[k + 1][j][0];

                    // True evaluations
                    if (evaluate(true, true, op)) dp[i][j][1] += leftTrue * rightTrue;
                    if (evaluate(true, false, op)) dp[i][j][1] += leftTrue * rightFalse;
                    if (evaluate(false, true, op)) dp[i][j][1] += leftFalse * rightTrue;
                    if (evaluate(false, false, op)) dp[i][j][1] += leftFalse * rightFalse;

                    // False evaluations
                    if (!evaluate(true, true, op)) dp[i][j][0] += leftTrue * rightTrue;
                    if (!evaluate(true, false, op)) dp[i][j][0] += leftTrue * rightFalse;
                    if (!evaluate(false, true, op)) dp[i][j][0] += leftFalse * rightTrue;
                    if (!evaluate(false, false, op)) dp[i][j][0] += leftFalse * rightFalse;
                }
            }
        }

        return dp[0][n - 1][1];
    }

    private static boolean evaluate(boolean b1, boolean b2, char op) {
        if (op == '&') return b1 & b2;
        if (op == '|') return b1 | b2;
        return b1 ^ b2;
    }
}
