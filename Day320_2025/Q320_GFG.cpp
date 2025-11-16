class Solution {
  public:
    int LCIS(vector<int> &a, vector<int> &b) {
        // Q. Longest Common Increasing Subsequence
        // code here
        int n = (int)a.size();
        int m = (int)b.size();
        vector<int> lcis(m, 0);
        for (int i = 0; i < n; ++i) {
            int current = 0;
            for (int j = 0; j < m; ++j) {
                if (a[i] == b[j]) {
                    if (lcis[j] < current + 1)
                        lcis[j] = current + 1;
                } else if (a[i] > b[j]) {
                    if (lcis[j] > current)
                        current = lcis[j];
                }
            }
        }
        return *max_element(lcis.begin(), lcis.end());
    }
};