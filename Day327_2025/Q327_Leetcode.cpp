class Solution {
public:
    int maxSumDivThree(vector<int>& nums) {
        // Q. Greatest Sum Divisible by Three
        vector<int> f = {0, INT_MIN, INT_MIN};
        for (int num : nums) {
            vector<int> g = f;
            for (int i = 0; i < 3; ++i) {
                g[(i + num % 3) % 3] = max(g[(i + num % 3) % 3], f[i] + num);
            }
            f = move(g);
        }
        return f[0];
    }
};