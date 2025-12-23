import java.util.*;

class Q357_Leetcode {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;

        // Sort by start time
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        // Suffix max of values
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = events[n - 1][2];

        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(events[i][2], suffixMax[i + 1]);
        }

        int maxSum = 0;

        for (int i = 0; i < n; i++) {
            int left = i + 1, right = n - 1;
            int nextIndex = -1;

            // Binary search for first event starting after events[i] ends
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (events[mid][0] > events[i][1]) {
                    nextIndex = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            if (nextIndex != -1) {
                maxSum = Math.max(maxSum, events[i][2] + suffixMax[nextIndex]);
            }

            // Case of selecting only one event
            maxSum = Math.max(maxSum, events[i][2]);
        }

        return maxSum;
    }
}
