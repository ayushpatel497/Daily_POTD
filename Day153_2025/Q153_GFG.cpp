class Solution {
  public:
    int uniquePaths(vector<vector<int>> &grid) {
        // Q. Unique Paths in a Grid
        // code here
        int n = grid.size(), m = grid[0].size();
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1) {
            return 0;
        }
        vector<int> dp(m, 0);
        dp[m-1] = 1;
        for(int j = m-2; j >= 0; j--) {
            if(grid[n-1][j] == 1) {
                dp[j] = 0;
            }
            else {
                dp[j] = dp[j+1];
            }
        }
        for(int i = n-2; i >= 0; i--) {
            if(grid[i][m-1] == 1) {
                dp[m-1] = 0;
            }
            for(int j = m-2; j >= 0; j--) {
                if(grid[i][j] == 1) {
                    dp[j] = 0;
                }
                else {
                    dp[j] = dp[j] + dp[j+1];
                }
            }
        }
        
        return dp[0];
    }
};