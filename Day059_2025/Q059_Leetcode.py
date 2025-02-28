class Solution:
    def shortestCommonSupersequence(self, str1: str, str2: str) -> str:
        str1Length, str2Length = len(str1), len(str2)
        dp = [[0] * (str2Length + 1) for _ in range(str1Length + 1)]

        for row in range(str1Length + 1):
            dp[row][0] = row
        for col in range(str2Length + 1):
            dp[0][col] = col

        for row in range(1, str1Length + 1):
            for col in range(1, str2Length + 1):
                if str1[row - 1] == str2[col - 1]:
                    dp[row][col] = dp[row - 1][col - 1] + 1
                else:
                    dp[row][col] = min(dp[row - 1][col], dp[row][col - 1]) + 1

        supersequence = []
        row, col = str1Length, str2Length

        while row > 0 and col > 0:
            if str1[row - 1] == str2[col - 1]:
                supersequence.append(str1[row - 1])
                row -= 1
                col -= 1
            elif dp[row - 1][col] < dp[row][col - 1]:
                supersequence.append(str1[row - 1])
                row -= 1
            else:
                supersequence.append(str2[col - 1])
                col -= 1

        while row > 0:
            supersequence.append(str1[row - 1])
            row -= 1
        while col > 0:
            supersequence.append(str2[col - 1])
            col -= 1

        return "".join(reversed(supersequence))
