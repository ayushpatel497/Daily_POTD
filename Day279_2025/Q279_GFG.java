import java.util.*;

class Q279_GFG {
    private ArrayList<ArrayList<Integer>> ans;
    private boolean flag = false;
    private int[] arr = {-1, 1, -2, -2, -1, 1, 2, 2};
    private int[] brr = {-2, -2, -1, 1, 2, 2, -1, 1};
    private int n;

    private void solve(int i, int j, int[][] vis, int step) {
        if (flag) return;

        if (step == n * n) {
            ans = new ArrayList<>();
            for (int[] row : vis) {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int val : row) temp.add(val);
                ans.add(temp);
            }
            flag = true;
            return;
        }

        for (int x = 0; x < 8; x++) {
            int p = i + arr[x];
            int q = j + brr[x];

            if (p >= 0 && q >= 0 && p < n && q < n && vis[p][q] == -1) {
                vis[p][q] = step;
                solve(p, q, vis, step + 1);
                vis[p][q] = -1;
            }
        }
    }

    public ArrayList<ArrayList<Integer>> knightTour(int n) {
        this.n = n;
        ans = new ArrayList<>();
        int[][] vis = new int[n][n];
        for (int[] row : vis) Arrays.fill(row, -1);

        vis[0][0] = 0;
        solve(0, 0, vis, 1);
        return ans;
    }
}
