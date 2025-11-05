class Solution {
  public:
    int minSquares(int n) {
        // Q. Get Minimum Squares
        // Code here
        vector<int> dp(n + 1, INT_MAX);
        dp[0] = 0;
        dp[1] = 1;
        
        for(int indexX = 2; indexX <= n; ++indexX){
            dp[indexX] = indexX;
            for(int indexY = 1; indexY * indexY <= indexX; ++indexY){
                dp[indexX] = min(dp[indexX], dp[indexX - (indexY * indexY)] + 1);
            }
        }
        
        return dp[n];
    }
};