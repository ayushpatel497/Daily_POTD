class Solution {
  public:
    vector<int> diagView(vector<vector<int>> mat) {
        // Q. Print Diagonally
        // code here
        map<int, vector<int>> mpp;
        for(int i = 0; i < mat.size(); i++){
            for(int j = 0; j < mat[0].size(); j++){
                mpp[i+j].push_back(mat[i][j]);
            }
        }
        vector<int> ans;
        for(auto it: mpp){
            ans.insert(ans.end(), it.second.begin(), it.second.end());
        }
        return ans;
    }
};