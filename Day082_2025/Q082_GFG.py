class Solution:
    def countWays(self, digits: str) -> int:
        MOD = 10**9 + 7
        n = len(digits)

        if digits[0] == '0':
            return 0

        dp = [0] * (n + 1)
        dp[0] = dp[1] = 1

        for i in range(2, n + 1):
            single = digits[i - 1]
            double_first = digits[i - 2]

            if '1' <= single <= '9':
                dp[i] = dp[i - 1] % MOD
            if double_first == '1' or (double_first == '2' and single <= '6'):
                dp[i] = (dp[i] + dp[i - 2]) % MOD

        return dp[n]
