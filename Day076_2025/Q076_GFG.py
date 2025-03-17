from typing import List

class Solution:
    def isSubsetSum(self, arr: List[int], sum: int) -> bool:
        n = len(arr)
        prev = [False] * (sum + 1)
        curr = [False] * (sum + 1)

        prev[0] = True  # Base case: sum 0 is always possible

        for i in range(1, n + 1):
            for j in range(sum + 1):
                if j < arr[i - 1]:
                    curr[j] = prev[j]
                else:
                    curr[j] = prev[j] or prev[j - arr[i - 1]]
            prev = curr[:]  # Copy current row to previous

        return prev[sum]
