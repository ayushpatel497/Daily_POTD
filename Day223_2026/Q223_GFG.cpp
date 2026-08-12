class Solution {
  public:
    vector<int> largestSquare(vector<vector<int>>& mat, vector<vector<int>>& queries, int k) {
        // Q. Largest Odd Squares with Limited 1s
        // code here
        int n = mat.size();
        int m = mat[0].size();
        vector<vector<int>> prefix(n + 1, vector<int>(m + 1, 0));

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefix[i][j] = mat[i - 1][j - 1] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
            }
        }
        auto getSum = [&](int r1, int c1, int r2, int c2) {
            r1++;
            c1++;
            r2++;
            c2++;
            return prefix[r2][c2] - prefix[r1 - 1][c2] - prefix[r2][c1 - 1] + prefix[r1 - 1][c1 - 1];
        };
        vector<int> answer;
        answer.reserve(queries.size());
        for (auto& query : queries) {
            int i = query[0];
            int j = query[1];
            int maxRadius = min({i, j, n - 1 - i, m - 1 - j});
            int low = 0;
            int high = maxRadius;
            int best = -1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int r1 = i - mid;
                int c1 = j - mid;
                int r2 = i + mid;
                int c2 = j + mid;
                int ones = getSum(r1, c1, r2, c2);
                if (ones <= k) {
                    best = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            answer.push_back(2 * best + 1);
        }

        return answer;
    }
};