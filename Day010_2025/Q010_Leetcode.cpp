class Solution {
public:
    vector<int> countt(string s) {
        vector<int> ans(26, 0);
        for (char c : s)
            ans[c - 'a']++;
        return ans;
    }

    vector<string> wordSubsets(vector<string>& words1, vector<string>& words2) {
        // Q. Word Subsets
        vector<int> bmax(26, 0);
        for (string b : words2) {
            vector<int> bCount = countt(b);
            for (int i = 0; i < 26; ++i)
                bmax[i] = max(bmax[i], bCount[i]);
        }

        vector<string> ans;
        for (string a : words1) {
            vector<int> aCount = countt(a);
            bool isUniversal = true;
            for (int i = 0; i < 26; ++i) {
                if (aCount[i] < bmax[i]) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal)
                ans.push_back(a);
        }

        return ans;
    }
};