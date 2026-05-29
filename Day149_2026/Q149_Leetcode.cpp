class Solution {
public:
    int minElement(vector<int>& nums) {
        // Q. Minimum Element After Replacement With Digit Sum
        int ans = 37;
        for (int num : nums) {
            int dig = 0;
            while (num) {
                dig += num % 10;
                num /= 10;
            }
            ans = min(ans, dig);
        }
        return ans;
    }
};