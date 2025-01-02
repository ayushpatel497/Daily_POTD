class Solution {
public:
    bool isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    bool check(string s){
        return (isVowel(s[0]) && isVowel(s[s.length() - 1]));
    }
    vector<int> vowelStrings(vector<string>& words, vector<vector<int>>& queries) {
        // Q. Count Vowel Strings in Ranges
        int n = words.size();
        vector<int> ans;
        vector<int> preSum;
        preSum.push_back(0);
        for(int i = 0; i < n; ++i){
            preSum.push_back(check(words[i]) ? preSum[i] + 1 : preSum[i]);
        }
        for(int j = 0; j < queries.size(); ++j){
            int low = queries[j][0];
            int up = queries[j][1];
            int val = preSum[up + 1] - preSum[low];
            ans.push_back(val);
        }
        return ans;
    }
};