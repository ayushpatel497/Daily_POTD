class Solution {
public:
    int minOperations(vector<int>& nums, int k) {
        // Q. Minimum Operations to Make Array Sum Divisible by K
        return accumulate(nums.begin(), nums.end(), 0) % k;
    }
};