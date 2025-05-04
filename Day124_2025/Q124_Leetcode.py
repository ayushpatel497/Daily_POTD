from typing import List


class Solution:
    def numEquivDominoPairs(self, dominoes: List[List[int]]) -> int:
        count = [0] * 100
        result = 0

        for a, b in dominoes:
            val = a * 10 + b if a < b else b * 10 + a
            result += count[val]
            count[val] += 1

        return result
