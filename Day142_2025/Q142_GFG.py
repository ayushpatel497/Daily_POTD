class Solution:
    def minDeletions(self, s: str) -> int:
        def lcs(i, j, s, s2, dp):
            if i < 0 or j < 0:
                return 0
            if dp[i][j] != -1:
                return dp[i][j]
            if s[i] == s2[j]:
                dp[i][j] = 1 + lcs(i - 1, j - 1, s, s2, dp)
            else:
                dp[i][j] = max(lcs(i - 1, j, s, s2, dp), lcs(i, j - 1, s, s2, dp))
            return dp[i][j]

        n = len(s)
        s2 = s[::-1]
        dp = [[-1 for _ in range(n)] for _ in range(n)]
        return n - lcs(n - 1, n - 1, s, s2, dp)
