class Solution {
  public:
    vector<int> findMean(vector<int> &arr, vector<vector<int>> &queries) {
        // Q. Mean of range in array
        // code here
        int n = arr.size();
        vector<int> ans;
        vector<int> pre(n, 0);
        
        pre[0] = arr[0];
        for(int i = 1; i < n; i++){
            pre[i] = (pre[i - 1] + arr[i]);
        }
        
        for(auto &it: queries){
            int u = it[0];
            int v = it[1];
            int sum = pre[v];
            if(u - 1 >= 0) sum -= pre[u - 1];
            ans.push_back(floor(sum / (v - u + 1)));
        }
        
        return ans;
    }
};