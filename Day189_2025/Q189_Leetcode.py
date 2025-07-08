from typing import List


class Solution:
    def maxValue(self, events: List[List[int]], k: int) -> int:
        events.sort()
        n = len(events)
        dp = [[0] * (n + 1) for _ in range(k + 1)]

        def binary_search(target):
            left, right = 0, n
            while left < right:
                mid = (left + right) // 2
                if events[mid][0] <= target:
                    left = mid + 1
                else:
                    right = mid
            return left

        for i in range(n - 1, -1, -1):
            for cnt in range(1, k + 1):
                nxt = binary_search(events[i][1])
                dp[cnt][i] = max(dp[cnt][i + 1], events[i][2] + dp[cnt - 1][nxt])
        return dp[k][0]
