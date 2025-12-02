class Solution:
    def solve(self, ind, s, adj, pref, nextPos, dp):
        if ind == len(s) - 1:
            return 0
        
        if dp[ind] != -1:
            return dp[ind]

        best = 0
        curr = ord(s[ind]) - ord('a')

        for targetChar in adj[curr]:
            jumpInd = nextPos[ind][ord(targetChar) - ord('a')]
            if jumpInd == -1:
                continue

            if targetChar == s[ind]:
                gain = pref[jumpInd] - pref[ind + 1]
            else:
                gain = pref[jumpInd] - pref[ind]

            gain += self.solve(jumpInd, s, adj, pref, nextPos, dp)
            best = max(best, gain)

        dp[ind] = best
        return best

    def maxScore(self, s, jumps):

        n = len(s)

        # adjacency list
        adj = [[] for _ in range(26)]
        for a, b in jumps:
            adj[ord(a) - ord('a')].append(b)

        # add (c -> c)
        for c in range(26):
            adj[c].append(chr(c + ord('a')))

        # nextPos computation
        nextPos = [[-1] * 26 for _ in range(n)]
        last = [-1] * 26

        for i in range(n - 1, -1, -1):
            for c in range(26):
                nextPos[i][c] = last[c]
            last[ord(s[i]) - ord('a')] = i

        # prefix sum
        pref = [0] * (n + 1)
        for i in range(n):
            pref[i + 1] = pref[i] + ord(s[i])

        dp = [-1] * n
        return self.solve(0, s, adj, pref, nextPos, dp)
