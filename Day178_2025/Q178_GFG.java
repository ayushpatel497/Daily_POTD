class Q178_GFG {
    public int getCount(int n) {
        if (n == 1) return 10;

        int[][] moves = {
            {0, 8},
            {1, 2, 4},
            {2, 1, 3, 5},
            {3, 2, 6},
            {4, 1, 5, 7},
            {5, 2, 4, 6, 8},
            {6, 3, 5, 9},
            {7, 4, 8},
            {8, 5, 7, 9, 0},
            {9, 6, 8}
        };

        long[][] dp = new long[n + 1][10];

        for (int i = 0; i <= 9; ++i) {
            dp[1][i] = 1;
        }

        for (int len = 2; len <= n; ++len) {
            for (int digit = 0; digit <= 9; ++digit) {
                dp[len][digit] = 0;
                for (int prev : moves[digit]) {
                    dp[len][digit] += dp[len - 1][prev];
                }
            }
        }

        long result = 0;
        for (int i = 0; i <= 9; ++i) {
            result += dp[n][i];
        }

        return (int) result;
    }
}
