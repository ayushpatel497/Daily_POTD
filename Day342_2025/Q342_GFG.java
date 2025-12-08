class Q342_GFG {

    static class PIS {
        int cost;
        String str;
        PIS(int c, String s) { cost = c; str = s; }
    }

    PIS[][] dp;

    private PIS solve(int[] arr, int st, int en, String s) {
        if (st == en) {
            return new PIS(0, String.valueOf(s.charAt(st - 1)));
        }

        if (dp[st][en] != null) {
            return dp[st][en];
        }

        int best = Integer.MAX_VALUE;
        String bestStr = "";

        for (int k = st; k < en; k++) {
            PIS left = solve(arr, st, k, s);
            PIS right = solve(arr, k + 1, en, s);
            int cost = arr[st - 1] * arr[k] * arr[en];

            int total = left.cost + right.cost + cost;
            if (total < best) {
                best = total;
                bestStr = "(" + left.str + right.str + ")";
            }
        }

        return dp[st][en] = new PIS(best, bestStr);
    }

    public String matrixChainOrder(int arr[]) {
        int n = arr.length;
        dp = new PIS[n + 1][n + 1];

        // Create matrix names A, B, C...
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            sb.append((char)('A' + i));
        }

        PIS ans = solve(arr, 1, n - 1, sb.toString());
        return ans.str;
    }
}
