class Solution {
public:
    string mapWordWeights(vector<string>& words, vector<int>& weights) {
        // Q. Weighted Word Mapping
        string ans;
        ans.reserve(words.size());
        for (string word : words) {
            int s = 0;
            for (char c : word) {
                s += weights[c - 'a'];
            }
            ans += 'z' - s % 26;
        }
        return ans;
    }
};