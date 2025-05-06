class Solution {
    public:
        vector<int> buildArray(vector<int>& nums) {
            // Q. Build Array from Permutation
            int n = nums.size();
            for (int i = 0; i < n; ++i) {
                nums[i] += 1000 * (nums[nums[i]] % 1000);
            }
            for (int i = 0; i < n; ++i) {
                nums[i] /= 1000;
            }
            return nums;
        }
    };