class Solution {
public:
    int findLHS(vector<int>& nums) {
        // Q. Longest Harmonious Subsequence
        unordered_map<int, int> freq = {};
        int res = 0;
        for(int num : nums) {
            freq[num]++;
        }

        for (auto& pair : freq) {
            if (freq.find(pair.first + 1) != freq.end()) {
                res = std::max(res, pair.second + freq[pair.first + 1]);
            }
        }
        
        return res;
    }
};