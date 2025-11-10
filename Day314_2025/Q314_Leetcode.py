from typing import List


class Solution:
    def minOperations(self, nums: List[int]) -> int:
        stack = []
        res = 0

        for a in nums:
            while stack and stack[-1] > a:
                stack.pop()
            if a == 0:
                continue
            if not stack or stack[-1] < a:
                res += 1
                stack.append(a)

        return res
