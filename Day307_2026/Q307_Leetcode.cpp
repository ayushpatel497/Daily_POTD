class Solution {
public:
    int minMoves(vector<int>& nums) {
        // Q. Minimum Moves to Equal Array Elements III
        int mx = nums[0];
        for (int x : nums) {
            mx = max(mx, x);
        }
        int ans = 0;
        for (int x : nums) {
            ans += mx - x;
        }
        return ans;
    }
};