class Solution {
    void dfs(vector<vector<int>>& a, int x, int y, int N, int M) {
        if (x < 0 || x >= N || y < 0 || y >= M || a[x][y] == 0) return;
        a[x][y] = 0;
        dfs(a, x + 1, y, N, M);
        dfs(a, x - 1, y, N, M);
        dfs(a, x, y + 1, N, M);
        dfs(a, x, y - 1, N, M);
    }
  public:
    int cntOnes(vector<vector<int>>& grid) {
        // Q. 1s Surrounded by 0s
        // code here
        int n = grid.size();
        int m = grid[0].size();
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) if (i == 0 || j == 0 || i == n - 1 || j == m - 1) dfs(grid, i, j, n, m);
        int cnt = 0;
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) cnt += grid[i][j];
        return cnt;
    }
};