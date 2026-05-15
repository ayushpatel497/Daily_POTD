class Solution {
public:
    int findMin(vector<int>& nums) {
        // Q. Find Minimum in Rotated Sorted Array
        return *partition_point(nums.begin(), nums.end(), [&](int n) { return n > nums.back(); });
    }
};