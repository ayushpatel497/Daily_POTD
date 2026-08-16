class Solution {
public:
    int longestSubsequence(vector<int>& nums) {
        // Q. Longest Subsequence With Non-Zero Bitwise XOR
        int n = nums.size();
        int totalXor = 0;
        bool allZero = true;

        for (int x : nums) {
            totalXor ^= x;
            if (x > 0) {
                allZero = false;
            }
        }

        if (totalXor > 0) {
            return n;
        }

        return allZero ? 0 : n - 1;
    }
};