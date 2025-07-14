class Solution:
    def is_power_of_five(self, s, start, end):
        num = int(s[start:end + 1], 2)
        if num == 0:
            return False
        while num > 1:
            if num % 5 != 0:
                return False
            num //= 5
        return True

    def helper(self, s, start, end, dp):
        if end < start:
            return 0
        if s[start] == '0':
            return -1
        if dp[start][end] != -1:
            return dp[start][end]
        if self.is_power_of_five(s, start, end):
            return 1

        ans = float('inf')
        for i in range(start, end + 1):
            if self.is_power_of_five(s, start, i):
                second = self.helper(s, i + 1, end, dp)
                if second != -1:
                    ans = min(ans, 1 + second)

        dp[start][end] = -1 if ans == float('inf') else ans
        return dp[start][end]

    def cuts(self, s):
        n = len(s)
        dp = [[-1] * n for _ in range(n)]
        return self.helper(s, 0, n - 1, dp)
