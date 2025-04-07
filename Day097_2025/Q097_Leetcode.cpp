class Solution {
    bool spaceOptimized(int numsSize, vector<int>& nums, int target){
        vector<bool> curr(target + 1, false);
        vector<bool> next(target + 1, false);
        curr[0] = true;
        next[0] = true;
        for(int index = numsSize - 1; index >= 0; --index){
            for(int targt = 0; targt <= target; ++targt){
                bool include = false;
                if(targt - nums[index] >= 0){
                    include = next[targt - nums[index]];
                }
                bool exclude = next[targt];
                curr[targt] = include || exclude;
            }
            next = curr;
        }
        return next[target];
    }

public:
    bool canPartition(vector<int>& nums) {
        // Q. Partition Equal Subset Sum
        int total = 0;
        int numsSize = nums.size();
        for(int index = 0; index < numsSize; ++index){
            total += nums[index];
        }
        if(total & 1){
            return false;
        }
        int target = total / 2;
        return spaceOptimized(numsSize, nums, target);
    }
};