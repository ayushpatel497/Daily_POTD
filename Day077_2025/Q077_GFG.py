from typing import List

class Solution:
    def equalPartition(self, arr: List[int]) -> bool:
        n = len(arr)
        totalSum = sum(arr)
        
        if totalSum % 2 != 0:
            return False
        
        targetSum = totalSum // 2
        memo = [[False] * (targetSum + 1) for _ in range(n + 1)]

        return self.subsetSum(0, n, targetSum, arr, memo)

    def subsetSum(self, pos, n, sum, arr, memo):
        if sum < 0:
            return False
        if pos == n:
            return sum == 0
        if memo[pos][sum]:
            return True
        
        memo[pos][sum] = self.subsetSum(pos + 1, n, sum - arr[pos], arr, memo) or self.subsetSum(pos + 1, n, sum, arr, memo)
        return memo[pos][sum]
