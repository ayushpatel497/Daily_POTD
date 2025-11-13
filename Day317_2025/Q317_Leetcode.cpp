class Solution {
public:
    int maxOperations(string s) {
        // Q. Maximum Number of Operations to Move Ones to the End
        int countOne = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s[i] == '0') {
                while ((i + 1) < s.length() && s[i + 1] == '0') {
                    i++;
                }
                ans += countOne;
            } else {
                countOne++;
            }
        }
        return ans;
    }
};