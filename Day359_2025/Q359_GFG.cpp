class Solution {
  public:
    vector<int> findPeakGrid(vector<vector<int>>& mat) {
        // Q. Find the Peak Element in a 2D Matrix
        // code here
        vector<int>ans;
        
        int n = mat.size();
        int m = mat[0].size();
        int t, b, l, r;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                t = 0, b = 0, l = 0, r = 0;
                
                if(i == 0) t = 1;
                else if(mat[i - 1][j] <= mat[i][j]) t = 1;
                
                if(i == n - 1) b = 1;
                else if(mat[i + 1][j] <= mat[i][j]) b = 1;
                
                if(j == 0) l = 1;
                else if(mat[i][j - 1] <= mat[i][j]) l = 1;
                
                if(j == m - 1) r = 1;
                else if(mat[i][j + 1] <= mat[i][j]) r = 1;
                
                if(t && b && l && r){
                    ans.push_back(i);
                    ans.push_back(j);
                    return ans;
                }
            }
        }
        
        return ans;
    }
};
