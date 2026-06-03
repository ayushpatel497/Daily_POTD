class Solution {
  public:
    vector<int> freqInRange(vector<int>& arr, vector<vector<int>>& queries) {
        // Q. Subarray Frequency Count Queries
        // code here
        map<int, vector<int>> mp;
        for(int i = 0; i < arr.size(); i++){
            mp[arr[i]].push_back(i);
        }
        vector<int> ans;
        int n = queries.size();
        for(int i = 0; i < n; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            int x = queries[i][2];
            int left = lower_bound(mp[x].begin(), mp[x].end(), l) - mp[x].begin();
            int right = upper_bound(mp[x].begin(), mp[x].end(), r) - mp[x].begin();
            int count = right - left;
            ans.push_back(count);
        }
        return ans;
    }
};