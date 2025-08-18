from typing import List

class Solution:
    EPS = 1e-6

    def judgePoint24(self, cards: List[int]) -> bool:
        nums = [float(c) for c in cards]
        return self.dfs(nums)

    def dfs(self, nums: List[float]) -> bool:
        if len(nums) == 1:
            return abs(nums[0] - 24.0) < self.EPS

        n = len(nums)
        for i in range(n):
            for j in range(n):
                if i == j:
                    continue
                next_nums = [nums[k] for k in range(n) if k != i and k != j]
                for val in self.compute(nums[i], nums[j]):
                    next_nums.append(val)
                    if self.dfs(next_nums):
                        return True
                    next_nums.pop()
        return False

    def compute(self, a: float, b: float) -> List[float]:
        res = [a + b, a - b, b - a, a * b]
        if abs(b) > self.EPS:
            res.append(a / b)
        if abs(a) > self.EPS:
            res.append(b / a)
        return res
