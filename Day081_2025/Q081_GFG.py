from typing import List

class Solution:
    def maxValTab(self, x: int, y: int, arr: List[int]) -> int:
        prev2 = arr[x]
        prev1 = max(arr[x], arr[x + 1])

        for j in range(x + 2, y + 1):
            take = arr[j] + prev2
            no_take = prev1
            curr = max(take, no_take)
            prev2, prev1 = prev1, curr

        return prev1

    def maxValue(self, arr: List[int]) -> int:
        n = len(arr)
        if n == 0:
            return 0
        if n == 1:
            return arr[0]

        ans = 0
        ans = max(ans, self.maxValTab(0, n - 2, arr))
        ans = max(ans, self.maxValTab(1, n - 1, arr))

        return ans
