class Solution {
  public:
    int findCoverage(vector<vector<int>>& mat) {
        // Q. Coverage of all Zeros in a Binary Matrix
        // code here
        int n = mat.size();
        int m = mat[0].size();
        int coverage = 0;
        for(int i = 0; i < n; i++) {
            bool foundOne = false;
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 1) foundOne = true;
                else {
                    if(foundOne) coverage++;
                }
            }
        }
        for(int i = 0; i < n; i++) {
            bool foundOne = false;
            for(int j = m-1; j >= 0; j--) {
                if(mat[i][j] == 1) foundOne = true;
                else {
                    if(foundOne) coverage++;
                }
            }
        }
        for(int i = 0; i < m; i++) {
            bool foundOne = false;
            for(int j = 0; j < n; j++) {
                if(mat[j][i] == 1) foundOne = true;
                else {
                    if(foundOne) coverage++;
                }
            }
        }
        for(int i = 0; i < m; i++) {
            bool foundOne = false;
            for(int j = n-1; j >= 0; j--) {
                if(mat[j][i] == 1) foundOne = true;
                else {
                    if(foundOne) coverage++;
                }
            }
        }
        
        return coverage;
    }
};
