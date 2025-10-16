class Solution {
public:
    int findSmallestInteger(vector<int>& nums, int value) {
        // Q. Smallest Missing Non-negative Integer After Operations
        vector<int> mp(value);
        for (auto& x : nums) {
            int v = (x % value + value) % value;
            mp[v]++;
        }
        int maxx = 0;
        while (mp[maxx % value] > 0) {
            mp[maxx % value]--;
            maxx++;
        }
        return maxx;
    }
};