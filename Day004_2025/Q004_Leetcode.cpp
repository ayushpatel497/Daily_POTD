class Solution {
public:
    int countPalindromicSubsequence(string s) {
        // Q. Unique Length-3 Palindromic Subsequences
        vector<int> firstt(26, INT_MAX), lastt(26, 0);
        for(int i = 0; i < s.length(); ++i){
            firstt[s[i] - 'a'] = min(firstt[s[i] - 'a'], i);
            lastt[s[i] - 'a'] = i;
        }
        int ans = 0;
        for(int i = 0; i < 26; ++i){
            if(firstt[i] < lastt[i]){
                ans += unordered_set(s.begin() + firstt[i] + 1, s.begin() + lastt[i]).size();
            }
        }
        return ans;
    }
};