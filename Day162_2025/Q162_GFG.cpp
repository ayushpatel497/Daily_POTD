class Solution {
  public:
    int findLength(vector<int> &color, vector<int> &radius) {
        // Q. Remove the balls
        // code here
        int n = color.size();
        stack<pair<int, int>> ans;
        ans.push({color[0], radius[0]});
        for(int i = 1; i < n; i++){
            if(!ans.empty() && (ans.top().first == color[i] && ans.top().second == radius[i])) ans.pop();
            else ans.push({color[i], radius[i]});
        }
        return ans.size();
    }
};