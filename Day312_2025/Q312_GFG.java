import java.util.*;

class Solution {
    private int traverse(int i, int j, int[][] mat, int k, int cnt, Map<Integer, Integer>[][] dp) {
        int n = mat.length;
        int m = mat[0].length;

        if (i >= n || j >= m)
            return 0;

        if (dp[i][j].containsKey(cnt))
            return dp[i][j].get(cnt);

        if (i == n - 1 && j == m - 1) {
            if (mat[i][j] == k - cnt)
                return 1;
            return 0;
        }

        int newCnt = cnt + mat[i][j];
        int res = traverse(i + 1, j, mat, k, newCnt, dp) + traverse(i, j + 1, mat, k, newCnt, dp);

        dp[i][j].put(cnt, res);
        return res;
    }

    public int numberOfPath(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        Map<Integer, Integer>[][] dp = new HashMap[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                dp[i][j] = new HashMap<>();

        return traverse(0, 0, mat, k, 0, dp);
    }
}
