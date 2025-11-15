class Solution:
    def minCutCost(self, n, cuts):
        cuts.sort()
        cuts = [0] + cuts + [n]

        m = len(cuts) - 2  # original number of cuts

        dp = [[0] * (m + 2) for _ in range(m + 2)]

        for l in range(m, 0, -1):
            for r in range(1, m + 1):

                if l > r:
                    dp[l][r] = 0
                    continue

                ans = float('inf')

                for i in range(l, r + 1):
                    cost = cuts[r + 1] - cuts[l - 1]

                    left = 0 if l > i - 1 else dp[l][i - 1]
                    right = 0 if i + 1 > r else dp[i + 1][r]

                    ans = min(ans, cost + left + right)

                dp[l][r] = ans

        return dp[1][m]
