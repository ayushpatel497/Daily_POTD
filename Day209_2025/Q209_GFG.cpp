class Solution {
  public:
    int balanceSums(vector<vector<int>>& mat) {
        // Q. Make Matrix Beautiful
        // code here
        int n = mat.size();
        int maxe = INT_MIN;
        for(int i = 0; i < n; ++i) {
            int rowSum = 0, colSum = 0;
            for(int j = 0; j < n; ++j) {
                rowSum += mat[i][j];
                colSum += mat[j][i];
            }
            maxe = max({maxe, rowSum, colSum});
        }
        
        int ans = 0;
        for(int i = 0; i < n; ++i) {
            int rowSum = 0;
            for(int j = 0; j < n; ++j) {
                rowSum += mat[i][j];
            }
            ans += maxe - rowSum;
        }
        
        return ans;
    }
};