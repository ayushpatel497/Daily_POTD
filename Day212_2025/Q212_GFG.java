import java.util.*;

class Q212_GFG {
    public int powerfulInteger(int[][] intervals, int k) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int ans = -1;
        int i = 0;
        for (int j = 0; j < n; j++) {
            while (i < n && start[i] <= end[j]) {
                i++;
            }
            if (i - j >= k) {
                ans = end[j];
            }
        }
        return ans;
    }
}
