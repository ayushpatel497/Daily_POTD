class Solution {
    public:
        int countSubarrays(vector<int>& nums) {
            // Q. Count Subarrays of Length Three With a Condition
            int n = nums.size();
            int ans = 0;
            for (int i = 1; i < n - 1; ++i) {
                if (nums[i] == (nums[i - 1] + nums[i + 1]) * 2) {
                    ++ans;
                }
            }
            return ans;
        }
    };