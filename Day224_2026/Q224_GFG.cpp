class Solution {
  public:
    vector<int> findWays(vector<vector<int>>& grid) {
        // Q. Adventure in a Maze
        // code here
        int n = grid.size();
        const long long MOD = 1000000007LL;
        vector<long long> ways(n, 0);
        vector<int> best(n, -1);
        ways[0] = 1;
        best[0] = grid[0][0];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 && j == 0) {
                    continue;
                }
                long long currentWays = 0;
                int currentBest = -1;
                if (j > 0 &&
                    (grid[i][j - 1] == 1 || grid[i][j - 1] == 3) &&
                    best[j - 1] != -1) {
                    currentWays = (currentWays + ways[j - 1]) % MOD;
                    currentBest = max(
                        currentBest,
                        best[j - 1] + grid[i][j]
                    );
                }
                if (i > 0 &&
                    (grid[i - 1][j] == 2 || grid[i - 1][j] == 3) &&
                    best[j] != -1) {
                    currentWays = (currentWays + ways[j]) % MOD;
                    currentBest = max(
                        currentBest,
                        best[j] + grid[i][j]
                    );
                }
                ways[j] = currentWays;
                best[j] = currentBest;
            }
        }

        if (best[n - 1] == -1) {
            return {0, 0};
        }

        return {(int)ways[n - 1], best[n - 1]};
    }
};