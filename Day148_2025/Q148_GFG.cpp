class Solution {
  public:
    bool ValidCorner(vector<vector<int> >& mat) {
        // Q. Find rectangle with corners as 1
        // code here
        int rows = mat.size();
        int cols = mat[0].size();
        unordered_set<string> seen;
        for (int i = 0; i < rows; i++) {
            for (int col1 = 0; col1 < cols - 1; col1++) {
                if (mat[i][col1] == 0) continue;
                for (int col2 = col1 + 1; col2 < cols; col2++) {
                    if (mat[i][col2] == 0) continue;
                    string key = to_string(col1) + "," + to_string(col2);
                    if (seen.find(key) != seen.end()) {
                        return true;
                    }
                    seen.insert(key);
                }
            }
        }
        return false;
    }
};