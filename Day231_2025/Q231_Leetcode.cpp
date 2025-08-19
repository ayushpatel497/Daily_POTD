class Solution {
public:
    long long zeroFilledSubarray(vector<int>& nums) {
        // Q. Number of Zero-Filled Subarrays
        long long cnt = 0, streak = 0;
        for (int num : nums) {
            if (num == 0) {
                streak++;
                cnt += streak;
            } else {
                streak = 0;
            }
        }
        return cnt;
    }
};