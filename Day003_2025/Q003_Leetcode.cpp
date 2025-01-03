class Solution {
public:
    int waysToSplitArray(vector<int>& nums) {
        // Q. Number of Ways to Split Array
        long long preSum = 0, total = 0;
        int ans = 0;
        for(int i : nums){
            total+=i;
        }
        for(int i = 0; i < nums.size() - 1; ++i){
            preSum += nums[i];
            if(preSum >= total - preSum){
                ans++;
            }
        }
        return ans;
    }
};