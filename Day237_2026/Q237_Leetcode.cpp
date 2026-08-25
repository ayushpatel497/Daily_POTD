class Solution {
public:
    int missingMultiple(vector<int>& nums, int k) {
        // Q. Smallest Missing Multiple of K
        unordered_set<int> seen(nums.begin(), nums.end());
        int ans = k;
        while (seen.count(ans)) {
            ans += k;
        }
        return ans;
    }
};