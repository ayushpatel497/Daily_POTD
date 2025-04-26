class Solution {
    public:
        long long countSubarrays(vector<int>& nums, int minK, int maxK) {
            // Q. Count Subarrays With Fixed Bounds
            long long ans = 0;
            int minPos = -1;
            int maxPos = -1;
            int leftBound = -1;
            for(int i = 0; i < nums.size(); i++) {
                if(nums[i] < minK || nums[i] > maxK)
                    leftBound = i;
                if(nums[i] == minK)
                    minPos = i;
                if(nums[i] == maxK)
                    maxPos = i;
                int count = min(maxPos, minPos) - leftBound;
                ans += (count <= 0) ? 0 : count;
            }
            
            return ans;
        }
    };