class Solution {
public:
    int maximumEnergy(vector<int>& energy, int k) {
        // Q. Taking Maximum Energy From the Mystic Dungeon
        int n = energy.size(), ans = INT_MIN;
        for (int i = n - k; i < n; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j -= k) {
                sum += energy[j];
                ans = max(ans, sum);
            }
        }
        return ans;
    }
};