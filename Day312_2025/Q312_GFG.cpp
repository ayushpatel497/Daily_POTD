class Solution {
    int traverse(int i, int j, vector<vector<int>>& mat, int k, int cnt, vector<vector<unordered_map<int, int>>>& dp)
    {
        int n = mat.size();
        int m = mat[0].size();
        if (i >= n || j >= m)
            return 0;
        if (dp[i][j].find(cnt) != dp[i][j].end()) return dp[i][j][cnt];
        if (i == n - 1 && j == m - 1) {
            if (mat[i][j] == k-cnt) {
                return 1;
            }
            return 0;
        }
        int newCnt = cnt + mat[i][j];
        int res = traverse(i + 1, j, mat, k, newCnt, dp) + traverse(i, j + 1, mat, k, newCnt, dp);
        return dp[i][j][cnt] = res;
    }
  public:
    int numberOfPath(vector<vector<int>>& mat, int k) {
        // Q. Number of paths in a matrix with k coins
        // Code Here
        int n = mat.size();
        int m = mat[0].size();
        vector<vector<unordered_map<int, int>>> dp(n, vector<unordered_map<int, int>>(m));
        int ans = traverse(0, 0, mat, k, 0, dp);
        return ans;
    }
};