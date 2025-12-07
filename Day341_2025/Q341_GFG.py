class Solution:
    def distinctSubseq(self, s: str) -> int:
        mod = 10**9 + 7
        n = len(s)

        dp = [0] * (n + 1)
        last = [-1] * 26

        dp[0] = 1  # empty subsequence

        for i in range(1, n + 1):
            dp[i] = (2 * dp[i - 1]) % mod

            ch = ord(s[i - 1]) - ord('a')

            if last[ch] != -1:
                dp[i] = (dp[i] - dp[last[ch]] + mod) % mod

            last[ch] = i - 1

        return dp[n]
