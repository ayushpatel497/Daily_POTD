class Solution {
  public:
    int solve(vector<int> &cost,int n,int w,int idx,vector<vector<int>>&dp){
        if(w == 0) return 0;
        if(idx >= n || w < 0) return INT_MAX;
        if(dp[idx][w] != -1) return dp[idx][w];
        int take = INT_MAX;
        if(cost[idx] != -1){
            int result = solve(cost, n, w - (idx + 1), idx, dp);
            if(result != INT_MAX){
                take = cost[idx] + result;
            }
        }
        int notTake = solve(cost, n, w, idx + 1, dp);
        return dp[idx][w] = min(take, notTake);
    }
    
    int minimumCost(vector<int> &cost, int w) {
        // Q. Minimum Cost to Fill Given Weight
        // code here
        int n = cost.size();
        vector<vector<int>> dp(n, vector<int>(w + 1, -1));
        int result = solve(cost, n, w, 0, dp);
        return result != INT_MAX ? result : -1;
    }
};
