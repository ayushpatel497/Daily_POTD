class Solution:
    def mergeStones(self, stones, k):
        n = len(stones)

        # If impossible to reduce to 1 pile
        if (n - 1) % (k - 1) != 0:
            return -1

        prefix = [0] * (n + 1)
        for i in range(n):
            prefix[i + 1] = prefix[i] + stones[i]

        def getSum(l, r):
            return prefix[r + 1] - prefix[l]

        INF = 10**9
        dp = [[[INF] * (k + 1) for _ in range(n)] for _ in range(n)]

        for i in range(n):
            dp[i][i][1] = 0

        for length in range(2, n + 1):
            for i in range(n - length + 1):
                j = i + length - 1

                for t in range(2, k + 1):
                    dp[i][j][t] = INF
                    for mid in range(i, j, k - 1):
                        if dp[i][mid][1] == INF or dp[mid + 1][j][t - 1] == INF:
                            continue
                        dp[i][j][t] = min(dp[i][j][t],
                                          dp[i][mid][1] + dp[mid + 1][j][t - 1])

                # Merge k piles into 1
                if dp[i][j][k] < INF:
                    dp[i][j][1] = dp[i][j][k] + getSum(i, j)

        return dp[0][n - 1][1]
