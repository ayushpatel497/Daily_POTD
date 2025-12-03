class Solution {
  public:
    int tsp(vector<vector<int>>& cost) {
        // Q. Travelling Salesman Problem
        // code here
        int n = cost.size();
        int N = 1 << n;
        vector<vector<int>> dp(N, vector<int>(n, 1e9));
        dp[1][0] = 0;

        for (int mask = 0; mask < N; mask++) {
            for (int u = 0; u < n; u++) {
                if (!(mask & (1 << u))) continue;
                for (int v = 0; v < n; v++) {
                    if (mask & (1 << v)) continue;
                    int nxt = mask | (1 << v);
                    dp[nxt][v] = min(dp[nxt][v], dp[mask][u] + cost[u][v]);
                }
            }
        }

        int ans = 1e9;
        for (int u = 0; u < n; u++)
            ans = min(ans, dp[(1 << n) - 1][u] + cost[u][0]);
        
        return ans;
    }
};