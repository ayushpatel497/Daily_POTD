from typing import List


class Solution:
    def prefixesDivBy5(self, nums: List[int]) -> List[bool]:
        answer = []
        prefix = 0

        for bit in nums:
            prefix = ((prefix << 1) + bit) % 5
            answer.append(prefix == 0)

        return answer
