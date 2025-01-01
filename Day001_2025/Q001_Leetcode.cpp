class Solution {
public:
    int maxScore(string s) {
        // Q. Maximum Score After Splitting a String
        int ans = 0;
        int zeros = 0;
        int ones = count(s.begin(), s.end(), '1');
        for (int i = 0; i < s.length() - 1; ++i) {
            zeros += (s[i] == '0');
            ones -= (s[i] == '1');
            ans = max(ans, (zeros + ones));
        }
        return ans;
    }
};