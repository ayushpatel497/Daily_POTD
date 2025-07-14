import java.util.Arrays;

class Q195_GFG {
    private boolean isPowerOfFive(String s, int start, int end) {
        long num = 0;
        long power = 1;
        for (int i = end; i >= start; i--) {
            if (s.charAt(i) == '1') {
                num += power;
            }
            power *= 2;
        }
        if (num == 0) return false;
        while (num > 1) {
            if (num % 5 != 0) return false;
            num /= 5;
        }
        return true;
    }

    private int helper(String s, int start, int end, int[][] dp) {
        if (end < start) return 0;
        if (s.charAt(start) == '0') return -1;
        if (dp[start][end] != -1) return dp[start][end];
        if (isPowerOfFive(s, start, end)) return 1;

        int ans = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            if (isPowerOfFive(s, start, i)) {
                int second = helper(s, i + 1, end, dp);
                if (second != -1) {
                    ans = Math.min(ans, 1 + second);
                }
            }
        }

        return dp[start][end] = (ans == Integer.MAX_VALUE ? -1 : ans);
    }

    public int cuts(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(s, 0, n - 1, dp);
    }
}
