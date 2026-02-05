class Solution {
public:
    vector<int> constructTransformedArray(vector<int>& nums) {
        // Q. Transformed Array
        int n = nums.size();
        vector<int> res(n);
        for (int i = 0; i < n; i++) {
            res[i] = nums[((i + nums[i]) % n + n) % n];
        }
        return res;
    }
};