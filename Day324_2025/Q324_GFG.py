class Solution:
    def minCost(self, s, t, transform, cost):
        INF = 10**9

        # distance matrix
        dist = [[INF] * 26 for _ in range(26)]
        for i in range(26):
            dist[i][i] = 0

        # fill direct transformations
        for i in range(len(transform)):
            u = ord(transform[i][0]) - ord('a')
            v = ord(transform[i][1]) - ord('a')
            dist[u][v] = min(dist[u][v], cost[i])

        # Floyd-Warshall
        for k in range(26):
            for i in range(26):
                for j in range(26):
                    if dist[i][k] < INF and dist[k][j] < INF:
                        dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])

        ans = 0

        # evaluate each character position
        for i in range(len(s)):
            a = ord(s[i]) - ord('a')
            b = ord(t[i]) - ord('a')

            if a == b:
                continue

            best = INF
            for c in range(26):
                if dist[a][c] < INF and dist[b][c] < INF:
                    best = min(best, dist[a][c] + dist[b][c])

            if best == INF:
                return -1

            ans += best

        return ans
