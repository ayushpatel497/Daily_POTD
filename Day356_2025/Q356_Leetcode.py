from typing import List

class Solution:
    def minDeletionSize(self, strs: List[str]) -> int:
        m = len(strs)
        n = len(strs[0])

        dp = [1] * n
        res = n - 1

        for j in range(n):
            for i in range(j):
                for k in range(m):
                    if strs[k][i] > strs[k][j]:
                        break
                else:
                    dp[j] = max(dp[j], dp[i] + 1)

            res = min(res, n - dp[j])

        return res
