class Solution {
public:
    int findGCD(vector<int>& nums) {
        // Q. Find Greatest Common Divisor of Array
        int mx = *max_element(nums.begin(), nums.end());
        int mn = *min_element(nums.begin(), nums.end());
        return gcd(mx, mn);
    }
};