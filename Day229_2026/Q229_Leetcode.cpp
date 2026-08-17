class Solution {
    vector<vector<int>> f;
    int dfs(const vector<int>& stoneValue, int left, int right) {
        if (left == right) {
            return 0;
        }
        if (f[left][right]) {
            return f[left][right];
        }

        int sum = accumulate(stoneValue.begin() + left, stoneValue.begin() + right + 1, 0);
        int suml = 0;
        for (int i = left; i < right; ++i) {
            suml += stoneValue[i];
            int sumr = sum - suml;
            if (suml < sumr) {
                f[left][right] = max(f[left][right], dfs(stoneValue, left, i) + suml);
            } else if (suml > sumr) {
                f[left][right] = max(f[left][right], dfs(stoneValue, i + 1, right) + sumr);
            } else {
                f[left][right] = max(f[left][right], max(dfs(stoneValue, left, i), dfs(stoneValue, i + 1, right)) + suml);
            }
        }
        return f[left][right];
    }
public:
    int stoneGameV(vector<int>& stoneValue) {
        // Q. Stone Game V
        int n = stoneValue.size();
        f.assign(n, vector<int>(n));
        return dfs(stoneValue, 0, n - 1);
    }
};