class Solution {
  public:
    int getCount(int n) {
        // Q. Mobile numeric keypad
        // code here
        if (n == 1) return 10;
        vector<vector<int>> moves = {
            {0, 8},   
            {1, 2, 4}, 
            {2, 1, 3, 5}, 
            {3, 2, 6}, 
            {4, 1, 5, 7}, 
            {5, 2, 4, 6, 8}, 
            {6, 3, 5, 9}, 
            {7, 4, 8}, 
            {8, 5, 7, 9, 0},
            {9, 6, 8}
        };
    
        vector<vector<long long>> dp(n + 1, vector<long long>(10, 0));
        for (int i = 0; i <= 9; ++i) {
            dp[1][i] = 1;
        }
        
        for (int len = 2; len <= n; ++len) {
            for (int digit = 0; digit <= 9; ++digit) {
                dp[len][digit] = 0;
                for (int prev : moves[digit]) {
                    dp[len][digit] += dp[len - 1][prev];
                }
            }
        }
    
        long long result = 0;
        for (int i = 0; i <= 9; ++i) {
            result += dp[n][i];
        }
    
        return result;
    }
};