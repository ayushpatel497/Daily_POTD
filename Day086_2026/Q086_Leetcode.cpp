class Solution {
public:
    bool areSimilar(vector<vector<int>>& mat, int k) {
        // Q. Matrix Similarity After Cyclic Shifts
        int m = mat.size(), n = mat[0].size();
        k %= n;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != mat[i][(j + k) % n]) {
                    return false;
                }
            }
        }
        return true;
    }
};