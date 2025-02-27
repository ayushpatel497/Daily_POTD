from typing import List

class Solution:
    def lenLongestFibSubseq(self, arr: List[int]) -> int:
        index_map = {num: i for i, num in enumerate(arr)}
        n = len(arr)
        dp = [[0] * n for _ in range(n)]
        max_len = 0

        for j in range(n):
            for i in range(j):
                prev = arr[j] - arr[i]
                if prev < arr[i] and prev in index_map:
                    k = index_map[prev]
                    dp[i][j] = dp[k][i] + 1
                    max_len = max(max_len, dp[i][j])

        return max_len + 2 if max_len else 0
