class Solution {
  public:
    int minCost(vector<int>& height) {
        // Q. Frog Jump
        // Code here
        int size = height.size();
        if(size == 1) return 0;
        
        vector<int> dp(size, 0);
        dp[0] = 0;
        dp[1] = abs(height[1] - height[0]);
        
        for(int index = 2; index < size; ++index){
            int oneJump = dp[index - 1] + abs(height[index] - height[index - 1]);
            int twoJump = dp[index - 2] + abs(height[index] - height[index - 2]);
            dp[index] = min(oneJump, twoJump);
        }
        
        return dp[size - 1];
    }
};