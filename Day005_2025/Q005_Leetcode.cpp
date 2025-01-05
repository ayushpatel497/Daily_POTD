class Solution {
public:
    string shiftingLetters(string s, vector<vector<int>>& shifts) {
        // Q. Shifting Letters II
        int n = s.length();
        vector<int> shiftCount(n + 1, 0);
        for(auto i : shifts){
            shiftCount[i[0]] += (2 * i[2] - 1);
            shiftCount[i[1] + 1] -= (2 * i[2] - 1);
        }
        
        string ans = "";
        int preSum = 0;
        for(int i = 0; i < n; ++i){
            preSum = (preSum + shiftCount[i]) % 26;
            ans += ('a' + (s[i] - 'a' + preSum + 26) % 26);
        }
        return ans;
    }
};