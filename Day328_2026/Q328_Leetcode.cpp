class Solution {
public:
    int maxLength(vector<int>& nums) {
        // Q. Maximum Subarray With Equal Products
        int res = 2;
        int prodVal = 1;
        int n = nums.size();
        int start = 0, end = 0;

        while (end < n) {
            while (gcd(prodVal, nums[end]) > 1) {
                prodVal /= nums[start];
                start++;
            }
            prodVal *= nums[end];
            res = max(res, end - start + 1);
            end++;
        }
        return res;
    }
};