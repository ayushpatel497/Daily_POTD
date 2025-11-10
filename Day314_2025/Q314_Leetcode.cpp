class Solution {
public:
    int minOperations(vector<int>& nums) {
        // Q. Minimum Operations to Convert All Elements to Zero
        vector<int> s;
        int res = 0;
        for (int a : nums) {
            while (!s.empty() && s.back() > a) {
                s.pop_back();
            }
            if (a == 0) continue;
            if (s.empty() || s.back() < a) {
                ++res;
                s.push_back(a);
            }
        }
        return res;
    }
};