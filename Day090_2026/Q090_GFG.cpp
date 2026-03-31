class Solution {
    int maxProfitTabSO(vector<int> &nums, int &k) {
        int size = nums.size();
        vector<int> curr(2, 0);
        vector<int> next(2, 0);
        
        for(int i = size-1; i >= 0; i--) {
            for(int buy = 0; buy <= 1; buy++) {
                int include = 0;
                if(buy == 1) {
                    include = nums[i] + next[0];
                }
                else {
                    include = -nums[i] -k + next[1];
                }
                int exclude = next[buy];
                
                curr[buy] = max(include, exclude);
            }
            next = curr;
        }
        
        return curr[0];
    }
  public:
    int maxProfit(vector<int>& arr, int k) {
        // Q. Buy Stock with Transaction Fee
        // Code here
        return maxProfitTabSO(arr, k);
    }
};