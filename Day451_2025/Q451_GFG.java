import java.util.*;

class Q451_GFG {
    public ArrayList<int[]> mergeOverlap(int[][] arr) {
        int n = arr.length;
        ArrayList<int[]> ans = new ArrayList<>();

        // temp array with sentinel row
        int[][] temp = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            temp[i][0] = arr[i][0];
            temp[i][1] = arr[i][1];
        }
        temp[n][0] = 10000002;
        temp[n][1] = 10000002;

        Arrays.sort(temp, (a, b) -> a[0] - b[0]);

        int s = temp[0][0];
        int e = temp[0][1];

        for (int i = 1; i <= n; i++) {
            int curS = temp[i][0];
            int curE = temp[i][1];

            if (curS > e) {
                ans.add(new int[]{s, e});
                s = curS;
                e = curE;
            } else {
                s = Math.min(s, curS);
                e = Math.max(e, curE);
            }
        }
        return ans;
    }
}
