class Solution {
public:
    bool isGood(vector<int>& nums) {
        // Q. Check if Array is Good
        int n = nums.size();
        vector<int> count(n, 0);
        for (int a : nums) {
            if (a >= n) {
                return false;
            }
            if (a < n - 1 && count[a] > 0) {
                return false;
            }
            if (a == n - 1 && count[a] > 1) {
                return false;
            }
            count[a]++;
        }
        return true;
    }
};