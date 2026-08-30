class Solution {
public:
    int minimumDeletions(vector<int>& nums) {
        // Q. Removing Minimum and Maximum From Array
        int n = nums.size();
        int minidx = min_element(nums.begin(), nums.end()) - nums.begin();
        int maxidx = max_element(nums.begin(), nums.end()) - nums.begin();
        int l = min(minidx, maxidx);
        int r = max(minidx, maxidx);
        return min({r + 1, n - l, l + 1 + n - r});
    }
};