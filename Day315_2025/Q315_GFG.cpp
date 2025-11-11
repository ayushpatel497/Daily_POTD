class Solution {
  public:
    int minSuperSeq(string &s1, string &s2) {
        // Q. Shortest Common Supersequence
        // code here
        string X = s1;
        string Y = s2;
        int m = X.length();
        int n = Y.length();
        vector<vector<int>> dp(m + 1, vector<int>(n + 1, 0));
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(X[i] == Y[j]) dp[i + 1][j + 1] = dp[i][j] + 1;
                else dp[i + 1][j + 1] = max(dp[i][j + 1], dp[i + 1][j]);
            }
        }
        return (m + n - dp[m][n]);
    }
};