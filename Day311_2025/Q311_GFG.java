import java.util.*;

class Q311_GFG {
    public int maxProfit(int[][] jobs) {
        int n = jobs.length;
        // Sort by job end times
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[1], b[1]));

        int[] endTimes = new int[n];
        for (int i = 0; i < n; i++) {
            endTimes[i] = jobs[i][1];
        }

        long[] dp = new long[n];
        dp[0] = jobs[0][2];

        for (int i = 1; i < n; i++) {
            long profitInclude = jobs[i][2];

            // Find the last job that ends before current job starts
            int idx = Arrays.binarySearch(endTimes, jobs[i][0]);
            if (idx < 0) idx = -idx - 2;
            if (idx >= 0) profitInclude += dp[idx];

            long profitExclude = dp[i - 1];
            dp[i] = Math.max(profitInclude, profitExclude);
        }

        return (int) dp[n - 1];
    }
}
