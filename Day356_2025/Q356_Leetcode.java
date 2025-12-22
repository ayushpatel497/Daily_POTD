import java.util.Arrays;

class Q356_Leetcode {
    public int minDeletionSize(String[] strs) {
        int m = strs.length;
        int n = strs[0].length();

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int res = n - 1;

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                int k;
                for (k = 0; k < m; k++) {
                    if (strs[k].charAt(i) > strs[k].charAt(j)) {
                        break;
                    }
                }
                if (k == m && dp[i] + 1 > dp[j]) {
                    dp[j] = dp[i] + 1;
                }
            }
            res = Math.min(res, n - dp[j]);
        }

        return res;
    }
}
