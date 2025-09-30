class Solution {
public:
    int triangularSum(vector<int>& nums) {
        // Q. Find Triangular Sum of an Array
        while (nums.size() > 1) {
            vector<int> new_nums;
            for (int i = 0; i < nums.size() - 1; ++i) {
                new_nums.push_back((nums[i] + nums[i + 1]) % 10);
            }
            nums = move(new_nums);
        }
        return nums[0];
    }
};