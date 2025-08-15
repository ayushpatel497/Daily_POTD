import java.util.*;

class Q227_GFG {
    public ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        int start = newInterval[0], end = newInterval[1];
        ArrayList<int[]> ans = new ArrayList<>();
        int c = -1;
        int n = intervals.length;
        
        for (int i = 0; i < n; i++) {
            int a = intervals[i][0], b = intervals[i][1];
            if (b < start) {
                ans.add(new int[]{a, b});
            } else if (c == -1 && Math.max(a, start) <= Math.min(b, end)) {
                start = Math.min(start, a);
                end = Math.max(end, b);
            } else {
                if (c == -1) {
                    c = 0;
                    ans.add(new int[]{start, end});
                }
                ans.add(new int[]{a, b});
            }
        }
        if (c == -1) {
            ans.add(new int[]{start, end});
        }
        return ans;
    }
}
