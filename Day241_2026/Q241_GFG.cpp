class Solution {
    int mod = 1e9 + 7;
    int solve(int i, int rem, int n, string& s, vector<vector<int>>& dp) {
        if (i == s.length()) {
            return rem == 0;
        }
        if (dp[i][rem] != -1) {
            return dp[i][rem];
        }
        int num = s[i] - '0';
        int newRem = (rem * 10 + num) % n;
        int skip = solve(i + 1, rem, n, s, dp);
        int take = solve(i + 1, newRem, n, s, dp);
        return dp[i][rem] = (take + skip) % mod;
    }
  public:
    int countSubsequences(string& s, int n) {
        // Q. Count Subsequences Divisible by n
        // code here
        int len = s.length();
        vector<vector<int>> dp(len + 1, vector<int>(n + 1, 0));
        vector<int> prev(len + 1, 0);
        vector<int> curr(n + 1, 0);
        dp[len][0] = 1;
        for (int i = len - 1; i >= 0; i--) {
            for (int rem = 0; rem < n; rem++) {
                int skip = dp[i + 1][rem];
                int num = s[i] - '0';
                int newRem = (rem * 10 + num) % n;
                int take = dp[i + 1][newRem];
                dp[i][rem] = (take + skip) % mod;
            }
        }
        return dp[0][0] - 1;
        return solve(0, 0, n, s, dp) - 1;
    }
};