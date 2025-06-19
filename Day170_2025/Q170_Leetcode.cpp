class Solution {
public:
    int partitionArray(vector<int>& nums, int k) {
        // Q. Partition Array Such That Maximum Difference Is K
        sort(nums.begin(), nums.end());
        int ans = 1;
        int rec = nums[0];
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] - rec > k) {
                ans++;
                rec = nums[i];
            }
        }
        return ans;
    }
};