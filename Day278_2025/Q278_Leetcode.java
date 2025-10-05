import java.util.*;

class Q278_Leetcode {
    private int n, m;
    private int[][] heights;
    private boolean[][] pac, atl;

    private void dfs(int i, int j, boolean[][] vis, int prevHeight) {
        if (i < 0 || i >= n || j < 0 || j >= m || vis[i][j] || heights[i][j] < prevHeight)
            return;
        vis[i][j] = true;
        dfs(i - 1, j, vis, heights[i][j]);
        dfs(i + 1, j, vis, heights[i][j]);
        dfs(i, j - 1, vis, heights[i][j]);
        dfs(i, j + 1, vis, heights[i][j]);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.n = heights.length;
        this.m = heights[0].length;
        this.heights = heights;
        pac = new boolean[n][m];
        atl = new boolean[n][m];

        // Pacific (left + top borders)
        for (int i = 0; i < n; i++) {
            dfs(i, 0, pac, -1);
            dfs(i, m - 1, atl, -1);
        }
        for (int j = 0; j < m; j++) {
            dfs(0, j, pac, -1);
            dfs(n - 1, j, atl, -1);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pac[i][j] && atl[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }
}
