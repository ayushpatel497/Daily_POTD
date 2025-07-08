import java.util.*;

class Q189_Leetcode {
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        int[][] dp = new int[k + 1][n + 1];

        for (int cur = n - 1; cur >= 0; cur--) {
            for (int cnt = 1; cnt <= k; cnt++) {
                int next = binarySearch(events, events[cur][1]);
                dp[cnt][cur] = Math.max(dp[cnt][cur + 1], events[cur][2] + dp[cnt - 1][next]);
            }
        }
        return dp[k][0];
    }

    private int binarySearch(int[][] events, int target) {
        int left = 0, right = events.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (events[mid][0] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
