class Solution {
public:
    int minChanges(string s) {
        // Q. Minimum Number of Changes to Make Binary String Beautiful
        int minChangesRequired = 0;
        for (int i = 0; i < s.length(); i += 2) {
            if (s[i] != s[i + 1]) {
                minChangesRequired++;
            }
        }

        return minChangesRequired;
    }
};