class Solution {
  public:
    int equalSumSpan(vector<int> &a1, vector<int> &a2) {
        // Q. Longest Span in two Binary Arrays
        // code here
        int x = 0, y = 0;
        unordered_map<int, int> mp;
        int ans = 0;
        mp[0] = -1;
        for(int  i = 0; i < a1.size(); i++){
            x += a1[i];
            y += a2[i];
            if(mp.find(x - y) == mp.end()) mp[x - y] = i;
            else ans = max(ans, i - mp[x - y]);
        }
        return ans;
    }
};