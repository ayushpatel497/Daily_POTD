class Solution {
  public:
    vector<int> cntInRange(vector<int> &arr, vector<vector<int>> &queries) {
        // Q. Elements in range [a, b]
        // code here
        int n=queries.size();
        vector<int> ans(n, 0);
      
        sort(arr.begin(), arr.end());
      
        int i=0;
        for(vector<int> &v: queries){
            int l = lower_bound(arr.begin(), arr.end(), v[0]) - arr.begin();
            int r = upper_bound(arr.begin(), arr.end(), v[1]) - arr.begin();
            ans[i++] = r-l;
        }
      
        return ans;
    }
};