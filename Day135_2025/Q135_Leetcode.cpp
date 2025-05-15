class Solution {
public:
    vector<string> getLongestSubsequence(vector<string>& words, vector<int>& groups) {
        // Q. Longest Unequal Adjacent Groups Subsequence I
        vector<string> ans;
        int n = words.size();
        for (int i = 0; i < n; i++) {
            if (i == 0 || groups[i] != groups[i - 1]) {
                ans.emplace_back(words[i]);
            }
        }
        return ans;
    }
};