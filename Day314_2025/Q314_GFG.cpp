class Solution {
  public:
    int maxProfit(vector<int>& arr) {
        // Q. Stock Buy and Sell with Cooldown
        // code here
        int n = arr.size();
        if (n == 0) return 0;
        long long dp0 = 0;
        long long dp1 = -arr[0];
        long long dp2 = 0;
        
        for (int i = 1; i < n; ++i) {
            long long price = arr[i];
            long long prev0 = dp0, prev1 = dp1, prev2 = dp2;
            dp0 = max(prev0, prev2);
            dp1 = max(prev1, prev0 - price);
            dp2 = prev1 + price;
        }
        
        return (int) max(dp0, dp2);
    }
};