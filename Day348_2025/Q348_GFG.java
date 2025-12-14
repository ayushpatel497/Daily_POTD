import java.util.*;

class Q348_GFG {
    public ArrayList<Integer> prefixSum2D(int[][] mat, int[][] queries) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] pre = new int[n][m];

        // Build prefix sum matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pre[i][j] = mat[i][j];
                if (i > 0) pre[i][j] += pre[i - 1][j];
                if (j > 0) pre[i][j] += pre[i][j - 1];
                if (i > 0 && j > 0) pre[i][j] -= pre[i - 1][j - 1];
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        // Answer queries
        for (int[] q : queries) {
            int r1 = q[0], c1 = q[1];
            int r2 = q[2], c2 = q[3];

            int sum = pre[r2][c2];
            if (r1 > 0) sum -= pre[r1 - 1][c2];
            if (c1 > 0) sum -= pre[r2][c1 - 1];
            if (r1 > 0 && c1 > 0) sum += pre[r1 - 1][c1 - 1];

            ans.add(sum);
        }

        return ans;
    }
}
