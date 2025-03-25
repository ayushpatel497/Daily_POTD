class Solution:
    def countWays(self, s: str) -> int:
        n = len(s)
        dp = [[[0, 0] for _ in range(n)] for _ in range(n)]

        # Initialize base cases
        for i in range(0, n, 2):
            dp[i][i][1] = 1 if s[i] == 'T' else 0
            dp[i][i][0] = 1 if s[i] == 'F' else 0

        # Iterate over increasing lengths of subexpressions
        for length in range(2, n, 2):
            for i in range(0, n - length, 2):
                j = i + length
                dp[i][j][0] = dp[i][j][1] = 0

                for k in range(i + 1, j, 2):
                    op = s[k]

                    leftTrue, leftFalse = dp[i][k - 1][1], dp[i][k - 1][0]
                    rightTrue, rightFalse = dp[k + 1][j][1], dp[k + 1][j][0]

                    # True evaluations
                    if self.evaluate(True, True, op): dp[i][j][1] += leftTrue * rightTrue
                    if self.evaluate(True, False, op): dp[i][j][1] += leftTrue * rightFalse
                    if self.evaluate(False, True, op): dp[i][j][1] += leftFalse * rightTrue
                    if self.evaluate(False, False, op): dp[i][j][1] += leftFalse * rightFalse

                    # False evaluations
                    if not self.evaluate(True, True, op): dp[i][j][0] += leftTrue * rightTrue
                    if not self.evaluate(True, False, op): dp[i][j][0] += leftTrue * rightFalse
                    if not self.evaluate(False, True, op): dp[i][j][0] += leftFalse * rightTrue
                    if not self.evaluate(False, False, op): dp[i][j][0] += leftFalse * rightFalse

        return dp[0][n - 1][1]

    def evaluate(self, b1: bool, b2: bool, op: str) -> bool:
        if op == '&': return b1 and b2
        if op == '|': return b1 or b2
        return b1 ^ b2
