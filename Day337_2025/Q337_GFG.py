class Solution:
    def tsp(self, cost):
        n = len(cost)
        N = 1 << n
        INF = 10**9

        dp = [[INF] * n for _ in range(N)]
        dp[1][0] = 0  # Start at city 0

        for mask in range(N):
            for u in range(n):
                if not (mask & (1 << u)):
                    continue
                for v in range(n):
                    if mask & (1 << v):
                        continue
                    nextMask = mask | (1 << v)
                    dp[nextMask][v] = min(dp[nextMask][v],
                                          dp[mask][u] + cost[u][v])

        ans = INF
        fullMask = (1 << n) - 1

        for u in range(n):
            ans = min(ans, dp[fullMask][u] + cost[u][0])

        return ans
