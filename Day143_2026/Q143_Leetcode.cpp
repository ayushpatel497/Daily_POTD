class Solution {
public:
    bool check(vector<int>& nums) {
        // Q. Check if Array Is Sorted and Rotated
        int n = nums.size();
        if (n <= 1) return true;
        int inversionCount = 0;
        for (int i = 1; i < n; ++i) {
            if (nums[i] < nums[i - 1]) {
                ++inversionCount;
                if (inversionCount > 1) return false;
            }
        }
        if (nums[0] < nums[n - 1]) {
            ++inversionCount;
        }

        return inversionCount <= 1;
    }
};