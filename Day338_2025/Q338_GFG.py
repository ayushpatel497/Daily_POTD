class Solution:
    def minCost(self, keys, freq):
        n = len(keys)

        dp = [[0] * n for _ in range(n)]
        opt = [[0] * n for _ in range(n)]

        pre = [0] * (n + 1)
        for i in range(n):
            pre[i + 1] = pre[i] + freq[i]

        def sum_range(l, r):
            return pre[r + 1] - pre[l]

        # single keys
        for i in range(n):
            dp[i][i] = freq[i]
            opt[i][i] = i

        # length >= 2
        for length in range(2, n + 1):
            for i in range(n - length + 1):
                j = i + length - 1

                dp[i][j] = float('inf')

                left_opt = opt[i][j - 1]
                right_opt = opt[i + 1][j]

                for k in range(left_opt, right_opt + 1):
                    left = dp[i][k - 1] if k > i else 0
                    right = dp[k + 1][j] if k < j else 0
                    val = left + right + sum_range(i, j)

                    if val < dp[i][j]:
                        dp[i][j] = val
                        opt[i][j] = k

        return dp[0][n - 1]
